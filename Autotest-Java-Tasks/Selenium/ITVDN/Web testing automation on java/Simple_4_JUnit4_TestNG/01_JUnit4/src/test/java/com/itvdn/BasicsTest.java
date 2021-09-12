package com.itvdn;

import org.junit.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class BasicsTest {

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("---@BeforeClass---");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("---@AfterClass---");
    }

    @Before
    public void setUp() {
        System.out.println("---@Before---");
    }

    @After
    public void tearDown() {
        System.out.println("---@After---");
    }

    @Test
    public void passingTest() {
        System.out.println("---@Test---");
    }

    @Test
    public void failingTest() {
        System.out.print("---@Test---  ");
        System.out.println("I fail! :(");
        Assert.assertTrue(false);
        Assert.assertNotNull(new Object());
        fail();
    }

    @Test
    public void failingTestWithException() {
        System.out.print("---@Test---  ");
        System.out.println("I fail with an unexpected Exception!");
        throw new RuntimeException();
    }

    @Test(expected = IllegalArgumentException.class)
    public void failingTestWithWrongException() {
        System.out.print("---@Test---  ");
        System.out.println("I fail, because the wrong exception is thrown!");
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void passingTestWithExpectedException() {
        System.out.print("---@Test---  ");
        System.out.println("I pass, although an exception is thrown!");
        throw new RuntimeException();
    }

    @Test
    @Ignore
    public void ignoredTest() {
        System.out.print("---@Test---  ");
        System.out.println("I'm ignored :-(");
        fail();
    }

    @Test(timeout = 1000)
    public void passingTestWithTimeout() {
        System.out.print("---@Test---  ");
        System.out.println("I pass because my exception doesn't take too long.");
    }

    @Test(timeout = 1000)
    public void failingTestWithTimeout() throws Exception {
        System.out.print("---@Test---  ");
        System.out.println("I fail because my exception takes too long.");
        TimeUnit.MILLISECONDS.sleep(2000);
    }
}
