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

import com.skratchdot.electribe.model.esx.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import com.skratchdot.electribe.model.esx.AmpEg;
import com.skratchdot.electribe.model.esx.ArpeggiatorControl;
import com.skratchdot.electribe.model.esx.ArpeggiatorScale;
import com.skratchdot.electribe.model.esx.AudioInMode;
import com.skratchdot.electribe.model.esx.Beat;
import com.skratchdot.electribe.model.esx.BpmSync;
import com.skratchdot.electribe.model.esx.EnabledFlag;
import com.skratchdot.electribe.model.esx.EsxFile;
import com.skratchdot.electribe.model.esx.EsxPackage;
import com.skratchdot.electribe.model.esx.FilterType;
import com.skratchdot.electribe.model.esx.FxChain;
import com.skratchdot.electribe.model.esx.FxSelect;
import com.skratchdot.electribe.model.esx.FxSend;
import com.skratchdot.electribe.model.esx.FxType;
import com.skratchdot.electribe.model.esx.GlobalParameters;
import com.skratchdot.electribe.model.esx.LastStep;
import com.skratchdot.electribe.model.esx.MidiChannel;
import com.skratchdot.electribe.model.esx.MidiChannelType;
import com.skratchdot.electribe.model.esx.MidiChannelTypeName;
import com.skratchdot.electribe.model.esx.MidiClock;
import com.skratchdot.electribe.model.esx.MidiControlChangeAssignment;
import com.skratchdot.electribe.model.esx.MidiControlChangeAssignmentName;
import com.skratchdot.electribe.model.esx.ModDest;
import com.skratchdot.electribe.model.esx.ModType;
import com.skratchdot.electribe.model.esx.MotionSequenceStatus;
import com.skratchdot.electribe.model.esx.MuteHold;
import com.skratchdot.electribe.model.esx.NextSongNumber;
import com.skratchdot.electribe.model.esx.NoteNumber;
import com.skratchdot.electribe.model.esx.ParametersFx;
import com.skratchdot.electribe.model.esx.ParametersMotion;
import com.skratchdot.electribe.model.esx.Part;
import com.skratchdot.electribe.model.esx.PartAccent;
import com.skratchdot.electribe.model.esx.PartAudioIn;
import com.skratchdot.electribe.model.esx.PartDrum;
import com.skratchdot.electribe.model.esx.PartKeyboard;
import com.skratchdot.electribe.model.esx.PartNoteNumber;
import com.skratchdot.electribe.model.esx.PartNoteNumberName;
import com.skratchdot.electribe.model.esx.PartStretchSlice;
import com.skratchdot.electribe.model.esx.PartWithCommon;
import com.skratchdot.electribe.model.esx.PartWithPitch;
import com.skratchdot.electribe.model.esx.PartWithSample;
import com.skratchdot.electribe.model.esx.PartWithSequenceData;
import com.skratchdot.electribe.model.esx.PartWithSequenceDataGate;
import com.skratchdot.electribe.model.esx.PartWithSlice;
import com.skratchdot.electribe.model.esx.Pattern;
import com.skratchdot.electribe.model.esx.PatternLength;
import com.skratchdot.electribe.model.esx.PatternNumber;
import com.skratchdot.electribe.model.esx.PatternSetParameter;
import com.skratchdot.electribe.model.esx.PitchBendRange;
import com.skratchdot.electribe.model.esx.PlayLevel;
import com.skratchdot.electribe.model.esx.Reverse;
import com.skratchdot.electribe.model.esx.Roll;
import com.skratchdot.electribe.model.esx.RollType;
import com.skratchdot.electribe.model.esx.Sample;
import com.skratchdot.electribe.model.esx.SampleNumber;
import com.skratchdot.electribe.model.esx.SampleTune;
import com.skratchdot.electribe.model.esx.SequenceData;
import com.skratchdot.electribe.model.esx.SequenceDataGate;
import com.skratchdot.electribe.model.esx.SequenceDataNote;
import com.skratchdot.electribe.model.esx.Song;
import com.skratchdot.electribe.model.esx.SongEvent;
import com.skratchdot.electribe.model.esx.SongEventControl;
import com.skratchdot.electribe.model.esx.SongEventDrumNote;
import com.skratchdot.electribe.model.esx.SongEventKeyboardNote;
import com.skratchdot.electribe.model.esx.SongEventMuteStatus;
import com.skratchdot.electribe.model.esx.SongEventTempo;
import com.skratchdot.electribe.model.esx.SongEventWithPart;
import com.skratchdot.electribe.model.esx.SongLength;
import com.skratchdot.electribe.model.esx.SongNumber;
import com.skratchdot.electribe.model.esx.SongPattern;
import com.skratchdot.electribe.model.esx.StretchStep;
import com.skratchdot.electribe.model.esx.Swing;
import com.skratchdot.electribe.model.esx.Tempo;
import com.skratchdot.electribe.model.esx.TempoLock;
import com.skratchdot.riff.wav.RIFFWave;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see com.skratchdot.electribe.model.esx.EsxPackage
 * @generated
 */
