package ru.course.selenium.steps.admin.countries;

import org.openqa.selenium.WebElement;
import ru.course.selenium.pages.admin.countries.CountriesPage;
import ru.course.selenium.steps.admin.BaseAdminSteps;

import java.util.List;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class CountriesSteps extends BaseAdminSteps {
    private CountriesPage countriesPage;

    public CountriesSteps() {
        super(CountriesPage.class);
        countriesPage = (CountriesPage) page;
    }

    public List<WebElement> getCountryNameElements(){
        return countriesPage.getCountryNameElements();
    }

    public List<String> getCountryNameValues(){
        return countriesPage.getCountryNameValues();
    }

    public List<String> getCountryZoneValues(){
        return countriesPage.getCountryZoneValues();
    }

    public EditCountrySteps editCountry(WebElement countryElement){
        countriesPage.editCountry(countryElement);
        return new EditCountrySteps();
    }
}
