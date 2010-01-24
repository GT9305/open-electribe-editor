/**
 * Copyright (c) 2009-2010 SKRATCHDOT.COM
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    JEFF |:at:| SKRATCHDOT |:dot:| COM
 *
 * $Id$
 */
package com.skratchdot.electribe.fileexplorer.views;

import java.io.File;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

import com.skratchdot.electribe.fileexplorer.Activator;
import com.skratchdot.electribe.fileexplorer.preferences.PreferenceConstants;

public class TableView extends ViewPart
	implements ISelectionListener, IPropertyChangeListener, IDoubleClickListener {
	public static final String ID = "com.skratchdot.electribe.fileexplorer.views.TableView";

	private TableViewer viewer;
	private TableColumn columnName;
	private TableColumn columnSize;
	private TableColumn columnType;
	private TableColumn columnDate;
	private String currentDirectory = null;

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.BORDER | SWT.MULTI);

		columnName = new TableColumn(viewer.getTable(), SWT.LEFT);
		columnName.setText("Name");
		columnName.setWidth(200);

		columnSize = new TableColumn(viewer.getTable(), SWT.RIGHT);
		columnSize.setText("Size");
		columnSize.setWidth(100);

		columnType = new TableColumn(viewer.getTable(), SWT.LEFT);
		columnType.setText("Type");
		columnType.setWidth(100);

		columnDate = new TableColumn(viewer.getTable(), SWT.LEFT);
		columnDate.setText("Modified Date");
		columnDate.setWidth(100);

		// Add drag support
		int ops = DND.DROP_COPY | DND.DROP_MOVE;
		Transfer[] transfers = new Transfer[] { FileTransfer.getInstance() };
		viewer.addDragSupport(ops, transfers, new FileExplorerDragSourceAdapter(viewer));

		viewer.setUseHashlookup(true); // try to speed things up
		viewer.setContentProvider(new TableViewContentProvider(
			Activator.getDefault().getPreferenceStore()
				.getBoolean(PreferenceConstants.PREFNAME_TABLEVIEW_ONLYSHOWINGDIRECTORIES),
			Activator.getDefault().getPreferenceStore()
				.getString(PreferenceConstants.PREFNAME_TABLEVIEW_FILEFILTERARRAY)
		));
		viewer.setLabelProvider(new TableViewLabelProvider());
		viewer.setSorter(new FileExplorerSorter());
		viewer.getTable().setHeaderVisible(true);
		viewer.setInput(null);

		// This view is a selection provider
		getSite().setSelectionProvider(viewer);

		// listen for double click events
		viewer.addDoubleClickListener((IDoubleClickListener) this);

		// listen for selection events from "FileTreeViewer"
		getSite().getPage().addSelectionListener(
			TreeView.ID,
			(ISelectionListener) this
		);

		// listen for preference change events
		Activator.getDefault().getPreferenceStore().addPropertyChangeListener((IPropertyChangeListener) this);

	}

	@Override
	public void dispose() {
		super.dispose();

		// Remove Listeners added in createPartControl()
		getSite().getPage().removeSelectionListener(
			TreeView.ID,
			(ISelectionListener) this
		);
		Activator.getDefault().getPreferenceStore().removePropertyChangeListener((IPropertyChangeListener) this);

	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part instanceof TreeView && selection instanceof IStructuredSelection) {
			Object firstObject = ((IStructuredSelection) selection).getFirstElement();
			// Handle File
			if (firstObject != null && firstObject instanceof File) {
				attemptToSetInput((File) firstObject);
			}
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		// If PREFNAME_TABLEVIEW_ONLYSHOWINGDIRECTORIES has changed
		if(event.getProperty().equals(PreferenceConstants.PREFNAME_TABLEVIEW_ONLYSHOWINGDIRECTORIES)) {
			((TableViewContentProvider) viewer.getContentProvider())
				.getFilter().setOnlyShowingDirectories((Boolean)event.getNewValue());
			viewer.refresh();
		}
		// If PREFNAME_TABLEVIEW_FILEFILTERARRAY has changed
		if(event.getProperty().equals(PreferenceConstants.PREFNAME_TABLEVIEW_FILEFILTERARRAY)) {
			((TableViewContentProvider) viewer.getContentProvider())
				.getFilter().setFileFilterString((String)event.getNewValue());
			viewer.refresh();
		}
	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		ISelection selection = event.getSelection();

		Object firstObject = ((IStructuredSelection) selection).getFirstElement();
		// Handle File
		if (firstObject != null && firstObject instanceof File) {
			// Navigate to the selected directory
			if (((File) firstObject).isDirectory()) {
				attemptToSetInput((File) firstObject);
			}
			// Try to open the selected file with the default editor
			else {
				IWorkbenchPage page = getSite().getWorkbenchWindow().getActivePage();
				if (page!=null) {
					try {
						IEditorDescriptor editorDescriptor = getSite().getWorkbenchWindow().getWorkbench().getEditorRegistry().getDefaultEditor(((File) firstObject).getName());
						if(editorDescriptor!=null && editorDescriptor.isInternal()) {
							IFileStore fileStore = EFS.getLocalFileSystem().getStore(new Path(((File) firstObject).getPath()));
							IDE.openEditorOnFileStore(page, fileStore);
						}
					} catch (PartInitException e) {
						e.printStackTrace();
					}
				}
			}
		}
		// Try to navigate to the parent directory.
		else if (firstObject != null && firstObject instanceof ParentDirectory) {
			String parentPath = ((ParentDirectory) firstObject).getParentPath();
			if (parentPath!=null) {
				attemptToSetInput(new File(parentPath));
			}
		}
		else {
			return;
		}
	}

	// We only need to call viewer.setInput() if we've changed directories
	public void attemptToSetInput(File file) {
		if (file!=null) {
			// Handle Directory
			if(file.isDirectory()) {
				String selectedDirectory = file.getAbsolutePath();
				if (currentDirectory==null || currentDirectory.equals(selectedDirectory)==false) {
					currentDirectory = file.getAbsolutePath();
					viewer.setInput(file);
				}
			}
			// Handle File
			else {
				String selectedDirectory = file.getParentFile().getAbsolutePath();
				if (currentDirectory==null || currentDirectory.equals(selectedDirectory)==false) {
					currentDirectory = file.getParentFile().getAbsolutePath();
					viewer.setInput(file.getParentFile());
				}
			}
		}
	}

}