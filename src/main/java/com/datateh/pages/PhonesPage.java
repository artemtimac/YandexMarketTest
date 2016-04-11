package com.datateh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

/**
 * Created by atugushev on 07.04.2016.
 */

public class PhonesPage extends Page
{
    @CacheLookup
    @FindBy(xpath = "//*[contains(text(),'Расширенный поиск')]")
    private WebElement advancedSearch;

    public void open(String section)
    {
        switch (section.toLowerCase())
        {
            case "advanced search" :
                advancedSearch.click();
                phonesSearchPage = new PhonesSearchPage();
                break;
            default :
                System.out.println("Section doesn't exist!");
                break;
        }
    }
}
