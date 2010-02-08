/**
 * Copyright (c) 2009-2010 SKRATCHDOT.COM
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     JEFF |:at:| SKRATCHDOT |:dot:| COM
 *
 * $Id$
 */
package com.skratchdot.electribe.model.esx.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import com.skratchdot.electribe.model.esx.EsxFactory;
import com.skratchdot.electribe.model.esx.EsxFile;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see com.skratchdot.electribe.model.esx.util.EsxResourceFactoryImpl
 * @generated
 */
public class EsxResourceImpl extends ResourceImpl {
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public EsxResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		File tempFile = new File(EsxUtil.getTempFilePath("esxLoad"));
		tempFile.deleteOnExit();
		try {
			IProgressMonitor monitor;
			// Get IProgressMonitor from options, else create one
			if(options.containsKey("IProgressMonitor")) {
				monitor = (IProgressMonitor) options.get("IProgressMonitor");
			}
			else {
				monitor = new NullProgressMonitor();
			}

			// Setup monitor
			monitor.beginTask("Loading ESX file...", 1 +
				EsxUtil.NUM_PATTERNS +
				EsxUtil.NUM_SONGS +
				EsxUtil.NUM_SAMPLES_MONO +
				EsxUtil.NUM_SAMPLES_STEREO
			);

			// Create a temporary RandomAccessFile file from our inputStream.
			// This will be passed to our "special" RandomAccessFile modal
			// object constructors to create our EsxFile object.
			// RandomAccessFile in = InputStreamConverter.toRandomAccessFile(inputStream);
			monitor.subTask("Starting");
			EsxRandomAccess in = new EsxRandomAccess(tempFile, inputStream, monitor);

			// Check if our stream is a valid EsxFile
			monitor.subTask("Checking file format");
			if(!EsxUtil.isValidEsxFile(in)) throw new IOException("Invalid Esx File Format");

			// Create an EsxFile from our stream
			monitor.subTask("Getting EsxFile");
			EsxFile root = EsxFactory.eINSTANCE.createEsxFileFromEsxFile(in, monitor);

			// Add to resource (self)
			monitor.subTask("Finishing up");
			this.getContents().add(root);

			// Close our stream, and delete temp file
			in.close();
			tempFile.delete();

			// We have finished loading
			monitor.done();

		} catch (EsxException e) {
			throw new IOException(e.getMessage());
		} finally {
			tempFile.delete();
		}

	}

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		File tempFile = new File(EsxUtil.getTempFilePath("esxSave"));
		tempFile.deleteOnExit();
		try {
			IProgressMonitor monitor;
			// Get IProgressMonitor from options, else create one
			if(options.containsKey("IProgressMonitor")) {
				monitor = (IProgressMonitor) options.get("IProgressMonitor");
			}
			else {
				monitor = new NullProgressMonitor();
			}

			// Setup monitor
			monitor.beginTask("Saving ESX file...", 1 +
				EsxUtil.NUM_PATTERNS +
				EsxUtil.NUM_SONGS +
				EsxUtil.NUM_SAMPLES_MONO +
				EsxUtil.NUM_SAMPLES_STEREO
			);

			// Get EsxRandomAccess which will be passed to our model's write() functions
			monitor.subTask("Starting");
			EsxRandomAccess out = new EsxRandomAccess(tempFile, "rwd");

			// Get our models root object (the EsxFile)
			monitor.subTask("Getting EsxFile");
			EsxFile root = (EsxFile) this.getContents().get(0);

			// Begin writing
			monitor.subTask("Begin writing");
			root.write(out, monitor);

			// Write our constructed EsxRandomAccess to the outputStream
			monitor.subTask("Finishing up");
			byte[] buffer = new byte[16384];
			int len;
			out.seek(0);
			while((len = out.read(buffer)) >= 0) {
				outputStream.write(buffer, 0, len);
			}

			// Close our stream, and delete temp file
			out.close();
			tempFile.delete();

			// We have finished saving
			monitor.done();

		} catch (EsxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			tempFile.delete();
		}
	}

} //EsxResourceImpl