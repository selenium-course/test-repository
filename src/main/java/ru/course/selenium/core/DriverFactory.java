package ru.course.selenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

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
            BrowserType type = ConfigurationProperties.getInstance().getBrowserType();
            WebDriver driver;
            DesiredCapabilities caps;
            switch (type) {
                case CHROME:
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                case FIREFOX_45ESR:
                    caps = new DesiredCapabilities();
                    caps.setCapability(FirefoxDriver.MARIONETTE, false);
                    driver = new FirefoxDriver(new FirefoxBinary(new File(ConfigurationProperties.getInstance().getFirefoxEsrPath())),
                            new FirefoxProfile(), caps);
                    break;
                case FIREFOX_NIGHTLY:
                    caps = new DesiredCapabilities();
                    caps.setCapability(FirefoxDriver.MARIONETTE, true);
                    driver = new FirefoxDriver(new FirefoxBinary(new File(ConfigurationProperties.getInstance().getFirefoxNightlyPath())),
                            new FirefoxProfile(), caps);
                    break;
                case EXPLORER:
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser type set in configuration - " + type);
            }
            driver.manage()
                    .timeouts()
                    .implicitlyWait(ConfigurationProperties.getInstance().getImplicitlyWait(), TimeUnit.SECONDS)
                    .pageLoadTimeout(ConfigurationProperties.getInstance().getPageLoadWait(), TimeUnit.SECONDS);
            return driver;
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
