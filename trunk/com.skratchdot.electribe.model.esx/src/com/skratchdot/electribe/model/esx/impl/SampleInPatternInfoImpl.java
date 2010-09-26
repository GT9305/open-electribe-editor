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

import com.skratchdot.electribe.model.esx.EsxPackage;
import com.skratchdot.electribe.model.esx.PatternNumber;
import com.skratchdot.electribe.model.esx.SampleInPatternInfo;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sample In Pattern Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleInPatternInfoImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleInPatternInfoImpl#getPatternNumber <em>Pattern Number</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleInPatternInfoImpl#getPartCount <em>Part Count</em>}</li>
 *   <li>{@link com.skratchdot.electribe.model.esx.impl.SampleInPatternInfoImpl#getPartList <em>Part List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SampleInPatternInfoImpl extends EObjectImpl implements SampleInPatternInfo {
	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getPatternNumber() <em>Pattern Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternNumber()
	 * @generated
	 * @ordered
	 */
	protected static final PatternNumber PATTERN_NUMBER_EDEFAULT = PatternNumber.PATTERN_A01;

	/**
	 * The cached value of the '{@link #getPatternNumber() <em>Pattern Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternNumber()
	 * @generated
	 * @ordered
	 */
	protected PatternNumber patternNumber = PATTERN_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getPartCount() <em>Part Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartCount()
	 * @generated
	 * @ordered
	 */
	protected static final int PART_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPartCount() <em>Part Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartCount()
	 * @generated
	 * @ordered
	 */
	protected int partCount = PART_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPartList() <em>Part List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartList()
	 * @generated
	 * @ordered
	 */
	protected static final String PART_LIST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartList() <em>Part List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartList()
	 * @generated
	 * @ordered
	 */
	protected String partList = PART_LIST_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SampleInPatternInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsxPackage.Literals.SAMPLE_IN_PATTERN_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(int newIndex) {
		int oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE_IN_PATTERN_INFO__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternNumber getPatternNumber() {
		return patternNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatternNumber(PatternNumber newPatternNumber) {
		PatternNumber oldPatternNumber = patternNumber;
		patternNumber = newPatternNumber == null ? PATTERN_NUMBER_EDEFAULT : newPatternNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE_IN_PATTERN_INFO__PATTERN_NUMBER, oldPatternNumber, patternNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPartCount() {
		return partCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartCount(int newPartCount) {
		int oldPartCount = partCount;
		partCount = newPartCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE_IN_PATTERN_INFO__PART_COUNT, oldPartCount, partCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPartList() {
		return partList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartList(String newPartList) {
		String oldPartList = partList;
		partList = newPartList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsxPackage.SAMPLE_IN_PATTERN_INFO__PART_LIST, oldPartList, partList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__INDEX:
				return getIndex();
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__PATTERN_NUMBER:
				return getPatternNumber();
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__PART_COUNT:
				return getPartCount();
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__PART_LIST:
				return getPartList();
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
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__INDEX:
				setIndex((Integer)newValue);
				return;
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__PATTERN_NUMBER:
				setPatternNumber((PatternNumber)newValue);
				return;
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__PART_COUNT:
				setPartCount((Integer)newValue);
				return;
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__PART_LIST:
				setPartList((String)newValue);
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
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__INDEX:
				setIndex(INDEX_EDEFAULT);
				return;
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__PATTERN_NUMBER:
				setPatternNumber(PATTERN_NUMBER_EDEFAULT);
				return;
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__PART_COUNT:
				setPartCount(PART_COUNT_EDEFAULT);
				return;
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__PART_LIST:
				setPartList(PART_LIST_EDEFAULT);
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
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__INDEX:
				return index != INDEX_EDEFAULT;
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__PATTERN_NUMBER:
				return patternNumber != PATTERN_NUMBER_EDEFAULT;
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__PART_COUNT:
				return partCount != PART_COUNT_EDEFAULT;
			case EsxPackage.SAMPLE_IN_PATTERN_INFO__PART_LIST:
				return PART_LIST_EDEFAULT == null ? partList != null : !PART_LIST_EDEFAULT.equals(partList);
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
		result.append(" (index: ");
		result.append(index);
		result.append(", patternNumber: ");
		result.append(patternNumber);
		result.append(", partCount: ");
		result.append(partCount);
		result.append(", partList: ");
		result.append(partList);
		result.append(')');
		return result.toString();
	}

} //SampleInPatternInfoImpl
