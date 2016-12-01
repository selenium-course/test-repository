package ru.course.selenium.litecart;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.course.selenium.BaseTest;
import ru.course.selenium.steps.store.StoreSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Aleksei.Klimenko on 30.11.2016.
 */
public class ProductStickersTest extends BaseTest {

    private StoreSteps storeSteps = new StoreSteps();

    @Test
    public void allProductsHaveSingleStickerTest() {
        storeSteps.openStorePage();
        Integer expectedStickersCount = 1;

        for (WebElement element : storeSteps.getMostPopular()){
            assertThat("Most popular product does not have a single sticker",
                    storeSteps.getProductStickersCount(element),
                    equalTo(expectedStickersCount));
        }

        for (WebElement element : storeSteps.getCampaigns()){
            assertThat("Campaign product does not have a single sticker",
                    storeSteps.getProductStickersCount(element),
                    equalTo(expectedStickersCount));
        }

        for (WebElement element : storeSteps.getLatestProducts()){
            assertThat("Latest product does not have a single sticker",
                    storeSteps.getProductStickersCount(element),
                    equalTo(expectedStickersCount));
        }
    }
}