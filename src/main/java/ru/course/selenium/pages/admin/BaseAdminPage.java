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

    private ApplicationMenu menu;

    public BaseAdminPage(WebDriver driver){
        this.menu = PageFactory.initElements(driver, ApplicationMenu.class);
    }

    protected abstract String getPageTitleLocal();

    protected abstract String getPageUrlLocal();

    public String getVersion() {
        return this.version.getText();
    }

    public ApplicationMenu getMenu() {
        return menu;
    }

    protected static String getPageTitle(String localTitle){
        return String.format("%s | My Store", localTitle);
    }

    public String getPageTitle(){
        return String.format("%s | My Store", getPageTitleLocal());
    }

    public String getPageUrl(){
        return ConfigurationProperties.getInstance().getEndpoint() + getPageUrlLocal();
    }
}
