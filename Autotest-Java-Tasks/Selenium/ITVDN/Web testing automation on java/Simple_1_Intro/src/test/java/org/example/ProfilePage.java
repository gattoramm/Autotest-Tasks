package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    // конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // определение области информации пользователя
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[3]/main/div/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div")
    private WebElement userInfo;

    // определение локатора меню пользователя
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div/a[1]/div")
    private WebElement userMenu;

    // определение локатора кнопки выхода из аккаунта
    @FindBy(xpath= "//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div/div/ul/ul/li[6]/a/span")
    private WebElement logoutBtn;

    // метод для получения имени пользователя из меню пользователя
    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/main/div/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div")));
        String userName = userInfo.getText();
        return userName;
    }

    // метод для нажатия кнопки меню пользователя
    public void entryMenu() {
        userMenu.click();
    }

    // метод для нажатия кнопки выхода из аккаунта
    public void userLogout() {
        logoutBtn.click();
    }
}
