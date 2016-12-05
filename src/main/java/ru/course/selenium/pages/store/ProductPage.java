package ru.course.selenium.pages.store;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.course.selenium.core.LitecartWebException;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Aleksei.Klimenko on 04.12.2016.
 */
public class ProductPage extends BaseStorePage {

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

    public List<WebElement> getSimilarProducts(){
        return this.similarProducts;
    }

    public String getProductName() {
        return this.productName.getText();
    }

    public Boolean hasProductDiscount() {
        try {
            if (productPrice.isDisplayed()) {
                return Boolean.FALSE;
            }
            if (productRegularPrice.isDisplayed() && productDiscountPrice.isDisplayed()) {
                return Boolean.TRUE;
            }
        } catch (NoSuchElementException ex) {
            return Boolean.TRUE;
        }
        throw new LitecartWebException("Could not correctly determine product price");
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
