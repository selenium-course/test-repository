package ru.course.selenium.pages.admin.modules;

import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.BaseAdminPage;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class BackgroundJobsPage extends BaseAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Job Modules";
    public static final String LOCAL_URL = "/admin/?app=modules&doc=jobs";

    public BackgroundJobsPage(WebDriver driver) {
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
