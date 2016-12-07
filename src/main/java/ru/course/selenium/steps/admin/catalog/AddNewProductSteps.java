package ru.course.selenium.steps.admin.catalog;

import ru.course.selenium.domain.Product;
import ru.course.selenium.pages.admin.catalog.AddNewProductPage;
import ru.course.selenium.steps.admin.BaseAdminSteps;

/**
 * Created by Aleksei.Klimenko on 07.12.2016.
 */
public class AddNewProductSteps extends BaseAdminSteps {

    private AddNewProductPage newProductPage;

    public AddNewProductSteps() {
        super(AddNewProductPage.class);
        newProductPage = (AddNewProductPage) page;
    }

    public AddNewProductSteps toGeneral(){
        newProductPage.clickGeneral();
        return this;
    }

    public AddNewProductSteps toInformation(){
        newProductPage.clickInformation();
        return this;
    }

    public AddNewProductSteps toPrices(){
        newProductPage.clickPrices();
        return this;
    }

    public AddNewProductSteps fillProductForms(Product product){
        toGeneral();
        newProductPage.setEnabled(product.getEnabled());
        newProductPage.setName(product.getName());
        newProductPage.setCode(product.getCode());
        newProductPage.setCategories(product.getCategory());
        newProductPage.setGender(product.getGender());
        newProductPage.setQuantity(product.getQuantity());
        newProductPage.setSoldOutStatus(product.getSoldOutStatus());
        newProductPage.setValidFrom(product.getDateFrom());
        newProductPage.setValidTo(product.getDateTo());
        toInformation();
        newProductPage.setManufacturer(product.getManufacturer());
        newProductPage.setKeywords(product.getKeywords());
        newProductPage.setShortDescription(product.getShortDescription());
        newProductPage.setDescription(product.getDescription());
        newProductPage.setHeadTitle(product.getHeadTitle());
        newProductPage.setMetaDescription(product.getMetaDescription());
        toPrices();
        newProductPage.setPurchasePrice(product.getPurchasePrice());
        newProductPage.setCurrency(product.getCurrency());
        newProductPage.setPrice(product.getPrice());
        return this;
    }

    public CatalogSteps saveProduct(){
        newProductPage.clickSave();
        return new CatalogSteps();
    }
}
