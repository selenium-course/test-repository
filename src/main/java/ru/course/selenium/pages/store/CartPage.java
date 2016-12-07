package ru.course.selenium.pages.store;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.course.selenium.pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Aleksei.Klimenko on 08.12.2016.
 */
public class CartPage extends BasePage {
    public static final String PRODUCT_NAME_CSS = "div#order_confirmation-wrapper td.item";

    @FindBy(css = "form[name=cart_form] button[name=remove_cart_item]")
    private WebElement buttonRemove;

    @FindBy(css = PRODUCT_NAME_CSS)
    private List<WebElement> productNames;

    public void clickRemove(){
        buttonRemove.click();
    }

    public Integer getProductsCount(){
        return productNames.size();
    }

    public List<String> getProductNames(){
        return productNames.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
