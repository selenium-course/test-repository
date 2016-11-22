package ru.course.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import ru.course.selenium.core.DriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public class BasePage {
    protected static final String SITE_URL = "http://localhost/litecart";

    protected FluentWait getPresenceWaiter(){
        return new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver())
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    protected FluentWait getElementPresenceWaiter(WebElement element){
        return new FluentWait<WebElement>(element)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

}