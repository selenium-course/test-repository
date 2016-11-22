package ru.course.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public class AdminPage extends BasePage{
    public static final String LOCAL_URL = "/admin";

    @FindBy(id = "platform")
    private WebElement version;

    public String getVesion() {
        return this.version.getText();
    }

    public static String getPageUrl(){
        return BasePage.SITE_URL + LOCAL_URL;
    }
}
