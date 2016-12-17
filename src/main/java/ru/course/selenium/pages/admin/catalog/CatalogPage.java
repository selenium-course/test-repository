package ru.course.selenium.pages.admin.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.course.selenium.pages.admin.TableAdminPage;

import java.util.List;

/**
 * Created by Aleksei.Klimenko on 27.11.2016.
 */
public class CatalogPage extends TableAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Catalog";
    public static final String LOCAL_URL = "/admin/?app=catalog&doc=catalog";
    private static final Integer COLUMN_NAME = 3;

    @FindBy(css = "td#content input[name=query]")
    private WebElement fieldSearch;

    @FindBy(xpath = "//td[@id='content']//a[contains(.,'Add New Category')]")
    private WebElement buttonAddNewCategory;

    @FindBy(xpath = "//td[@id='content']//a[contains(.,'Add New Product')]")
    private WebElement buttonAddNewProduct;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitleExpected() {
        return PAGE_TITLE_LOCAL;
    }

    @Override
    protected String getPageUrlLocal() {
        return LOCAL_URL;
    }

    public List<String> getProductNameValues(){
        return getColumnValuesList(COLUMN_NAME);
    }

    public List<WebElement> getProductNameElements(){
        return driver.findElements(By.cssSelector("table.dataTable tr.row img+a"));
    }

    public List<WebElement> getCategoryNameElements(){
        return driver.findElements(By.cssSelector("table.dataTable tr.row i+a"));
    }

    public void editProduct(WebElement productElement){
        productElement.click();
    }

    public void clickAddNewProduct(){
        buttonAddNewProduct.click();
    }

    public void searchProduct(String product){
        fieldSearch.sendKeys(product);
        fieldSearch.sendKeys(Keys.RETURN);
    }
}
