package com.datateh.tests;

/**
 * Created by atugushev on 07.04.2016.
 */

import com.datateh.utils.WebDriverManager;
import org.testng.annotations.*;
import java.net.MalformedURLException;

public abstract class TestBase
{
    @Parameters({"browserName", "browserVersion"})
    @BeforeClass
    public void setUp(@Optional String browserName, String browserVersion) throws MalformedURLException
    {
        WebDriverManager.setDriver(browserName, browserVersion);
    }

    @AfterClass
    public void tearDown() throws Exception{
        WebDriverManager.getDriver().close();
    }
}
