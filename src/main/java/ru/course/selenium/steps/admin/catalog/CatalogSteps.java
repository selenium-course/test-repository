package ru.course.selenium.steps.admin.catalog;

import org.openqa.selenium.WebElement;
import ru.course.selenium.pages.admin.catalog.CatalogPage;
import ru.course.selenium.steps.admin.BaseAdminSteps;

import java.util.List;

/**
 * Created by Aleksei.Klimenko on 27.11.2016.
 */
public class CatalogSteps extends BaseAdminSteps {

    private CatalogPage catalogPage;

    public CatalogSteps() {
        super(CatalogPage.class);
        catalogPage = (CatalogPage) page;
    }

    public AddNewProductSteps openAddNewProduct(){
        catalogPage.clickAddNewProduct();
        return new AddNewProductSteps();
    }

    public List<String> getProductNameValues(){
        return catalogPage.getProductNameValues();
    }

    public List<WebElement> getProductNameElements(){
        return catalogPage.getProductNameElements();
    }

    public List<WebElement> getCategoryNameElements(){
        return catalogPage.getCategoryNameElements();
    }

    public AddNewProductSteps editProduct(WebElement productElement){
        catalogPage.editProduct(productElement);
        return new AddNewProductSteps();
    }

    public CatalogSteps searchProduct(String product){
        catalogPage.searchProduct(product);
        return this;
    }
}
