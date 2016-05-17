package com.datateh.utils;

import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;

/**
 * Created by atugushev on 13.05.2016.
 */
public class WebDriverManager
{
    private static InheritableThreadLocal<WebDriver> webDriver = new InheritableThreadLocal<WebDriver>();
    private static WebDriverFactory factory;

    public static void setDriver(String browserName, String browserVersion) throws MalformedURLException
    {
        factory = new WebDriverFactory();
        webDriver.set(factory.getDriver(browserName, browserVersion));
    }

    public static WebDriver getDriver()
    {
        return webDriver.get();
    }
}
