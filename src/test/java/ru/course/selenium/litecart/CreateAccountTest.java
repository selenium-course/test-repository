package ru.course.selenium.litecart;

import org.testng.annotations.Test;
import ru.course.selenium.BaseTest;
import ru.course.selenium.domain.User;
import ru.course.selenium.steps.store.StoreSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Aleksei.Klimenko on 05.12.2016.
 */
public class CreateAccountTest extends BaseTest{

    private StoreSteps storeSteps = new StoreSteps();

    @Test
    public void createAccountTest() {
        storeSteps.openStorePage();
        User user = User.getDefault();
        StoreSteps steps = storeSteps.openCreateAccount()
                .fillAccountForm(user)
                .createAccount()
                .logout()
                .loginAs(user);
        assertThat("User is not logged in", steps.isUserLoggedIn(), equalTo(Boolean.TRUE));
    }
}

