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
import com.skratchdot.electribe.model.esx.SampleMono;
import com.skratchdot.electribe.model.esx.SampleNumber;
import com.skratchdot.electribe.model.esx.SampleTune;
import com.skratchdot.electribe.model.esx.StretchStep;
import com.skratchdot.electribe.model.esx.util.EsxException;
import com.skratchdot.electribe.model.esx.util.EsxRandomAccess;
import com.skratchdot.electribe.model.esx.util.EsxUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sample Mono</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SampleMonoImpl extends SampleImpl implements SampleMono {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected SampleMonoImpl() {
		super();
		init();
	}
	
	/**
	 * @param in A valid Esx file in EsxRandomAccess form
	 * @param monoSampleNumber A valid mono sample number 0-255
	 * @throws EsxException
	 * @throws IOException
	 */
	public SampleMonoImpl(EsxRandomAccess in, int monoSampleNumber) throws EsxException, IOException {
		super();
		init();

		// Stop immediately if we are passed an invalid monoSampleNumber
		if (monoSampleNumber >= EsxUtil.NUM_SAMPLES_MONO || monoSampleNumber < 0)
			throw new EsxException("Invalid monoSampleNumber: " + monoSampleNumber);

		// Jump to the start of monoSampleNumber's header data
		in.seek(EsxUtil.ADDR_SAMPLE_HEADER_MONO + (monoSampleNumber * EsxUtil.CHUNKSIZE_SAMPLE_HEADER_MONO));

		// Set the original .esx file sample number
		this.setSampleNumberOriginal(SampleNumber.get(monoSampleNumber));

		// bytes 0~7
		byte[] newSampleName = new byte[8];
		in.read(newSampleName, 0, 8);
		this.setName(new String(newSampleName));

		// bytes 8~11
		this.setOffsetChannel1Start(in.readInt());
		// bytes 12~15
		this.setOffsetChannel1End(in.readInt());
		// bytes 16~19
		this.setStart(in.readInt());
		// bytes 20~23
		this.setEnd(in.readInt());
		// bytes 24~27
		this.setLoopStart(in.readInt());
		// bytes 28~31
		this.setSampleRate(in.readInt());
		// bytes 32~33
		SampleTune newSampleTune = EsxFactory.eINSTANCE.createSampleTune();
		newSampleTune.setCurrentValueFromShort(in.readShort());
		this.setSampleTune(newSampleTune);
		// byte 34
		this.setPlayLevel(PlayLevel.get(in.readByte()));
		// byte 35
		this.setUnknownByte1(in.readByte());
		// byte 36
		this.setStretchStep(StretchStep.get(in.readByte()));
		// byte 37
		this.setUnknownByte2(in.readByte());
		// byte 38
		this.setUnknownByte3(in.readByte());
		// byte 39
		this.setUnknownByte4(in.readByte());

		// Determine if there is a valid sample to read in
		int offset1Size = this.getOffsetChannel1End() - this.getOffsetChannel1Start();
		if (offset1Size > 0
				&& this.getOffsetChannel1Start() != 0xFFFFFFFF
				&& this.getOffsetChannel1End() != 0xFFFFFFFF) {

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

			// Read in audioDataChannel2 (same as audioDataChannel1)
			this.setAudioDataChannel2(newAudioDataChannel);

			// Read in slice info
			byte[] newSliceArray = new byte[EsxUtil.CHUNKSIZE_SLICE_DATA];
			in.seek(EsxUtil.ADDR_SLICE_DATA + (monoSampleNumber * EsxUtil.CHUNKSIZE_SLICE_DATA));
			for (int i = 0; i < EsxUtil.CHUNKSIZE_SLICE_DATA; i++) {
				newSliceArray[i] = in.readByte();
			}
			this.setSliceArray(newSliceArray);
		}

	}

	/**
	 * @param file A valid Esx file
	 * @throws EsxException
	 */
	public SampleMonoImpl(File file) throws EsxException {
		super(file);
		init();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsxPackage.Literals.SAMPLE_MONO;
	}

	@Override
	public void writeHeader(EsxRandomAccess out, int monoSampleNumber) throws EsxException, IOException {
		// Stop immediately if we are passed an invalid monoSampleNumber
		if (monoSampleNumber >= EsxUtil.NUM_SAMPLES_MONO || monoSampleNumber < 0)
			throw new EsxException("Invalid monoSampleNumber: " + monoSampleNumber);

		// Jump to the start of monoSampleNumber's header data
		out.seek(EsxUtil.ADDR_SAMPLE_HEADER_MONO + (monoSampleNumber * EsxUtil.CHUNKSIZE_SAMPLE_HEADER_MONO));

		// bytes 0~7
		out.write(EsxUtil.getByteArrayWithLength(this.getName(), 8, (byte) 0x00), 0, 8);
		// bytes 8~11
		out.writeInt(this.getOffsetChannel1Start());
		// bytes 12~15
		out.writeInt(this.getOffsetChannel1End());
		// bytes 16~19
		out.writeInt(this.getStart());
		// bytes 20~23
		out.writeInt(this.getEnd());
		// bytes 24~27
		out.writeInt(this.getLoopStart());
		// bytes 28~31
		out.writeInt(this.getSampleRate());
		// bytes 32~33
		out.writeShort(this.getSampleTune().getShortFromCurrentValue());
		// byte 34
		out.writeByte(this.getPlayLevel().getValue());
		// byte 35
		out.writeByte(this.getUnknownByte1());
		// byte 36
		out.writeByte(this.getStretchStep().getValue());
		// byte 37
		out.writeByte(this.getUnknownByte2());
		// byte 38
		out.writeByte(this.getUnknownByte3());
		// byte 39
		out.writeByte(this.getUnknownByte4());
	}

	@Override
	public void writeSlice(EsxRandomAccess out, int monoSampleNumber) throws EsxException, IOException {
		// Stop immediately if we are passed an invalid monoSampleNumber
		if (monoSampleNumber >= EsxUtil.NUM_SAMPLES_MONO || monoSampleNumber < 0)
			throw new EsxException("Invalid monoSampleNumber: " + monoSampleNumber);

		// Jump to the start of monoSampleNumber's slice data
		out.seek(EsxUtil.ADDR_SLICE_DATA + (monoSampleNumber * EsxUtil.CHUNKSIZE_SLICE_DATA));

		// Write slice info
		if(this.getSliceArray()!=null) {
			out.write(this.getSliceArray());
		}
		else {
			out.write(EsxUtil.getByteArrayWithLength("", EsxUtil.CHUNKSIZE_SLICE_DATA, (byte) 0x00));
		}
	}

} //SampleMonoImpl