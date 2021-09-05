package com.itvdn;

import org.junit.Test;

import static org.hamcrest.core.Is.isA;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class MatchersTest {

	private static final String STRING = "I like using JUnit 4's matchers!";

	@Test
	public void passingTest() {
		assertThat(new Object(), isA(Object.class));
	}

	@Test
	public void assertThatEqual() {
		assertThat(STRING, equalTo(STRING));
	}

	@Test
	public void assertEqualTo() {
		assertEquals(STRING, STRING);
	}

	@Test
	public void assertThatEqualFail() {
		assertThat(STRING, equalTo(""));
	}
	
	@Test
	public void assertEqualToFail() {
		assertEquals("Fails", STRING, "");
	}
	
	@Test
	public void assertThatNotEqual() {
		assertThat(STRING, not(equalTo("")));
	}

	@Test
	public void assertThatNotEqualFail() {
		assertThat(STRING, not(equalTo(STRING)));
	}

	@Test
	public void assertNotEqualsFail() {
		assertFalse(!STRING.equals(""));
	}

}
