package com.itvdn;


import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;


public class BasicsTest {

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("This is executed once before any test runs.");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("This is executed once after all tests have been run.");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("This is executed once before every test.");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("This is executed once after every test.");
    }

    @Test
    public void passingTest() {
        System.out.println("I'm a simple test that passes!");
    }

    @Test
    public void failingTest() {
        System.out.println("I fail! :(");
        fail();
    }

    @Test
    public void failingTestWithException() {
        System.out.println("I fail with an unexpected Exception!");
        throw new RuntimeException();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void failingTestWithWrongException() {
        System.out.println("I fail, because the wrong exception is thrown!");
        throw new RuntimeException();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void passingTestWithExpectedException() {
        System.out.println("I pass, although an exception is thrown!");
        throw new RuntimeException();
    }

    @Test(enabled = false)
    public void ignoredTest() {
        System.out.println("I'm ignored :-(");
        fail();
    }

    @Test(timeOut = 1000)
    public void passingTestWithTimeout() {
        System.out.println("I pass because my exception doesn't take too long.");
    }

    @Test(timeOut = 1000)
    public void failingTestWithTimeout() throws Exception {
        System.out.println("I fail because my exception takes too long.");
        TimeUnit.MILLISECONDS.sleep(2000);
    }

}
