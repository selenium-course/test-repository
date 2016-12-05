package ru.course.selenium.litecart;

import org.testng.annotations.Test;
import ru.course.selenium.BaseTest;
import ru.course.selenium.domain.User;
import ru.course.selenium.domain.UserEnum;
import ru.course.selenium.steps.admin.AdminSteps;
import ru.course.selenium.steps.admin.AdminLoginSteps;
import ru.course.selenium.steps.store.CreateAccountSteps;
import ru.course.selenium.steps.store.StoreSteps;

/**
 * Created by Aleksei.Klimenko on 05.12.2016.
 */
public class CreateAccountTest extends BaseTest{

    private StoreSteps storeSteps = new StoreSteps();

    @Test
    public void createAccountTest() {
        storeSteps.openStorePage();
        User user = User.getDefault();
        CreateAccountSteps accSteps = storeSteps.openCreateAccount();
        StoreSteps steps = accSteps.fillAccountForm(user)
                .createAccount();
        StoreSteps steps2 = steps.logout();
        StoreSteps steps3 = steps2.loginAs(user);

    }
}

