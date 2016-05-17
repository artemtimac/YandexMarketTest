package com.datateh.utils;

import com.datateh.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by atugushev on 07.04.2016.
 */
public class WebDriverFactory
{
    private static WebDriver driver;

    public static WebDriver getDriver(String browserName, String browserVersion) throws MalformedURLException
    {
        if (driver == null)
        {
            URL hubUrl = new URL("http://atugushev-pc.datateh.ru:4444/wd/hub");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browserName);
            capabilities.setVersion(browserVersion);
            driver = new RemoteWebDriver(hubUrl, capabilities);
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