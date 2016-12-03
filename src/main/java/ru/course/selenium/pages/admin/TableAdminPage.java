package ru.course.selenium.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Aleksei.Klimenko on 02.12.2016.
 */
public abstract class TableAdminPage extends BaseAdminPage {
    private static final String COLUMN_CSS_TEMPLATE = "table.dataTable tr:not(.footer) td:nth-of-type(%d)";

    private WebDriver driver;

    @FindBy(css = "table.dataTable tr.row")
    private List<WebElement> rowsList;

    public TableAdminPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    protected By getColumnLocator(Integer columnNum) {
        return By.cssSelector(String.format(COLUMN_CSS_TEMPLATE, columnNum));
    }

    /**
     * @param columnNum starting from 1
     * @return list of WebElements
     */
    protected List<WebElement> getColumnElementsList(Integer columnNum) {
        Integer columnCounts = driver.findElements(By.cssSelector("tr.header th")).size();
        if (columnNum >= columnCounts){
            return Collections.emptyList();
        }
        return driver.findElements(getColumnLocator(columnNum));
    }

    /**
     * @param columnNum starting from 1
     * @return list of String values
     */
    protected List<String> getColumnValuesList(Integer columnNum) {
        return getColumnElementsList(columnNum).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
