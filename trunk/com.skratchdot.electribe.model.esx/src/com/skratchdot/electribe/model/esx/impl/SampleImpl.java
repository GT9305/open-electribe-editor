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
package com.skratchdot.electribe.model.esx.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;

import com.skratchdot.electribe.model.esx.EsxFile;
import com.skratchdot.electribe.model.esx.EsxPackage;
import com.skratchdot.electribe.model.esx.PlayLevel;
import com.skratchdot.electribe.model.esx.Sample;
import com.skratchdot.electribe.model.esx.SampleNumber;
import com.skratchdot.electribe.model.esx.SampleTune;
import com.skratchdot.electribe.model.esx.StretchStep;
import com.skratchdot.electribe.model.esx.util.EsxException;
import com.skratchdot.electribe.model.esx.util.EsxUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sample</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getOffsetChannel1Start <em>Offset Channel1 Start</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getOffsetChannel1End <em>Offset Channel1 End</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getOffsetChannel2Start <em>Offset Channel2 Start</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getOffsetChannel2End <em>Offset Channel2 End</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getStart <em>Start</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getEnd <em>End</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getLoopStart <em>Loop Start</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getSampleRate <em>Sample Rate</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getSampleTune <em>Sample Tune</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getNumberOfSampleFrames <em>Number Of Sample Frames</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getPlayLevel <em>Play Level</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getUnknownByte1 <em>Unknown Byte1</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getStretchStep <em>Stretch Step</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getUnknownByte2 <em>Unknown Byte2</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getUnknownByte3 <em>Unknown Byte3</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getUnknownByte4 <em>Unknown Byte4</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getAudioDataChannel1 <em>Audio Data Channel1</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getAudioDataChannel2 <em>Audio Data Channel2</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getSliceArray <em>Slice Array</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#isLoop <em>Loop</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#isSlice <em>Slice</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#isStereo <em>Stereo</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getMemUsedInBytes <em>Mem Used In Bytes</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#isBeingUsed <em>Being Used</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getSampleNumberOriginal <em>Sample Number Original</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleImpl#getSampleNumberCurrent <em>Sample Number Current</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SampleImpl extends EObjectImpl implements Sample {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOffsetChannel1Start() <em>Offset Channel1 Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetChannel1Start()
	 * @generated
	 * @ordered
	 */
	protected static final int OFFSET_CHANNEL1_START_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOffsetChannel1Start() <em>Offset Channel1 Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetChannel1Start()
	 * @generated
	 * @ordered
	 */
	protected int offsetChannel1Start = OFFSET_CHANNEL1_START_EDEFAULT;

	/**
	 * The default value of the '{@link #getOffsetChannel1End() <em>Offset Channel1 End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetChannel1End()
	 * @generated
	 * @ordered
	 */
	protected static final int OFFSET_CHANNEL1_END_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOffsetChannel1End() <em>Offset Channel1 End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetChannel1End()
	 * @generated
	 * @ordered
	 */
	protected int offsetChannel1End = OFFSET_CHANNEL1_END_EDEFAULT;

	/**
	 * The default value of the '{@link #getOffsetChannel2Start() <em>Offset Channel2 Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetChannel2Start()
	 * @generated
	 * @ordered
	 */
	protected static final int OFFSET_CHANNEL2_START_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOffsetChannel2Start() <em>Offset Channel2 Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetChannel2Start()
	 * @generated
	 * @ordered
	 */
	protected int offsetChannel2Start = OFFSET_CHANNEL2_START_EDEFAULT;

	/**
	 * The default value of the '{@link #getOffsetChannel2End() <em>Offset Channel2 End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetChannel2End()
	 * @generated
	 * @ordered
	 */
	protected static final int OFFSET_CHANNEL2_END_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOffsetChannel2End() <em>Offset Channel2 End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetChannel2End()
	 * @generated
	 * @ordered
	 */
	protected int offsetChannel2End = OFFSET_CHANNEL2_END_EDEFAULT;

	/**
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final int START_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected int start = START_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected static final int END_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected int end = END_EDEFAULT;

	/**
	 * The default value of the '{@link #getLoopStart() <em>Loop Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopStart()
	 * @generated
	 * @ordered
	 */
	protected static final int LOOP_START_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLoopStart() <em>Loop Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopStart()
	 * @generated
	 * @ordered
	 */
	protected int loopStart = LOOP_START_EDEFAULT;

	/**
	 * The default value of the '{@link #getSampleRate() <em>Sample Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleRate()
	 * @generated
	 * @ordered
	 */
	protected static final int SAMPLE_RATE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSampleRate() <em>Sample Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleRate()
	 * @generated
	 * @ordered
	 */
	protected int sampleRate = SAMPLE_RATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSampleTune() <em>Sample Tune</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleTune()
	 * @generated
	 * @ordered
	 */
	protected SampleTune sampleTune;

	/**
	 * The default value of the '{@link #getNumberOfSampleFrames() <em>Number Of Sample Frames</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfSampleFrames()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_SAMPLE_FRAMES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberOfSampleFrames() <em>Number Of Sample Frames</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfSampleFrames()
	 * @generated
	 * @ordered
	 */
	protected int numberOfSampleFrames = NUMBER_OF_SAMPLE_FRAMES_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlayLevel() <em>Play Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayLevel()
	 * @generated
	 * @ordered
	 */
	protected static final PlayLevel PLAY_LEVEL_EDEFAULT = PlayLevel.DB_0;

	/**
	 * The cached value of the '{@link #getPlayLevel() <em>Play Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayLevel()
	 * @generated
	 * @ordered
	 */
	protected PlayLevel playLevel = PLAY_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnknownByte1() <em>Unknown Byte1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknownByte1()
	 * @generated
	 * @ordered
	 */
	protected static final byte UNKNOWN_BYTE1_EDEFAULT = 0x00;

	/**
	 * The cached value of the '{@link #getUnknownByte1() <em>Unknown Byte1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknownByte1()
	 * @generated
	 * @ordered
	 */
	protected byte unknownByte1 = UNKNOWN_BYTE1_EDEFAULT;

	/**
	 * The default value of the '{@link #getStretchStep() <em>Stretch Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStretchStep()
	 * @generated
	 * @ordered
	 */
	protected static final StretchStep STRETCH_STEP_EDEFAULT = StretchStep.STRETCH_STEP_OFF;

	/**
	 * The cached value of the '{@link #getStretchStep() <em>Stretch Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStretchStep()
	 * @generated
	 * @ordered
	 */
	protected StretchStep stretchStep = STRETCH_STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnknownByte2() <em>Unknown Byte2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknownByte2()
	 * @generated
	 * @ordered
	 */
	protected static final byte UNKNOWN_BYTE2_EDEFAULT = 0x00;

	/**
	 * The cached value of the '{@link #getUnknownByte2() <em>Unknown Byte2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknownByte2()
	 * @generated
	 * @ordered
	 */
	protected byte unknownByte2 = UNKNOWN_BYTE2_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnknownByte3() <em>Unknown Byte3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknownByte3()
	 * @generated
	 * @ordered
	 */
	protected static final byte UNKNOWN_BYTE3_EDEFAULT = 0x00;

	/**
	 * The cached value of the '{@link #getUnknownByte3() <em>Unknown Byte3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknownByte3()
	 * @generated
	 * @ordered
	 */
	protected byte unknownByte3 = UNKNOWN_BYTE3_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnknownByte4() <em>Unknown Byte4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknownByte4()
	 * @generated
	 * @ordered
	 */
	protected static final byte UNKNOWN_BYTE4_EDEFAULT = 0x00;

	/**
	 * The cached value of the '{@link #getUnknownByte4() <em>Unknown Byte4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknownByte4()
	 * @generated
	 * @ordered
	 */
	protected byte unknownByte4 = UNKNOWN_BYTE4_EDEFAULT;

	/**
	 * The default value of the '{@link #getAudioDataChannel1() <em>Audio Data Channel1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAudioDataChannel1()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] AUDIO_DATA_CHANNEL1_EDEFAULT = {};

	/**
	 * The cached value of the '{@link #getAudioDataChannel1() <em>Audio Data Channel1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAudioDataChannel1()
	 * @generated
	 * @ordered
	 */
	protected byte[] audioDataChannel1 = AUDIO_DATA_CHANNEL1_EDEFAULT;

	/**
	 * The default value of the '{@link #getAudioDataChannel2() <em>Audio Data Channel2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAudioDataChannel2()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] AUDIO_DATA_CHANNEL2_EDEFAULT = {};

	/**
	 * The cached value of the '{@link #getAudioDataChannel2() <em>Audio Data Channel2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAudioDataChannel2()
	 * @generated
	 * @ordered
	 */
	protected byte[] audioDataChannel2 = AUDIO_DATA_CHANNEL2_EDEFAULT;

	/**
	 * The default value of the '{@link #getSliceArray() <em>Slice Array</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSliceArray()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] SLICE_ARRAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSliceArray() <em>Slice Array</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSliceArray()
	 * @generated
	 * @ordered
	 */
	protected byte[] sliceArray = SLICE_ARRAY_EDEFAULT;

	/**
	 * The default value of the '{@link #isLoop() <em>Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoop()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOOP_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isSlice() <em>Slice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSlice()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SLICE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isStereo() <em>Stereo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStereo()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STEREO_EDEFAULT = true;

	/**
	 * The default value of the '{@link #getMemUsedInBytes() <em>Mem Used In Bytes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemUsedInBytes()
	 * @generated
	 * @ordered
	 */
	protected static final int MEM_USED_IN_BYTES_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #isBeingUsed() <em>Being Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBeingUsed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BEING_USED_EDEFAULT = true;

	/**
	 * The default value of the '{@link #getSampleNumberOriginal() <em>Sample Number Original</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleNumberOriginal()
	 * @generated
	 * @ordered
	 */
	protected static final SampleNumber SAMPLE_NUMBER_ORIGINAL_EDEFAULT = SampleNumber.SAMPLE_OFF;

	/**
	 * The cached value of the '{@link #getSampleNumberOriginal() <em>Sample Number Original</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleNumberOriginal()
	 * @generated
	 * @ordered
	 */
	protected SampleNumber sampleNumberOriginal = SAMPLE_NUMBER_ORIGINAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSampleNumberCurrent() <em>Sample Number Current</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleNumberCurrent()
	 * @generated
	 * @ordered
	 */
	protected static final SampleNumber SAMPLE_NUMBER_CURRENT_EDEFAULT = SampleNumber.SAMPLE_OFF;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SampleImpl() {
		super();
	}

	protected SampleImpl(File file) throws EsxException {
		super();
		
		// Declare our streams and formats
		AudioFormat audioFormatEncoded;
		AudioFormat audioFormatDecoded;
		AudioInputStream audioInputStreamEncoded;
		AudioInputStream audioInputStreamDecoded;

		try {
			// Initialize our streams and formats
			audioInputStreamEncoded = AudioSystem.getAudioInputStream(file);
			audioFormatEncoded = audioInputStreamEncoded.getFormat();
			audioFormatDecoded = new AudioFormat(
					AudioFormat.Encoding.PCM_SIGNED,
					audioFormatEncoded.getSampleRate(),
					16,
					audioFormatEncoded.getChannels(),
					audioFormatEncoded.getChannels()*2,
					audioFormatEncoded.getSampleRate(),
					true
				);
			audioInputStreamDecoded = AudioSystem.getAudioInputStream(
				audioFormatDecoded,
				audioInputStreamEncoded
			);

			// We have a decoded stereo audio stream
			// Now we need to get the stream info into a list we can manipulate
			byte[] audioData = new byte[4096];
			int nBytesRead = 0;
			long nTotalBytesRead = 0;
			List<Byte> audioDataListChannel1 = new ArrayList<Byte>();
			List<Byte> audioDataListChannel2 = new ArrayList<Byte>();
			boolean isAudioDataStereo = false;

			// Set isAudioDataStereo
			if(audioFormatEncoded.getChannels()==1) {
				isAudioDataStereo = false;
			}
			else if(audioFormatEncoded.getChannels()==2) {
				isAudioDataStereo = true;
			}
			else {
				throw new EsxException("Sample has too many channels: " + file.getAbsolutePath());
			}

			// Convert stream to list. This needs to be optimized. Converting
			// a byte at a time is probably too slow...
			while(nBytesRead>=0) {
				nBytesRead = audioInputStreamDecoded.read(audioData, 0, audioData.length);

				// If we aren't at the end of the stream
				if(nBytesRead>0) {
					for(int i=0; i<nBytesRead; i++) {
						// MONO
						if(!isAudioDataStereo) {
							audioDataListChannel1.add(audioData[i]);
							audioDataListChannel2.add(audioData[i]);
						}
						// STEREO (LEFT)
						else if(nTotalBytesRead%4<2) {
							audioDataListChannel1.add(audioData[i]);
						}
						// STEREO (RIGHT)
						else {
							audioDataListChannel2.add(audioData[i]);
						}

						// Update the total amount of bytes we've read
						nTotalBytesRead++;
					}
				}

				// Throw Exception if sample is too big
				if(nTotalBytesRead>EsxUtil.MAX_NUM_SAMPLES*2) {
					throw new EsxException("Sample is too big: " + file.getAbsolutePath());
				}
			}

			// Set member variables
			int frameLength = audioDataListChannel1.size();
			this.setNumberOfSampleFrames(frameLength);
			this.setEnd(frameLength-1);
			this.setLoopStart(frameLength-1);
			this.setSampleRate((int) audioFormatEncoded.getSampleRate());
			this.setAudioDataChannel1(EsxUtil.listToByteArray(audioDataListChannel1));
			this.setAudioDataChannel2(EsxUtil.listToByteArray(audioDataListChannel2));
		
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
			throw new EsxException("Invalid audio file: " + file.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
			throw new EsxException("Invalid audio file: " + file.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
			throw new EsxException("Invalid audio file: " + file.getAbsolutePath());
		}

		String newSampleName = StringUtils.left(StringUtils.trim(file.getName()), 8);
		this.setName(newSampleName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsxPackage.Literals.SAMPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOffsetChannel1Start() {
		return offsetChannel1Start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffsetChannel1Start(int newOffsetChannel1Start) {
		int oldOffsetChannel1Start = offsetChannel1Start;
		offsetChannel1Start = newOffsetChannel1Start;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__OFFSET_CHANNEL1_START, oldOffsetChannel1Start, offsetChannel1Start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOffsetChannel1End() {
		return offsetChannel1End;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffsetChannel1End(int newOffsetChannel1End) {
		int oldOffsetChannel1End = offsetChannel1End;
		offsetChannel1End = newOffsetChannel1End;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__OFFSET_CHANNEL1_END, oldOffsetChannel1End, offsetChannel1End));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOffsetChannel2Start() {
		return offsetChannel2Start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffsetChannel2Start(int newOffsetChannel2Start) {
		int oldOffsetChannel2Start = offsetChannel2Start;
		offsetChannel2Start = newOffsetChannel2Start;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__OFFSET_CHANNEL2_START, oldOffsetChannel2Start, offsetChannel2Start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOffsetChannel2End() {
		return offsetChannel2End;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffsetChannel2End(int newOffsetChannel2End) {
		int oldOffsetChannel2End = offsetChannel2End;
		offsetChannel2End = newOffsetChannel2End;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__OFFSET_CHANNEL2_END, oldOffsetChannel2End, offsetChannel2End));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(int newStart) {
		int oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd(int newEnd) {
		int oldEnd = end;
		end = newEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__END, oldEnd, end));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLoopStart() {
		return loopStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopStart(int newLoopStart) {
		int oldLoopStart = loopStart;
		loopStart = newLoopStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__LOOP_START, oldLoopStart, loopStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSampleRate() {
		return sampleRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSampleRate(int newSampleRate) {
		int oldSampleRate = sampleRate;
		sampleRate = newSampleRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__SAMPLE_RATE, oldSampleRate, sampleRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SampleTune getSampleTune() {
		return sampleTune;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSampleTune(SampleTune newSampleTune, NotificationChain msgs) {
		SampleTune oldSampleTune = sampleTune;
		sampleTune = newSampleTune;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__SAMPLE_TUNE, oldSampleTune, newSampleTune);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSampleTune(SampleTune newSampleTune) {
		if (newSampleTune != sampleTune) {
			NotificationChain msgs = null;
			if (sampleTune != null)
				msgs = ((InternalEObject)sampleTune).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsxPackage.SAMPLE__SAMPLE_TUNE, null, msgs);
			if (newSampleTune != null)
				msgs = ((InternalEObject)newSampleTune).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsxPackage.SAMPLE__SAMPLE_TUNE, null, msgs);
			msgs = basicSetSampleTune(newSampleTune, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__SAMPLE_TUNE, newSampleTune, newSampleTune));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfSampleFrames() {
		return numberOfSampleFrames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfSampleFrames(int newNumberOfSampleFrames) {
		int oldNumberOfSampleFrames = numberOfSampleFrames;
		numberOfSampleFrames = newNumberOfSampleFrames;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__NUMBER_OF_SAMPLE_FRAMES, oldNumberOfSampleFrames, numberOfSampleFrames));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlayLevel getPlayLevel() {
		return playLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlayLevel(PlayLevel newPlayLevel) {
		PlayLevel oldPlayLevel = playLevel;
		playLevel = newPlayLevel == null ? PLAY_LEVEL_EDEFAULT : newPlayLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__PLAY_LEVEL, oldPlayLevel, playLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte getUnknownByte1() {
		return unknownByte1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnknownByte1(byte newUnknownByte1) {
		byte oldUnknownByte1 = unknownByte1;
		unknownByte1 = newUnknownByte1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__UNKNOWN_BYTE1, oldUnknownByte1, unknownByte1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StretchStep getStretchStep() {
		return stretchStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStretchStep(StretchStep newStretchStep) {
		StretchStep oldStretchStep = stretchStep;
		stretchStep = newStretchStep == null ? STRETCH_STEP_EDEFAULT : newStretchStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__STRETCH_STEP, oldStretchStep, stretchStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte getUnknownByte2() {
		return unknownByte2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnknownByte2(byte newUnknownByte2) {
		byte oldUnknownByte2 = unknownByte2;
		unknownByte2 = newUnknownByte2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__UNKNOWN_BYTE2, oldUnknownByte2, unknownByte2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte getUnknownByte3() {
		return unknownByte3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnknownByte3(byte newUnknownByte3) {
		byte oldUnknownByte3 = unknownByte3;
		unknownByte3 = newUnknownByte3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__UNKNOWN_BYTE3, oldUnknownByte3, unknownByte3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte getUnknownByte4() {
		return unknownByte4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnknownByte4(byte newUnknownByte4) {
		byte oldUnknownByte4 = unknownByte4;
		unknownByte4 = newUnknownByte4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__UNKNOWN_BYTE4, oldUnknownByte4, unknownByte4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getAudioDataChannel1() {
		return audioDataChannel1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAudioDataChannel1(byte[] newAudioDataChannel1) {
		byte[] oldAudioDataChannel1 = audioDataChannel1;
		audioDataChannel1 = newAudioDataChannel1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__AUDIO_DATA_CHANNEL1, oldAudioDataChannel1, audioDataChannel1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getAudioDataChannel2() {
		return audioDataChannel2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAudioDataChannel2(byte[] newAudioDataChannel2) {
		byte[] oldAudioDataChannel2 = audioDataChannel2;
		audioDataChannel2 = newAudioDataChannel2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__AUDIO_DATA_CHANNEL2, oldAudioDataChannel2, audioDataChannel2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getSliceArray() {
		return sliceArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSliceArray(byte[] newSliceArray) {
		byte[] oldSliceArray = sliceArray;
		sliceArray = newSliceArray;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__SLICE_ARRAY, oldSliceArray, sliceArray));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SampleNumber getSampleNumberOriginal() {
		return sampleNumberOriginal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSampleNumberOriginal(SampleNumber newSampleNumberOriginal) {
		SampleNumber oldSampleNumberOriginal = sampleNumberOriginal;
		sampleNumberOriginal = newSampleNumberOriginal == null ? SAMPLE_NUMBER_ORIGINAL_EDEFAULT : newSampleNumberOriginal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE__SAMPLE_NUMBER_ORIGINAL, oldSampleNumberOriginal, sampleNumberOriginal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SampleNumber getSampleNumberCurrent() {
		if(this.eResource()!=null) {
			Resource resource = (Resource) this.eResource();
			Object rootObject = resource.getContents().get(0);
			if(rootObject instanceof EsxFile) {
				return SampleNumber.get(((EsxFile) rootObject).getSamples().indexOf(this));
			}
		}
		return SampleNumber.get(-1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsxPackage.SAMPLE__SAMPLE_TUNE:
				return basicSetSampleTune(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isLoop() {
		return (this.end!=this.loopStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSlice() {
		return (
			this.getSliceArray()!=null && this.getSliceArray().length>0 && (
				this.getUnknownByte2()!=0x00 ||
				this.getUnknownByte3()!=0x00 ||
				this.getUnknownByte4()!=0x00
			)
		);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isBeingUsed() {
		if(this.getAudioDataChannel1()!=null && this.getAudioDataChannel1().length>0)
			return true;
		else
			return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isStereo() {
		return this.getSampleNumberCurrent().getValue() >= EsxUtil.NUM_SAMPLES_MONO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getMemUsedInBytes() {
		if(this.isBeingUsed()) {
			if(this.isStereo()) {
				return this.numberOfSampleFrames * 4;
			}
			else {
				return this.numberOfSampleFrames * 2;
			}
		}
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsxPackage.SAMPLE__NAME:
				return getName();
			case EsxPackage.SAMPLE__OFFSET_CHANNEL1_START:
				return getOffsetChannel1Start();
			case EsxPackage.SAMPLE__OFFSET_CHANNEL1_END:
				return getOffsetChannel1End();
			case EsxPackage.SAMPLE__OFFSET_CHANNEL2_START:
				return getOffsetChannel2Start();
			case EsxPackage.SAMPLE__OFFSET_CHANNEL2_END:
				return getOffsetChannel2End();
			case EsxPackage.SAMPLE__START:
				return getStart();
			case EsxPackage.SAMPLE__END:
				return getEnd();
			case EsxPackage.SAMPLE__LOOP_START:
				return getLoopStart();
			case EsxPackage.SAMPLE__SAMPLE_RATE:
				return getSampleRate();
			case EsxPackage.SAMPLE__SAMPLE_TUNE:
				return getSampleTune();
			case EsxPackage.SAMPLE__NUMBER_OF_SAMPLE_FRAMES:
				return getNumberOfSampleFrames();
			case EsxPackage.SAMPLE__PLAY_LEVEL:
				return getPlayLevel();
			case EsxPackage.SAMPLE__UNKNOWN_BYTE1:
				return getUnknownByte1();
			case EsxPackage.SAMPLE__STRETCH_STEP:
				return getStretchStep();
			case EsxPackage.SAMPLE__UNKNOWN_BYTE2:
				return getUnknownByte2();
			case EsxPackage.SAMPLE__UNKNOWN_BYTE3:
				return getUnknownByte3();
			case EsxPackage.SAMPLE__UNKNOWN_BYTE4:
				return getUnknownByte4();
			case EsxPackage.SAMPLE__AUDIO_DATA_CHANNEL1:
				return getAudioDataChannel1();
			case EsxPackage.SAMPLE__AUDIO_DATA_CHANNEL2:
				return getAudioDataChannel2();
			case EsxPackage.SAMPLE__SLICE_ARRAY:
				return getSliceArray();
			case EsxPackage.SAMPLE__LOOP:
				return isLoop();
			case EsxPackage.SAMPLE__SLICE:
				return isSlice();
			case EsxPackage.SAMPLE__STEREO:
				return isStereo();
			case EsxPackage.SAMPLE__MEM_USED_IN_BYTES:
				return getMemUsedInBytes();
			case EsxPackage.SAMPLE__BEING_USED:
				return isBeingUsed();
			case EsxPackage.SAMPLE__SAMPLE_NUMBER_ORIGINAL:
				return getSampleNumberOriginal();
			case EsxPackage.SAMPLE__SAMPLE_NUMBER_CURRENT:
				return getSampleNumberCurrent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsxPackage.SAMPLE__NAME:
				setName((String)newValue);
				return;
			case EsxPackage.SAMPLE__OFFSET_CHANNEL1_START:
				setOffsetChannel1Start((Integer)newValue);
				return;
			case EsxPackage.SAMPLE__OFFSET_CHANNEL1_END:
				setOffsetChannel1End((Integer)newValue);
				return;
			case EsxPackage.SAMPLE__OFFSET_CHANNEL2_START:
				setOffsetChannel2Start((Integer)newValue);
				return;
			case EsxPackage.SAMPLE__OFFSET_CHANNEL2_END:
				setOffsetChannel2End((Integer)newValue);
				return;
			case EsxPackage.SAMPLE__START:
				setStart((Integer)newValue);
				return;
			case EsxPackage.SAMPLE__END:
				setEnd((Integer)newValue);
				return;
			case EsxPackage.SAMPLE__LOOP_START:
				setLoopStart((Integer)newValue);
				return;
			case EsxPackage.SAMPLE__SAMPLE_RATE:
				setSampleRate((Integer)newValue);
				return;
			case EsxPackage.SAMPLE__SAMPLE_TUNE:
				setSampleTune((SampleTune)newValue);
				return;
			case EsxPackage.SAMPLE__NUMBER_OF_SAMPLE_FRAMES:
				setNumberOfSampleFrames((Integer)newValue);
				return;
			case EsxPackage.SAMPLE__PLAY_LEVEL:
				setPlayLevel((PlayLevel)newValue);
				return;
			case EsxPackage.SAMPLE__UNKNOWN_BYTE1:
				setUnknownByte1((Byte)newValue);
				return;
			case EsxPackage.SAMPLE__STRETCH_STEP:
				setStretchStep((StretchStep)newValue);
				return;
			case EsxPackage.SAMPLE__UNKNOWN_BYTE2:
				setUnknownByte2((Byte)newValue);
				return;
			case EsxPackage.SAMPLE__UNKNOWN_BYTE3:
				setUnknownByte3((Byte)newValue);
				return;
			case EsxPackage.SAMPLE__UNKNOWN_BYTE4:
				setUnknownByte4((Byte)newValue);
				return;
			case EsxPackage.SAMPLE__AUDIO_DATA_CHANNEL1:
				setAudioDataChannel1((byte[])newValue);
				return;
			case EsxPackage.SAMPLE__AUDIO_DATA_CHANNEL2:
				setAudioDataChannel2((byte[])newValue);
				return;
			case EsxPackage.SAMPLE__SLICE_ARRAY:
				setSliceArray((byte[])newValue);
				return;
			case EsxPackage.SAMPLE__SAMPLE_NUMBER_ORIGINAL:
				setSampleNumberOriginal((SampleNumber)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EsxPackage.SAMPLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__OFFSET_CHANNEL1_START:
				setOffsetChannel1Start(OFFSET_CHANNEL1_START_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__OFFSET_CHANNEL1_END:
				setOffsetChannel1End(OFFSET_CHANNEL1_END_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__OFFSET_CHANNEL2_START:
				setOffsetChannel2Start(OFFSET_CHANNEL2_START_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__OFFSET_CHANNEL2_END:
				setOffsetChannel2End(OFFSET_CHANNEL2_END_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__START:
				setStart(START_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__END:
				setEnd(END_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__LOOP_START:
				setLoopStart(LOOP_START_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__SAMPLE_RATE:
				setSampleRate(SAMPLE_RATE_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__SAMPLE_TUNE:
				setSampleTune((SampleTune)null);
				return;
			case EsxPackage.SAMPLE__NUMBER_OF_SAMPLE_FRAMES:
				setNumberOfSampleFrames(NUMBER_OF_SAMPLE_FRAMES_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__PLAY_LEVEL:
				setPlayLevel(PLAY_LEVEL_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__UNKNOWN_BYTE1:
				setUnknownByte1(UNKNOWN_BYTE1_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__STRETCH_STEP:
				setStretchStep(STRETCH_STEP_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__UNKNOWN_BYTE2:
				setUnknownByte2(UNKNOWN_BYTE2_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__UNKNOWN_BYTE3:
				setUnknownByte3(UNKNOWN_BYTE3_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__UNKNOWN_BYTE4:
				setUnknownByte4(UNKNOWN_BYTE4_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__AUDIO_DATA_CHANNEL1:
				setAudioDataChannel1(AUDIO_DATA_CHANNEL1_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__AUDIO_DATA_CHANNEL2:
				setAudioDataChannel2(AUDIO_DATA_CHANNEL2_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__SLICE_ARRAY:
				setSliceArray(SLICE_ARRAY_EDEFAULT);
				return;
			case EsxPackage.SAMPLE__SAMPLE_NUMBER_ORIGINAL:
				setSampleNumberOriginal(SAMPLE_NUMBER_ORIGINAL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EsxPackage.SAMPLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EsxPackage.SAMPLE__OFFSET_CHANNEL1_START:
				return offsetChannel1Start != OFFSET_CHANNEL1_START_EDEFAULT;
			case EsxPackage.SAMPLE__OFFSET_CHANNEL1_END:
				return offsetChannel1End != OFFSET_CHANNEL1_END_EDEFAULT;
			case EsxPackage.SAMPLE__OFFSET_CHANNEL2_START:
				return offsetChannel2Start != OFFSET_CHANNEL2_START_EDEFAULT;
			case EsxPackage.SAMPLE__OFFSET_CHANNEL2_END:
				return offsetChannel2End != OFFSET_CHANNEL2_END_EDEFAULT;
			case EsxPackage.SAMPLE__START:
				return start != START_EDEFAULT;
			case EsxPackage.SAMPLE__END:
				return end != END_EDEFAULT;
			case EsxPackage.SAMPLE__LOOP_START:
				return loopStart != LOOP_START_EDEFAULT;
			case EsxPackage.SAMPLE__SAMPLE_RATE:
				return sampleRate != SAMPLE_RATE_EDEFAULT;
			case EsxPackage.SAMPLE__SAMPLE_TUNE:
				return sampleTune != null;
			case EsxPackage.SAMPLE__NUMBER_OF_SAMPLE_FRAMES:
				return numberOfSampleFrames != NUMBER_OF_SAMPLE_FRAMES_EDEFAULT;
			case EsxPackage.SAMPLE__PLAY_LEVEL:
				return playLevel != PLAY_LEVEL_EDEFAULT;
			case EsxPackage.SAMPLE__UNKNOWN_BYTE1:
				return unknownByte1 != UNKNOWN_BYTE1_EDEFAULT;
			case EsxPackage.SAMPLE__STRETCH_STEP:
				return stretchStep != STRETCH_STEP_EDEFAULT;
			case EsxPackage.SAMPLE__UNKNOWN_BYTE2:
				return unknownByte2 != UNKNOWN_BYTE2_EDEFAULT;
			case EsxPackage.SAMPLE__UNKNOWN_BYTE3:
				return unknownByte3 != UNKNOWN_BYTE3_EDEFAULT;
			case EsxPackage.SAMPLE__UNKNOWN_BYTE4:
				return unknownByte4 != UNKNOWN_BYTE4_EDEFAULT;
			case EsxPackage.SAMPLE__AUDIO_DATA_CHANNEL1:
				return AUDIO_DATA_CHANNEL1_EDEFAULT == null ? audioDataChannel1 != null : !AUDIO_DATA_CHANNEL1_EDEFAULT.equals(audioDataChannel1);
			case EsxPackage.SAMPLE__AUDIO_DATA_CHANNEL2:
				return AUDIO_DATA_CHANNEL2_EDEFAULT == null ? audioDataChannel2 != null : !AUDIO_DATA_CHANNEL2_EDEFAULT.equals(audioDataChannel2);
			case EsxPackage.SAMPLE__SLICE_ARRAY:
				return SLICE_ARRAY_EDEFAULT == null ? sliceArray != null : !SLICE_ARRAY_EDEFAULT.equals(sliceArray);
			case EsxPackage.SAMPLE__LOOP:
				return isLoop() != LOOP_EDEFAULT;
			case EsxPackage.SAMPLE__SLICE:
				return isSlice() != SLICE_EDEFAULT;
			case EsxPackage.SAMPLE__STEREO:
				return isStereo() != STEREO_EDEFAULT;
			case EsxPackage.SAMPLE__MEM_USED_IN_BYTES:
				return getMemUsedInBytes() != MEM_USED_IN_BYTES_EDEFAULT;
			case EsxPackage.SAMPLE__BEING_USED:
				return isBeingUsed() != BEING_USED_EDEFAULT;
			case EsxPackage.SAMPLE__SAMPLE_NUMBER_ORIGINAL:
				return sampleNumberOriginal != SAMPLE_NUMBER_ORIGINAL_EDEFAULT;
			case EsxPackage.SAMPLE__SAMPLE_NUMBER_CURRENT:
				return getSampleNumberCurrent() != SAMPLE_NUMBER_CURRENT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", offsetChannel1Start: ");
		result.append(offsetChannel1Start);
		result.append(", offsetChannel1End: ");
		result.append(offsetChannel1End);
		result.append(", offsetChannel2Start: ");
		result.append(offsetChannel2Start);
		result.append(", offsetChannel2End: ");
		result.append(offsetChannel2End);
		result.append(", start: ");
		result.append(start);
		result.append(", end: ");
		result.append(end);
		result.append(", loopStart: ");
		result.append(loopStart);
		result.append(", sampleRate: ");
		result.append(sampleRate);
		result.append(", numberOfSampleFrames: ");
		result.append(numberOfSampleFrames);
		result.append(", playLevel: ");
		result.append(playLevel);
		result.append(", unknownByte1: ");
		result.append(unknownByte1);
		result.append(", stretchStep: ");
		result.append(stretchStep);
		result.append(", unknownByte2: ");
		result.append(unknownByte2);
		result.append(", unknownByte3: ");
		result.append(unknownByte3);
		result.append(", unknownByte4: ");
		result.append(unknownByte4);
		result.append(", audioDataChannel1: ");
		result.append(audioDataChannel1);
		result.append(", audioDataChannel2: ");
		result.append(audioDataChannel2);
		result.append(", sliceArray: ");
		result.append(sliceArray);
		result.append(", sampleNumberOriginal: ");
		result.append(sampleNumberOriginal);
		result.append(')');
		return result.toString();
	}

	@Override
	public AudioInputStream getAudioInputStream() {
		byte[] left = this.getAudioDataChannel1();
		byte[] right = this.getAudioDataChannel2();
		byte[] both = new byte[left.length + right.length];

		// Combine left and right channels to one stream
		// In try/catch to catch array out of bounds
		// TODO: This logic should be fixed so out of bounds
		// never occurs. Too lazy to fix right now.
		try {
			for (int i = 0, j = 0; j < this.getNumberOfSampleFrames()*2; i = i + 4, j = j+2) {
				both[i] = left[j];
				both[i + 1] = left[j + 1];
				both[i + 2] = right[j];
				both[i + 3] = right[j + 1];
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		// Create audioInputStream
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(both);
		AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, // Encoding
				(float) this.getSampleRate(), // sampleRate
				16, // sampleSizeInBits
				2, // channels
				4, // frameSize ( (sampleSizeInBits*channels)/8 )
				this.getSampleRate(), // frameRate
				true // bigEndian
		);
		AudioInputStream audioInputStream = new AudioInputStream(byteArrayInputStream, audioFormat,
				this.getNumberOfSampleFrames()*2);

		return audioInputStream;
	}

} //SampleImpl
