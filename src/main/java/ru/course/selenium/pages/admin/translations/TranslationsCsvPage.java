package ru.course.selenium.pages.admin.translations;

import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.BaseAdminPage;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class TranslationsCsvPage extends BaseAdminPage {
    public static final String PAGE_TITLE_LOCAL = "CSV Import/Export";
    public static final String LOCAL_URL = "/admin/?app=translations&doc=csv";

    public TranslationsCsvPage(WebDriver driver) {
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
