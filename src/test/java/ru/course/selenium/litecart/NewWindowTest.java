package ru.course.selenium.litecart;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.course.selenium.BaseTest;
import ru.course.selenium.domain.UserEnum;
import ru.course.selenium.steps.admin.AdminLoginSteps;
import ru.course.selenium.steps.admin.countries.EditCountrySteps;


/**
 * Created by Aleksei.Klimenko on 08.12.2016.
 */
public class NewWindowTest extends BaseTest {

    private AdminLoginSteps loginSteps = new AdminLoginSteps();

    @Test
    public void externalLinksTest() {
        EditCountrySteps addCountrySteps = loginSteps.openLoginPage()
                .loginAs(UserEnum.ADMIN)
                .toCountries()
                .addNewCountry();
        String mainWindow = addCountrySteps.getDriver().getWindowHandle();

        for (WebElement link : addCountrySteps.getWikiLinks()){
            addCountrySteps.toExternalLink(mainWindow, link);
            addCountrySteps.toMainWindow();
        }
    }
}
