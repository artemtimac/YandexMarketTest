package com.datateh.tests;

import com.datateh.browser.Browser;
import org.junit.*;

/**
 * Created by atugushev on 07.04.2016.
 */

public abstract class TestBase
{
    @After
    public void tearDown()
    {
        Browser.getDriver().close();
    }
}
