package ru.course.selenium.steps.store;

import org.openqa.selenium.WebElement;
import ru.course.selenium.pages.store.ProductPage;

import java.util.List;

/**
 * Created by Aleksei.Klimenko on 04.12.2016.
 */
public class ProductSteps extends BaseStoreSteps{

    private ProductPage productPage;

    public ProductSteps(){
        super(ProductPage.class);
        this.productPage = (ProductPage)super.page;
    }

    public List<WebElement> getSimilarProducts(){
        return productPage.getSimilarProducts();
    }

    public String getProductName() {
        return productPage.getProductName();
    }

    public Boolean hasProductDiscount() {
        return productPage.hasProductDiscount();
    }

    public String getProductPrice() {
        return productPage.getProductPrice();
    }

    public String getProductRegularPrice() {
        return productPage.getProductRegularPrice();
    }

    public String getProductDiscountPrice() {
        return productPage.getProductDiscountPrice();
    }

    public List<String> getDiscountStyles(){
        return productPage.getDiscountStyles();
    }

    public ProductSteps addProductToCart(){
        productPage.addToCart();
        return this;
    }
}