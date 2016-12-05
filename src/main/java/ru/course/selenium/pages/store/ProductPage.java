package ru.course.selenium.pages.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.course.selenium.core.LitecartWebException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksei.Klimenko on 04.12.2016.
 */
public class ProductPage extends BaseStorePage {
    private static final String PRODUCT_PRICE_CSS = "div#box-product div.price-wrapper span.price";
    private static final String PRODUCT_REGULAR_PRICE_CSS = "div#box-product s.regular-price";
    private static final String PRODUCT_DISCOUNT_PRICE_CSS = "div#box-product strong.campaign-price";

    private WebDriver driver;

    @FindBy(css = "div#box-similar-products li.product")
    private List<WebElement> similarProducts;

    @FindBy(css = "div#box-product h1")
    private WebElement productName;

    @FindBy(css = "div#box-product div.price-wrapper span.price")
    private WebElement productPrice;

    @FindBy(css = "div#box-product s.regular-price")
    private WebElement productRegularPrice;

    @FindBy(css = "div#box-product strong.campaign-price")
    private WebElement productDiscountPrice;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getSimilarProducts(){
        return this.similarProducts;
    }

    public String getProductName() {
        return this.productName.getText();
    }

    public Boolean hasProductDiscount() {
        if (driver.findElements(By.cssSelector(PRODUCT_PRICE_CSS)).size() == 0 &&
                driver.findElements(By.cssSelector(PRODUCT_REGULAR_PRICE_CSS)).size() == 1 &&
                driver.findElements(By.cssSelector(PRODUCT_DISCOUNT_PRICE_CSS)).size() == 1) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public String getProductPrice() {
        if (hasProductDiscount()) {
            return productDiscountPrice.getText();
        } else {
            return productPrice.getText();
        }
    }

    public String getProductRegularPrice() {
        if (hasProductDiscount()){
            return productRegularPrice.getText();
        }
        throw new LitecartWebException("Could not find regular price for product");
    }

    public String getProductDiscountPrice() {
        if (hasProductDiscount()){
            return productDiscountPrice.getText();
        }
        throw new LitecartWebException("Could not find discount price for product");
    }

    public List<String> getDiscountStyles(){
        List<String> styleList = new ArrayList<>();
        if (hasProductDiscount()){
            styleList.add(productRegularPrice.getCssValue("color"));
            styleList.add(productRegularPrice.getCssValue("font-size"));
            styleList.add(productRegularPrice.getCssValue("text-decoration"));

            styleList.add(productDiscountPrice.getCssValue("color"));
            styleList.add(productDiscountPrice.getCssValue("font-size"));
            styleList.add(productDiscountPrice.getCssValue("font-weight"));
        }
        return styleList;
    }
}