public class EsxValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final EsxValidator INSTANCE = new EsxValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "com.skratchdot.electribe.model.esx";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Valid Mem Free In Bytes' of 'File'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ESX_FILE__VALID_MEM_FREE_IN_BYTES = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsxValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return EsxPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case EsxPackage.ESX_FILE:
				return validateEsxFile((EsxFile)value, diagnostics, context);
			case EsxPackage.GLOBAL_PARAMETERS:
				return validateGlobalParameters((GlobalParameters)value, diagnostics, context);
			case EsxPackage.MIDI_CHANNEL_TYPE:
				return validateMidiChannelType((MidiChannelType)value, diagnostics, context);
			case EsxPackage.MIDI_CONTROL_CHANGE_ASSIGNMENT:
				return validateMidiControlChangeAssignment((MidiControlChangeAssignment)value, diagnostics, context);
			case EsxPackage.OPERATION:
				return validateOperation((Operation)value, diagnostics, context);
			case EsxPackage.PARAMETERS_FX:
				return validateParametersFx((ParametersFx)value, diagnostics, context);
			case EsxPackage.PARAMETERS_MOTION:
				return validateParametersMotion((ParametersMotion)value, diagnostics, context);
			case EsxPackage.PART:
				return validatePart((Part)value, diagnostics, context);
			case EsxPackage.PART_ACCENT:
				return validatePartAccent((PartAccent)value, diagnostics, context);
			case EsxPackage.PART_AUDIO_IN:
				return validatePartAudioIn((PartAudioIn)value, diagnostics, context);
			case EsxPackage.PART_DRUM:
				return validatePartDrum((PartDrum)value, diagnostics, context);
			case EsxPackage.PART_KEYBOARD:
				return validatePartKeyboard((PartKeyboard)value, diagnostics, context);
			case EsxPackage.PART_NOTE_NUMBER:
				return validatePartNoteNumber((PartNoteNumber)value, diagnostics, context);
			case EsxPackage.PART_STRETCH_SLICE:
				return validatePartStretchSlice((PartStretchSlice)value, diagnostics, context);
			case EsxPackage.PART_WITH_COMMON:
				return validatePartWithCommon((PartWithCommon)value, diagnostics, context);
			case EsxPackage.PART_WITH_PITCH:
				return validatePartWithPitch((PartWithPitch)value, diagnostics, context);
			case EsxPackage.PART_WITH_SAMPLE:
				return validatePartWithSample((PartWithSample)value, diagnostics, context);
			case EsxPackage.PART_WITH_SEQUENCE_DATA:
				return validatePartWithSequenceData((PartWithSequenceData)value, diagnostics, context);
			case EsxPackage.PART_WITH_SEQUENCE_DATA_GATE:
				return validatePartWithSequenceDataGate((PartWithSequenceDataGate)value, diagnostics, context);
			case EsxPackage.PART_WITH_SLICE:
				return validatePartWithSlice((PartWithSlice)value, diagnostics, context);
			case EsxPackage.PATTERN:
				return validatePattern((Pattern)value, diagnostics, context);
			case EsxPackage.PATTERN_SET_PARAMETER:
				return validatePatternSetParameter((PatternSetParameter)value, diagnostics, context);
			case EsxPackage.SAMPLE:
				return validateSample((Sample)value, diagnostics, context);
			case EsxPackage.SAMPLE_IN_PATTERN_INFO:
				return validateSampleInPatternInfo((SampleInPatternInfo)value, diagnostics, context);
			case EsxPackage.SAMPLE_TUNE:
				return validateSampleTune((SampleTune)value, diagnostics, context);
			case EsxPackage.SEQUENCE_DATA:
				return validateSequenceData((SequenceData)value, diagnostics, context);
			case EsxPackage.SEQUENCE_DATA_GATE:
				return validateSequenceDataGate((SequenceDataGate)value, diagnostics, context);
			case EsxPackage.SEQUENCE_DATA_NOTE:
				return validateSequenceDataNote((SequenceDataNote)value, diagnostics, context);
			case EsxPackage.SONG:
				return validateSong((Song)value, diagnostics, context);
			case EsxPackage.SONG_EVENT:
				return validateSongEvent((SongEvent)value, diagnostics, context);
			case EsxPackage.SONG_EVENT_CONTROL:
				return validateSongEventControl((SongEventControl)value, diagnostics, context);
			case EsxPackage.SONG_EVENT_DRUM_NOTE:
				return validateSongEventDrumNote((SongEventDrumNote)value, diagnostics, context);
			case EsxPackage.SONG_EVENT_KEYBOARD_NOTE:
				return validateSongEventKeyboardNote((SongEventKeyboardNote)value, diagnostics, context);
			case EsxPackage.SONG_EVENT_MUTE_STATUS:
				return validateSongEventMuteStatus((SongEventMuteStatus)value, diagnostics, context);
			case EsxPackage.SONG_EVENT_TEMPO:
				return validateSongEventTempo((SongEventTempo)value, diagnostics, context);
			case EsxPackage.SONG_EVENT_WITH_PART:
				return validateSongEventWithPart((SongEventWithPart)value, diagnostics, context);
			case EsxPackage.SONG_PATTERN:
				return validateSongPattern((SongPattern)value, diagnostics, context);
			case EsxPackage.TEMPO:
				return validateTempo((Tempo)value, diagnostics, context);
			case EsxPackage.AMP_EG:
				return validateAmpEg((AmpEg)value, diagnostics, context);
			case EsxPackage.ARPEGGIATOR_CONTROL:
				return validateArpeggiatorControl((ArpeggiatorControl)value, diagnostics, context);
			case EsxPackage.ARPEGGIATOR_SCALE:
				return validateArpeggiatorScale((ArpeggiatorScale)value, diagnostics, context);
			case EsxPackage.AUDIO_IN_MODE:
				return validateAudioInMode((AudioInMode)value, diagnostics, context);
			case EsxPackage.BEAT:
				return validateBeat((Beat)value, diagnostics, context);
			case EsxPackage.BPM_SYNC:
				return validateBpmSync((BpmSync)value, diagnostics, context);
			case EsxPackage.ENABLED_FLAG:
				return validateEnabledFlag((EnabledFlag)value, diagnostics, context);
			case EsxPackage.FILTER_TYPE:
				return validateFilterType((FilterType)value, diagnostics, context);
			case EsxPackage.FX_CHAIN:
				return validateFxChain((FxChain)value, diagnostics, context);
			case EsxPackage.FX_SELECT:
				return validateFxSelect((FxSelect)value, diagnostics, context);
			case EsxPackage.FX_SEND:
				return validateFxSend((FxSend)value, diagnostics, context);
			case EsxPackage.FX_TYPE:
				return validateFxType((FxType)value, diagnostics, context);
			case EsxPackage.LAST_STEP:
				return validateLastStep((LastStep)value, diagnostics, context);
			case EsxPackage.MIDI_CHANNEL:
				return validateMidiChannel((MidiChannel)value, diagnostics, context);
			case EsxPackage.MIDI_CHANNEL_TYPE_NAME:
				return validateMidiChannelTypeName((MidiChannelTypeName)value, diagnostics, context);
			case EsxPackage.MIDI_CLOCK:
				return validateMidiClock((MidiClock)value, diagnostics, context);
			case EsxPackage.MIDI_CONTROL_CHANGE_ASSIGNMENT_NAME:
				return validateMidiControlChangeAssignmentName((MidiControlChangeAssignmentName)value, diagnostics, context);
			case EsxPackage.MOD_DEST:
				return validateModDest((ModDest)value, diagnostics, context);
			case EsxPackage.MOD_TYPE:
				return validateModType((ModType)value, diagnostics, context);
			case EsxPackage.MOTION_SEQUENCE_STATUS:
				return validateMotionSequenceStatus((MotionSequenceStatus)value, diagnostics, context);
			case EsxPackage.MUTE_HOLD:
				return validateMuteHold((MuteHold)value, diagnostics, context);
			case EsxPackage.NEXT_SONG_NUMBER:
				return validateNextSongNumber((NextSongNumber)value, diagnostics, context);
			case EsxPackage.NOTE_NUMBER:
				return validateNoteNumber((NoteNumber)value, diagnostics, context);
			case EsxPackage.OPERATION_TYPE:
				return validateOperationType((OperationType)value, diagnostics, context);
			case EsxPackage.PART_NOTE_NUMBER_NAME:
				return validatePartNoteNumberName((PartNoteNumberName)value, diagnostics, context);
			case EsxPackage.PATTERN_LENGTH:
				return validatePatternLength((PatternLength)value, diagnostics, context);
			case EsxPackage.PATTERN_NUMBER:
				return validatePatternNumber((PatternNumber)value, diagnostics, context);
			case EsxPackage.PITCH_BEND_RANGE:
				return validatePitchBendRange((PitchBendRange)value, diagnostics, context);
			case EsxPackage.PLAY_LEVEL:
				return validatePlayLevel((PlayLevel)value, diagnostics, context);
			case EsxPackage.REVERSE:
				return validateReverse((Reverse)value, diagnostics, context);
			case EsxPackage.ROLL:
				return validateRoll((Roll)value, diagnostics, context);
			case EsxPackage.ROLL_TYPE:
				return validateRollType((RollType)value, diagnostics, context);
			case EsxPackage.SAMPLE_NUMBER:
				return validateSampleNumber((SampleNumber)value, diagnostics, context);
			case EsxPackage.SONG_EVENT_PART:
				return validateSongEventPart((SongEventPart)value, diagnostics, context);
			case EsxPackage.SONG_LENGTH:
				return validateSongLength((SongLength)value, diagnostics, context);
			case EsxPackage.SONG_NUMBER:
				return validateSongNumber((SongNumber)value, diagnostics, context);
			case EsxPackage.STRETCH_STEP:
				return validateStretchStep((StretchStep)value, diagnostics, context);
			case EsxPackage.SWING:
				return validateSwing((Swing)value, diagnostics, context);
			case EsxPackage.TEMPO_LOCK:
				return validateTempoLock((TempoLock)value, diagnostics, context);
			case EsxPackage.ARRAY_LIST:
				return validateArrayList((ArrayList<?>)value, diagnostics, context);
			case EsxPackage.FILE:
				return validateFile((File)value, diagnostics, context);
			case EsxPackage.INPUT_STREAM:
				return validateInputStream((InputStream)value, diagnostics, context);
			case EsxPackage.INDEX_OUT_OF_BOUNDS_EXCEPTION:
				return validateIndexOutOfBoundsException((IndexOutOfBoundsException)value, diagnostics, context);
			case EsxPackage.IO_EXCEPTION:
				return validateIOException((IOException)value, diagnostics, context);
			case EsxPackage.IPROGRESS_MONITOR:
				return validateIProgressMonitor((IProgressMonitor)value, diagnostics, context);
			case EsxPackage.OBJECT:
				return validateObject(value, diagnostics, context);
			case EsxPackage.RIFF_WAVE:
				return validateRIFFWave((RIFFWave)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEsxFile(EsxFile esxFile, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(esxFile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(esxFile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(esxFile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(esxFile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(esxFile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(esxFile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(esxFile, diagnostics, context);
		if (result || diagnostics != null) result &= validateEsxFile_validMemFreeInBytes(esxFile, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validMemFreeInBytes constraint of '<em>File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEsxFile_validMemFreeInBytes(EsxFile esxFile, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return esxFile.validMemFreeInBytes(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalParameters(GlobalParameters globalParameters, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(globalParameters, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePatternSetParameter(PatternSetParameter patternSetParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(patternSetParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMidiChannelType(MidiChannelType midiChannelType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(midiChannelType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartNoteNumber(PartNoteNumber partNoteNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(partNoteNumber, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMidiControlChangeAssignment(MidiControlChangeAssignment midiControlChangeAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(midiControlChangeAssignment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(operation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParametersFx(ParametersFx parametersFx, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parametersFx, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParametersMotion(ParametersMotion parametersMotion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parametersMotion, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceData(SequenceData sequenceData, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sequenceData, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceDataGate(SequenceDataGate sequenceDataGate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sequenceDataGate, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceDataNote(SequenceDataNote sequenceDataNote, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sequenceDataNote, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePart(Part part, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(part, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartWithSequenceData(PartWithSequenceData partWithSequenceData, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(partWithSequenceData, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartWithCommon(PartWithCommon partWithCommon, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(partWithCommon, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartWithSample(PartWithSample partWithSample, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(partWithSample, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartWithSlice(PartWithSlice partWithSlice, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(partWithSlice, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartWithPitch(PartWithPitch partWithPitch, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(partWithPitch, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartWithSequenceDataGate(PartWithSequenceDataGate partWithSequenceDataGate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(partWithSequenceDataGate, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartAccent(PartAccent partAccent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(partAccent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartAudioIn(PartAudioIn partAudioIn, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(partAudioIn, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartDrum(PartDrum partDrum, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(partDrum, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartKeyboard(PartKeyboard partKeyboard, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(partKeyboard, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartStretchSlice(PartStretchSlice partStretchSlice, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(partStretchSlice, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePattern(Pattern pattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(pattern, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSample(Sample sample, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sample, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSampleInPatternInfo(SampleInPatternInfo sampleInPatternInfo, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sampleInPatternInfo, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSampleTune(SampleTune sampleTune, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sampleTune, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSong(Song song, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(song, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSongPattern(SongPattern songPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(songPattern, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSongEvent(SongEvent songEvent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(songEvent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSongEventWithPart(SongEventWithPart songEventWithPart, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(songEventWithPart, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSongEventControl(SongEventControl songEventControl, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(songEventControl, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSongEventDrumNote(SongEventDrumNote songEventDrumNote, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(songEventDrumNote, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSongEventKeyboardNote(SongEventKeyboardNote songEventKeyboardNote, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(songEventKeyboardNote, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSongEventTempo(SongEventTempo songEventTempo, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(songEventTempo, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSongEventMuteStatus(SongEventMuteStatus songEventMuteStatus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(songEventMuteStatus, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTempo(Tempo tempo, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tempo, diagnostics, context);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArpeggiatorControl(ArpeggiatorControl arpeggiatorControl, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAudioInMode(AudioInMode audioInMode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMidiClock(MidiClock midiClock, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMidiControlChangeAssignmentName(MidiControlChangeAssignmentName midiControlChangeAssignmentName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnabledFlag(EnabledFlag enabledFlag, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePitchBendRange(PitchBendRange pitchBendRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMidiChannel(MidiChannel midiChannel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMidiChannelTypeName(MidiChannelTypeName midiChannelTypeName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlayLevel(PlayLevel playLevel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePatternNumber(PatternNumber patternNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSampleNumber(SampleNumber sampleNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSongEventPart(SongEventPart songEventPart, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSongNumber(SongNumber songNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSongLength(SongLength songLength, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTempoLock(TempoLock tempoLock, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMuteHold(MuteHold muteHold, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNextSongNumber(NextSongNumber nextSongNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStretchStep(StretchStep stretchStep, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwing(Swing swing, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePatternLength(PatternLength patternLength, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBeat(Beat beat, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRollType(RollType rollType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFxChain(FxChain fxChain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLastStep(LastStep lastStep, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArpeggiatorScale(ArpeggiatorScale arpeggiatorScale, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNoteNumber(NoteNumber noteNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationType(OperationType operationType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartNoteNumberName(PartNoteNumberName partNoteNumberName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFilterType(FilterType filterType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFxSelect(FxSelect fxSelect, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFxSend(FxSend fxSend, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFxType(FxType fxType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRoll(Roll roll, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAmpEg(AmpEg ampEg, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReverse(Reverse reverse, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModDest(ModDest modDest, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModType(ModType modType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBpmSync(BpmSync bpmSync, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMotionSequenceStatus(MotionSequenceStatus motionSequenceStatus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObject(Object object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRIFFWave(RIFFWave riffWave, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArrayList(ArrayList<?> arrayList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFile(File file, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInputStream(InputStream inputStream, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIndexOutOfBoundsException(IndexOutOfBoundsException indexOutOfBoundsException, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIOException(IOException ioException, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIProgressMonitor(IProgressMonitor iProgressMonitor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //EsxValidator
