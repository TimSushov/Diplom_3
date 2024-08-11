package stepsUI;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;

    private final By registerHypertext = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By entranceHeader = By.xpath(".//h2[text()='Вход']");
    private final By emailTextField = By.xpath(".//label[text()='Email']//following-sibling::input[@name='name']");
    private final By passwordTextField = By.xpath(".//label[text()='Пароль']//following-sibling::input[@name='Пароль']");
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    private final By recoveryPasswordHypertext = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Кликаем по гипертексту Зарегистрироваться")
    public void clickRegisterHypertext() {
        driver.findElement(registerHypertext).click();
    }

    @Step("Проверяем появления хэдера Вход")
    public void checkEntranceHeader () {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(entranceHeader));
        driver.findElement(entranceHeader);
    }

    @Step("Вводим данные в поле email")
    public void setEmailTextField (String emailText) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(emailTextField));
        driver.findElement(emailTextField).sendKeys(emailText);
    }

    @Step("Вводим данные в поле Пароль")
    public void setPasswordTextField (String passwordText) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(passwordTextField));
        driver.findElement(passwordTextField).sendKeys(passwordText);
    }

    @Step("Кликаем по кнопке Войти")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Кликаем по гипертексту Восстановить пароль")
    public void clickRecoveryPasswordHypertext() {
        driver.findElement(recoveryPasswordHypertext).click();
    }

}
