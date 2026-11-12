package demo.orangehrm;

import demo.orangehrm.pages.AdminPage;
import demo.orangehrm.pages.BasePage;
import demo.orangehrm.pages.LoginPage;
import demo.orangehrm.pages.NavigationPanel;
import demo.orangehrm.utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAdminFeature {
    private WebDriver driver;
    private BasePage basePage;
    DriverUtils driverUtils;
    @BeforeMethod
    public void  prepareTestCondition (){
        // khởi tạo brownser
        driverUtils = new DriverUtils();
        driver =  driverUtils.initBrowser();
        basePage = new BasePage(driver);
        basePage.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //Ascess orange url
    }
    @AfterMethod
    public void tearDown (){
        driverUtils.quitBrowser(driver);
    }
    @Test
    void testRecordCheckBoxBehavior() throws InterruptedException {
        //openlogin URL
       // login account
       // ChromeDriver chromeDriver = basePage.getWebDriver();

        LoginPage loginPage = new LoginPage(driver);

        // verify login button is enable event username and password are not filld
        boolean loginButtonIsEnabled = loginPage.checkLoginButtonIsEnabled();
        Assert.assertTrue(loginButtonIsEnabled, "Login is not enables ");


        //   loginPage.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        loginPage.clickLoginButton();
        NavigationPanel navigationPanel = new NavigationPanel(driver);
        navigationPanel.clickAdminMenu();
        AdminPage adminPage = new AdminPage(driver);

        boolean firstRecordCheckBoxIsChecked = adminPage.isFirstRecordCheckBoxChecked();
        Assert.assertFalse(firstRecordCheckBoxIsChecked, "Default status off ist record checkbox ");
        adminPage.clickFirstRecordCheckBox();
        firstRecordCheckBoxIsChecked = adminPage.isFirstRecordCheckBoxChecked();
        Assert.assertTrue(firstRecordCheckBoxIsChecked, " ist record checkbox  is not checkes ");

    }

}
