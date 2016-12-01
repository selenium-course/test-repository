package ru.course.selenium.pages.store;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Aleksei.Klimenko on 01.12.2016.
 */
public class StorePage extends BaseStorePage {

    @FindBy(css = "div#box-most-popular li.product")
    private List<WebElement> mostPopular;

    @FindBy(css = "div#box-campaigns li.product")
    private List<WebElement> campaigns;

    @FindBy(css = "div#box-latest-products li.product")
    private List<WebElement> latestProducts;

    public List<WebElement> getMostPopular(){
        return this.mostPopular;
    }

    public List<WebElement> getCampaigns(){
        return this.campaigns;
    }

    public List<WebElement> getLatestProducts(){
        return this.latestProducts;
    }
}
