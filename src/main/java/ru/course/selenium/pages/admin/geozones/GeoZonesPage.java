package ru.course.selenium.pages.admin.geozones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.course.selenium.pages.admin.TableAdminPage;

import java.util.List;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class GeoZonesPage extends TableAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Geo Zones";
    public static final String LOCAL_URL = "/admin/?app=geo_zones&doc=geo_zones";
    public static final Integer COLUMN_NAME = 3;

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

    public List<WebElement> getGeoZoneNameElements(){
        return getColumnElementsList(COLUMN_NAME);
    }

    public void editZone(WebElement zoneElement){
        zoneElement.findElement(By.cssSelector("a")).click();
    }
}
