package ru.course.selenium;

import ru.course.selenium.core.DriverFactory;
import org.testng.annotations.AfterClass;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public class BaseTest {

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverFactory.getInstance().removeDriver();
    }
}
