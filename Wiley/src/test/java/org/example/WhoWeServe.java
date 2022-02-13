package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class WhoWeServe {
    // конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;

    public WhoWeServe(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // definition of locator "Who We Serve"
    @FindBy(css = ".navigation-menu-items.initialized > .dropdown-submenu:nth-child(1)")
    private WebElement LocWhoWeServe;

    // select "Who We Serve"
    public void clickWWSBtn() {
        LocWhoWeServe.click();
    }

    // definition of locator "Students"
    @FindBy(xpath = "//*[@id=\"Level1NavNode1\"]/ul/li[1]/a")
    private WebElement fieldStudents;

    // definition of locator "Instructors"
    @FindBy(xpath = "//*[@id=\"Level1NavNode1\"]/ul/li[2]/a")
    private WebElement fieldInstructors;

    // definition of locator "Book Authors"
    @FindBy(xpath = "//*[@id=\"Level1NavNode1\"]/ul/li[3]/a")
    private WebElement fieldBookAuthors;

    // definition of locator "Professionals"
    @FindBy(xpath = "//*[@id=\"Level1NavNode1\"]/ul/li[4]/a")
    private WebElement fieldProfessionals;

    // definition of locator "Researchers"
    @FindBy(xpath = "//*[@id=\"Level1NavNode1\"]/ul/li[5]/a")
    private WebElement fieldResearchers;

    // definition of locator "Institutions"
    @FindBy(xpath = "//*[@id=\"Level1NavNode1\"]/ul/li[6]/a")
    private WebElement fieldInstitutions;

    // definition of locator "Librarians"
    @FindBy(xpath = "//*[@id=\"Level1NavNode1\"]/ul/li[7]/a")
    private WebElement fieldLibrarians;

    // definition of locator "Corporations"
    @FindBy(xpath = "//*[@id=\"Level1NavNode1\"]/ul/li[8]/a")
    private WebElement fieldCorporations;

    // definition of locator "Societies"
    @FindBy(xpath = "//*[@id=\"Level1NavNode1\"]/ul/li[9]/a")
    private WebElement fieldSocieties;

    // definition of locator "Journal Editors"
    @FindBy(xpath = "//*[@id=\"Level1NavNode1\"]/ul/li[10]/a")
    private WebElement fieldJournalEditors;

    // definition of locator "Bookstores"
    @FindBy(xpath = "//*[@id=\"Level1NavNode1\"]/ul/li[11]/a")
    private WebElement fieldBookstores;

    // definition of locator "Government"
    @FindBy(xpath = "//*[@id=\"Level1NavNode1\"]/ul/li[12]/a")
    private WebElement fieldGovernment;

    public WebElement getFieldStudents() {
        return fieldStudents;
    }

    public WebElement getFieldInstructors() {
        return fieldInstructors;
    }

    public WebElement getFieldBookAuthors() {
        return fieldBookAuthors;
    }

    public WebElement getFieldProfessionals() {
        return fieldProfessionals;
    }

    public WebElement getFieldResearchers() {
        return fieldResearchers;
    }

    public WebElement getFieldInstitutions() {
        return fieldInstitutions;
    }

    public WebElement getFieldLibrarians() {
        return fieldLibrarians;
    }

    public WebElement getFieldCorporations() {
        return fieldCorporations;
    }

    public WebElement getFieldSocieties() {
        return fieldSocieties;
    }

    public WebElement getFieldJournalEditors() {
        return fieldJournalEditors;
    }

    public WebElement getFieldBookstores() {
        return fieldBookstores;
    }

    public WebElement getFieldGovernment() {
        return fieldGovernment;
    }

    public String getElementWWS(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    // locator: in search result field - elements of search results section
    @FindBy(xpath = "//*[@id=\"Level1NavNode1\"]/ul/li/a")
    private List<WebElement> searchWWSSection;

    public List<WebElement> getSearchWWSSection() {
        return searchWWSSection;
    }

    // это офигенно - добавить пробелы и перенос строки, чтобы выровнять списки в WWS
    public String[] getElementsWWSSection() {
        List<WebElement> a = getSearchWWSSection();
        String[] searchWWSSectionTrim = new String[a.size()];

        for (int i = 0; i < a.size(); i++)
            searchWWSSectionTrim[i] = a.get(i).getAttribute("text").trim();

        return searchWWSSectionTrim;
    }
}
