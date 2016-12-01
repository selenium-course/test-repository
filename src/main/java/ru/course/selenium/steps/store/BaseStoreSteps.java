package ru.course.selenium.steps.store;

import org.openqa.selenium.support.PageFactory;
import ru.course.selenium.pages.store.BaseStorePage;
import ru.course.selenium.steps.BaseSteps;

/**
 * Created by Aleksei.Klimenko on 01.12.2016.
 */
public abstract class BaseStoreSteps<T extends BaseStorePage> extends BaseSteps{
    protected T page;

    public BaseStoreSteps(Class<T> pageClass){
        page = PageFactory.initElements(getDriver(), pageClass);
    }
}
