package ru.course.selenium.litecart;

import org.testng.annotations.Test;
import ru.course.selenium.BaseTest;
import ru.course.selenium.domain.Product;
import ru.course.selenium.domain.UserEnum;
import ru.course.selenium.steps.admin.AdminLoginSteps;
import ru.course.selenium.steps.admin.catalog.AddNewProductSteps;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

/**
 * Created by Aleksei.Klimenko on 06.12.2016.
 */
public class AddProductTest extends BaseTest{

    private AdminLoginSteps adminLoginSteps = new AdminLoginSteps();

    @Test
    public void addNewProductTest() {
        adminLoginSteps.openLoginPage();
        AddNewProductSteps newProductSteps = adminLoginSteps.loginAs(UserEnum.ADMIN)
                .toCatalog()
                .openAddNewProduct();
        Product product = Product.getDefault();
        List<String> productNames = newProductSteps.fillProductForms(product)
                .saveProduct()
                .searchProduct(product.getName())
                .getProductNameValues();
        assertThat("Product does not present in products list", productNames, hasItem(product.getName()));
    }
}
