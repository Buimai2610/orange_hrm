package demo.orangehrm.pages;

import demo.orangehrm.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class BasePage  extends  Abstraction {
    public static final String testedLanguage = System.getProperty("language", "english" );
    private final WebDriver webDriver;

    public  BasePage (WebDriver webDriver){

        this.webDriver = webDriver;
    }
    public void openUrl(String url) {
       // chromeDriver = new ChromeDriver();
      //  chromeDriver.manage().window().maximize();
        webDriver.get(url);
        Log.info(this.getClass(), "Open Url", url);

    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
    public String getCssValueOf(String cssAttribute, By locator) {
        return  webDriver.findElement(locator).getCssValue(cssAttribute);
    }

    public List<String> getStringListFormLocator(By locator) {
        List<WebElement> webElementList = webDriver.findElements(locator);
        List<String> result = new ArrayList<>();
        for(WebElement element : webElementList){
            result.add(element.getText());
        }
        return  result;
    }

    /**
     * Check:
     * If current language same as testedLanguage then do nothing
     * Else set application language to testedLanguage
     * @param testedLanguage expected language to be set
     */
    public void setAgodaAppLanguage(String testedLanguage) {
        webDriver.findElement(AgodaHeader.userMenuButton).click();
        String currentLanguage = webDriver.findElement(AgodaUserMenu.selectedLanguageText).getAttribute("alt");
        testedLanguage = convertLanguageToUIDisplay(testedLanguage);
        if (!currentLanguage.equalsIgnoreCase(testedLanguage)) {
            ////button[contains(@aria-describedby,"language")]
            webDriver.findElement(AgodaUserMenu.changeLanguageButton).click();
            String uiLangaugeText = convertLanguageToUIDisplay(testedLanguage);
            By targetLanguageLocator = By.xpath(String.format("//p[text()=\"%s\"]", uiLangaugeText));
            webDriver.findElement(targetLanguageLocator).click();
        }
    }
}
//button[contains(@aria-describedby,language