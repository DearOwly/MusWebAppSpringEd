package so.sonya.muswebapp2.security.util;

import static so.sonya.muswebapp2.api.util.Constants.AUTH_API_URL;

public final class Constants {
    public static final String LOGIN_PAGE_URL = "/login";
    public static final String SIGNUP_URL = AUTH_API_URL + "/signup";
    public static final String LOGIN_PROCESSING_URL = AUTH_API_URL + "/login";
    public static final String OAUTH2_LOGIN_PROCESSING_URL = LOGIN_PROCESSING_URL + "/oauth/authorize";
}
