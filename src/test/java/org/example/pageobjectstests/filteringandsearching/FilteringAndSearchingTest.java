package org.example.pageobjectstests.filteringandsearching;

import org.example.pageobjectstests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FilteringAndSearchingTest extends BaseTest {

    @DataProvider(name = "brandNames")
    public Object[][] brandNames() {
        return new Object[][]{
                {"Corsair"}
        };
    }

    @Test(dataProvider = "brandNames")
    public void verifyTitlesContainChosenBrand(String brandName) {
        boolean everyTitleContainsInputWord = mainPage
                .openMainPage()
                .openGamingKeyboardsPage()
                .selectBrand(brandName)
                .verifyEveryTitleContainsBrandName(brandName);

        Assert.assertTrue(everyTitleContainsInputWord, "Not every title contains chosen brand name");
    }

    @DataProvider(name = "brandNamesAndPriceRanges")
    public Object[][] brandNamesAndPriceRanges() {
        return new Object[][]{
                {"Corsair", 50, 250}
        };
    }

    @Test(dataProvider = "brandNamesAndPriceRanges")
    public void verifyProductsPricesAreInDefinedRange(String brandName, float minPrice, float maxPrice) {
        boolean arePricesInChosenRange = mainPage
                .openMainPage()
                .openGamingKeyboardsPage()
                .selectBrand(brandName)
                .setPriceRange(minPrice, maxPrice)
                .verifyPricesAreInChosenRange(minPrice, maxPrice);

        Assert.assertTrue(arePricesInChosenRange, "Prices are not within specified range");
    }

    @Test(dataProvider = "brandNames")
    public void verifyProductsPricesAreSortedAscendingly(String brandName) {
        boolean arePricesInAscendingOrder = mainPage
                .openMainPage()
                .openGamingKeyboardsPage()
                .selectBrand(brandName)
                .sortProductsByPriceLowToHigh()
                .verifyPricesAreInAscendingOrder();

        Assert.assertTrue(arePricesInAscendingOrder, "Prices are not in ascending order");
    }
}
