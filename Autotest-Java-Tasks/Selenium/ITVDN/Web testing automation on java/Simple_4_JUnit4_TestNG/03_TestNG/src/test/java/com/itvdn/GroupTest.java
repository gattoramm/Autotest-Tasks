package com.itvdn;

import org.testng.annotations.*;

public class GroupTest {

    @BeforeSuite(groups = {"include-group"})
    public void beforeSuite() {
        System.out.println("Before Suite method");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test method");
    }

    @BeforeGroups(groups = {"include-group"})
    public void beforeGroups() {
        System.out.println("Before Groups method");
    }

    @Test(groups = {"include-group"})
    public void testMethodOne() {
        System.out.println("Test method one belonging to include group.");
    }

    @Test(groups = {"include-group"})
    public void testMethodTwo() {
        System.out.println("Test method two belonging to include group.");
    }

    @Test(groups = {"include-group", "exclude-group"})
    public void testMethodThree() {
        System.out.println("Test method three belonging to exclude/include groups.");
    }

    @AfterGroups(groups = {"include-group"})
    public void afterGroups() {
        System.out.println("After Groups method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test method");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite method");
    }

}