import org.testng.annotations.Test;
import softwareengineering.model.Bruker;
import softwareengineering.model.Deltager;
import softwareengineering.model.Organiser;

import static org.junit.jupiter.api.Assertions.*;

@Test
public class BrukerTest {

    // krav nr 9.
    @Test
    public void HashPwd(){
        Deltager deltager = new Deltager("testttttt","123","ttt","eee");
        String password = "123";
        String testpwd = deltager.hashPassword(password, deltager.getSalt());
        assertEquals(testpwd,deltager.getPassword());
    }
    // krav nr 2.
    @Test
    public void Sjekk_login(){
        Deltager deltager = new Deltager("sjekk@gmail.com", "admin", "sjekk", "sjekk");
        assertEquals(deltager, Bruker.login("sjekk@gmail.com", "admin"));
        assertNotEquals(deltager, (Bruker.login("sjekk@gmail.com", "adminnn")));
        assertNull(Bruker.login("sjekk@hotmail.com", "admin"));
    }
    // krav nr 1.
    @Test
    public void registrer_bruker_som_deltager(){
        assertTrue(Bruker.registrerBruker("kalle@gmail.com", "admin", "kalle", "kalleson", null) instanceof Deltager);
        Deltager deltager = new Deltager("kalle@gmail.com", "admin", "kalle", "kalleson");
        assertEquals(Bruker.registrerBruker("kalle@gmail.com", "admin", "kalle", "kalleson", null).toString(), deltager.toString());
        assertFalse(Bruker.registrerBruker("kalle@gmail.com", "admin", "kalle", null, null) instanceof Deltager);
    }
    // krav nr 1.
    @Test
    public void registrer_bruker_som_Organiser(){
        assertTrue(Bruker.registrerBruker("kalle@gmail.com", "admin", null, null, "kalleCorp") instanceof Organiser);
        Organiser organiser = new Organiser("kalle@gmail.com", "admin","kalleCorp");
        assertEquals(Bruker.registrerBruker("kalle@gmail.com", "admin", null, null, "kalleCorp").toString(), organiser.toString());
        assertFalse(Bruker.registrerBruker("kalle@gmail.com", "admin", "kalle", null, null) instanceof Organiser);
    }
}
