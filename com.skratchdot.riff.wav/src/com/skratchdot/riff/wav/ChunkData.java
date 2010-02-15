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
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Chunk Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.skratchdot.riff.wav.ChunkData#getChannels <em>Channels</em>}</li>
 *   <li>{@link com.skratchdot.riff.wav.ChunkData#getSampleDataOriginal <em>Sample Data Original</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.skratchdot.riff.wav.WavPackage#getChunkData()
 * @model
 * @generated
 */
public interface ChunkData extends Chunk {
	/**
	 * Returns the value of the '<em><b>Channels</b></em>' containment reference list.
	 * The list contents are of type {@link com.skratchdot.riff.wav.Channel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channels</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channels</em>' containment reference list.
	 * @see com.skratchdot.riff.wav.WavPackage#getChunkData_Channels()
	 * @model containment="true"
	 * @generated
	 */
	EList<Channel> getChannels();

	/**
	 * Returns the value of the '<em><b>Sample Data Original</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sample Data Original</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sample Data Original</em>' attribute.
	 * @see #setSampleDataOriginal(byte[])
	 * @see com.skratchdot.riff.wav.WavPackage#getChunkData_SampleDataOriginal()
	 * @model
	 * @generated
	 */
	byte[] getSampleDataOriginal();

	/**
	 * Sets the value of the '{@link com.skratchdot.riff.wav.ChunkData#getSampleDataOriginal <em>Sample Data Original</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sample Data Original</em>' attribute.
	 * @see #getSampleDataOriginal()
	 * @generated
	 */
	void setSampleDataOriginal(byte[] value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="com.skratchdot.riff.wav.IOException" outDataType="com.skratchdot.riff.wav.WavRandomAccessFile"
	 * @generated
	 */
	void write(RIFFWave riffWave, WavRandomAccessFile out) throws IOException;

} // ChunkData
