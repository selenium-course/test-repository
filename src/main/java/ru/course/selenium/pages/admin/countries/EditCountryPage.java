package ru.course.selenium.pages.admin.countries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.TableAdminPage;

import java.util.List;

/**
 * Created by Aleksei.Klimenko on 03.12.2016.
 */
public class EditCountryPage extends TableAdminPage{
    public static final String PAGE_TITLE_LOCAL = "Edit Country";
    public static final String LOCAL_URL = "/admin/?app=countries&doc=edit_country&country_code=";
    private static final Integer COLUMN_NAME = 3;
    private static final String COLUMN_XPATH_TEMPLATE = "//table[@class='dataTable']//td[%d]/input[@type='hidden']/..";

    public EditCountryPage(WebDriver driver) {
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
        return getColumnValuesList(COLUMN_NAME);
    }
}
