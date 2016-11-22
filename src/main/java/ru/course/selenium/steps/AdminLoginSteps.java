package ru.course.selenium.steps;

import org.openqa.selenium.support.PageFactory;
import ru.course.selenium.pages.AdminLoginPage;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public class AdminLoginSteps extends BaseSteps{

    private AdminLoginPage adminLoginPage;

    public AdminSteps loginAs(String username, String password){
        adminLoginPage.setUsernameField(username);
        adminLoginPage.setPasswordField(password);
        adminLoginPage.pressLoginButton();
        return new AdminSteps();
    }

    public AdminLoginSteps openLoginPage(){
        getDriver().get(AdminLoginPage.getPageUrl());
        this.adminLoginPage = PageFactory.initElements(getDriver(), AdminLoginPage.class);
        return this;
    }
}
