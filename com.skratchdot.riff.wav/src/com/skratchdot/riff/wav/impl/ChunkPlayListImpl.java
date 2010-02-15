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
package com.skratchdot.riff.wav.impl;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.skratchdot.riff.wav.ChunkPlayList;
import com.skratchdot.riff.wav.ChunkTypeID;
import com.skratchdot.riff.wav.ParseChunkException;
import com.skratchdot.riff.wav.RIFFWave;
import com.skratchdot.riff.wav.Segment;
import com.skratchdot.riff.wav.WavFactory;
import com.skratchdot.riff.wav.WavPackage;
import com.skratchdot.riff.wav.util.RiffWaveException;
import com.skratchdot.riff.wav.util.WavRandomAccessFile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Chunk Play List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.skratchdot.riff.wav.impl.ChunkPlayListImpl#getNumberOfSegments <em>Number Of Segments</em>}</li>
 *   <li>{@link com.skratchdot.riff.wav.impl.ChunkPlayListImpl#getSegments <em>Segments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChunkPlayListImpl extends ChunkImpl implements ChunkPlayList {
	/**
	 * The default value of the '{@link #getNumberOfSegments() <em>Number Of Segments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfSegments()
	 * @generated
	 * @ordered
	 */
	protected static final Long NUMBER_OF_SEGMENTS_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSegments() <em>Segments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSegments()
	 * @generated
	 * @ordered
	 */
	protected EList<Segment> segments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChunkPlayListImpl() {
		super();
	}

	/**
	 * @param riffWave a valid RIFFWave object
	 * @param in a valid WavRandomAccessFile
	 * @throws RiffWaveException
	 */
	public ChunkPlayListImpl(RIFFWave riffWave, WavRandomAccessFile in) throws RiffWaveException {
		super();
		try {
			// Check Chunk Type ID
			if(ChunkTypeID.get((int)in.readUnsignedInt())!=this.getChunkTypeID())
				throw new RiffWaveException("Invalid Chunk ID for "+this.getChunkTypeID().getLiteral());

			// Read in data size
			long chunkSize = in.readUnsignedInt();

			// Read in segments
			long numSegments = in.readUnsignedInt();
			for(int i=0; i<numSegments; i++) {
				Segment segment = WavFactory.eINSTANCE.createSegment();
				segment.setCuePointID(in.readUnsignedInt());
				segment.setLengthInSamples(in.readUnsignedInt());
				segment.setNumberOfRepeats(in.readUnsignedInt());
				this.getSegments().add(segment);
			}

			// Does the size we read in match the size we calculate from the data read in?
			if(chunkSize!=this.getSize()) {
				ParseChunkException pce = WavFactory.eINSTANCE.createParseChunkException();
				pce.setException(new Exception("Invalid chunk size for format chunk." +
					"From File: " + Long.toString(chunkSize) +
					"Calculated: " + Long.toString(this.getSize())
				));
				riffWave.getParseChunkExceptions().add(pce);
			}

		} catch (Exception e) {
			throw new RiffWaveException(e.getMessage(), e.getCause());
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WavPackage.Literals.CHUNK_PLAY_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Long getNumberOfSegments() {
		return this.getSegments()==null?0:(long)this.getSegments().size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Segment> getSegments() {
		if (segments == null) {
			segments = new EObjectResolvingEList<Segment>(Segment.class, this, WavPackage.CHUNK_PLAY_LIST__SEGMENTS);
		}
		return segments;
	}

	/* (non-Javadoc)
	 * @see com.skratchdot.riff.wav.impl.ChunkImpl#getChunkTypeID()
	 */
	@Override
	public ChunkTypeID getChunkTypeID() {
		return ChunkTypeID.PLST;
	}

	/* (non-Javadoc)
	 * @see com.skratchdot.riff.wav.impl.ChunkImpl#getChunkTypeIDValue()
	 */
	@Override
	public int getChunkTypeIDValue() {
		return ChunkTypeID.PLST_VALUE;
	}

	/* (non-Javadoc)
	 * @see com.skratchdot.riff.wav.impl.ChunkImpl#getSize()
	 */
	@Override
	public long getSize() {
		return 4 + (this.getNumberOfSegments() * 12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WavPackage.CHUNK_PLAY_LIST__NUMBER_OF_SEGMENTS:
				return getNumberOfSegments();
			case WavPackage.CHUNK_PLAY_LIST__SEGMENTS:
				return getSegments();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WavPackage.CHUNK_PLAY_LIST__SEGMENTS:
				getSegments().clear();
				getSegments().addAll((Collection<? extends Segment>)newValue);
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
			case WavPackage.CHUNK_PLAY_LIST__SEGMENTS:
				getSegments().clear();
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
			case WavPackage.CHUNK_PLAY_LIST__NUMBER_OF_SEGMENTS:
				return NUMBER_OF_SEGMENTS_EDEFAULT == null ? getNumberOfSegments() != null : !NUMBER_OF_SEGMENTS_EDEFAULT.equals(getNumberOfSegments());
			case WavPackage.CHUNK_PLAY_LIST__SEGMENTS:
				return segments != null && !segments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void write(RIFFWave riffWave, WavRandomAccessFile out) throws IOException {
		out.writeUnsignedInt(this.getChunkTypeIDValue());
		out.writeUnsignedInt(this.getSize());
		
		out.writeUnsignedInt(this.getNumberOfSegments());

		for(int i=0; i<this.getNumberOfSegments(); i++) {
			out.writeUnsignedInt(this.getSegments().get(i).getCuePointID());
			out.writeUnsignedInt(this.getSegments().get(i).getLengthInSamples());
			out.writeUnsignedInt(this.getSegments().get(i).getNumberOfRepeats());
		}
	}

} //ChunkPlayListImpl
