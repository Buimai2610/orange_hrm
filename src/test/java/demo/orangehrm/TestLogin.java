package demo.orangehrm;

import demo.orangehrm.pages.BasePage;
import demo.orangehrm.pages.LoginPage;
import demo.orangehrm.pages.TopHeader;
import demo.orangehrm.utils.DriverUtils;
import demo.orangehrm.utils.TestDataHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestLogin {
    private WebDriver driver;
    private BasePage basePage;
     DriverUtils driverUtils;

     @BeforeClass
     public  static  void setUp(){
         new TestDataHelper().loadEnviromentTestData();
     }

    @BeforeTest
    public void  prepareTestCondition (){
        // khởi tạo brownser
        driverUtils = new DriverUtils();
        driver =  driverUtils.initBrowser();
        //Ascess orange url
        basePage = new BasePage(driver); //https://www.google.com - orange_url
        String url = TestDataHelper.getDataOf("orange_url");
 //       basePage.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        basePage.openUrl(url);

    }

    @AfterMethod
    public void tearDown (){
     driverUtils.quitBrowser(driver);
   }

    @Test
    void testLoginSuccesfully() throws InterruptedException{

        LoginPage loginPage = new LoginPage(driver);

        // verify login button is enable event username and password are not filld
        boolean loginButtonIsEnabled = loginPage.checkLoginButtonIsEnabled();
        Assert.assertTrue(loginButtonIsEnabled, "Login is not enables ");

        //   loginPage.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.inputUsername(TestDataHelper.getDataOf("admin_username"));
        loginPage.inputPassword(TestDataHelper.getDataOf("admin_password"));
        loginPage.clickLoginButton();

        //Verify: Check URL/ Dashboard / profile image
        String currentUrl = basePage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard"));

        //getText()
        TopHeader topHeader = new TopHeader(driver);
        String currentPageTitle = topHeader.getPageTitle();
        Assert.assertEquals(currentPageTitle, "Dashboard");
        //isVisible
        boolean profileImageDisplay = topHeader.getDisplayOfProfileImage();
        Assert.assertTrue(profileImageDisplay, "Profile image is not displayed");



    }
    @Test
    void loginSucessfullUsingForm (){
        //openlogin URL
         // login account
      //  ChromeDriver chromeDriver = basePage.getWebDriver();

        LoginPage loginPage = new LoginPage(driver);

        // verify login button is enable event username and password are not filld
        boolean loginButtonIsEnabled = loginPage.checkLoginButtonIsEnabled();
        Assert.assertTrue(loginButtonIsEnabled, "Login is not enables ");


        //   loginPage.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        loginPage.submitFormLogin();
    }

    @Test
    void verifyLoginFormCssStyle() {
       // login account
       // ChromeDriver chromeDriver = basePage.getWebDriver();

        LoginPage loginPage = new LoginPage(driver);

        //check background
        String loginButtonBackgoundColor = loginPage.getBackgroundLoginButton();
        Assert.assertEquals(loginButtonBackgoundColor, "rgba(21, 244, 233, 1)");


    }


}
