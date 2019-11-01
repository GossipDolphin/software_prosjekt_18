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
    void finner_riktig_bruker_ved_login() {
        Deltager dummyDeltager = new Deltager("brekk@gmail.com", "admin", "sjekk", "skjekk");
        Organiser organiser = new Organiser("organiser@email.com", "passord1", "Telenor");

        assertEquals(dummyDeltager, Bruker.finnBruker("brekk@gmail.com"));
        assertEquals(organiser, Bruker.finnBruker("organiser@email.com"));
    }

    @Test
    void Skal_ikke_logge_inn_bruker_ved_feil_passord() {
        Deltager deltager = new Deltager("sjekk@gmail.com", "admin", "sjekk", "sjekk");
        Organiser organiser = new Organiser("organiser@email.com", "passord1", "Telenor");

        assertNotEquals(deltager, (Bruker.login("sjekk@gmail.com", "FeilPassord")));
        assertNotEquals(organiser, (Bruker.login("organiser@email.com", "FeilPassord")));
    }

    @Test
    void bruker_som_ikke_finnes_logges_ikke_inn() {
        assertNull(Bruker.login("DenneBrukerenFinnesIkke@hotmail.com", "admin"));
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
