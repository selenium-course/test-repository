package ru.course.selenium;

import org.testng.annotations.Listeners;
import ru.course.selenium.core.DriverFactory;
import org.testng.annotations.AfterClass;
import ru.course.selenium.core.TestListener;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
@Listeners({TestListener.class})
public class BaseTest {

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverFactory.getInstance().removeDriver();
    }
}
