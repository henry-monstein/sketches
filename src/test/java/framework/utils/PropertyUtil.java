package framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    private static final String CONFIG_PROPERTIES = "src/test/resources/config.properties";

    private static Properties property = null;

    private static void init() {
        FileInputStream inputStream;
        property = new Properties();
        try {
            inputStream = new FileInputStream(CONFIG_PROPERTIES);
            property.load(inputStream);
        } catch (IOException e) {
            System.err.println("File don't find.");
        }
    }

    public static String getProperty(String key) {
        if (property == null) {
            init();
        }
        return property.getProperty(key);
    }
}
