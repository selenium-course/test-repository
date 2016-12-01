package ru.course.selenium.pages.admin;

import org.openqa.selenium.WebDriver;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public class AdminPage extends BaseAdminPage{
    public static final String LOCAL_URL = "/admin";
    public static final String PAGE_TITLE = "My Store";

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitleExpected() {
        return PAGE_TITLE;
    }

    @Override
    protected String getPageUrlLocal() {
        return LOCAL_URL;
    }
}
