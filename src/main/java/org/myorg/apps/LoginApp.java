package org.myorg.apps;

import org.myorg.models.User;
import spark.Session;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.myorg.services.HashGenerator.generator;
import static org.myorg.services.URLReader.trust;
import static spark.Spark.*;

public class LoginApp {
    private static final ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>(Map.of(
            "jorge", new User("jorge", generator("123456")),
            "laura", new User("laura", generator("astro123"))
    ));
    public static void main(String[] args) {
        port(getPort());
        secure(getKeyPath(), getKeyPwd(), null, null);
        get("/login", ((request, response) -> {
            response.type("text/html");
            return Files.readString(Paths.get("src/main/resources/index.html"));
        }));

        post("/login", (request, response) -> {
            String username = request.queryParams("username");
            String password = request.queryParams("password");

            if (users.containsKey(username) && users.get(username).getPassword().equals(generator(password))) {
                Session session = request.session(true);
                session.attribute("username", username);
                trust(getKeyTrustPath(), getKeyPwd());
                response.redirect("https://107.23.88.160:4567/hello");
                return null;
            }

            return "Wrong Password or Username";
        });
    }

    public static Integer getPort() {
        return System.getenv("PORT") != null ? Integer.parseInt(System.getenv("PORT")) : 7654;
    }

    public static String getKeyPath() {
        return System.getenv("KEY-PATH") != null ? System.getenv("KEY-PATH") : "certificates/ecikeystore.p12";
    }

    public static String getKeyTrustPath() {
        return System.getenv("KEY-PATH") != null ? System.getenv("KEY-TRUST-PATH") : "certificates/myTrustStore";
    }

    public static String getKeyPwd() {
        return System.getenv("KEY-PWD") != null ? System.getenv("KEY-PWD") : "123456";
    }
}
