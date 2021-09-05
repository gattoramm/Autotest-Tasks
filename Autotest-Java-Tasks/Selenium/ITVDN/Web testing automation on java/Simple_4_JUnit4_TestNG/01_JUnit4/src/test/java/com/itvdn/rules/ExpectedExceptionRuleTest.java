package com.itvdn.rules;

import org.hamcrest.core.Is;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExpectedExceptionRuleTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void unexpectedException() {
		throw new RuntimeException();
	}

	@Test
	public void wrongExpectedException() {
		thrown.expect(IllegalArgumentException.class);
		throw new RuntimeException();
	}

	@Test
	public void expectedException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("null");
		throw new IllegalArgumentException("Argument must not be null");
	}

	@Test
	public void expectedCause() {
		thrown.expectCause(Is.isA(NullPointerException.class));
		NullPointerException theCause = new NullPointerException("Argument must not be null");
		throw new RuntimeException(theCause);
	}
	
}
