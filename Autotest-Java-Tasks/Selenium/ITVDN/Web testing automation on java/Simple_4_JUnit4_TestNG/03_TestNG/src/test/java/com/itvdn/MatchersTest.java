package com.itvdn;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.HashMap;
import java.util.Map;

public class MatchersTest {

    private static final String STRING = "I like using TestNG's matchers!";

    // Сравнивает объекты по значению через метод equals(), если он не переопределен то сравниваются ссылки
    @Test
    public void assertEquals() {
        Assert.assertEquals(STRING, STRING, STRING);
//        Assert.assertEquals(STRING, new String(STRING), STRING);
    }

    // Сравнивает ссылки объектов
    @Test
    public void assertSame() {
        Assert.assertSame(STRING, STRING, STRING);
//        Assert.assertSame(STRING, new String(STRING), STRING);
    }

    @Test
    public void assertEqualsList() {
        Assert.assertEquals(Lists.newArrayList("foo", "bar", "baz"), Lists.newArrayList("foo", "bar", "baz"));
    }

    @Test
    public void assertEqualsListFail() {
        Assert.assertEquals(Lists.newArrayList("foo", "BAR", "baz"), Lists.newArrayList("foo", "baz", "BAR"));
    }

    @Test
    public void assertEqualsNoOrder() {
        String[] array = {"foo", "BAR", "baz"};
        String[] arrayInMess = {"foo", "baz", "BAR"};
        Assert.assertEqualsNoOrder(array, arrayInMess);
    }

    @Test
    public void assertEqualsMap() {
        Map<String, Object> actualMap = new HashMap<String, Object>() {
            {
                put("foo", "foo");
                put("bar", "bar");
                put("baz", Lists.newArrayList("String"));
            }
        };
        Map<String, Object> expectedMap = new HashMap<String, Object>() {
            {
                put("bar", "bar");
                put("foo", "foo");
                put("baz", Lists.newArrayList("String"));
            }
        };
        Assert.assertEquals(actualMap, expectedMap);
    }

    @Test
    public void assertFalse() {
        Assert.assertFalse(false);
    }

    @Test
    public void assertTrue() {
        Assert.assertTrue(true);
    }

    @Test
    public void assertNull() {
        Assert.assertNull(null);
    }
}
