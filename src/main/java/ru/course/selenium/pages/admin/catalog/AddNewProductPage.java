package ru.course.selenium.pages.admin.catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.course.selenium.domain.CurrencyEnum;
import ru.course.selenium.domain.GenderEnum;
import ru.course.selenium.pages.admin.BaseAdminPage;
import org.openqa.selenium.support.ui.Select;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aleksei.Klimenko on 06.12.2016.
 */
public class AddNewProductPage extends BaseAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Add New Product";
    public static final String LOCAL_URL = "/admin/?category_id=0&app=catalog&doc=edit_product";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

    @FindBy(css = "ul.index a[href$=general]")
    private WebElement tabGeneral;

    @FindBy(css = "ul.index a[href$=information]")
    private WebElement tabInformation;

    @FindBy(css = "ul.index a[href$=prices]")
    private WebElement tabPrices;

    //Tab General

    @FindBy(xpath = "//div[@id='tab-general']//input[@type='radio']/../../label[contains(.,'Enabled')]")
    private WebElement radioEnabled;

    @FindBy(xpath = "//div[@id='tab-general']//input[@type='radio']/../../label[contains(.,'Disabled')]")
    private WebElement radioDisabled;

    @FindBy(css = "div#tab-general input[name='name[en]']")
    private WebElement fieldName;

    @FindBy(css = "div#tab-general input[name=code]")
    private WebElement fieldCode;

    @FindBy(css = "div#tab-general input[name='categories[]']")
    private List<WebElement> categories;

    @FindBy(css = "div#tab-general input[name='product_groups[]']")
    private List<WebElement> productGroups;

    //div[@id='tab-general']//strong[contains(.,'Product Groups')]/..//td[contains(.,'Unisex')]/..//input

    @FindBy(css = "div#tab-general input[name=quantity]")
    private WebElement fieldQuantity;

    @FindBy(css = "div#tab-general select[name=sold_out_status_id]")
    private WebElement fieldSoldOutStatus;


    @FindBy(css = "div#tab-general input[name=date_valid_from]")
    private WebElement fieldValidFrom;

    @FindBy(css = "div#tab-general input[name=date_valid_to]")
    private WebElement fieldValidTo;

    //Tab Information

    @FindBy(css = "div#tab-information select[name=manufacturer_id]")
    private WebElement fieldManufacturer;

    @FindBy(css = "div#tab-information input[name=keywords]")
    private WebElement fieldKeywords;

    @FindBy(css = "div#tab-information input[name='short_description[en]']")
    private WebElement fieldShortDescription;

    @FindBy(css = "div#tab-information div.trumbowyg-editor")
    private WebElement fieldDescription;

    @FindBy(css = "div#tab-information input[name='head_title[en]']")
    private WebElement fieldHeadTitle;

    @FindBy(css = "div#tab-information input[name='meta_description[en]']")
    private WebElement fieldMetaDescription;

    //Tab Prices

    @FindBy(css = "div#tab-prices input[name=purchase_price]")
    private WebElement fieldPurchasePrice;

    @FindBy(css = "div#tab-prices select[name=purchase_price_currency_code]")
    private WebElement currency;

    @FindBy(css = "div#tab-prices input[name='prices[USD]']")
    private WebElement fieldPrice;

    @FindBy(css = "span.button-set button[name=save]")
    private WebElement buttonSave;

    public AddNewProductPage(WebDriver driver) {
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

    public void clickGeneral(){
        tabGeneral.click();
    }

    public void clickInformation(){
        tabInformation.click();
    }

    public void clickPrices(){
        tabPrices.click();
    }

    public void clickSave(){
        buttonSave.click();
    }

    //Tab General

    public void setEnabled(Boolean enabled){
        if (enabled){
            radioEnabled.click();
        } else {
            radioDisabled.click();
        }
    }

    public void setName(String name){
        fieldName.sendKeys(name);
    }

    public void setCode(String code){
        fieldCode.sendKeys(code);
    }

    public void setCategories(Integer... categoriesIndex) {
        List expectedCategories = Arrays.asList(categoriesIndex);
        for (int i = 0; i < categories.size(); i++) {
            if (expectedCategories.contains(i) && categories.get(i).getAttribute("checked").equals("false")) {
                categories.get(i).click();
            }
        }
    }

    public void setGender(GenderEnum gender){
        productGroups.get(gender.getCode()).click();
    }

    public void setQuantity(String quantity){
        fieldQuantity.sendKeys(quantity);
    }

    public void setSoldOutStatus(Integer statusIndex){
        new Select(fieldSoldOutStatus).selectByIndex(statusIndex);
    }

    public void setValidFrom(LocalDate validFrom){
        fieldValidFrom.sendKeys(validFrom.format(formatter));
    }

    public void setValidTo(LocalDate validTo){
        fieldValidTo.sendKeys(validTo.format(formatter));
    }

    //Tab Information

    public void setKeywords(String keywords){
        fieldKeywords.sendKeys(keywords);
    }

    public void setManufacturer(Integer manufacturerIndex){
        new Select(fieldManufacturer).selectByIndex(manufacturerIndex);
    }

    public void setShortDescription(String shortDescription){
        fieldShortDescription.sendKeys(shortDescription);
    }

    public void setDescription(String description){
        fieldDescription.sendKeys(description);
    }

    public void setHeadTitle(String headTitle){
        fieldHeadTitle.sendKeys(headTitle);
    }

    public void setMetaDescription(String metaDescription){
        fieldMetaDescription.sendKeys(metaDescription);
    }

    //Tab Prices

    public void setPurchasePrice(BigDecimal purchasePrice){
        fieldPurchasePrice.sendKeys(purchasePrice.toString());
    }

    public void setCurrency(CurrencyEnum purchasePrice){
        new Select(currency).selectByValue(purchasePrice.name());
    }

    public void setPrice(BigDecimal price){
        fieldPrice.sendKeys(price.toString());
    }
}
