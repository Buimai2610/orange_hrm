package demo.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends  BasePage{
    private final WebDriver webDriver;
    private final By usernameTextBox = By.name("username");
    private final By passwordTextBox = By.name("password");
    private final By loginButton = By.cssSelector("button[class*=\"login-button\"]");
    private final By loginForm = By.cssSelector("form");

    public LoginPage (WebDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    public void inputUsername(String username) {
        webDriver.findElement(usernameTextBox).clear();
        webDriver.findElement(usernameTextBox).sendKeys(username);

    }

    public void inputPassword(String password) {
        webDriver.findElement(passwordTextBox).clear();
        webDriver.findElement(passwordTextBox).sendKeys(password);
    }

    public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }

    public boolean getLoginButton() {
        return false;
    }

    public boolean checkLoginButtonIsEnabled() {
        return  webDriver.findElement(loginButton).isEnabled();
    }

    public void submitFormLogin() {
        webDriver.findElement(loginForm).submit();
    }


    public String getBackgroundLoginButton() {
       return  getCssValueOf("background-color",loginButton);
    //    return chromeDriver.findElement(loginButton).getCssValue("background-color");
    }
    public String getColorOfLoginButton() {
        return getCssValueOf("color", loginButton);
    }

    public String getAttributeOfUserName() {
        return webDriver.findElement(usernameTextBox).getAttribute("username");
    }


}

