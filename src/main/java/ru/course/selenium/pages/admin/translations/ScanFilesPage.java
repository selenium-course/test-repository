package ru.course.selenium.pages.admin.translations;

import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.BaseAdminPage;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class ScanFilesPage extends BaseAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Scan Files For  Translations";
    public static final String LOCAL_URL = "/admin/?app=translations&doc=scan";

    public ScanFilesPage(WebDriver driver) {
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
