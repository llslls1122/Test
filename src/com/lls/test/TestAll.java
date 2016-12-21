package com.lls.test;

import junit.framework.TestSuite;

import org.junit.Test;
import org.openqa.jetty.util.TestCase;

import com.lls.DealIn;
import com.lls.DealOut;
import com.lls.DealP;

public class TestAll extends TestSuite{
	public static junit.framework.Test suite(){
		TestSuite suite=new TestSuite("Test");
		suite.addTestSuite(DealP.class);
		suite.addTestSuite(DealOut.class);
		return suite;
	}
}
