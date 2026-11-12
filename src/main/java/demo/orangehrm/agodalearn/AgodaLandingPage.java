package demo.orangehrm.agodalearn;

import demo.orangehrm.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AgodaLandingPage extends BasePage {
    private  final WebDriver webDriver;
    private final By welcomeMsg =  By.cssSelector("h1");
    private final By tabNameList =  By.xpath(" //div[@role=\"tablist\"]/div//p");
    public AgodaLandingPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public String getWelcomeMsg() {
        return webDriver.findElement(welcomeMsg).getText();
    }

    public List<String> getTabNameList() {
        return getStringListFormLocator(tabNameList);

    }

}

//  div[role="tablist"]div
//  //div[@role="tablist"]/div//p
