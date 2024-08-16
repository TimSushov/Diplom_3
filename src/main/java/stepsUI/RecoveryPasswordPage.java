package stepsUI;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {
    private final WebDriver driver;

    private final By loginHypertext = By.xpath(".//a[text()='Войти']");

    public RecoveryPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Кликаем по гипертексту Войти")
    public void clickLoginHypertext() {
        driver.findElement(loginHypertext).click();
    }
}
