package com.datateh.pages;

import com.datateh.utils.WebDriverFactory;
import com.datateh.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by atugushev on 07.04.2016.
 */

public abstract class Page
{
    public static HomePage homePage;
    public static MarketPage marketPage;
    public static PhonesPage phonesPage;
    public static PhonesSearchPage phonesSearchPage;
    public static PhonePage phonePage;

    public static WebDriverWait wait;
    public static Actions action;

    public Page()
    {
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }
}
