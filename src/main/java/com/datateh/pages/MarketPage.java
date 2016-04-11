package com.datateh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by atugushev on 07.04.2016.
 */

public class MarketPage extends Page
{
    @CacheLookup
    @FindBy(xpath = "//*[a[text()='Электроника']]")
    private WebElement electronics;
    @CacheLookup
    @FindBy(xpath = "//*[text()='Мобильные телефоны']")
    private WebElement phones;

    public void open(String section)
    {
        switch (section.toLowerCase())
        {
            case "phones" :
                action.moveToElement(electronics).perform();
                wait.until(ExpectedConditions.visibilityOf(phones)).click();
                phonesPage = new PhonesPage();
                break;
            default :
                System.out.println("Section doesn't exist!");
                break;
        }
    }
}
