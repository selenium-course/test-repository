package ru.course.selenium.core;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

/**
 * Created by Aleksei.Klimenko on 22.11.2016.
 */
@Resource.Classpath("configuration.properties")
public class ConfigurationProperties {

    @Property("litecart.endpoint")
    private String endpoint = "localhost";

    @Property("test.browser.type")
    private BrowserType browserType = BrowserType.CHROME;

    @Property("test.browser.implicitly.wait")
    private Long implicitlyWait = 5L;

    @Property("test.browser.pageload.wait")
    private Long pageLoadWait = 30L;

    @Property("test.hub.endpoint")
    private String hubEndpoint;

    @Property("firefox.path.esr")
    private String firefoxEsrPath;

    @Property("firefox.path.nightly")
    private String firefoxNightlyPath;

    private static ConfigurationProperties configProperties;

    private ConfigurationProperties(){
        PropertyLoader.newInstance().populate(this);
    }

    public static ConfigurationProperties getInstance() {
        if (configProperties == null) {
            synchronized (ConfigurationProperties.class) {
                if (configProperties == null) {
                    configProperties = new ConfigurationProperties();
                }
            }
        }
        return configProperties;
    }

    public BrowserType getBrowserType() {
        return browserType;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public Long getImplicitlyWait() {
        return implicitlyWait;
    }

    public Long getPageLoadWait() {
        return pageLoadWait;
    }

    public String getHubEndpoint() {
        return hubEndpoint;
    }

    public String getFirefoxEsrPath() {
        return firefoxEsrPath;
    }

    public String getFirefoxNightlyPath() {
        return firefoxNightlyPath;
    }
}
