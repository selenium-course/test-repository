package ru.course.selenium.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.course.selenium.core.ConfigurationProperties;
import ru.course.selenium.pages.BasePage;
import ru.course.selenium.pages.component.ApplicationMenu;

/**
 * Created by Aleksei.Klimenko on 27.11.2016.
 */
public abstract class BaseAdminPage extends BasePage {

    @FindBy(id = "platform")
    private WebElement version;

    @FindBy(tagName = "h1")
    private WebElement pageTitle;

    private ApplicationMenu menu;

    public BaseAdminPage(WebDriver driver){
        this.menu = PageFactory.initElements(driver, ApplicationMenu.class);
    }

    public abstract String getPageTitleExpected();

    protected abstract String getPageUrlLocal();

    public String getVersion() {
        return this.version.getText();
    }

    public ApplicationMenu getMenu() {
        return menu;
    }

    public String getPageTitle(){
        return this.pageTitle.getText();
    }

    public String getPageUrl(){
        return ConfigurationProperties.getInstance().getEndpoint() + getPageUrlLocal();
    }
}
