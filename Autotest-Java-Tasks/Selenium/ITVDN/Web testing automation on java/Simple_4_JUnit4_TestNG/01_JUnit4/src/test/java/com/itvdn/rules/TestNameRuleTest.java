package com.itvdn.rules;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestNameRuleTest {
	
	@Rule
	public TestName testName = new TestName();

	@Before
	public void setUp() {
		System.out.println(String.format("Starting %s...", testName.getMethodName()));
	}

	@After
	public void tearDown() {
		System.out.println(String.format("Done with %s!", testName.getMethodName()));
		
	}
	
	@Test
	public void aTest() {
		System.out.println(String.format("Running %s...", testName.getMethodName()));
	}

	@Test
	public void anotherTest() {
		System.out.println(String.format("Running %s...", testName.getMethodName()));
	}

}
