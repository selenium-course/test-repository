package ru.course.selenium.steps.admin.geozones;

import org.openqa.selenium.WebElement;
import ru.course.selenium.pages.admin.geozones.GeoZonesPage;
import ru.course.selenium.steps.admin.BaseAdminSteps;

import java.util.List;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class GeoZonesSteps extends BaseAdminSteps {
    private GeoZonesPage zonesPage;

    public GeoZonesSteps() {
        super(GeoZonesPage.class);
        zonesPage = (GeoZonesPage) page;
    }

    public List<WebElement> getGeoZoneNameElements(){
        return zonesPage.getGeoZoneNameElements();
    }

    public EditGeoZoneSteps editGeoZone(WebElement countryElement){
        zonesPage.editZone(countryElement);
        return new EditGeoZoneSteps();
    }
}
