package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    // конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    //определение локатора поля ввода логина
    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    private WebElement loginField;

    // определение локатора кнопки входа в аккаунт
    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    private WebElement loginBtn;

    // определение локатора поля ввода пароля
    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passwdField;

    // определение локатора пропуска установки фото
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/span/a")
    private WebElement photoField;

    // метод для ввода логина
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    // метод для ввода пароля
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    // метод для осуществления нажатия кнопки входа в аккаунт
    public void clickLoginBtn() {
        loginBtn.click();
    }

    // метод для осуществления нажатия кнопки отказа фото
    public void clickNoPhotoBtn() {
        photoField.click();
    }
}
