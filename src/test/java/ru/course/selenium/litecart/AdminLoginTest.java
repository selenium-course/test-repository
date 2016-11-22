package ru.course.selenium.litecart;

import org.testng.annotations.Test;
import ru.course.selenium.BaseTest;
import ru.course.selenium.steps.AdminSteps;
import ru.course.selenium.steps.AdminLoginSteps;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public class AdminLoginTest extends BaseTest{

    private AdminLoginSteps adminLoginSteps = new AdminLoginSteps();

    @Test
    public void loginTest() {
        adminLoginSteps.openLoginPage();
        AdminSteps adminSteps = adminLoginSteps.loginAs("admin", "admin");
        System.out.println("Version = " + adminSteps.getVersion());
    }
}
