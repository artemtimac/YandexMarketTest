package com.datateh.browser;

import com.datateh.pages.Page;
import com.datateh.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
/**
 * Created by atugushev on 07.04.2016.
 */

public class Browser
{
    private static WebDriver driver;

    public static WebDriver getDriver()
    {
        if (driver == null)
        {
            switch(TestProperties.getTestProperty("browser"))
            {
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "ie":
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    System.out.println("No such driver");
                    break;
            }
            driver.manage()
                    .window()
                    .maximize();
            driver.manage()
                    .timeouts()
                    .implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage()
                    .timeouts()
                    .pageLoadTimeout(10,TimeUnit.SECONDS);
            Page.wait = new WebDriverWait(driver, 5);
            Page.action = new Actions(driver);
        }
        return driver;
    }
}