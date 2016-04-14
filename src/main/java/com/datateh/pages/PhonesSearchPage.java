package com.datateh.pages;

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
    @FindBy(xpath = "//*[text()='по новизне']")
    private WebElement byNovelty;
    @CacheLookup
    @FindBy(xpath = "//a[contains(@href,'page=2')]")
    private WebElement pageTwo;
    @CacheLookup
    @FindBy(className = "snippet-card__header-text")
    private WebElement firstPhone;
    //endregion
    private String firstPhoneName;
    private int page = 1;

    private void openPage(int number)
    {
        switch (number)
        {
            case 2:
                pageTwo.click();
                break;
            case 3:
                //pageThree.click();
                break;
            default:
                System.out.println("Page with this number doesn't exist!");
                break;
        }
    }

    private void printCount(WebElement counter, String text)
    {
        applyButton.click();
        String counterText = wait.until(ExpectedConditions.visibilityOf(counter)).getText();
        int phones = Integer.parseInt(counterText.substring(0, counterText.indexOf(" ")));
        System.out.println(phones + text);
    }

    public void fillForm()
    {
        priceFrom.sendKeys("35000");
        diagonalForm.click();
        diagonalFrom.sendKeys("3");
        printCount(counter, " phones from 35000 rub and from 3 inches");
        appleBox.click();
        printCount(counter, " of them - Apple phones");
    }

    public void sortBy(String filter) throws Exception
    {
        firstPhoneName = wait.until(ExpectedConditions.visibilityOf(firstPhone)).getText();
        switch (filter.toLowerCase())
        {
            case "novelty" :
                byNovelty.click();
                Thread.sleep(1500);
                break;
            default :
                System.out.println("Filter doesn't exist!");
                break;
        }
    }

    public void openMostPopular()
    {
        try
        {
            getDriver()
                    .findElement(By.xpath(String.format("//*[@title = '%s']", firstPhoneName)))
                    .click();
            System.out.println(firstPhoneName + " is most popular");
            phonePage = new PhonePage();
        }
        catch (Exception e)
        {
            page++;
            openPage(page);
            openMostPopular();
        }
    }
}