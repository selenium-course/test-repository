package ru.course.selenium.steps.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.course.selenium.pages.admin.BaseAdminPage;
import ru.course.selenium.steps.BaseSteps;
import ru.course.selenium.steps.admin.appearance.TemplateSteps;
import ru.course.selenium.steps.admin.catalog.CatalogSteps;
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

import java.util.List;

/**
 * Created by Aleksei.Klimenko on 27.11.2016.
 */
public abstract class BaseAdminSteps<T extends BaseAdminPage> extends BaseSteps{
    protected T page;

    public BaseAdminSteps(Class<T> pageClass){
        page = PageFactory.initElements(getDriver(), pageClass);
    }

    public String getPageTitleExpected(){
        return page.getPageTitleExpected();
    }

    public String getPageTitle(){
        return page.getPageTitle();
    }

    protected T getPage(){
        return page;
    }

    public String getVersion(){
        return page.getVersion();
    }

    public List<WebElement> getMainMenuItems(){
        return page.getMenu().getMainMenuItems();
    }

    public List<WebElement> getSubMenuItems(){
        return page.getMenu().getSubMenuItems();
    }

    public TemplateSteps toAppearance(){
        page.getMenu().clickAppearance();
        return new TemplateSteps();
    }

    public CatalogSteps toCatalog(){
        page.getMenu().clickCatalog();
        return new CatalogSteps();
    }

    public CountriesSteps toCountries(){
        page.getMenu().clickCountries();
        return new CountriesSteps();
    }

    public CurrenciesSteps toCurrencies(){
        page.getMenu().clickCurrencies();
        return new CurrenciesSteps();
    }

    public CustomersSteps toCustomers(){
        page.getMenu().clickCustomers();
        return new CustomersSteps();
    }

    public GeoZonesSteps toGeoZones(){
        page.getMenu().clickGeoZones();
        return new GeoZonesSteps();
    }

    public LanguagesSteps toLanguages(){
        page.getMenu().clickLanguages();
        return new LanguagesSteps();
    }

    public BackgroundJobsSteps toModules(){
        page.getMenu().clickModules();
        return new BackgroundJobsSteps();
    }

    public OrdersSteps toOrders(){
        page.getMenu().clickOrders();
        return new OrdersSteps();
    }

    public PagesSteps toPages(){
        page.getMenu().clickPages();
        return new PagesSteps();
    }

    public MonthlySalesSteps toReports(){
        page.getMenu().clickReports();
        return new MonthlySalesSteps();
    }

    public StoreInfoSteps toSettings(){
        page.getMenu().clickSettings();
        return new StoreInfoSteps();
    }

    public SlidesSteps toSlides(){
        page.getMenu().clickSlides();
        return new SlidesSteps();
    }

    public TaxClassesSteps toTax(){
        page.getMenu().clickTax();
        return new TaxClassesSteps();
    }

    public SearchTranslationsSteps toTranslations(){
        page.getMenu().clickTranslations();
        return new SearchTranslationsSteps();
    }

    public UsersSteps toUsers(){
        page.getMenu().clickUsers();
        return new UsersSteps();
    }

    public VqmodsSteps toVqmods(){
        page.getMenu().clickVqmods();
        return new VqmodsSteps();
    }
}
