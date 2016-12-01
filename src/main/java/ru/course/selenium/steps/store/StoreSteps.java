package ru.course.selenium.steps.store;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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

    public List<WebElement> getMostPopular(){
        return storePage.getMostPopular();
    }

    public List<WebElement> getCampaigns(){
        return storePage.getCampaigns();
    }

    public List<WebElement> getLatestProducts(){
        return storePage.getLatestProducts();
    }

    public Integer getProductStickersCount(WebElement element){
        return element.findElements(By.cssSelector("div.sticker")).size();
    }
}
