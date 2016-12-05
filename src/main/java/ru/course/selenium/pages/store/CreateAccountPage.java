package ru.course.selenium.pages.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.course.selenium.core.LitecartWebException;
import ru.course.selenium.pages.BasePage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksei.Klimenko on 05.12.2016.
 */
public class CreateAccountPage extends BasePage{

    @FindBy(css = "form[name=customer_form] input[name=firstname]")
    private WebElement fieldFirstName;

    @FindBy(css = "form[name=customer_form] input[name=lastname]")
    private WebElement fieldLastName;

    @FindBy(css = "form[name=customer_form] input[name=address1]")
    private WebElement fieldAddress1;

    @FindBy(css = "form[name=customer_form] input[name=postcode]")
    private WebElement fieldPostcode;

    @FindBy(css = "form[name=customer_form] input[name=city]")
    private WebElement fieldCity;

    @FindBy(css = "form[name=customer_form] input[name=email]")
    private WebElement fieldEmail;

    @FindBy(css = "form[name=customer_form] input[name=phone]")
    private WebElement fieldPhone;

    @FindBy(css = "form[name=customer_form] input[name=password]")
    private WebElement fieldDesiredPassword;

    @FindBy(css = "form[name=customer_form] input[name=confirmed_password]")
    private WebElement fieldConfirmPassword;

    @FindBy(css = "form[name=customer_form] button[name=create_account]")
    private WebElement buttonCreateAccount;

    public void clickCreateAccount(){
        this.buttonCreateAccount.click();
    }

    public void setFirstName(String firstName){
        this.fieldFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        this.fieldLastName.sendKeys(lastName);
    }

    public void setAddress1(String address1){
        this.fieldAddress1.sendKeys(address1);
    }

    public void setPostcode(String postcode){
        this.fieldPostcode.sendKeys(postcode);
    }

    public void setCity(String city){
        this.fieldCity.sendKeys(city);
    }

    public void setEmail(String email){
        this.fieldEmail.sendKeys(email);
    }

    public void setPhone(String phone){
        this.fieldPhone.sendKeys(phone);
    }

    public void setDesiredPassword(String password){
        this.fieldDesiredPassword.sendKeys(password);
    }

    public void setConfirmPassword(String password){
        this.fieldConfirmPassword.sendKeys(password);
    }
}
