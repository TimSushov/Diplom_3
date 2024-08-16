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

public class PersonalAccountWithAuthtorizationTest {

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
    @DisplayName("Вход в личный кабинет с авторизацией")
    @Description("Пользователь авторизован и личный кабинет открывается")
    public void openPersonalAccountWithAuth(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        userSteps = new UserSteps();

        userSteps.createUser(email, password, name, 200);
        constructorPage.clickLoginInAccountButton();
        loginPage.setEmailTextField(email);
        loginPage.setPasswordTextField(password);
        loginPage.clickEnterButton();
        constructorPage.clickPersonalAccountButton();
        personalAccountPage.checkProfileHeader();
    }

    @Test
    @DisplayName("Переход по клику на Конструктор из личного кабинета")
    @Description("Окрывается страница конструктора")
    public void clickLogoFromPersonalAccount(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        userSteps = new UserSteps();

        userSteps.createUser(email, password, name, 200);
        constructorPage.clickLoginInAccountButton();
        loginPage.setEmailTextField(email);
        loginPage.setPasswordTextField(password);
        loginPage.clickEnterButton();
        constructorPage.clickPersonalAccountButton();
        personalAccountPage.clickConstructorButton();
        constructorPage.checkCreateBurgerHeader();
    }

    @Test
    @DisplayName("Переход по клику на лого из личного кабинета")
    @Description("Окрывается страница конструктора")
    public void clickConstructorFromPersonalAccount(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        userSteps = new UserSteps();

        userSteps.createUser(email, password, name, 200);
        constructorPage.clickLoginInAccountButton();
        loginPage.setEmailTextField(email);
        loginPage.setPasswordTextField(password);
        loginPage.clickEnterButton();
        constructorPage.clickPersonalAccountButton();
        personalAccountPage.clickLogoStellarBurgers();
        constructorPage.checkCreateBurgerHeader();
    }

    @Test
    @DisplayName("Выход из личного кабинета")
    @Description("Пользователь не авторизован")
    public void logoutFromPersonalAccount(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        userSteps = new UserSteps();

        userSteps.createUser(email, password, name, 200);
        constructorPage.clickLoginInAccountButton();
        loginPage.setEmailTextField(email);
        loginPage.setPasswordTextField(password);
        loginPage.clickEnterButton();
        constructorPage.clickPersonalAccountButton();
        personalAccountPage.clickLogoutButton();
        loginPage.checkEntranceHeader();
    }

    @After
    public void tearDown() {
        userSteps.deleteUser(userSteps.getToken(email, password));
        driver.quit();
    }
}
