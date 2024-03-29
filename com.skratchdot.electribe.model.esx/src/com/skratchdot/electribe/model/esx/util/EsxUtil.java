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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EsxUtil {
	public static final int DEFAULT_SAMPLING_RATE = 44100;

	// 0x00000000 -> 0x00000200 (32 unknown bytes)
	public static final int ADDR_VALID_ESX_CHECK_1		= 0x00000000;	// K O R G . . . 0x71 E S X

	// 192 bytes
	public static final int ADDR_GLOBAL_PARAMETERS		= 0x00000020;

	// 0x000000E0 -> 0x00000200 (288 unknown/reserved? bytes)
	public static final int ADDR_UNKNOWN_SECTION_1		= 0x000000E0;

	// 256 patterns at 4280 bytes each
	public static final int ADDR_PATTERN_DATA			= 0x00000200;

	// After getting to ADDR_PATTERN_DATA, the
	// PART data starts at the given offsets.
	public static final int PATTERN_OFFSET_PARTS_DRUM			= 24;
	public static final int PATTERN_OFFSET_PARTS_KEYBOARD		= 330;
	public static final int PATTERN_OFFSET_PARTS_STRETCHSLICE 	= 878;
	public static final int PATTERN_OFFSET_PARTS_AUDIOIN		= 974;
	public static final int PATTERN_OFFSET_PARTS_ACCENT			= 1130;
	public static final int PATTERN_OFFSET_PARAMETERS_FX		= 1148;
	public static final int PATTERN_OFFSET_PARAMETERS_MOTION	= 1160;

	// 0x0010BA00 -> 0x00130000 (148992 unknown/reserved? bytes)
	public static final int ADDR_UNKNOWN_SECTION_2		= 0x0010BA00;

	// 64 songs at 528 bytes each
	public static final int ADDR_SONG_DATA				= 0x00130000;

	// Up to 20000 song events at 8 bytes each
	public static final int ADDR_SONG_EVENT_DATA		= 0x00138400;

	// 0x0015F500 -> 0x001B0000 (330496 unknown/reserved? bytes)
	public static final int ADDR_UNKNOWN_SECTION_3	 	= 0x0015F500;

	// 0x001B0000 -> 0x001B0020 (32 unknown bytes)
	public static final int ADDR_VALID_ESX_CHECK_2		= 0x001B0000;	// K O R G . . . 0x71 B P S

	// Number of mono samples being used (4 bytes)
	public static final int ADDR_NUM_MONO_SAMPLES		= 0x001B0020;

	// Number of stereo samples being used (4 bytes)
	public static final int ADDR_NUM_STEREO_SAMPLES		= 0x001B0024;

	// Current offset
	public static final int ADDR_CURRENT_OFFSET			= 0x001B0028;

	// 0x001B002C -> 0x001B0100 (212 unknown bytes) - likely all null
	public static final int ADDR_DISK_SPACE				= 0x001B0028;	// 4 bytes

	// 256 mono sample headers at 40 bytes each
	public static final int ADDR_SAMPLE_HEADER_MONO	= 0x001B0100;

	// 128 stereo sample headers at 44 bytes each
	public static final int ADDR_SAMPLE_HEADER_STEREO	= 0x001B2900;

	public static final int ADDR_UNKNOWN_SECTION_4 		= 0x001B3F00;
	public static final int ADDR_SLICE_DATA				= 0x001B4200;
	public static final int ADDR_SAMPLE_DATA			= 0x00250000;

	public static final int CHUNKSIZE_GLOBAL_PARAMETERS = 192;
	public static final int CHUNKSIZE_PATTERN = 4280;
	public static final int CHUNKSIZE_SONG = 528;
	public static final int CHUNKSIZE_SONG_EVENT = 8;
	public static final int CHUNKSIZE_SAMPLE_HEADER_MONO = 40;
	public static final int CHUNKSIZE_SAMPLE_HEADER_STEREO = 44;
	public static final int CHUNKSIZE_PARAMETERS_FX = 4;
	public static final int CHUNKSIZE_PARAMETERS_MOTION = 130;
	public static final int CHUNKSIZE_PARTS_DRUM = 34;
	public static final int CHUNKSIZE_PARTS_KEYBOARD = 274;
	public static final int CHUNKSIZE_PARTS_STRETCHSLICE = 32;
	public static final int CHUNKSIZE_PARTS_ACCENT = 18;
	public static final int CHUNKSIZE_PARTS_AUDIOIN = 156;
	public static final int CHUNKSIZE_SLICE_DATA = 2048;

	public static final int NUM_MIDI_CHANNELS = 3;
	public static final int NUM_PART_NOTE_NUMBERS = 13;
	public static final int NUM_MIDI_CONTROL_CHANGE_ASSIGNMENTS = 33;
	public static final int NUM_PATTERN_SET_PARAMETERS = 128;
	public static final int NUM_PATTERNS = 256;
	public static final int NUM_SONGS = 64;
	public static final int NUM_SONG_PATTERNS = 256;
	public static final int NUM_SAMPLES_MONO = 256;
	public static final int NUM_SAMPLES_STEREO = 128;
	public static final int NUM_SAMPLES = NUM_SAMPLES_MONO + NUM_SAMPLES_STEREO;
	public static final int NUM_PARAMETERS_FX = 3;
	public static final int NUM_PARAMETERS_MOTION = 24;
	public static final int NUM_MOTION_OPERATIONS = 128;
	public static final int NUM_PARTS = 16;
	public static final int NUM_PARTS_DRUM = 9;
	public static final int NUM_PARTS_KEYBOARD = 2;
	public static final int NUM_PARTS_STRETCHSLICE = 3;
	public static final int NUM_PARTS_ACCENT = 1;
	public static final int NUM_PARTS_AUDIOIN = 1;
	public static final int NUM_SEQUENCE_DATA = 16;
	public static final int NUM_SEQUENCE_DATA_GATE = 128;
	public static final int NUM_SEQUENCE_DATA_NOTE = 128;
	public static final int NUM_SLICE_DATA = 256;

	//public static final int MAX_NUM_SAMPLES = 12582911;
	public static final int MAX_SAMPLE_MEM_IN_FRAMES = 0xC00000;
	public static final int MAX_SAMPLE_MEM_IN_BYTES = MAX_SAMPLE_MEM_IN_FRAMES*2;
	public static final float MAX_SAMPLE_MEM_IN_SECONDS = (float)MAX_SAMPLE_MEM_IN_FRAMES/44100;
	public static final int MAX_NUM_SONG_EVENTS = 20000;
	public static final int SIZE_FILE_MIN = 0x00250010;
	public static final int SIZE_FILE_MAX = SIZE_FILE_MIN + MAX_SAMPLE_MEM_IN_BYTES;

	/**
	 * @param byteArray
	 * @return
	 */
	public static List<Byte> byteArrayToList(byte[] byteArray) {
		List<Byte> list = new ArrayList<Byte>();
		for(byte b : byteArray) {
			list.add(b);
		}
		return list;
	}

	/**
	 * @param collection The collection of EObjects to search.
	 * @param startingIndex The index to start searching from.
	 * @param skipIndices Don't include these indices in the search
	 * @param feature The feature to search/compare against.
	 * @param value The value to look for.
	 * @param allowLoop If a value isn't found between startingIndex and the end of the collection, then look for a value between 0 and startingIndex.
	 * @return returns The first index of the collection whose feature matches the given value. If not found, returns -1.
	 */
	public static int findFirstIndex(EList<? extends EObject> collection, int startingIndex, ArrayList<Integer> skipIndices, EStructuralFeature feature, Object value, boolean allowLoop) {
		int returnIndex = -1;

		for (int i = 0; i < collection.size(); i++) {
			if (collection.get(i).eGet(feature).equals(value) && !skipIndices.contains(i)) {
				if (i >= startingIndex) {
					return i;
				} else if (returnIndex == -1 && allowLoop==true) {
					returnIndex = i;
				}
			}
		}

		return returnIndex;
	}

	/**
	 * @param input
	 * @param length
	 * @param fillByte
	 * @return
	 */
	public static byte[] getByteArrayWithLength(String input, int length, byte fillByte) {
		byte[] b = new byte[length];
		int i=0;
		for(i=0; i<input.length() && i<length; i++) {
			b[i] = (byte) input.charAt(i);
		}
		for(;i<length; i++) {
			b[i] = fillByte;
		}
		return b;
	}
	
	/**
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static byte[] inputStreamToByteArray(InputStream in) throws IOException {
		int len = 0;
		int available = in.available();
		int bufferSize = 1024;

		// Set bigger bufferSize
		if(available>bufferSize) {
			bufferSize = available;
		}

		// Allocate buffers
		ByteArrayOutputStream out = new ByteArrayOutputStream(bufferSize);
		byte[] buffer = new byte[bufferSize];

		// Read in data
		while((len = in.read(buffer)) >= 0) {
			out.write(buffer, 0, len);
		}

		// Close streams
		in.close();
		out.close();

		return out.toByteArray();
	}
	
	/**
	 * @param b
	 * @return
	 * @throws IOException
	 */
	public static boolean isValidEsxFile(byte[] b) throws IOException {
		ExtendedByteBuffer in = new ExtendedByteBuffer(b);

		// File is not big enough
		if (in.limit() < SIZE_FILE_MIN)
			throw new IOException("Invalid Esx File Format: File is too small");

		// File is too big
		if (in.limit() > SIZE_FILE_MAX)
			throw new IOException("Invalid Esx File Format: File is too big");

		// ESX Check 1
		byte[] byteCheckOne = new byte[12];
		in.position(ADDR_VALID_ESX_CHECK_1);
		in.getBytes(byteCheckOne);
		if (
				byteCheckOne[0]  != 0x4b || // K
				byteCheckOne[1]  != 0x4f || // O
				byteCheckOne[2]  != 0x52 || // R
				byteCheckOne[3]  != 0x47 || // G
				byteCheckOne[4]  != 0x00 || // .
				byteCheckOne[5]  != 0x00 || // .
				byteCheckOne[6]  != 0x00 || // .
				byteCheckOne[7]  != 0x71 || // 0x71
				byteCheckOne[8]  != 0x45 || // E
				byteCheckOne[9]  != 0x53 || // S
				byteCheckOne[10] != 0x58 || // X
				byteCheckOne[11] != 0x00    // .
			)
			throw new IOException("Invalid Esx File Format: Failed Esx Check 1");

		// ESX Check 2
		byte[] byteCheckTwo = new byte[12];
		in.position(ADDR_VALID_ESX_CHECK_2);
		in.getBytes(byteCheckTwo);
		if (
				byteCheckTwo[0]  != 0x4b || // K
				byteCheckTwo[1]  != 0x4f || // O
				byteCheckTwo[2]  != 0x52 || // R
				byteCheckTwo[3]  != 0x47 || // G
				byteCheckTwo[4]  != 0x00 || // .
				byteCheckTwo[5]  != 0x00 || // .
				byteCheckTwo[6]  != 0x00 || // .
				byteCheckTwo[7]  != 0x71 /*|| // 0x71
				byteCheckTwo[8]  != 0x42 || // B
				byteCheckTwo[9]  != 0x50 || // P
				byteCheckTwo[10] != 0x53 || // S
				byteCheckTwo[11] != 0x20    // .
				*/
			)
			throw new IOException("Invalid Esx File Format: Failed Esx Check 2");

		// File must be valid if we've reached this point
		return true;
	}

	/**
	 * @param list
	 * @return
	 */
	public static byte[] listToByteArray(List<Byte> list){
		byte[] byteArray = new byte[list.size()];
		for(int i = 0; i<list.size(); i++) {
			byteArray[i] = list.get(i);
		}
		return byteArray;
	}

	/**
	 * @param packedInt
	 * @param inputValue
	 * @param numBits
	 * @param numShiftedLeft
	 * @return
	 */
	public static int packInt(int packedInt, int inputValue, int numBits, int numShiftedLeft) {
		//	The comments below assume we are passing in:
		//		packedInt		= yyyy yyyy
		//		inputValue		= 0000 0010  HEX: 0x02  DEC: 2
		//		numBits			= 3
		//		numShiftedLeft	= 4
		//	We want to end up with: y010 yyyy

		int bitsUnshifted = (int) (Math.pow(2, numBits) - 1);	// 0000 0111
		int bitsShifted = bitsUnshifted << numShiftedLeft;		// 0111 0000
		int shiftedInputValue = inputValue << numShiftedLeft;	// 0010 0000

		packedInt = packedInt & (~bitsShifted);					// y000 yyyy
		packedInt = packedInt | shiftedInputValue;				// y010 yyyy
		return packedInt;
	}
	
	/**
	 * @param packedInt
	 * @param numBits
	 * @param numShiftedLeft
	 * @return
	 */
	public static int unpackInt(int packedInt, int numBits, int numShiftedLeft) {
		//	The comments below assume we are passing in:
		//		packedInt		= y010 yyyy
		//		numBits			= 3
		//		numShiftedLeft	= 4
		//	We want to end up with: 0000 0010

		int bitsUnshifted = (int) (Math.pow(2, numBits) - 1);	// 0000 0111
		int bitsShifted = bitsUnshifted << numShiftedLeft;		// 0111 0000
		int outputValue = packedInt & bitsShifted;				// 0yyy 0000
		return outputValue >> numShiftedLeft;					// 0000 0yyy
	}

	/**
	 * @param sampleNumber
	 * @return Returns true if sampleNumber is valid, returns false otherwise
	 */
	public static boolean isValidSampleNumber(int sampleNumber) {
		return (sampleNumber>=0 && sampleNumber<NUM_SAMPLES);
	}

	/**
	 * @param patternNumber
	 * @return Returns true if patternNumber is valid, returns false otherwise
	 */
	public static boolean isValidPatternNumber(int patternNumber) {
		return (patternNumber>=0 && patternNumber<NUM_PATTERNS);
	}

	/**
	 * @param songNumber
	 * @return Returns true if songNumber is valid, returns false otherwise
	 */
	public static boolean isValidSongNumber(int songNumber) {
		return (songNumber>=0 && songNumber<NUM_SONGS);
	}

}
