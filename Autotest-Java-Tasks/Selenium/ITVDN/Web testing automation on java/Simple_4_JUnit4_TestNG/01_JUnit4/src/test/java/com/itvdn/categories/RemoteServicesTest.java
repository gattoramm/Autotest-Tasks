package com.itvdn.categories;

import com.itvdn.categories.categoriesMarker.IntegrationTests;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(value = {IntegrationTests.class})
public class RemoteServicesTest {

    @Test
    public void aTest() {
        System.out.println("I'm slow, because my class annotation says so!");
    }

    @Test
    public void anotherTest() {
        System.out.println("I'm also slow...");
    }
}
