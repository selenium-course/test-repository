package ru.course.selenium.pages.admin.appearance;

import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.BaseAdminPage;

/**
 * Created by Aleksei.Klimenko on 27.11.2016.
 */
public class TemplatePage extends BaseAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Template";
    public static final String LOCAL_URL = "/admin/?app=appearance&doc=template";

    public TemplatePage(WebDriver driver) {
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
