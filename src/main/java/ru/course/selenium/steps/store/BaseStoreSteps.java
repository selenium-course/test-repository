package ru.course.selenium.steps.store;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.course.selenium.domain.User;
import ru.course.selenium.pages.store.BaseStorePage;
import ru.course.selenium.steps.BaseSteps;

/**
 * Created by Aleksei.Klimenko on 01.12.2016.
 */
public abstract class BaseStoreSteps<T extends BaseStorePage> extends BaseSteps{
    protected T page;

    public BaseStoreSteps(Class<T> pageClass){
        page = PageFactory.initElements(getDriver(), pageClass);
    }

    public CreateAccountSteps openCreateAccount() {
        page.clickCreateAccount();
        return new CreateAccountSteps();
    }

    public StoreSteps toHome(){
        page.clickHome();
        return new StoreSteps();
    }

    public Boolean isUserLoggedIn(){
        return getDriver().findElements(By.cssSelector("div#box-account")).size() == 1;
    }

    public StoreSteps loginAs(User user){
        return loginAs(user.getEmail(), user.getPassword());
    }

    public StoreSteps loginAs(String email, String password){
        page.setEmail(email);
        page.setPassword(password);
        page.clickLogin();
        return new StoreSteps();
    }

    public StoreSteps logout(){
        page.clickLogout();
        return new StoreSteps();
    }

    public CartSteps cartCheckout(){
        page.clickCheckout();
        return new CartSteps();
    }

    public Integer getCartQuantity(){
        return page.getCartQuantity();
    }

    public BaseStoreSteps<T> waitQuantityChanged(Integer expectedValue){
        getWaiter().until(ExpectedConditions.textToBePresentInElementLocated(
                By.cssSelector(BaseStorePage.CART_QUANTITY_CSS),
                expectedValue.toString()));
        return this;
    }
}
