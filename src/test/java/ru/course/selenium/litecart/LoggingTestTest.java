package ru.course.selenium.litecart;

import org.testng.annotations.Test;
import ru.course.selenium.BaseTest;
import ru.course.selenium.domain.UserEnum;
import ru.course.selenium.steps.admin.AdminLoginSteps;
import ru.course.selenium.steps.admin.catalog.AddNewProductSteps;
import ru.course.selenium.steps.admin.catalog.CatalogSteps;

import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
/**
 * Created by Aleksei.Klimenko on 15.12.2016.
 */
public class LoggingTestTest extends BaseTest{
    private AdminLoginSteps adminLoginSteps = new AdminLoginSteps();

    @Test
    public void loggingTest() {
        adminLoginSteps.openLoginPage();
        CatalogSteps catalogSteps = adminLoginSteps.loginAs(UserEnum.ADMIN)
                .toCatalog();
        AddNewProductSteps editProductSteps;
        for (int i = 0; i < catalogSteps.getProductNameElements().size(); i++) {
            editProductSteps = catalogSteps.editProduct(catalogSteps.getProductNameElements().get(i));
            assertThat("There are unexpected messages in Browser log",
                    editProductSteps.getDriver().manage().logs().get("browser").filter(Level.ALL),
                    hasSize(0));
            editProductSteps.toCatalog();
        }
    }
}
