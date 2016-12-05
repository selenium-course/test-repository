package ru.course.selenium.litecart;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.course.selenium.BaseTest;
import ru.course.selenium.steps.store.ProductSteps;
import ru.course.selenium.steps.store.StoreSteps;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.contains;

/**
 * Created by Aleksei.Klimenko on 04.12.2016.
 */
public class ProductDiscountTest extends BaseTest {

    private StoreSteps storeSteps = new StoreSteps();

    @Test
    public void productDiscountTest() {
        storeSteps.openStorePage();
        WebElement discountDuck = storeSteps.getCampaigns().get(0);
        assertThat("First campaign product has no discount", storeSteps.hasProductDiscount(discountDuck), equalTo(true));

        List<String> actualStyles = storeSteps.getDiscountStyles(discountDuck);
        String[] expectedStyles = new String[]{"rgba(119, 119, 119, 1)", "14.4px", "line-through", "rgba(204, 0, 0, 1)", "18px", "bold"};
        assertThat("Discount prices style in campaign list does not match expected values", actualStyles, contains(expectedStyles));

        String productNameInList = storeSteps.getProductName(discountDuck);
        String regularPriceInList = storeSteps.getProductRegularPrice(discountDuck);
        String discountPriceInList = storeSteps.getProductDiscountPrice(discountDuck);

        ProductSteps productSteps = storeSteps.openProductPage(discountDuck);
        String productName = productSteps.getProductName();
        String regularPrice = productSteps.getProductRegularPrice();
        String discountPrice = productSteps.getProductDiscountPrice();

        assertThat("Product name does not match name in campaign list", productNameInList, equalTo(productName));
        assertThat("Product regular price does not match name in campaign list", regularPriceInList, equalTo(regularPrice));
        assertThat("Product discount price does not match name in campaign list", discountPriceInList, equalTo(discountPrice));

        List<String> actualProductStyles = productSteps.getDiscountStyles();
        String[] expectedProductStyles = new String[]{"rgba(102, 102, 102, 1)", "16px", "line-through", "rgba(204, 0, 0, 1)", "22px", "bold"};
        assertThat("Discount prices style does not match expected values", actualProductStyles, contains(expectedProductStyles));
    }
}
