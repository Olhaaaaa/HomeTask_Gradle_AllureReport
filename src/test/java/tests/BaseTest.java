package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import util.DriverFactoryMultiton;

import java.io.IOException;

public class BaseTest {

    @BeforeTest
    public void profileSetUp() throws IOException {
        DriverFactoryMultiton.getInstance().setDriver();
        DriverFactoryMultiton.getInstance().getDriver();
        DriverFactoryMultiton.getInstance().getBrowserURL();
    }

    @AfterTest
    public void tearDown() {
        DriverFactoryMultiton.getInstance().driverClose();
    }

}
