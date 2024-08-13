import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import resours.BrowserWebdrivers;
import resours.Credential;
import resours.Urls;
import stepsApi.UserSteps;
import stepsUI.ConstructorPage;
import stepsUI.LoginPage;
import stepsUI.RegisterPage;

public class RegisterUserTest {

    private String email = Credential.EMAIL;
    private String password = Credential.PASSWORD;
    private String name = Credential.NAME;

    BrowserWebdrivers browserWebdrivers = new BrowserWebdrivers();
    WebDriver driver = browserWebdrivers.chromeWebdriver();
    UserSteps userSteps;

    @Before
    public void tearUp(){
        driver.get(Urls.BASE_URL);
    }

    @Test
    @DisplayName("Регистрация пользователя через кнопку Войти в аккаунт")
    @Description("Пользователь создается")
    public void registerUserLoginInAccountButton(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        userSteps = new UserSteps();

        constructorPage.clickLoginInAccountButton();
        loginPage.clickRegisterHypertext();
        registerPage.setNameTextField(name);
        registerPage.setEmailTextField(email);
        registerPage.setPasswordTextField(password);
        registerPage.clickRegisterButton();
        loginPage.checkEntranceHeader();
    }

    @Test
    @DisplayName("Регистрация пользователя через кнопку Личный кабинет")
    @Description("Пользователь создается")
    public void registerUserPersonalAccountButton(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        userSteps = new UserSteps();

        constructorPage.clickPersonalAccountButton();
        loginPage.clickRegisterHypertext();
        registerPage.setNameTextField(name);
        registerPage.setEmailTextField(email);
        registerPage.setPasswordTextField(password);
        registerPage.clickRegisterButton();
        loginPage.checkEntranceHeader();
    }

    @After
    public void tearDown() {
        userSteps.deleteUser(userSteps.getToken(email, password));
        driver.quit();
    }
}
