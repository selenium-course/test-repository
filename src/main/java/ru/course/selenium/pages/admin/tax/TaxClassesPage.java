package ru.course.selenium.pages.admin.tax;

import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.BaseAdminPage;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class TaxClassesPage extends BaseAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Tax Classes";
    public static final String LOCAL_URL = "/admin/?app=tax&doc=tax_classes";

    public TaxClassesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getPageTitleLocal() {
        return PAGE_TITLE_LOCAL;
    }

    @Override
    protected String getPageUrlLocal() {
        return LOCAL_URL;
    }
}
