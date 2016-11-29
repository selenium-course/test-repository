package ru.course.selenium.pages.admin.customers;

import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.BaseAdminPage;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class NewsletterPage extends BaseAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Newsletter";
    public static final String LOCAL_URL = "/admin/?app=customers&doc=newsletter";

    public NewsletterPage(WebDriver driver) {
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
