package ru.course.selenium.steps;

import org.openqa.selenium.WebDriver;
import ru.course.selenium.core.DriverFactory;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public abstract class BaseSteps {

    public WebDriver getDriver(){
        return DriverFactory.getInstance().getDriver();
    }
}
