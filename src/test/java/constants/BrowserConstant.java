package constants;

import utils.PropertyUtil;

public class BrowserConstant {
    private static final String BROWSER_CONFIG_FIELD = "browser.name";

    public static String getBrowserConfigField() {
        return PropertyUtil.getProperty(BROWSER_CONFIG_FIELD);
    }
}
