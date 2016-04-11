package com.datateh.browser;

import com.datateh.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by atugushev on 07.04.2016.
 */

public class Browser {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
            driver.manage()
                    .window()
                    .maximize();
            driver.manage()
                    .timeouts()
                    .implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage()
                    .timeouts()
                    .pageLoadTimeout(10,TimeUnit.SECONDS);
            Page.wait = new WebDriverWait(driver, 3);
            Page.action = new Actions(driver);
        }
        return driver;
    }
}
