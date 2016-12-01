package ru.course.selenium.pages.admin.geozones;

import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.BaseAdminPage;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class GeoZonesPage extends BaseAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Geo Zones";
    public static final String LOCAL_URL = "/admin/?app=geo_zones&doc=geo_zones";

    public GeoZonesPage(WebDriver driver) {
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
