package ru.course.selenium.core;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Aleksei.Klimenko on 19.12.2016.
 */
public class TestListener implements ITestListener {
    private static Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        //Do nothing
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //Do nothing
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        File screen = ((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        File destination = new File(String.format("%s%s%s",
                ConfigurationProperties.getInstance().getScreenshotsPath(),
                iTestResult.getInstanceName().replace('.', '/'),
                ".png"));
        destination.getParentFile().mkdirs();
        try {
            Files.copy(screen, destination);
        } catch (IOException ex) {
            log.error("Exception occurs on making screenshot", ex);
            throw new LitecartGeneralException("Exception occurs on making screenshot", ex);
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        //Do nothing
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //Do nothing
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        //Do nothing
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        //Do nothing
    }
}
