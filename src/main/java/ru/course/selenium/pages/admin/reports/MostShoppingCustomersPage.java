package ru.course.selenium.pages.admin.reports;

import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.BaseAdminPage;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class MostShoppingCustomersPage extends BaseAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Most Shopping Customers";
    public static final String LOCAL_URL = "/admin/?app=reports&doc=most_shopping_customers";

    public MostShoppingCustomersPage(WebDriver driver) {
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
