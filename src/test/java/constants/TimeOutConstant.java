package constants;

import utils.PropertyUtil;

public class TimeOutConstant {
    private static final String PAGE_LOAD_TIMEOUT_FIELD = "pageLoadTimeout";
    private static final String SCRIPT_TIMEOUT_FIELD = "scriptTimeout";
    private static final String IMPLICITLY_WAIT_FIELD = "implicitlyWaitTimeout";
    private static final String CLICKABLE_TIMEOUT_FIELD = "clickableTimeout";
    private static final String PRESENCE_OF_ELEMENT_TIMEOUT_FIELD = "presenceOfElementTimeout";

    public static int getPageLoadTimeout() {
        return Integer.parseInt(PropertyUtil.getProperty(PAGE_LOAD_TIMEOUT_FIELD));
    }

    public static int getScriptTimeout() {
        return Integer.parseInt(PropertyUtil.getProperty(SCRIPT_TIMEOUT_FIELD));
    }

    public static int getImplicitlyWait() {
        return Integer.parseInt(PropertyUtil.getProperty(IMPLICITLY_WAIT_FIELD));
    }

    public static int getClickableTimeout() {
        return Integer.parseInt(PropertyUtil.getProperty(CLICKABLE_TIMEOUT_FIELD));
    }

    public static int getPresenceOfElementTimeout() {
        return Integer.parseInt(PropertyUtil.getProperty(PRESENCE_OF_ELEMENT_TIMEOUT_FIELD));
    }
}
