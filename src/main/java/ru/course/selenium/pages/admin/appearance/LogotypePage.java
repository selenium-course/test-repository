package ru.course.selenium.pages.admin.appearance;

import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.BaseAdminPage;

/**
 * Created by Aleksei.Klimenko on 27.11.2016.
 */
public class LogotypePage extends BaseAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Logotype";
    public static final String LOCAL_URL = "/admin/?app=appearance&doc=logotype";

    public LogotypePage(WebDriver driver) {
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
