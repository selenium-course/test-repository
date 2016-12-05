package ru.course.selenium.steps.store;

import org.openqa.selenium.support.PageFactory;
import ru.course.selenium.domain.User;
import ru.course.selenium.pages.store.CreateAccountPage;
import ru.course.selenium.steps.BaseSteps;

/**
 * Created by Aleksei.Klimenko on 05.12.2016.
 */
public class CreateAccountSteps extends BaseSteps {

    private CreateAccountPage createAccountPage;

    public CreateAccountSteps(){
        this.createAccountPage = PageFactory.initElements(getDriver(), CreateAccountPage.class);
    }

    public CreateAccountSteps fillAccountForm(User user) {
        createAccountPage.setFirstName(user.getFirstName());
        createAccountPage.setLastName(user.getLastName());
        createAccountPage.setAddress1(user.getAddress1());
        createAccountPage.setPostcode(user.getPostcode());
        createAccountPage.setCity(user.getCity());
        createAccountPage.setEmail(user.getEmail());
        createAccountPage.setPhone(user.getPhone());
        createAccountPage.setDesiredPassword(user.getPassword());
        createAccountPage.setConfirmPassword(user.getPassword());
        return this;
    }

    public StoreSteps createAccount(){
        createAccountPage.clickCreateAccount();
        return new StoreSteps();
    }
}