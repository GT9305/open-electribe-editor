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
package com.skratchdot.electribe.model.esx.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>esx</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class EsxTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new EsxTests("esx Tests");
		suite.addTestSuite(EsxFileTest.class);
		suite.addTestSuite(GlobalParametersTest.class);
		suite.addTestSuite(PatternTest.class);
		suite.addTestSuite(SampleMonoTest.class);
		suite.addTestSuite(SampleStereoTest.class);
		suite.addTestSuite(SongTest.class);
		suite.addTestSuite(SongPatternTest.class);
		suite.addTestSuite(TempoTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsxTests(String name) {
		super(name);
	}

} //EsxTests
