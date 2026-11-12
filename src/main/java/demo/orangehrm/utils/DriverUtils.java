package demo.orangehrm.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.reflect.Method;
import java.time.Duration;

public class DriverUtils {

    public WebDriver initBrowser(){
        String browserName = System.getProperty("browser", "chrome");
        WebDriver webDriver;
        switch (browserName){
            case "chrome":
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                webDriver = new FirefoxDriver();
                break;
            case "edge":
                webDriver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException(String.format(
                        "Not supported browser: %s. Allowed: [\"chrome\", \"firefox\", \"edge\"]", browserName));        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // set implicit wait
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3)); // set page load timeout
        return webDriver;
    }


    public void quitBrowser(WebDriver webDriver ) {
        webDriver.quit();
    }
}
