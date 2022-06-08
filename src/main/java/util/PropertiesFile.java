package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesFile {

    static Properties prop = new Properties();
    static String projectPath = System.getProperty("user.dir");

    public static String getProperties() throws IOException {
        InputStream inputStream = new FileInputStream(projectPath + "/src/main/resources/config.properties");
        prop.load(inputStream);
        String browser = prop.getProperty("browser");
        return browser;

    }

    public static String getUrl() {
        String url = prop.getProperty("url");
        return url;
    }
}
