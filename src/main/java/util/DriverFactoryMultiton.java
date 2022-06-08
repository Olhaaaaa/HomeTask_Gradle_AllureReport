package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverFactoryMultiton {

    public ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    private static DriverFactoryMultiton instance = null;

    public static DriverFactoryMultiton getInstance() {
        if (instance == null)
            instance = new DriverFactoryMultiton();
        return instance;
    }

    public WebDriver getDriver() {
        return webDriver.get();
    }

    public final void setDriver() throws IOException {
        String browser = PropertiesFile.getProperties();
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            webDriver.set(new ChromeDriver());
        }
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }


    public final void getBrowserURL() {
        String url = PropertiesFile.getUrl();
        getDriver().get(url);
    }

    public void driverClose() {
        getDriver().close();
    }
}

