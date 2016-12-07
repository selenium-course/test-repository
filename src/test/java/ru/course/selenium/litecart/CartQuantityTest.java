package ru.course.selenium.litecart;

import org.testng.annotations.Test;
import ru.course.selenium.BaseTest;
import ru.course.selenium.steps.store.CartSteps;
import ru.course.selenium.steps.store.StoreSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Aleksei.Klimenko on 08.12.2016.
 */
public class CartQuantityTest extends BaseTest{

    private StoreSteps storeSteps = new StoreSteps();

    @Test
    public void cartQuantityTest() {
        storeSteps.openStorePage();
        storeSteps.openProductPage(storeSteps.getMostPopular().get(0))
                .addProductToCart()
                .waitQuantityChanged(1)
                .toHome();
        storeSteps.openProductPage(storeSteps.getCampaigns().get(0))
                .addProductToCart()
                .waitQuantityChanged(2)
                .toHome();
        storeSteps.openProductPage(storeSteps.getMostPopular().get(1))
                .addProductToCart()
                .waitQuantityChanged(3)
                .toHome();
        CartSteps cartSteps = storeSteps.cartCheckout();
        assertThat("Incorrect cart products count", cartSteps.getProductsCount(), equalTo(3));
        cartSteps.removeProduct()
                .waitTableItemsCountChanged(2)
                .removeProduct()
                .waitTableItemsCountChanged(1)
                .removeProduct()
                .waitTableItemsCountChanged(0);
        assertThat("Incorrect cart products count", cartSteps.getProductsCount(), equalTo(0));
    }
}
