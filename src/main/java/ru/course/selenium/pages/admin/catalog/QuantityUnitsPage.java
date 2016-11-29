package ru.course.selenium.pages.admin.catalog;

import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.BaseAdminPage;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class QuantityUnitsPage extends BaseAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Quantity Units";
    public static final String LOCAL_URL = "/admin/?app=catalog&doc=quantity_units";

    public QuantityUnitsPage(WebDriver driver) {
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
