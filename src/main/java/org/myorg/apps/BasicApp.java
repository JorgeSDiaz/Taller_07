package org.myorg.apps;

import static spark.Spark.*;
import static org.myorg.services.URLReader.*;

/**
 * Hello world!
 */
public class BasicApp {
    public static void main(String[] args) {
        port(getPort());
        secure(getKeyPath(), getKeyPwd(), null, null);
        get("/hello", (req, res) -> "Hello World");
    }

    public static Integer getPort() {
        return System.getenv("PORT") != null ? Integer.parseInt(System.getenv("PORT")) : 4567;
    }

    public static String getKeyPath() {
        return System.getenv("KEY-PATH") != null ? System.getenv("KEY-PATH") : "certificates/ecikeystore.p12";
    }

    public static String getKeyPwd() {
        return System.getenv("KEY-PWD") != null ? System.getenv("KEY-PWD") : "123456";
    }
}
