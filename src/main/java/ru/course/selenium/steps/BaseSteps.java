package ru.course.selenium.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.course.selenium.core.ConfigurationProperties;
import ru.course.selenium.core.CustomConditions;
import ru.course.selenium.core.DriverFactory;

import java.util.Set;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
public abstract class BaseSteps {

    private String mainWindowHandle;

    public WebDriver getDriver(){
        return DriverFactory.getInstance().getDriver();
    }

    public WebDriverWait getWaiter(){
        return new WebDriverWait(getDriver(), ConfigurationProperties.getInstance().getImplicitlyWait());
    }

    public void toExternalLink(String mainWindowHandle, WebElement externalLink){
        this.mainWindowHandle = mainWindowHandle;
        Set<String> oldWindows = getDriver().getWindowHandles();
        externalLink.click();
        String newWindow = getWaiter().until(CustomConditions.anyWindowOtherThan(oldWindows));
        getDriver().switchTo().window(newWindow);
    }

    public void toMainWindow(){
        if (this.mainWindowHandle != null) {
            getDriver().close();
            getDriver().switchTo().window(mainWindowHandle);
        }
    }
}
