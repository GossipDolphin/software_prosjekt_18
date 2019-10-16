package softwareengineering.utilities;

import softwareengineering.model.Bruker;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BrukerCookieUtility {
    private static Map<String,Bruker> cookieMap = new HashMap<>();

    public Bruker checkCookie(Cookie cookie) throws IOException, ClassNotFoundException {
        System.out.println("input value" + cookie.getValue());
        System.out.println("map value" + cookieMap.get(cookie.getValue()));

        for(Map.Entry<String,Bruker> entry: cookieMap.entrySet())
        {
            System.out.println("looping: " + entry.getKey() + " should match " + cookieMap.get(cookie.getValue()));
            if(entry.getKey()==cookie.getValue())
                return entry.getValue();
        }
        return cookieMap.get(cookie.getValue());
    }

    public Cookie BrukerCookie(Bruker bruker) throws IOException {
        /*ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream so = new ObjectOutputStream(bo);
        so.writeObject(bruker);
        so.flush();*/
        Cookie cookie = new Cookie("bruker",randomString(20));
        cookieMap.put(cookie.getValue(),bruker);
        System.out.println("t" + cookieMap.get(cookie.getValue()));
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        return cookie;
    }
    public String randomString(int length){
        Random random = new Random();
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String ny = "";
        while(ny.length()<length){
            char a = abc.charAt(random.nextInt(abc.length()));
            if(random.nextInt(2)<1)
                a = Character.toLowerCase(a);
            ny += a;
        }
        return ny;
    }
}
