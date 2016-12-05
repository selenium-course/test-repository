package ru.course.selenium.pages.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.course.selenium.core.LitecartWebException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksei.Klimenko on 01.12.2016.
 */
public class StorePage extends BaseStorePage {
    private static final By PRODUCT_PRICE_LOCATOR = By.cssSelector("div.price-wrapper span.price");
    private static final By PRODUCT_REGULAR_PRICE_LOCATOR = By.cssSelector("div.price-wrapper s.regular-price");
    private static final By PRODUCT_DISCOUNT_PRICE_LOCATOR = By.cssSelector("div.price-wrapper strong.campaign-price");

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

    public Integer getProductStickersCount(WebElement productElement){
        return productElement.findElements(By.cssSelector("div.sticker")).size();
    }

    public String getProductName(WebElement productElement) {
        return productElement.findElement(By.cssSelector("div.name")).getText();
    }

    public Boolean hasProductDiscount(WebElement productElement) {
        if (productElement.findElements(PRODUCT_PRICE_LOCATOR).size() == 0 &&
                productElement.findElements(PRODUCT_REGULAR_PRICE_LOCATOR).size() == 1 &&
                productElement.findElements(PRODUCT_DISCOUNT_PRICE_LOCATOR).size() == 1) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public String getProductPrice(WebElement productElement) {
        By priceLocator;
        if (hasProductDiscount(productElement)) {
            priceLocator = PRODUCT_DISCOUNT_PRICE_LOCATOR;
        } else {
            priceLocator = PRODUCT_PRICE_LOCATOR;
        }
        return productElement.findElement(priceLocator).getText();
    }

    public String getProductRegularPrice(WebElement productElement) {
        if (hasProductDiscount(productElement)){
            return productElement.findElement(PRODUCT_REGULAR_PRICE_LOCATOR).getText();
        }
        throw new LitecartWebException("Could not find regular price for product");
    }

    public String getProductDiscountPrice(WebElement productElement) {
        if (hasProductDiscount(productElement)){
            return productElement.findElement(PRODUCT_DISCOUNT_PRICE_LOCATOR).getText();
        }
        throw new LitecartWebException("Could not find discount price for product");
    }

    public List<String> getDiscountStyles(WebElement productElement){
        List<String> styleList = new ArrayList<>();
        if (hasProductDiscount(productElement)){
            styleList.add(productElement.findElement(PRODUCT_REGULAR_PRICE_LOCATOR).getCssValue("color"));
            styleList.add(productElement.findElement(PRODUCT_REGULAR_PRICE_LOCATOR).getCssValue("font-size"));
            styleList.add(productElement.findElement(PRODUCT_REGULAR_PRICE_LOCATOR).getCssValue("text-decoration"));

            styleList.add(productElement.findElement(PRODUCT_DISCOUNT_PRICE_LOCATOR).getCssValue("color"));
            styleList.add(productElement.findElement(PRODUCT_DISCOUNT_PRICE_LOCATOR).getCssValue("font-size"));
            styleList.add(productElement.findElement(PRODUCT_DISCOUNT_PRICE_LOCATOR).getCssValue("font-weight"));
        }
        return styleList;
    }
}
