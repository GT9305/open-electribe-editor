/**
 * Copyright (c) 2010 SKRATCHDOT.COM
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Initial modeling finished using information provided by:
 * 	http://www.sonicspot.com/guide/wavefiles.html
 * 
 * Contributors:
 *     JEFF |:at:| SKRATCHDOT |:dot:| COM
 *
 * $Id$
 */
package com.skratchdot.riff.wav;

import java.io.IOException;

import com.skratchdot.riff.wav.util.WavRandomAccessFile;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Chunk Data List Type Note</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see com.skratchdot.riff.wav.WavPackage#getChunkDataListTypeNote()
 * @model
 * @generated
 */
public interface ChunkDataListTypeNote extends ChunkDataListType {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="com.skratchdot.riff.wav.IOException" outDataType="com.skratchdot.riff.wav.WavRandomAccessFile"
	 * @generated
	 */
	void write(RIFFWave riffWave, WavRandomAccessFile out) throws IOException;
} // ChunkDataListTypeNote
