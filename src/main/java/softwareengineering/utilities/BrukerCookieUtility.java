package softwareengineering.utilities;

import softwareengineering.model.Bruker;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BrukerCookieUtility {
    private static Map<String, Bruker> cookieMap = new HashMap<>();

    public Bruker checkCookie(Cookie cookie) throws IOException, ClassNotFoundException {
        for (Map.Entry<String, Bruker> entry : cookieMap.entrySet()) {
            if (entry.getKey() == cookie.getValue())
                return entry.getValue();
        }
        return cookieMap.get(cookie.getValue());
    }

    public Cookie BrukerCookie(Bruker bruker) throws IOException {
        Cookie cookie = new Cookie("bruker", randomString(20));
        cookieMap.put(cookie.getValue(), bruker);
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        return cookie;
    }

    public String randomString(int length) {
        Random random = new Random();
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String ny = "";
        while (ny.length() < length) {
            char a = abc.charAt(random.nextInt(abc.length()));
            if (random.nextInt(2) < 1)
                a = Character.toLowerCase(a);
            ny += a;
        }
        return ny;
    }

    public static Bruker opprettBrukerFraCookie(HttpServletRequest request) {
        BrukerCookieUtility brukerCookieUtility = new BrukerCookieUtility();
        Bruker user = null;
        try {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                user = brukerCookieUtility.checkCookie(cookie);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }
}
