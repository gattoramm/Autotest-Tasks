package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchInputTest {
    public static SearchInput searchInput;

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        // driver instance
        driver = new ChromeDriver();

        //System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        //driver = new FirefoxDriver();

        searchInput = new SearchInput(driver);

        //окно разворачивается на полный экран
        driver.manage().window().maximize();

        //задержка на выполнение теста = 5 сек.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getPropertyString("mainpage"));
    }

    @Test
    public void inputInSearchFieldWord() {
        String word = ConfProperties.getPropertyString("magicword");
        searchInput.setSearchLocator(word);

        List<WebElement> searchResultField = searchInput.getSearchResultSection();

        // проверка, что результаты поиска не пустые
        assertEquals("Suggestions", searchInput.getElementOfSearchResultSection(searchResultField.get(0)));
        assertEquals("Products", searchInput.getElementOfSearchResultSection(searchResultField.get(1)));
        assertEquals("Other", searchInput.getElementOfSearchResultSection(searchResultField.get(2)));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
