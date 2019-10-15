package softwareengineering.utilities;

import softwareengineering.model.Bruker;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class BrukerCookieUtility {
    private HashMap<Cookie,Bruker> cookieMap = new HashMap<>();

    public Bruker checkCookie(Cookie cookie) throws IOException, ClassNotFoundException {
        /*byte b[] = cookie.getValue().getBytes();
        ByteArrayInputStream bi = new ByteArrayInputStream(b);
        ObjectInputStream si = new ObjectInputStream(bi);
        Bruker bruker = (Bruker) si.readObject();*/
        return cookieMap.get(cookie);
    }

    public Cookie BrukerCookie(Bruker bruker) throws IOException {
        /*ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream so = new ObjectOutputStream(bo);
        so.writeObject(bruker);
        so.flush();*/
        Cookie cookie = new Cookie("bruker",randomString(20));
        cookieMap.put(cookie,bruker);
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
