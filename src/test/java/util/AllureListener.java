package util;

import io.qameta.allure.Attachment;
import logging.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

//import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class AllureListener implements ITestListener, ISuiteListener, IInvokedMethodListener {
    final static Logger logger = Logger.getLogger(String.valueOf(CustomTestListener.class));

    protected List<String> suiteResult = new LinkedList<>();

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }


    @Override
    public void onStart(ITestContext iTestContext) {
        Log.log("onStart method: " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", DriverFactoryMultiton.getInstance().getDriver());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.log("onFinish method " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.log("Start test: " + getTestMethodName(result) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.log("onTestSuccess method.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.log("onTestFailure method: " + getTestMethodName(result) + " failed");
        Object testClass = result.getInstance();
        WebDriver driver = DriverFactoryMultiton.getInstance().getDriver();
        if (driver instanceof WebDriver) {
            Log.log("Screenshot captured for test case: " + getTestMethodName(result));
            saveScreenshotPNG(driver);
        }
        saveTextLog(getTestMethodName(result) + " failed and screenshot taken!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.log("onTestSkipped method: " + getTestMethodName(result) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Log.log("Test failed but it is in defined success ratio: " + getTestMethodName(result));
    }
}