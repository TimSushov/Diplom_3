package stepsUI;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private final WebDriver driver;

    private final By nameTextField = By.xpath(".//label[text()='Имя']//following-sibling::input[@name='name']");
    private final By emailTextField = By.xpath(".//label[text()='Email']//following-sibling::input[@name='name']");
    private final By passwordTextField = By.xpath(".//label[text()='Пароль']//following-sibling::input[@name='Пароль']");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By errorPasswordValidation = By.xpath(".//p[text()='Некорректный пароль']");
    private final By loginHypertext = By.xpath(".//a[text()='Войти']");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Вводим данные в поле Имя")
    public void setNameTextField (String nameText) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(nameTextField));
        driver.findElement(nameTextField).sendKeys(nameText);
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

    @Step("Кликаем по кнопке Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Проверяем ошибку валидации поля Пароль")
    public void checkPasswordValidation () {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(errorPasswordValidation));
        driver.findElement(errorPasswordValidation);
    }

    @Step("Кликаем по гипертексту Войти")
    public void clickLoginHypertext() {
        driver.findElement(loginHypertext).click();
    }
}
