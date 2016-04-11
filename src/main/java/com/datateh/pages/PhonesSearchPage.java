package com.datateh.pages;

import java.lang.Thread;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

/**
 * Created by atugushev on 07.04.2016.
 */

public class PhonesSearchPage extends Page
{
    //region WebElements
    @CacheLookup
    @FindBy(xpath = "//*[contains(text(),'Диагональ')]")
    private WebElement diagonalForm;
    @CacheLookup
    @FindBy(id = "gf-pricefrom-var")
    private WebElement priceFrom;
    @CacheLookup
    @FindBy(id = "gf-2142557926-from")
    private WebElement diagonalFrom;
    @CacheLookup
    @FindBy(id = "gf-1801946-1871375")
    private WebElement appleBox;
    @CacheLookup
    @FindBy(xpath = "//*[contains(@class,'button_action_filter-apply')]")
    private WebElement applyButton;
    @CacheLookup
    @FindBy(xpath = "//*[contains(@class,'filter-panel-counter')]")
    private WebElement counter;
    @CacheLookup
    @FindBy(xpath = "//*[span[text()='Apple iPhone 5S 16Gb']]")
    private WebElement apple5s;
    @CacheLookup
    @FindBy(xpath = "//*[text()='по новизне']")
    private WebElement byNovelty;
    @CacheLookup
    @FindBy(xpath = "//a[contains(@href,'page=2')]")
    private WebElement pageTwo;
    //endregion

    private void printCount(WebElement counter, String text)
    {
        wait.until(ExpectedConditions.visibilityOf(counter));
        String counterText = counter.getText();
        int phones = Integer.parseInt(counterText.substring(0, counterText.indexOf(" ")));
        System.out.println(phones + text);
    }
    public void fillForm()
    {
        priceFrom.sendKeys("35000");
        diagonalForm.click();
        diagonalFrom.sendKeys("3");
        applyButton.click();
        printCount(counter, " phones from 35000 rub and from 3 inches");
        appleBox.click();
        applyButton.click();
        printCount(counter, " of them - Apple phones");
    }
    public void sortBy(String filter) throws Exception
    {
        switch (filter.toLowerCase())
        {
            case "novelty" :
                byNovelty.click();
                Thread.sleep(3000);
                break;
            default :
                System.out.println("Filter doesn't exist!");
                break;
        }
    }
    public void openPhone(String phone)
    {
        switch (phone.toLowerCase())
        {
            case "apple iphone 5s 16gb" :
                apple5s.click();
                apple5sPage = new Apple5sPage();
                break;
            default :
                System.out.println("Phone not found!");
                break;
        }
    }
    public void openPage(String number)
    {
        switch (number)
        {
            case "2" :
                wait.until(ExpectedConditions.elementToBeClickable(pageTwo)).click();
                break;
            default :
                System.out.println("Page with this number doesn't exist!");
                break;
        }
    }
}