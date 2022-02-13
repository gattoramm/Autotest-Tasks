package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchInput {
    public WebDriver driver;

    // PageFactory pattern
    public SearchInput(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // locator: search field
    @FindBy(xpath = "//*[@id=\"js-site-search-input\"]")
    private WebElement searchLocator;

    public WebElement getSearchLocator() {
        return searchLocator;
    }

    // locator: search result field
    @FindBy(xpath = "//*[@id=\"ui-id-2\"]")
    private WebElement searchResultLocator;

    public WebElement getSearchResultLocator() {
        return searchResultLocator;
    }

    // locator: in search result field - elements of search results section
    @FindBy(xpath = "//*[@id=\"ui-id-2\"]/section/h3")
    private List<WebElement> searchResultSection;

    public List<WebElement> getSearchResultSection() {
        return searchResultSection;
    }

    public String getElementOfSearchResultSection(WebElement webElement) {
        return webElement.getAttribute("innerHTML");
    }

    // locator: in search result field - elements of search results sub-section
    @FindBy(xpath = "//*[@id=\"ui-id-2\"]/section/div/div")
    private List<WebElement> searchResultSubSection;

    public List<WebElement> getSearchResultSubSection() {
        return searchResultSubSection;
    }
}
