package utils;

import org.testng.ReporterConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    public static final String CONFIG_PROPERTIES = "src/test/resources/config.properties";
    public static final String BROWSER_CONFIG_FIELD = "browser.name";
    public static final String USERNAME_CONFIG_FIELD = "username";
    public static final String PASSWORD_CONFIG_FIELD = "password";

    private Properties property;

    public PropertyUtil() {
        FileInputStream inputStream;
        property = new Properties();
        try {
            inputStream = new FileInputStream(CONFIG_PROPERTIES);
            property.load(inputStream);
        } catch (IOException e) {
            System.err.println("File don't find.");
        }
    }

    public String getBrowserType() {
        return property.getProperty(BROWSER_CONFIG_FIELD);
    }

    public String[] getUsernameAndPassword() {
        return new String[]{property.getProperty(USERNAME_CONFIG_FIELD), property.getProperty(PASSWORD_CONFIG_FIELD)};
    }
}
