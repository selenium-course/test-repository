package ru.course.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import ru.course.selenium.core.ConfigurationProperties;
import ru.course.selenium.core.DriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public class BasePage {
    //TODO Tricky initialization - could affect application start in case of ConfigurationProperties problems
    protected static final String SITE_URL = ConfigurationProperties.getInstance().getEndpoint();

    protected FluentWait getFluentWait(){
        return new FluentWait(DriverFactory.getInstance().getDriver())
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }
}