package ru.course.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import ru.course.selenium.core.ConfigurationProperties;
import ru.course.selenium.core.DriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public abstract class BasePage {
    protected FluentWait getFluentWait(){
        return new FluentWait(DriverFactory.getInstance().getDriver())
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }
}