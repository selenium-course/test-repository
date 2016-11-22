package ru.course.selenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public class DriverFactory {
    private static DriverFactory driverFactory = new DriverFactory();

    private DriverFactory(){
        //Do Nothing
    }

    public static DriverFactory getInstance(){
        if (driverFactory == null) {
            synchronized (DriverFactory.class) {
                if (driverFactory == null) {
                    driverFactory = new DriverFactory();
                }
            }
        }
        return driverFactory;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            return new ChromeDriver();
        }
    };

    public WebDriver getDriver(){
        return driver.get();
    }

    public void removeDriver(){
        driver.get().quit();
        driver.remove();
    }
}
