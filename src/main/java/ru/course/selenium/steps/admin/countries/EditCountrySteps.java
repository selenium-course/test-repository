package ru.course.selenium.steps.admin.countries;

import ru.course.selenium.pages.admin.countries.EditCountryPage;
import ru.course.selenium.steps.admin.BaseAdminSteps;

import java.util.List;


/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class EditCountrySteps extends BaseAdminSteps {
    private EditCountryPage editCountryPage;

    public EditCountrySteps() {
        super(EditCountryPage.class);
        editCountryPage = (EditCountryPage) page;
    }

    public List<String> getZoneNameValues(){
        return editCountryPage.getZoneNameValues();
    }

}
