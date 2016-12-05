package ru.course.selenium.pages.store;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.course.selenium.pages.BasePage;
import ru.course.selenium.steps.store.CreateAccountSteps;

/**
 * Created by Aleksei.Klimenko on 01.12.2016.
 */
public abstract class BaseStorePage extends BasePage {

    @FindBy(css = "nav#site-menu li.general-0")
    private WebElement buttonHome;

    @FindBy(css = "form[name=login_form] input[name=email]")
    private WebElement fieldEmail;

    @FindBy(css = "form[name=login_form] input[name=password]")
    private WebElement fieldPassword;

    @FindBy(css = "form[name=login_form] button[name=login]")
    private WebElement buttonLogin;

    @FindBy(css = "form[name=login_form] a[href$=create_account]")
    private WebElement linkCreateAccount;

    @FindBy(css = "div#box-account a[href$=logout]")
    private WebElement linkLogout;

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

    public void clickLogout() {
        linkLogout.click();
    }

    public void clickCreateAccount() {
        linkCreateAccount.click();
    }
}
