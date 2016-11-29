package ru.course.selenium.pages.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Aleksei.Klimenko on 27.11.2016.
 */


/**
 * * Admin page main menu
 */
@FindBy(css = "ul#box-apps-menu")
public class ApplicationMenu{

    @FindBy(xpath = "//span[contains(., 'Appearence')]")
    private WebElement itemAppearence;

    @FindBy(xpath = "//span[contains(., 'Catalog')]")
    private WebElement itemCatalog;

    @FindBy(xpath = "//span[contains(., 'Countries')]")
    private WebElement itemCountries;

    @FindBy(xpath = "//span[contains(., 'Currencies')]")
    private WebElement itemCurrencies;

    @FindBy(xpath = "//span[contains(., 'Customers')]")
    private WebElement itemCustomers;

    @FindBy(xpath = "//span[contains(., 'Geo Zones')]")
    private WebElement itemGeoZones;

    @FindBy(xpath = "//span[contains(., 'Languages')]")
    private WebElement itemLanguages;

    @FindBy(xpath = "//span[contains(., 'Modules')]")
    private WebElement itemModules;

    @FindBy(xpath = "//span[contains(., 'Orders')]")
    private WebElement itemOrders;

    @FindBy(xpath = "//span[contains(., 'Pages')]")
    private WebElement itemPages;

    @FindBy(xpath = "//span[contains(., 'Reports')]")
    private WebElement itemReports;

    @FindBy(xpath = "//span[contains(., 'Settings')]")
    private WebElement itemSettings;

    @FindBy(xpath = "//span[contains(., 'Slides')]")
    private WebElement itemSlides;

    @FindBy(xpath = "//span[contains(., 'Tax')]")
    private WebElement itemTax;

    @FindBy(xpath = "//span[contains(., 'Translations')]")
    private WebElement itemTranslations;

    @FindBy(xpath = "//span[contains(., 'Users')]")
    private WebElement itemUsers;

    @FindBy(xpath = "//span[contains(., 'vQmods')]")
    private WebElement itemVqmods;

    @FindBy(css = "li#app- > a")
    private List<WebElement> mainMenuItems;

    @FindBy(css = "ul.docs > li")
    private List<WebElement> subMenuItems;

    public List<WebElement> getMainMenuItems(){
        return mainMenuItems;
    }

    public List<WebElement> getSubMenuItems(){
        return subMenuItems;
    }

    public void clickAppearance() {
        itemAppearence.click();
    }

    public void clickCatalog() {
        itemCatalog.click();
    }

    public void clickCountries() {
        itemCountries.click();
    }

    public void clickCurrencies() {
        itemCurrencies.click();
    }

    public void clickCustomers() {
        itemCustomers.click();
    }

    public void clickGeoZones() {
        itemGeoZones.click();
    }

    public void clickLanguages() {
        itemLanguages.click();
    }

    public void clickModules() {
        itemModules.click();
    }

    public void clickOrders() {
        itemOrders.click();
    }

    public void clickPages() {
        itemPages.click();
    }

    public void clickReports() {
        itemReports.click();
    }

    public void clickSettings() {
        itemSettings.click();
    }

    public void clickSlides() {
        itemSlides.click();
    }

    public void clickTax() {
        itemTax.click();
    }

    public void clickTranslations() {
        itemTranslations.click();
    }

    public void clickUsers() {
        itemUsers.click();
    }

    public void clickVqmods() {
        itemVqmods.click();
    }
}
