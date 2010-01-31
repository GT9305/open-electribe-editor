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

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.EClass;

import com.skratchdot.electribe.model.esx.EsxFactory;
import com.skratchdot.electribe.model.esx.EsxPackage;
import com.skratchdot.electribe.model.esx.PlayLevel;
import com.skratchdot.electribe.model.esx.SampleNumber;
import com.skratchdot.electribe.model.esx.SampleStereo;
import com.skratchdot.electribe.model.esx.SampleTune;
import com.skratchdot.electribe.model.esx.StretchStep;
import com.skratchdot.electribe.model.esx.util.EsxException;
import com.skratchdot.electribe.model.esx.util.EsxRandomAccess;
import com.skratchdot.electribe.model.esx.util.EsxUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sample Stereo</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SampleStereoImpl extends SampleImpl implements SampleStereo {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SampleStereoImpl() {
		super();
	}

	public SampleStereoImpl(EsxRandomAccess in, int stereoSampleNumber) throws EsxException, IOException {
		// Stop immediately if we are passed an invalid stereoSampleNumber
		if (stereoSampleNumber >= EsxUtil.NUM_SAMPLES_STEREO || stereoSampleNumber < 0)
			throw new EsxException("Invalid stereoSampleNumber: " + stereoSampleNumber);

		// Jump to the start of stereoSampleNumber's header data
		in.seek(EsxUtil.ADDR_SAMPLE_HEADER_STEREO + (stereoSampleNumber * EsxUtil.CHUNKSIZE_SAMPLE_HEADER_STEREO));

		// Set the original .esx file sample number
		this.setSampleNumberOriginal(SampleNumber.get(stereoSampleNumber+EsxUtil.NUM_SAMPLES_MONO));

		// bytes 0~7
		byte[] newSampleName = new byte[8];
		in.read(newSampleName, 0, 8);
		this.setName(new String(newSampleName));

		// bytes 8~11
		this.setOffsetChannel1Start(in.readInt());
		// bytes 12~15
		this.setOffsetChannel1End(in.readInt());
		// bytes 16~19
		this.setOffsetChannel2Start(in.readInt());
		// bytes 20~23
		this.setOffsetChannel2End(in.readInt());
		// bytes 24~27
		this.setStart(in.readInt());
		// bytes 28~31
		this.setEnd(in.readInt());
		// bytes 32~35
		this.setSampleRate(in.readInt());
		// bytes 36~37
		SampleTune newSampleTune = EsxFactory.eINSTANCE.createSampleTune();
		newSampleTune.setCurrentValueFromShort(in.readShort());
		this.setSampleTune(newSampleTune);
		// byte 38
		this.setPlayLevel(PlayLevel.get(in.readByte()));
		// byte 39
		this.setUnknownByte1(in.readByte());
		// byte 40
		this.setStretchStep(StretchStep.get(in.readByte()));
		// byte 41
		this.setUnknownByte2(in.readByte());
		// byte 42
		this.setUnknownByte3(in.readByte());
		// byte 43
		this.setUnknownByte4(in.readByte());

		// Determine if there is a valid sample to read in
		int offset1Size = this.getOffsetChannel1End() - this.getOffsetChannel1Start();
		int offset2Size = this.getOffsetChannel2End() - this.getOffsetChannel2Start();
		if (offset1Size == offset2Size
				&& offset1Size > 0
				&& offset2Size > 0
				&& this.getOffsetChannel1Start() != 0xFFFFFFFF
				&& this.getOffsetChannel1End() != 0xFFFFFFFF
				&& this.getOffsetChannel2Start() != 0xFFFFFFFF
				&& this.getOffsetChannel2End() != 0xFFFFFFFF) {

			// Declare temp byte[]
			byte[] newAudioDataChannel;

			// Get number of sample frames
			int newNumberOfSampleFrames = ((offset1Size - 16) / 2);
			this.setNumberOfSampleFrames(newNumberOfSampleFrames);

			// Read in audioDataChannel1
			newAudioDataChannel = new byte[newNumberOfSampleFrames * 2];
			in.seek(EsxUtil.ADDR_SAMPLE_DATA + this.getOffsetChannel1Start() + 16);
			for (int i = 0; i < newAudioDataChannel.length; i++) {
				newAudioDataChannel[i] = in.readByte();
			}
			this.setAudioDataChannel1(newAudioDataChannel);

			// Read in audioDataChannel2
			newAudioDataChannel = new byte[newNumberOfSampleFrames * 2];
			in.seek(EsxUtil.ADDR_SAMPLE_DATA + this.getOffsetChannel2Start() + 16);
			for (int i = 0; i < newAudioDataChannel.length; i++) {
				newAudioDataChannel[i] = in.readByte();
			}
			this.setAudioDataChannel2(newAudioDataChannel);

		}


	}

	public SampleStereoImpl(File file) throws EsxException {
		super(file);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsxPackage.Literals.SAMPLE_STEREO;
	}

	@Override
	public void writeHeader(EsxRandomAccess out, int stereoSampleNumber) throws EsxException, IOException {
		// Stop immediately if we are passed an invalid stereoSampleNumber
		if (stereoSampleNumber >= EsxUtil.NUM_SAMPLES_STEREO || stereoSampleNumber < 0)
			throw new EsxException("Invalid stereoSampleNumber: " + stereoSampleNumber);

		// Jump to the start of stereoSampleNumber's header data
		out.seek(EsxUtil.ADDR_SAMPLE_HEADER_STEREO + (stereoSampleNumber * EsxUtil.CHUNKSIZE_SAMPLE_HEADER_STEREO));

		// bytes 0~7
		out.write(EsxUtil.getByteArrayWithLength(this.getName(), 8, (byte) 0x00), 0, 8);
		// bytes 8~11
		out.writeInt(this.getOffsetChannel1Start());
		// bytes 12~15
		out.writeInt(this.getOffsetChannel1End());
		// bytes 16~19
		out.writeInt(this.getOffsetChannel2Start());
		// bytes 20~23
		out.writeInt(this.getOffsetChannel2End());
		// bytes 24~27
		out.writeInt(this.getStart());
		// bytes 28~31
		out.writeInt(this.getEnd());
		// bytes 32~35
		out.writeInt(this.getSampleRate());
		// bytes 36~37
		out.writeShort(this.getSampleTune().getShortFromCurrentValue());
		// byte 38
		out.writeByte(this.getPlayLevel().getValue());
		// byte 39
		out.writeByte(this.getUnknownByte1());
		// byte 40
		out.writeByte(this.getStretchStep().getValue());
		// byte 41
		out.writeByte(this.getUnknownByte2());
		// byte 42
		out.writeByte(this.getUnknownByte3());
		// byte 43
		out.writeByte(this.getUnknownByte4());
	}

} //SampleStereoImpl
