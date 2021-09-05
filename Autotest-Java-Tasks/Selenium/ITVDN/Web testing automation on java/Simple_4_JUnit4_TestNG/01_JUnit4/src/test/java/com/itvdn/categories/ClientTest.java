package com.itvdn.categories;

import com.itvdn.categories.categoriesMarker.PerformanceTests;
import com.itvdn.categories.categoriesMarker.SlowTests;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ClientTest {

	@Test
	public void fastTest() {
		System.out.println("I run fast!");
	}
	
	@Test
	@Category(value = { SlowTests.class })
	public void slowTest() {
		System.out.println("I'm a slow running test...");
	}

	@Test
	@Category(value = { PerformanceTests.class })
	public void performanceTest() {
		System.out.println("I test performance and may therefore be slow...");
	}
	
}
