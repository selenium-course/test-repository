package ru.course.selenium.litecart;

import org.testng.annotations.Test;
import ru.course.selenium.BaseTest;
import ru.course.selenium.domain.UserEnum;
import ru.course.selenium.steps.admin.AdminSteps;
import ru.course.selenium.steps.admin.AdminLoginSteps;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public class AdminLoginTest extends BaseTest{

    private AdminLoginSteps adminLoginSteps = new AdminLoginSteps();

    @Test
    public void loginTest() {
        adminLoginSteps.openLoginPage();
        AdminSteps adminSteps = adminLoginSteps.loginAs(UserEnum.ADMIN);
        System.out.println("Version = " + adminSteps.getVersion());
    }
}
