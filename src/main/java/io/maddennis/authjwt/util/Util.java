package io.maddennis.authjwt.util;

public class Util {

    public static final String[] ENDPOINTS_WHITELIST = {
            "/swagger-ui/**",
            "/api/auth/signin",
            "/api/auth/signup",
    };

    public static final String SIGNIN_URL = "/api/auth/signin";
    public static final String SIGNUP_URL = "/api/auth/signup";
}
