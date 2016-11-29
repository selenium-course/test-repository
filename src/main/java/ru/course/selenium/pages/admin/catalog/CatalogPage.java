package ru.course.selenium.pages.admin.catalog;

import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.BaseAdminPage;

/**
 * Created by Aleksei.Klimenko on 27.11.2016.
 */
public class CatalogPage extends BaseAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Catalog";
    public static final String LOCAL_URL = "/admin/?app=catalog&doc=catalog";

    public CatalogPage(WebDriver driver) {
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
