import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import resours.BrowserWebdrivers;
import resours.Urls;
import stepsUI.ConstructorPage;
import stepsUI.LoginPage;

public class PersonalAccountWithoutAuthTest {

    BrowserWebdrivers browserWebdrivers = new BrowserWebdrivers();
    WebDriver driver = browserWebdrivers.chromeWebdriver();

    @Before
    public void tearUp(){
        driver.get(Urls.BASE_URL);
    }

    @Test
    @DisplayName("Вход в личный кабинет без авторизации")
    @Description("Пользователь не авторизован и открывается страница авторизации")
    public void openPersonalAccountWithoutAuth(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        constructorPage.clickPersonalAccountButton();
        loginPage.checkEntranceHeader();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
