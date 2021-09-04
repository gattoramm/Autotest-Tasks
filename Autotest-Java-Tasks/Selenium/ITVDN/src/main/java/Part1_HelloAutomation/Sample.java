package Part1_HelloAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Sample {


    public static void main(String[] args) {


        // Указываем путь к драйверу. Это необходимо для всех драйверов кроме Firefox до 46 версии.
        // Версия драйвера Google Chrome должна соответствовать версии установленного Google Chrome на вашем компьютере
        // Скачать Google Chrome драйвер можно здесь http://chromedriver.chromium.org/downloads
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver_92.exe");

        // ИЛИ

        // Этот второй способ инициализировать драйвер. В данном случае не используются .exe. файлы дравера из \resources
        // Это сторонняя библиотека webdrivermanager. Она сама скачивает драйвер и использует его для теста

        // Для Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Для Firefox
         //WebDriverManager.firefoxdriver().setup();
         //WebDriver driver = new FirefoxDriver();

        // Для IE
        //WebDriverManager.iedriver().setup();
        //WebDriver driver = new InternetExplorerDriver();

        // Для Edge
        //WebDriverManager.edgedriver().setup();
        //WebDriver driver = new EdgeDriver();

        // OnLoad событие
        driver.get("http://www.google.com/xhtml");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("pickles");
        searchBox.submit();


        // Дополнительный способ перейти на страницу
        // driver.get() == driver.navigate().to()
        driver.navigate().to("https://dictionary.cambridge.org");

        WebElement cambridgeSearchBox = driver.findElement(By.id("searchword"));
        cambridgeSearchBox.sendKeys("carrot");
        cambridgeSearchBox.submit();

        // Основные функции навигации браузера
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        driver.quit();
    }
}
