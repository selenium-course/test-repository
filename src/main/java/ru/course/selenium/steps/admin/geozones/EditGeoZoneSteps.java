package ru.course.selenium.steps.admin.geozones;

import ru.course.selenium.pages.admin.geozones.EditGeoZonePage;
import ru.course.selenium.steps.admin.BaseAdminSteps;

import java.util.List;


/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class EditGeoZoneSteps extends BaseAdminSteps {
    private EditGeoZonePage editZonePage;

    public EditGeoZoneSteps() {
        super(EditGeoZonePage.class);
        editZonePage = (EditGeoZonePage) page;
    }

    public List<String> getZoneNameValues(){
        return editZonePage.getZoneNameValues();
    }

}
