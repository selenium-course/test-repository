package ru.course.selenium.pages.store;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.course.selenium.pages.BasePage;

/**
 * Created by Aleksei.Klimenko on 01.12.2016.
 */
public abstract class BaseStorePage extends BasePage {

    @FindBy(id = "nav#site-menu li.general-0")
    private WebElement buttonHome;

    @FindBy(id = "form[name=login_form] input[name=email]")
    private WebElement fieldEmail;

    @FindBy(id = "form[name=login_form] input[name=password]")
    private WebElement fieldPassword;

    @FindBy(id = "form[name=login_form] input[name=password]")
    private WebElement buttonLogin;

    public void clickHome() {
        buttonHome.click();
    }

    public void setEmail(String email) {
        fieldEmail.sendKeys(email);
    }

    public void setPassword(String password) {
        fieldPassword.sendKeys(password);
    }

    public void clickLogin() {
        buttonLogin.click();
    }
}
