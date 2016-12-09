package ru.course.selenium.pages.admin.countries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.course.selenium.pages.admin.TableAdminPage;

import java.util.List;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class CountriesPage extends TableAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Countries";
    public static final String LOCAL_URL = "/admin/?app=countries&doc=countries";
    private static final Integer COLUMN_NAME = 5;
    private static final Integer COLUMN_ZONES = 6;

    @FindBy(xpath = "//td[@id='content']//a[contains(.,'Add New Country')]")
    private WebElement buttonAddNewCountry;

    public CountriesPage(WebDriver driver) {
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

    public List<WebElement> getCountryNameElements(){
        return getColumnElementsList(COLUMN_NAME);
    }

    public List<String> getCountryNameValues(){
        return getColumnValuesList(COLUMN_NAME);
    }

    public List<String> getCountryZoneValues(){
        return getColumnValuesList(COLUMN_ZONES);
    }

    public void editCountry(WebElement countryElement){
        countryElement.findElement(By.cssSelector("a")).click();
    }

    public void clickAddNewCountry(){
        buttonAddNewCountry.click();
    }
}
