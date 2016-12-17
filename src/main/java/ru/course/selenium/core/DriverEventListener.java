package ru.course.selenium.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Aleksei.Klimenko on 14.12.2016.
 */

public class DriverEventListener extends AbstractWebDriverEventListener {
        private Logger log = LoggerFactory.getLogger(DriverEventListener.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            log.info("Look for element: " + by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            log.info("Found element: " + by);
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            log.error("Exception occurs on WebDriver operations", throwable);
        }

}
