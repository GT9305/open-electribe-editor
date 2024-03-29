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
package com.skratchdot.electribe.model.esx.provider;


import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemColorProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.skratchdot.electribe.model.esx.EsxPackage;
import com.skratchdot.electribe.model.esx.Sample;

/**
 * This is the item provider adapter for a {@link com.skratchdot.electribe.model.esx.Sample} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SampleItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider, ITableItemColorProvider, IItemColorProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SampleItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addStartPropertyDescriptor(object);
			addEndPropertyDescriptor(object);
			addLoopStartPropertyDescriptor(object);
			addSampleRatePropertyDescriptor(object);
			addSampleTunePropertyDescriptor(object);
			addNumberOfSampleFramesPropertyDescriptor(object);
			addPlayLevelPropertyDescriptor(object);
			addStretchStepPropertyDescriptor(object);
			addLoopPropertyDescriptor(object);
			addSlicePropertyDescriptor(object);
			addStereoOriginalPropertyDescriptor(object);
			addStereoCurrentPropertyDescriptor(object);
			addLabelPropertyDescriptor(object);
			addMemUsedInBytesPropertyDescriptor(object);
			addEmptyPropertyDescriptor(object);
			addPartCountPropertyDescriptor(object);
			addPatternCountPropertyDescriptor(object);
			addSampleInPatternInfoListPropertyDescriptor(object);
			addSampleNumberOriginalPropertyDescriptor(object);
			addSampleNumberCurrentPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_name_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mem Used In Bytes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMemUsedInBytesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_memUsedInBytes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_memUsedInBytes_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__MEM_USED_IN_BYTES,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Empty feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEmptyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_empty_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_empty_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__EMPTY,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Part Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPartCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_partCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_partCount_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__PART_COUNT,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Pattern Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPatternCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_patternCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_patternCount_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__PATTERN_COUNT,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sample In Pattern Info List feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSampleInPatternInfoListPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_sampleInPatternInfoList_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_sampleInPatternInfoList_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__SAMPLE_IN_PATTERN_INFO_LIST,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Start feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_start_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_start_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__START,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the End feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_end_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_end_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__END,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Loop Start feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLoopStartPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_loopStart_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_loopStart_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__LOOP_START,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sample Rate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSampleRatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_sampleRate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_sampleRate_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__SAMPLE_RATE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sample Tune feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSampleTunePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_sampleTune_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_sampleTune_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__SAMPLE_TUNE,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Number Of Sample Frames feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberOfSampleFramesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_numberOfSampleFrames_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_numberOfSampleFrames_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__NUMBER_OF_SAMPLE_FRAMES,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Play Level feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPlayLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_playLevel_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_playLevel_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__PLAY_LEVEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Stretch Step feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStretchStepPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_stretchStep_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_stretchStep_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__STRETCH_STEP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sample Number Original feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSampleNumberOriginalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_sampleNumberOriginal_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_sampleNumberOriginal_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__SAMPLE_NUMBER_ORIGINAL,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sample Number Current feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSampleNumberCurrentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_sampleNumberCurrent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_sampleNumberCurrent_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__SAMPLE_NUMBER_CURRENT,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EsxPackage.Literals.SAMPLE__SAMPLE_TUNE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This adds a property descriptor for the Loop feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLoopPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_loop_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_loop_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__LOOP,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Slice feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSlicePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_slice_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_slice_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__SLICE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Stereo Original feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStereoOriginalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_stereoOriginal_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_stereoOriginal_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__STEREO_ORIGINAL,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Stereo Current feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStereoCurrentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_stereoCurrent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_stereoCurrent_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__STEREO_CURRENT,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Label feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLabelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sample_label_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sample_label_feature", "_UI_Sample_type"),
				 EsxPackage.Literals.SAMPLE__LABEL,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns Sample.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Sample"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Sample)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Sample_type") :
			getString("_UI_Sample_type") + " " + label;
	}

	/**
	 * This returns the column text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getColumnText(Object object, int columnIndex) {
		switch(columnIndex) {
			// Esx#
			case 0: return ((Sample) object).getSampleNumberCurrent().toString();
			// Orig#
			case 1: return ((Sample) object).getSampleNumberOriginal().toString();
			// Name
			case 2: return ((Sample) object).getName();
			// MemSize
			case 3: return Integer.toString(((Sample) object).getMemUsedInBytes());
			// SampleRate
			case 4: return Integer.toString(((Sample) object).getSampleRate());
			// SampleTune
			case 5: return Float.toString(((Sample) object).getSampleTune().getValue());
			// StretchStep
			case 6: return ((Sample) object).getStretchStep().getLiteral();
			// IsLoop
			case 7: return ((Sample) object).isLoop()?getString("_UI_Display_Yes"):getString("_UI_Display_No");
			// IsSlice?
			case 8: return ((Sample) object).isSlice()?getString("_UI_Display_Yes"):getString("_UI_Display_No");
			// PlayLevel
			case 9: return ((Sample) object).getPlayLevel().getLiteral();
			// Start
			case 10: return Integer.toString(((Sample) object).getStart());
			// LoopStart
			case 11: return Integer.toString(((Sample) object).getLoopStart());
			// End
			case 12: return Integer.toString(((Sample) object).getEnd());
			// NumSampleFrames
			case 13: return Integer.toString(((Sample) object).getNumberOfSampleFrames());
			// StereoOriginal
			case 14: return ((Sample) object).isStereoOriginal()?getString("_UI_Display_Yes"):getString("_UI_Display_No");
			default: return getText(object);
		}
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Sample.class)) {
			case EsxPackage.SAMPLE__NAME:
			case EsxPackage.SAMPLE__OFFSET_CHANNEL1_START:
			case EsxPackage.SAMPLE__OFFSET_CHANNEL1_END:
			case EsxPackage.SAMPLE__OFFSET_CHANNEL2_START:
			case EsxPackage.SAMPLE__OFFSET_CHANNEL2_END:
			case EsxPackage.SAMPLE__START:
			case EsxPackage.SAMPLE__END:
			case EsxPackage.SAMPLE__LOOP_START:
			case EsxPackage.SAMPLE__SAMPLE_RATE:
			case EsxPackage.SAMPLE__NUMBER_OF_SAMPLE_FRAMES:
			case EsxPackage.SAMPLE__PLAY_LEVEL:
			case EsxPackage.SAMPLE__UNKNOWN_BYTE1:
			case EsxPackage.SAMPLE__STRETCH_STEP:
			case EsxPackage.SAMPLE__UNKNOWN_BYTE2:
			case EsxPackage.SAMPLE__UNKNOWN_BYTE3:
			case EsxPackage.SAMPLE__UNKNOWN_BYTE4:
			case EsxPackage.SAMPLE__AUDIO_DATA_CHANNEL1:
			case EsxPackage.SAMPLE__AUDIO_DATA_CHANNEL2:
			case EsxPackage.SAMPLE__AUDIO_DATA_CHANNEL_BOTH:
			case EsxPackage.SAMPLE__AUDIO_DATA_LOOP_START:
			case EsxPackage.SAMPLE__SLICE_ARRAY:
			case EsxPackage.SAMPLE__LOOP:
			case EsxPackage.SAMPLE__SLICE:
			case EsxPackage.SAMPLE__STEREO_ORIGINAL:
			case EsxPackage.SAMPLE__STEREO_CURRENT:
			case EsxPackage.SAMPLE__LABEL:
			case EsxPackage.SAMPLE__MEM_USED_IN_BYTES:
			case EsxPackage.SAMPLE__EMPTY:
			case EsxPackage.SAMPLE__PART_COUNT:
			case EsxPackage.SAMPLE__PATTERN_COUNT:
			case EsxPackage.SAMPLE__SAMPLE_NUMBER_ORIGINAL:
			case EsxPackage.SAMPLE__SAMPLE_NUMBER_CURRENT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsxPackage.SAMPLE__SAMPLE_TUNE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return EsxEditPlugin.INSTANCE;
	}

	@Override
	protected Command createSetCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Object value) {

		// When setting name, only allow 8 characters
		if(feature == EsxPackage.Literals.SAMPLE__NAME) {
			value = StringUtils.left((String)value, 8);
		}

		// Start cannot be negative, greater than getEnd(),
		// or greater than getNumberOfSampleFrames()
		// If it's greater than getLoopStart(), then we need to adjust loopStart()
		if(feature == EsxPackage.Literals.SAMPLE__START) {
			int loopStart = ((Sample)owner).getLoopStart();
			int end = ((Sample)owner).getEnd();
			int maxEnd = ((Sample)owner).getNumberOfSampleFrames()-1;
			maxEnd = maxEnd<0?0:maxEnd;
			// Start cannot be negative
			if((Integer)value<0) {
				value = new Integer(0);
			}
			// Start cannot be greater than getEnd()
			if((Integer)value>end) {
				value = new Integer(end);
			}
			// Start cannot be greater than getNumberOfSampleFrames()
			if((Integer)value>maxEnd) {
				value = new Integer(maxEnd);
			}
			// If End is less than getLoopStart(), we need to adjust loopStart
			if((Integer)value>loopStart) {
				CompoundCommand cmd = new CompoundCommand();
				// Change getLoopStart()
				cmd.append(new SetCommand(domain, owner, EsxPackage.Literals.SAMPLE__LOOP_START, (Integer)value));
				// Change getEnd()
				cmd.append(new SetCommand(domain, owner, feature, (Integer)value));
				return cmd;
			}
		}

		// End cannot be negative, less than getStart(),
		// or greater than getNumberOfSampleFrames()
		// If it's less than getLoopStart(), then we need to adjust loopStart()
		if(feature == EsxPackage.Literals.SAMPLE__END) {
			int loopStart = ((Sample)owner).getLoopStart();
			int start = ((Sample)owner).getStart();
			int maxEnd = ((Sample)owner).getNumberOfSampleFrames()-1;
			maxEnd = maxEnd<0?0:maxEnd;
			// End cannot be negative
			if((Integer)value<0) {
				value = new Integer(0);
			}
			// End cannot be less than getStart()
			if((Integer)value<start) {
				value = new Integer(start);
			}
			// End cannot be greater than getNumberOfSampleFrames()
			if((Integer)value>maxEnd) {
				value = new Integer(maxEnd);
			}
			// If End is less than getLoopStart(), we need to adjust loopStart
			if((Integer)value<loopStart) {
				CompoundCommand cmd = new CompoundCommand();
				// Change getLoopStart()
				cmd.append(new SetCommand(domain, owner, EsxPackage.Literals.SAMPLE__LOOP_START, (Integer)value));
				// Change getEnd()
				cmd.append(new SetCommand(domain, owner, feature, (Integer)value));
				return cmd;
			}
		}

		// LoopStart cannot be negative, less than getStart(), 
		// greater than getEnd(), or greater than getNumberOfSampleFrames()
		if(feature == EsxPackage.Literals.SAMPLE__LOOP_START) {
			int start = ((Sample)owner).getStart();
			int end = ((Sample)owner).getEnd();
			int maxEnd = ((Sample)owner).getNumberOfSampleFrames()-1;
			maxEnd = maxEnd<0?0:maxEnd;
			// LoopStart cannot be negative
			if((Integer)value<0) {
				value = new Integer(0);
			}
			// LoopStart cannot be less that getStart()
			if((Integer)value<start) {
				value = new Integer(start);
			}
			// LoopStart cannot be greater than getEnd()
			if((Integer)value>end) {
				value = new Integer(end);
			}
			// LoopStart cannot be greater than getNumberOfSampleFrames()
			if((Integer)value>maxEnd) {
				value = new Integer(maxEnd);
			}
		}
		
		return super.createSetCommand(domain, owner, feature, value);
	}

}
