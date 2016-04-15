package com.datateh.tests;

/**
 * Created by atugushev on 04.04.2016.
 */

import org.junit.*;
import com.datateh.pages.*;

public class YandexTest extends TestBase
{
    @Test
    public void testMarket() throws Exception
    {
        HomePage.open();
        Page.homePage.open("Market");
        Page.marketPage.open("Phones");
        Page.phonesPage.open("Advanced Search");
        Page.phonesSearchPage.fillForm();
        Page.phonesSearchPage.sortBy("Novelty");
        Page.phonesSearchPage.findMostPopular();
        Page.phonePage.getRating();
    }
}