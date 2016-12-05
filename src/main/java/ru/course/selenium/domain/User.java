package ru.course.selenium.domain;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Aleksei.Klimenko on 05.12.2016.
 */
public class User {
    private String firstName;

    private String lastName;

    private String address1;

    private String postcode;

    private String city;

    private String email;

    private String phone;

    private String password;

    private User(){
        //Do nothing
    }

    public static User getDefault(){
        User user = new User();
        user.firstName = "Autotest";
        user.lastName = "Ivanov";
        user.address1 = "Nevskiy blvd 123, apt 5";
        user.postcode = "123456";
        user.city = "Barentsburg";
        user.email = "user-" + RandomStringUtils.randomNumeric(5) + "@mail.com";
        user.phone = "+79111234567";
        user.password = "password";
        return user;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}
