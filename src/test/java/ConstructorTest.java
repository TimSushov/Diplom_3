import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import resours.BrowserWebdrivers;
import resours.Credential;
import resours.Urls;
import stepsApi.UserSteps;
import stepsUI.ConstructorPage;
import stepsUI.LoginPage;
import stepsUI.PersonalAccountPage;

public class ConstructorTest {

    BrowserWebdrivers browserWebdrivers = new BrowserWebdrivers();
    WebDriver driver = browserWebdrivers.chromeWebdriver();

    @Before
    public void tearUp(){
        driver.get(Urls.BASE_URL);
    }

    @Test
    @DisplayName("Переход к разделу Булки")
    @Description("Скролл страницы до раздела Булки")
    public void scrollToСhapterBun(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.checkBunChapter();
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    @Description("Скролл страницы до раздела Соусы")
    public void scrollToСhapterSauce(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.checkSauceChapter();
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    @Description("Скролл страницы до раздела Начинки")
    public void scrollToСhapterFilling(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.checkFillingChapter();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
