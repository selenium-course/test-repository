package ru.course.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public class AdminLoginPage extends BasePage{
    public static final String LOCAL_URL = "/admin/login.php";

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "login")
    private WebElement loginButton;

    public void setPasswordField(String password) {
        this.passwordField.sendKeys(password);
    }

    public void setUsernameField(String username) {
        this.usernameField.sendKeys(username);
    }

    public void pressLoginButton() {
        this.loginButton.click();
    }

    public static String getPageUrl(){
        return BasePage.SITE_URL + LOCAL_URL;
    }
}
