package logging;

import io.qameta.allure.Allure;
import org.openqa.selenium.logging.LogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.Level;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.WARNING;

//import static java.util.logging.Level.INFO;


public class Log {
    private static Logger logger = null;

    private static Logger setName(String name){
        logger = LoggerFactory.getLogger(String.format("%s", name));
        return Log.logger;
    }

    private static Logger getLogger(){
        if (logger != null){
            return logger;
        } else{
            logger = setName("Some testing:");
            return logger;
        }
    }

    public static void log(String message){
        getLogger().info(message);
        Allure.addAttachment("Test result", "text/html", message);
    }

    public static void log(String messageName, String message, Object... parameters){
        String messageWithParams = String.format(message, parameters);
        Allure.addAttachment(message, "text/html", messageWithParams);
        getLogger().info(messageWithParams);
    }

//    public static void log(LogType type, String messageName, String message){
//        switch (type){
//            case INFO:
//                getLogger().info(message);
//                Allure.addAttachment(messageName, "text/html", message);
//                break;
//            case ERROR:
//                getLogger().error(message);
//                Allure.addAttachment(messageName, "text/html", message);
//                break;
//            case WARNING:
//                getLogger().warn(message);
//                break;
//        }
//    }

}
