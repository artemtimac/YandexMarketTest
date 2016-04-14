package com.datateh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

/**
 * Created by atugushev on 07.04.2016.
 */

public class PhonePage extends Page
{
    @CacheLookup
    @FindBy(xpath = "//*[@class='product-card__offer']//*[@data-rate]")
    private WebElement phoneRating;

    public int getRating()
    {
        int rating = Integer.parseInt(phoneRating.getAttribute("data-rate"));
        System.out.println("Rating: " + rating);
        return rating;
    }
}
