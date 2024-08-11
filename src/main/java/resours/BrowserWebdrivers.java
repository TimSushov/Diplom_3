package resours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserWebdrivers {

    public  WebDriver chromeWebdriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public  WebDriver firefoxWebdriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public  WebDriver yandexWebdriver(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        ChromeOptions options=new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        WebDriver driver= new ChromeDriver(options);
        return driver;
    }

}
