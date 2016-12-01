package ru.course.selenium.pages.admin.tax;

import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.BaseAdminPage;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class TaxRatesPage extends BaseAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Tax Rates";
    public static final String LOCAL_URL = "/admin/?app=tax&doc=tax_rates";

    public TaxRatesPage(WebDriver driver) {
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
}
