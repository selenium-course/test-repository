package ru.course.selenium.steps;

import org.openqa.selenium.support.PageFactory;
import ru.course.selenium.pages.AdminPage;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public class AdminSteps extends BaseSteps{
    private AdminPage adminPage;

    public AdminSteps(){
        adminPage = PageFactory.initElements(getDriver(), AdminPage.class);
    }

    public String getVersion(){
        return adminPage.getVesion();
    }
}
