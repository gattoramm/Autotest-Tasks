package com.itvdn.categories.suites;

import com.itvdn.categories.ClientTest;
import com.itvdn.categories.RemoteServicesTest;
import com.itvdn.categories.categoriesMarker.SlowTests;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Класс для запуска всех НЕ медленных тестов
 */
@RunWith(Categories.class)
@ExcludeCategory(SlowTests.class)
@SuiteClasses( { RemoteServicesTest.class, ClientTest.class })
public class FastTestsSuite {

}
