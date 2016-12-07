package ru.course.selenium.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.course.selenium.core.ConfigurationProperties;
import ru.course.selenium.core.DriverFactory;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public abstract class BaseSteps {

    public WebDriver getDriver(){
        return DriverFactory.getInstance().getDriver();
    }

    public WebDriverWait getWaiter(){
        return new WebDriverWait(getDriver(), ConfigurationProperties.getInstance().getImplicitlyWait());
    }
}
