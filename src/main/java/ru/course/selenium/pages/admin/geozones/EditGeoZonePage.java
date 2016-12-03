package ru.course.selenium.pages.admin.geozones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.TableAdminPage;

import java.util.List;

/**
 * Created by Aleksei.Klimenko on 03.12.2016.
 */
public class EditGeoZonePage extends TableAdminPage{
    public static final String PAGE_TITLE_LOCAL = "Edit Geo Zone";
    public static final String LOCAL_URL = "/admin/?app=geo_zones&doc=edit_geo_zone&page=1&geo_zone_id=";
    private static final Integer COLUMN_ZONE = 3;
    private static final String COLUMN_XPATH_TEMPLATE = "//table[@class='dataTable']//td[%d]/select/option[@selected='selected']";

    public EditGeoZonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getColumnLocator(Integer columnNum) {
        return By.xpath(String.format(COLUMN_XPATH_TEMPLATE, columnNum));
    }

    @Override
    public String getPageTitleExpected() {
        return PAGE_TITLE_LOCAL;
    }

    @Override
    protected String getPageUrlLocal() {
        return LOCAL_URL;
    }

    public List<String> getZoneNameValues(){
        return getColumnValuesList(COLUMN_ZONE);
    }
}
