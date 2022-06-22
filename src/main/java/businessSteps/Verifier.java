package businessSteps;

import io.qameta.allure.Step;
import logging.Log;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import static java.util.logging.Level.INFO;

public class Verifier {

    @Step("Step 1")
    public Verifier verify1(){
        //Log.log(LogType.INFO, "Message name 1", "Everything passed %s", true);
        Assert.assertTrue(true);
        return this;
    }

    @Step("Step 2")
    public Verifier verify2(){
       // Log.log(LogType.INFO, "Message name 2", "Everything passed %s", true);
        Assert.assertTrue(true);
        return this;
    }
}
