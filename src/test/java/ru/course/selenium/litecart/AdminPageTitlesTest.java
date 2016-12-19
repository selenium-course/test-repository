package ru.course.selenium.litecart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.course.selenium.BaseTest;
import ru.course.selenium.domain.UserEnum;
import ru.course.selenium.steps.admin.AdminLoginSteps;
import ru.course.selenium.steps.admin.AdminSteps;
import ru.course.selenium.steps.admin.catalog.CatalogSteps;
import ru.course.selenium.steps.admin.appearance.TemplateSteps;
import ru.course.selenium.steps.admin.countries.CountriesSteps;
import ru.course.selenium.steps.admin.currencies.CurrenciesSteps;
import ru.course.selenium.steps.admin.customers.CustomersSteps;
import ru.course.selenium.steps.admin.geozones.GeoZonesSteps;
import ru.course.selenium.steps.admin.languages.LanguagesSteps;
import ru.course.selenium.steps.admin.modules.BackgroundJobsSteps;
import ru.course.selenium.steps.admin.orders.OrdersSteps;
import ru.course.selenium.steps.admin.pages.PagesSteps;
import ru.course.selenium.steps.admin.reports.MonthlySalesSteps;
import ru.course.selenium.steps.admin.settings.StoreInfoSteps;
import ru.course.selenium.steps.admin.slides.SlidesSteps;
import ru.course.selenium.steps.admin.tax.TaxClassesSteps;
import ru.course.selenium.steps.admin.translations.SearchTranslationsSteps;
import ru.course.selenium.steps.admin.users.UsersSteps;
import ru.course.selenium.steps.admin.vqmods.VqmodsSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class AdminPageTitlesTest extends BaseTest {

    private AdminLoginSteps adminLoginSteps = new AdminLoginSteps();

    @Test
    public void adminPageTitlesEasyTest() {
        AdminSteps adminSteps = adminLoginSteps.openLoginPage()
                .loginAs(UserEnum.ADMIN);

        for (int i = 0; i < adminSteps.getMainMenuItems().size(); i++){
            ((WebElement)adminSteps.getMainMenuItems().get(i)).click();
            assertThat("No page title on navigating to main menu item",
                    adminSteps.getDriver().findElement(By.cssSelector("h1")),
                    notNullValue());
            for (int k = 0; k < adminSteps.getSubMenuItems().size(); k++){
                ((WebElement)adminSteps.getSubMenuItems().get(k)).click();
                assertThat("No page title on navigating to submenu item",
                        adminSteps.getDriver().findElement(By.cssSelector("h1")),
                        notNullValue());
            }
        }
    }

    @Test(enabled = false)
    public void adminPageTitlesHardcoreTest() {
        AdminSteps adminSteps = adminLoginSteps.openLoginPage()
                .loginAs(UserEnum.ADMIN);

        TemplateSteps appearance = adminSteps.toAppearance();
        assertThat("Title does not match expected", appearance.getPageTitle(), equalTo(appearance.getPageTitleExpected()));

        CatalogSteps catalog = appearance.toCatalog();
        assertThat("Title does not match expected", catalog.getPageTitle(), equalTo(catalog.getPageTitleExpected()));

        CountriesSteps countries = catalog.toCountries();
        assertThat("Title does not match expected", countries.getPageTitle(), equalTo(countries.getPageTitleExpected()));

        CurrenciesSteps currencies = countries.toCurrencies();
        assertThat("Title does not match expected", currencies.getPageTitle(), equalTo(currencies.getPageTitleExpected()));

        CustomersSteps customers = currencies.toCustomers();
        assertThat("Title does not match expected", customers.getPageTitle(), equalTo(customers.getPageTitleExpected()));

        GeoZonesSteps geoZones = customers.toGeoZones();
        assertThat("Title does not match expected", geoZones.getPageTitle(), equalTo(geoZones.getPageTitleExpected()));

        LanguagesSteps languages = geoZones.toLanguages();
        assertThat("Title does not match expected", languages.getPageTitle(), equalTo(languages.getPageTitleExpected()));

        BackgroundJobsSteps modules = languages.toModules();
        assertThat("Title does not match expected", modules.getPageTitle(), equalTo(modules.getPageTitleExpected()));

        OrdersSteps orders = modules.toOrders();
        assertThat("Title does not match expected", orders.getPageTitle(), equalTo(orders.getPageTitleExpected()));

        PagesSteps pages = orders.toPages();
        assertThat("Title does not match expected", pages.getPageTitle(), equalTo(pages.getPageTitleExpected()));

        MonthlySalesSteps reports = pages.toReports();
        assertThat("Title does not match expected", reports.getPageTitle(), equalTo(reports.getPageTitleExpected()));

        StoreInfoSteps settings = reports.toSettings();
        assertThat("Title does not match expected", settings.getPageTitle(), equalTo(settings.getPageTitleExpected()));

        SlidesSteps slides = settings.toSlides();
        assertThat("Title does not match expected", slides.getPageTitle(), equalTo(slides.getPageTitleExpected()));

        TaxClassesSteps tax = slides.toTax();
        assertThat("Title does not match expected", tax.getPageTitle(), equalTo(tax.getPageTitleExpected()));

        SearchTranslationsSteps translations = tax.toTranslations();
        assertThat("Title does not match expected", translations.getPageTitle(), equalTo(translations.getPageTitleExpected()));

        UsersSteps users = translations.toUsers();
        assertThat("Title does not match expected", users.getPageTitle(), equalTo(users.getPageTitleExpected()));

        VqmodsSteps vqmods = users.toVqmods();
        assertThat("Title does not match expected", vqmods.getPageTitle(), equalTo(vqmods.getPageTitleExpected()));
    }
}
