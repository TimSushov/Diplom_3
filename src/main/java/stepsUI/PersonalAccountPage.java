package stepsUI;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {
    private final WebDriver driver;

    private final By profileHeader = By.xpath(".//a[text()='Профиль']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By logoStellarBurgers = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private final By logoutButton = By.xpath(".//button[text()='Выход']");

    public PersonalAccountPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Проверяем появления хэдера Профиль")
    public void checkProfileHeader () {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(profileHeader));
        driver.findElement(profileHeader);
    }

    @Step("Кликаем по кнопке Конструктор")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Кликаем по логотипу Stellar Burgers")
    public void clickLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
    }

    @Step("Ожидаем и кликаем по кнопке Выход")
    public void clickLogoutButton() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
    }


}
