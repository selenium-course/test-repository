package ru.course.selenium.steps.store;

import org.openqa.selenium.WebElement;
import ru.course.selenium.core.ConfigurationProperties;
import ru.course.selenium.pages.store.StorePage;

import java.util.List;

/**
 * Created by Aleksei.Klimenko on 01.12.2016.
 */
public class StoreSteps extends BaseStoreSteps{

    private StorePage storePage;

    public StoreSteps(){
        super(StorePage.class);
        this.storePage = (StorePage)super.page;
    }

    public StoreSteps openStorePage() {
        getDriver().get(ConfigurationProperties.getInstance().getEndpoint());
        return this;
    }

    public StoreSteps loginAs(String email, String password){
        storePage.setEmail(email);
        storePage.setPassword(password);
        storePage.clickLogin();
        return this;
    }

    public ProductSteps openProductPage(WebElement productElement){
        productElement.click();
        return new ProductSteps();
    }

    public List<WebElement> getMostPopular(){
        return storePage.getMostPopular();
    }

    public List<WebElement> getCampaigns(){
        return storePage.getCampaigns();
    }

    public List<WebElement> getLatestProducts(){
        return storePage.getLatestProducts();
    }

    public Integer getProductStickersCount(WebElement productElement){
        return storePage.getProductStickersCount(productElement);
    }

    public String getProductName(WebElement productElement){
        return storePage.getProductName(productElement);
    }

    public Boolean hasProductDiscount(WebElement productElement){
        return storePage.hasProductDiscount(productElement);
    }

    public String getProductPrice(WebElement productElement){
        return storePage.getProductPrice(productElement);
    }

    public String getProductDiscountPrice(WebElement productElement){
        return storePage.getProductDiscountPrice(productElement);
    }

    public String getProductRegularPrice(WebElement productElement){
        return storePage.getProductRegularPrice(productElement);
    }

    public List<String> getDiscountStyles(WebElement productElement){
        return storePage.getDiscountStyles(productElement);
    }
}