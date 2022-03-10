package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\ramil\\Documents\\GitHub\\Autotest-Tasks\\Autotest-Java-Tasks\\Selenium\\ITVDN\\Web testing automation on java\\Simple_1_Intro\\src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        //окно разворачивается на полный экран
        driver.manage().window().maximize();

        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    // тестовый метод для осуществления аутентификации
    @Test
    public void loginTest() {
        //получение доступа к методам класса LoginPage для взаимодействия с элементами страницы
        //значение login/password берутся из файла настроек по аналогии с chromedriver и loginpage

        //вводим логин
        //loginPage.inputLogin(ConfProperties.getProperty("gatto.ramm"));
        loginPage.inputLogin("");

        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        //вводим пароль
        //loginPage.inputPasswd(ConfProperties.getProperty("VaY6mCuREMeuR!W"));
        loginPage.inputPasswd("");

        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        // нажимаем пропуск фото
        //loginPage.clickNoPhotoBtn();

        //получаем отображаемый логин
        String user = profilePage.getUserName();

        //и сравниваем его с логином из файла настроек
        Assert.assertEquals("gatto.ramm", user);
    }

    // осуществление выхода из аккаунта с последующим закрытием окна браузера
    @AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userLogout();
        driver.quit(); }
}

