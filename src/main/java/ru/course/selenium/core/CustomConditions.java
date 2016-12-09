package ru.course.selenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.Set;

/**
 * Created by Aleksei.Klimenko on 09.12.2016.
 */
public class CustomConditions {

    private CustomConditions() {
    }

    public static ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
        return new ExpectedCondition<String>() {

            public String apply(WebDriver webDriver) {
                Set<String> handles = webDriver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }

            public String toString() {
                return "any new windows to be opened";
            }
        };
    }
}
