package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;


public class WhoWeServeTest {
    public static WhoWeServe wws;

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver","src\\\\main\\\\resources\\\\chromedriver.exe");
        // driver instance
        driver = new ChromeDriver();

        //System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        //driver = new FirefoxDriver();

        wws = new WhoWeServe(driver);

        //окно разворачивается на полный экран
        driver.manage().window().maximize();

        //задержка на выполнение теста = 5 сек.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getPropertyString("mainpage"));
    }

    @Test
    public void elementsOfLocatorWhoWeServeTest() {
        wws.clickWWSBtn();

        String[] wwsItemsActual = ConfProperties.getPropertyArray("wwswords");
        String[] wwsItemsExpected = wws.getElementsWWSSection();

        assertThat(wwsItemsActual, arrayWithSize(12));

        for (String item : wwsItemsActual)
            assertThat(wwsItemsExpected, hasItemInArray(item));

        // easy
        assertEquals("Students", wws.getElementWWS(wws.getFieldStudents()));
        assertEquals("Instructors", wws.getElementWWS(wws.getFieldInstructors()));
        assertEquals("Book Authors", wws.getElementWWS(wws.getFieldBookAuthors()));
        assertEquals("Professionals", wws.getElementWWS(wws.getFieldProfessionals()));
        assertEquals("Researchers", wws.getElementWWS(wws.getFieldResearchers()));
        assertEquals("Institutions", wws.getElementWWS(wws.getFieldInstitutions()));
        assertEquals("Librarians", wws.getElementWWS(wws.getFieldLibrarians()));
        assertEquals("Corporations", wws.getElementWWS(wws.getFieldCorporations()));
        assertEquals("Societies", wws.getElementWWS(wws.getFieldSocieties()));
        assertEquals("Journal Editors", wws.getElementWWS(wws.getFieldJournalEditors()));
        assertEquals("Bookstores", wws.getElementWWS(wws.getFieldBookstores()));
        assertEquals("Government", wws.getElementWWS(wws.getFieldGovernment()));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
