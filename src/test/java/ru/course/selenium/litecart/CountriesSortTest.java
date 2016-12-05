package ru.course.selenium.litecart;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.course.selenium.BaseTest;
import ru.course.selenium.domain.UserEnum;
import ru.course.selenium.steps.admin.AdminLoginSteps;
import ru.course.selenium.steps.admin.countries.CountriesSteps;
import ru.course.selenium.steps.admin.countries.EditCountrySteps;
import ru.course.selenium.steps.admin.geozones.EditGeoZoneSteps;
import ru.course.selenium.steps.admin.geozones.GeoZonesSteps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

/**
 * Created by Aleksei.Klimenko on 02.12.2016.
 */
public class CountriesSortTest extends BaseTest {

    private AdminLoginSteps loginSteps = new AdminLoginSteps();

    @Test
    public void countriesAlphabeticalSortTest() {
        CountriesSteps countriesSteps = loginSteps.openLoginPage()
                .loginAs(UserEnum.ADMIN)
                .toCountries();
        List<String> actualList = countriesSteps.getCountryNameValues();

        List<String> expectedList = new ArrayList<>(actualList);
        Collections.sort(expectedList);
        assertThat("Country names are not alphabetically sorted", actualList, contains(expectedList.toArray()));
    }

    @Test
    public void countryZonesAlphabeticalSortTest() {
        CountriesSteps countriesSteps = loginSteps.openLoginPage()
                .loginAs(UserEnum.ADMIN)
                .toCountries();
        //get country with zone indexes
        List<String> zonesList = countriesSteps.getCountryZoneValues();
        int[] countryWithZones = IntStream.range(0, zonesList.size())
                .filter(i -> zonesList.get(i).compareTo("0") > 0)
                .toArray();

        List<String> actualList;
        List<String> expectedList;
        EditCountrySteps editCountrySteps;
        for (int i : countryWithZones){
            editCountrySteps = countriesSteps.editCountry(countriesSteps.getCountryNameElements().get(i));
            actualList = editCountrySteps.getZoneNameValues();
            expectedList = new ArrayList<>(actualList);
            Collections.sort(expectedList);
            assertThat("Country zone names are not alphabetically sorted", actualList, contains(expectedList.toArray()));
            countriesSteps = editCountrySteps.toCountries();
        }
    }

    @Test
    public void countriesInGeoZonesAlphabeticalSortTest() {
        GeoZonesSteps geoZonesSteps = loginSteps.openLoginPage()
                .loginAs(UserEnum.ADMIN)
                .toGeoZones();

        List<String> actualList;
        List<String> expectedList;
        EditGeoZoneSteps editZoneSteps;

        for (int i=0; i < geoZonesSteps.getGeoZoneNameElements().size(); i++){
            editZoneSteps = geoZonesSteps.editGeoZone(geoZonesSteps.getGeoZoneNameElements().get(i));
            actualList = editZoneSteps.getZoneNameValues();
            expectedList = new ArrayList<>(actualList);
            Collections.sort(expectedList);
            assertThat("Country names in Geo Zone are not alphabetically sorted", actualList, contains(expectedList.toArray()));
            geoZonesSteps = editZoneSteps.toGeoZones();
        }
    }
}
