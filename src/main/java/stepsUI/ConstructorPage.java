package stepsUI;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ConstructorPage {
    private final WebDriver driver;

    private final By loginInAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By createBurgerHeader = By.xpath(".//h1[text()='Соберите бургер']");
    private final By bunChapter = By.xpath(".//span[text()='Булки']");
    private final By sauceChapter = By.xpath(".//span[text()='Соусы']");
    private final By fillingChapter = By.xpath(".//span[text()='Начинки']");
    private final By bunInMenuContainer = By.xpath(".//h2[text()='Булки']");
    private final By sauceInMenuContainer = By.xpath(".//h2[text()='Соусы']");
    private final By fillingInMenuContainer = By.xpath(".//h2[text()='Начинки']");
    private final By lastFillingInList = By.xpath(".//p[text()='Сыр с астероидной плесенью']");


    public ConstructorPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Кликаем по кнопке Войти в аккаунт")
    public void clickLoginInAccountButton() {
        driver.findElement(loginInAccountButton).click();
    }

    @Step("Кликаем по кнопке Личный Кабинет")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Проверяем появления хэдера Соберите бургер")
    public void checkCreateBurgerHeader () {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(createBurgerHeader));
        driver.findElement(createBurgerHeader);
    }

    @Step("Кликаем по разделу Булки")
    public void clickBunChapter() {
        driver.findElement(bunChapter).click();
    }

    @Step("Кликаем о разделу Соусы")
    public void clickSauceChapter() {
        driver.findElement(sauceChapter).click();
    }

    @Step("Кликаем о разделу Начинки")
    public void clickFillingChapter() {
        driver.findElement(fillingChapter).click();
    }

    @Step("Проверяем скролла к разделу Булки")
    public void checkBunChapter () {
        scrollListDown();
        String location1 = String.valueOf(driver.findElement(bunInMenuContainer).getLocation());
        clickBunChapter();
        String location2 = String.valueOf(driver.findElement(bunInMenuContainer).getLocation());
        Assert.assertNotEquals(location2, location1);

    }

    @Step("Проверяем скролла к разделу Соусы")
    public void checkSauceChapter() {
        scrollListDown();
        String location1 = String.valueOf(driver.findElement(sauceInMenuContainer).getLocation());
        clickSauceChapter();
        String location2 = String.valueOf(driver.findElement(sauceInMenuContainer).getLocation());
        Assert.assertNotEquals(location2, location1);
    }

    @Step("Проверяем скролла к разделу Начинки")
    public void checkFillingChapter () {
        String location1 = String.valueOf(driver.findElement(fillingInMenuContainer).getLocation());
        clickFillingChapter();
        String location2 = String.valueOf(driver.findElement(fillingInMenuContainer).getLocation());
        Assert.assertNotEquals(location2, location1);
    }

    @Step("Скроллим до нижнего элемента")
    public void scrollListDown() {
        WebElement element = driver.findElement(lastFillingInList);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

    }
}
