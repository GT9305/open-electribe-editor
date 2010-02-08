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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemColorProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import com.skratchdot.electribe.model.esx.util.EsxAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EsxItemProviderAdapterFactory extends EsxAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EsxItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
		supportedTypes.add(ITableItemLabelProvider.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.EsxFile} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EsxFileItemProvider esxFileItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.EsxFile}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEsxFileAdapter() {
		if (esxFileItemProvider == null) {
			esxFileItemProvider = new EsxFileItemProvider(this);
		}

		return esxFileItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.GlobalParameters} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalParametersItemProvider globalParametersItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.GlobalParameters}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGlobalParametersAdapter() {
		if (globalParametersItemProvider == null) {
			globalParametersItemProvider = new GlobalParametersItemProvider(this);
		}

		return globalParametersItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.PatternSetParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternSetParameterItemProvider patternSetParameterItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.PatternSetParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPatternSetParameterAdapter() {
		if (patternSetParameterItemProvider == null) {
			patternSetParameterItemProvider = new PatternSetParameterItemProvider(this);
		}

		return patternSetParameterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.MidiChannelType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MidiChannelTypeItemProvider midiChannelTypeItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.MidiChannelType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMidiChannelTypeAdapter() {
		if (midiChannelTypeItemProvider == null) {
			midiChannelTypeItemProvider = new MidiChannelTypeItemProvider(this);
		}

		return midiChannelTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.PartNoteNumber} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartNoteNumberItemProvider partNoteNumberItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.PartNoteNumber}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPartNoteNumberAdapter() {
		if (partNoteNumberItemProvider == null) {
			partNoteNumberItemProvider = new PartNoteNumberItemProvider(this);
		}

		return partNoteNumberItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.MidiControlChangeAssignment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MidiControlChangeAssignmentItemProvider midiControlChangeAssignmentItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.MidiControlChangeAssignment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMidiControlChangeAssignmentAdapter() {
		if (midiControlChangeAssignmentItemProvider == null) {
			midiControlChangeAssignmentItemProvider = new MidiControlChangeAssignmentItemProvider(this);
		}

		return midiControlChangeAssignmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.ParametersFx} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParametersFxItemProvider parametersFxItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.ParametersFx}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createParametersFxAdapter() {
		if (parametersFxItemProvider == null) {
			parametersFxItemProvider = new ParametersFxItemProvider(this);
		}

		return parametersFxItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.ParametersMotion} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParametersMotionItemProvider parametersMotionItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.ParametersMotion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createParametersMotionAdapter() {
		if (parametersMotionItemProvider == null) {
			parametersMotionItemProvider = new ParametersMotionItemProvider(this);
		}

		return parametersMotionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.SequenceData} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceDataItemProvider sequenceDataItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.SequenceData}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSequenceDataAdapter() {
		if (sequenceDataItemProvider == null) {
			sequenceDataItemProvider = new SequenceDataItemProvider(this);
		}

		return sequenceDataItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.SequenceDataGate} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceDataGateItemProvider sequenceDataGateItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.SequenceDataGate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSequenceDataGateAdapter() {
		if (sequenceDataGateItemProvider == null) {
			sequenceDataGateItemProvider = new SequenceDataGateItemProvider(this);
		}

		return sequenceDataGateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.SequenceDataNote} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceDataNoteItemProvider sequenceDataNoteItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.SequenceDataNote}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSequenceDataNoteAdapter() {
		if (sequenceDataNoteItemProvider == null) {
			sequenceDataNoteItemProvider = new SequenceDataNoteItemProvider(this);
		}

		return sequenceDataNoteItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.PartAccent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartAccentItemProvider partAccentItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.PartAccent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPartAccentAdapter() {
		if (partAccentItemProvider == null) {
			partAccentItemProvider = new PartAccentItemProvider(this);
		}

		return partAccentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.PartAudioIn} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartAudioInItemProvider partAudioInItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.PartAudioIn}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPartAudioInAdapter() {
		if (partAudioInItemProvider == null) {
			partAudioInItemProvider = new PartAudioInItemProvider(this);
		}

		return partAudioInItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.PartDrum} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartDrumItemProvider partDrumItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.PartDrum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPartDrumAdapter() {
		if (partDrumItemProvider == null) {
			partDrumItemProvider = new PartDrumItemProvider(this);
		}

		return partDrumItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.PartKeyboard} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartKeyboardItemProvider partKeyboardItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.PartKeyboard}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPartKeyboardAdapter() {
		if (partKeyboardItemProvider == null) {
			partKeyboardItemProvider = new PartKeyboardItemProvider(this);
		}

		return partKeyboardItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.PartStretchSlice} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartStretchSliceItemProvider partStretchSliceItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.PartStretchSlice}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPartStretchSliceAdapter() {
		if (partStretchSliceItemProvider == null) {
			partStretchSliceItemProvider = new PartStretchSliceItemProvider(this);
		}

		return partStretchSliceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.Pattern} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternItemProvider patternItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.Pattern}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPatternAdapter() {
		if (patternItemProvider == null) {
			patternItemProvider = new PatternItemProvider(this);
		}

		return patternItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.SampleMono} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SampleMonoItemProvider sampleMonoItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.SampleMono}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSampleMonoAdapter() {
		if (sampleMonoItemProvider == null) {
			sampleMonoItemProvider = new SampleMonoItemProvider(this);
		}

		return sampleMonoItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.SampleStereo} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SampleStereoItemProvider sampleStereoItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.SampleStereo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSampleStereoAdapter() {
		if (sampleStereoItemProvider == null) {
			sampleStereoItemProvider = new SampleStereoItemProvider(this);
		}

		return sampleStereoItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.SampleTune} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SampleTuneItemProvider sampleTuneItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.SampleTune}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSampleTuneAdapter() {
		if (sampleTuneItemProvider == null) {
			sampleTuneItemProvider = new SampleTuneItemProvider(this);
		}

		return sampleTuneItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.Song} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SongItemProvider songItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.Song}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSongAdapter() {
		if (songItemProvider == null) {
			songItemProvider = new SongItemProvider(this);
		}

		return songItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.SongPattern} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SongPatternItemProvider songPatternItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.SongPattern}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSongPatternAdapter() {
		if (songPatternItemProvider == null) {
			songPatternItemProvider = new SongPatternItemProvider(this);
		}

		return songPatternItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.Tempo} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TempoItemProvider tempoItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.Tempo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTempoAdapter() {
		if (tempoItemProvider == null) {
			tempoItemProvider = new TempoItemProvider(this);
		}

		return tempoItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.SongEventControl} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SongEventControlItemProvider songEventControlItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.SongEventControl}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSongEventControlAdapter() {
		if (songEventControlItemProvider == null) {
			songEventControlItemProvider = new SongEventControlItemProvider(this);
		}

		return songEventControlItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.SongEventDrumNote} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SongEventDrumNoteItemProvider songEventDrumNoteItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.SongEventDrumNote}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSongEventDrumNoteAdapter() {
		if (songEventDrumNoteItemProvider == null) {
			songEventDrumNoteItemProvider = new SongEventDrumNoteItemProvider(this);
		}

		return songEventDrumNoteItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.SongEventKeyboardNote} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SongEventKeyboardNoteItemProvider songEventKeyboardNoteItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.SongEventKeyboardNote}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSongEventKeyboardNoteAdapter() {
		if (songEventKeyboardNoteItemProvider == null) {
			songEventKeyboardNoteItemProvider = new SongEventKeyboardNoteItemProvider(this);
		}

		return songEventKeyboardNoteItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.SongEventTempo} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SongEventTempoItemProvider songEventTempoItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.SongEventTempo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSongEventTempoAdapter() {
		if (songEventTempoItemProvider == null) {
			songEventTempoItemProvider = new SongEventTempoItemProvider(this);
		}

		return songEventTempoItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.skratchdot.electribe.model.esx.SongEventMuteStatus} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SongEventMuteStatusItemProvider songEventMuteStatusItemProvider;

	/**
	 * This creates an adapter for a {@link com.skratchdot.electribe.model.esx.SongEventMuteStatus}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSongEventMuteStatusAdapter() {
		if (songEventMuteStatusItemProvider == null) {
			songEventMuteStatusItemProvider = new SongEventMuteStatusItemProvider(this);
		}

		return songEventMuteStatusItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (esxFileItemProvider != null) esxFileItemProvider.dispose();
		if (globalParametersItemProvider != null) globalParametersItemProvider.dispose();
		if (midiChannelTypeItemProvider != null) midiChannelTypeItemProvider.dispose();
		if (midiControlChangeAssignmentItemProvider != null) midiControlChangeAssignmentItemProvider.dispose();
		if (parametersFxItemProvider != null) parametersFxItemProvider.dispose();
		if (parametersMotionItemProvider != null) parametersMotionItemProvider.dispose();
		if (partAccentItemProvider != null) partAccentItemProvider.dispose();
		if (partAudioInItemProvider != null) partAudioInItemProvider.dispose();
		if (partDrumItemProvider != null) partDrumItemProvider.dispose();
		if (partKeyboardItemProvider != null) partKeyboardItemProvider.dispose();
		if (partNoteNumberItemProvider != null) partNoteNumberItemProvider.dispose();
		if (partStretchSliceItemProvider != null) partStretchSliceItemProvider.dispose();
		if (patternItemProvider != null) patternItemProvider.dispose();
		if (patternSetParameterItemProvider != null) patternSetParameterItemProvider.dispose();
		if (sampleMonoItemProvider != null) sampleMonoItemProvider.dispose();
		if (sampleStereoItemProvider != null) sampleStereoItemProvider.dispose();
		if (sampleTuneItemProvider != null) sampleTuneItemProvider.dispose();
		if (sequenceDataItemProvider != null) sequenceDataItemProvider.dispose();
		if (sequenceDataGateItemProvider != null) sequenceDataGateItemProvider.dispose();
		if (sequenceDataNoteItemProvider != null) sequenceDataNoteItemProvider.dispose();
		if (songItemProvider != null) songItemProvider.dispose();
		if (songEventControlItemProvider != null) songEventControlItemProvider.dispose();
		if (songEventDrumNoteItemProvider != null) songEventDrumNoteItemProvider.dispose();
		if (songEventKeyboardNoteItemProvider != null) songEventKeyboardNoteItemProvider.dispose();
		if (songEventMuteStatusItemProvider != null) songEventMuteStatusItemProvider.dispose();
		if (songEventTempoItemProvider != null) songEventTempoItemProvider.dispose();
		if (songPatternItemProvider != null) songPatternItemProvider.dispose();
		if (tempoItemProvider != null) tempoItemProvider.dispose();
	}

}
