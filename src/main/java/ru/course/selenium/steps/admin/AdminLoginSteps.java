package ru.course.selenium.steps.admin;

import org.openqa.selenium.support.PageFactory;
import ru.course.selenium.core.ConfigurationProperties;
import ru.course.selenium.domain.UserEnum;
import ru.course.selenium.pages.admin.AdminLoginPage;
import ru.course.selenium.steps.BaseSteps;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public class AdminLoginSteps extends BaseSteps {

    private AdminLoginPage adminLoginPage;

    public AdminLoginSteps(){
        this.adminLoginPage = PageFactory.initElements(getDriver(), AdminLoginPage.class);
    }

    public AdminSteps loginAs(UserEnum user){
        return this.loginAs(user.getUsername(), user.getPassword());
    }

    public AdminSteps loginAs(String username, String password){
        adminLoginPage.setUsernameField(username);
        adminLoginPage.setPasswordField(password);
        adminLoginPage.pressLoginButton();
        return new AdminSteps();
    }

    public AdminLoginSteps openLoginPage(){
        getDriver().get(ConfigurationProperties.getInstance().getEndpoint() + AdminLoginPage.LOCAL_URL);
        return this;
    }
}
