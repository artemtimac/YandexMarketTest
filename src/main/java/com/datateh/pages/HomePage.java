package com.datateh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

/**
 * Created by atugushev on 07.04.2016.
 */

public class HomePage extends Page
{
    private final static String URL = "http://yandex.ru/";

    @CacheLookup
    @FindBy(xpath = "//*[text()='Маркет']")
    private WebElement market;

    public static void open()
    {
        getDriver().get(URL);
        homePage = new HomePage();
    }

    public void open(String section)
    {
        switch (section.toLowerCase())
        {
            case "market" :
                market.click();
                marketPage = new MarketPage();
                break;
            default :
                System.out.println("Section doesn't exist!");
                break;
        }
    }
}
