package ru.course.selenium.steps.store;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.course.selenium.pages.store.CartPage;
import ru.course.selenium.steps.BaseSteps;


/**
 * Created by Aleksei.Klimenko on 04.12.2016.
 */
public class CartSteps extends BaseSteps {

    private CartPage cartPage;

    public CartSteps(){
        this.cartPage = PageFactory.initElements(getDriver(), CartPage.class);
    }

    public CartSteps removeProduct(){
        cartPage.clickRemove();
        return this;
    }

    public Integer getProductsCount(){
        return cartPage.getProductsCount();
    }

    public CartSteps waitTableItemsCountChanged(Integer expectedValue){
        getWaiter().until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(CartPage.PRODUCT_NAME_CSS), expectedValue));
        return this;
    }
}