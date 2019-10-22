import org.testng.annotations.Test;
import softwareengineering.model.Deltager;
import softwareengineering.utilities.BrukerCookieUtility;

import javax.servlet.http.Cookie;

import static org.junit.jupiter.api.Assertions.*;

@Test
public class CookieTest {

    @Test
    public void get_Bruker_Cookie() throws Exception{
        Deltager kalle = new Deltager("kalle@gmail.com", "admin", "kalle", "kalleson");
        BrukerCookieUtility cookieUtility = new BrukerCookieUtility();

        assertTrue(cookieUtility.BrukerCookie(kalle) instanceof Cookie);
    }

    @Test
    public void sjekk_cookie() throws Exception{
        Deltager kalle = new Deltager("kalle@gmail.com", "admin", "kalle", "kalleson");
        BrukerCookieUtility cookieUtility = new BrukerCookieUtility();

        assertEquals(cookieUtility.checkCookie(cookieUtility.BrukerCookie(kalle)), kalle);
    }

    @Test
    public void sjekk_at_random_string_blir_riktig_lengde(){
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; //lengde 36
        BrukerCookieUtility cookieUtility = new BrukerCookieUtility();
        assertEquals(abc.length(), cookieUtility.randomString(36).length());
        assertNotEquals(abc.length(), cookieUtility.randomString(30).length());
    }

    @Test
    public void sjekk_at_random_string_ikke_generer_lik(){
        BrukerCookieUtility cookieUtility = new BrukerCookieUtility();
        String randomString1 = cookieUtility.randomString(36);
        String randomString2 = cookieUtility.randomString(36);
        assertNotEquals(randomString1,  randomString2);
    }
}
