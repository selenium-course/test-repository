package ru.course.selenium.pages.admin.modules;

import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.BaseAdminPage;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class CustomerPage extends BaseAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Customer Modules";
    public static final String LOCAL_URL = "/admin/?app=modules&doc=customer";

    public CustomerPage(WebDriver driver) {
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
