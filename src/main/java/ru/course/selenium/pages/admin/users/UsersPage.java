package ru.course.selenium.pages.admin.users;

import org.openqa.selenium.WebDriver;
import ru.course.selenium.pages.admin.BaseAdminPage;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public class UsersPage extends BaseAdminPage {
    public static final String PAGE_TITLE_LOCAL = "Users";
    public static final String LOCAL_URL = "/admin/?app=users&doc=users";

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getPageTitleLocal() {
        return PAGE_TITLE_LOCAL;
    }

    @Override
    protected String getPageUrlLocal() {
        return LOCAL_URL;
    }
}
