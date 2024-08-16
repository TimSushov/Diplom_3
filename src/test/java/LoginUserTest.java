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
import stepsUI.RecoveryPasswordPage;
import stepsUI.RegisterPage;

public class LoginUserTest {

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
    @DisplayName("Вход по кнопке Войти в аккаунт на главной")
    @Description("Пользователь авторизован")
    public void loginUserLoginInAccountButton(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        userSteps = new UserSteps();

        userSteps.createUser(email, password, name, 200);
        constructorPage.clickLoginInAccountButton();
        loginPage.setEmailTextField(email);
        loginPage.setPasswordTextField(password);
        loginPage.clickEnterButton();
        constructorPage.checkCreateBurgerHeader();
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    @Description("Пользователь авторизован")
    public void loginUserPersonalAccountButton(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        userSteps = new UserSteps();

        userSteps.createUser(email, password, name, 200);
        constructorPage.clickPersonalAccountButton();
        loginPage.setEmailTextField(email);
        loginPage.setPasswordTextField(password);
        loginPage.clickEnterButton();
        constructorPage.checkCreateBurgerHeader();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Пользователь авторизован")
    public void loginUserRegisterPage(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        userSteps = new UserSteps();

        userSteps.createUser(email, password, name, 200);
        constructorPage.clickLoginInAccountButton();
        loginPage.clickRegisterHypertext();
        registerPage.clickLoginHypertext();
        loginPage.setEmailTextField(email);
        loginPage.setPasswordTextField(password);
        loginPage.clickEnterButton();
        constructorPage.checkCreateBurgerHeader();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Пользователь авторизован")
    public void loginUserRecoveryPassword(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RecoveryPasswordPage recoveryPasswordPage = new RecoveryPasswordPage(driver);
        userSteps = new UserSteps();

        userSteps.createUser(email, password, name, 200);
        constructorPage.clickLoginInAccountButton();
        loginPage.clickRecoveryPasswordHypertext();
        recoveryPasswordPage.clickLoginHypertext();
        loginPage.setEmailTextField(email);
        loginPage.setPasswordTextField(password);
        loginPage.clickEnterButton();
        constructorPage.checkCreateBurgerHeader();
    }

    @After
    public void tearDown() {
        userSteps.deleteUser(userSteps.getToken(email, password));
        driver.quit();
    }
}
