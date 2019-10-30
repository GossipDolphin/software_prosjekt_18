import org.testng.annotations.Test;
import softwareengineering.model.Bruker;
import softwareengineering.model.Deltager;

import static org.junit.jupiter.api.Assertions.*;

@Test
public class BrukerTest {

    @Test
    public void checkSalt(){

    }
    @Test
    public void HashPwd(){
        Deltager deltager = new Deltager("testttttt","123","ttt","eee");
        String password = "123";
        String testpwd = deltager.hashPassword(password, deltager.getSalt());
        assertEquals(testpwd,deltager.getPassword());
    }
    @Test
    public void Sjekk_login(){
        Deltager deltager = new Deltager("sjekk@gmail.com", "admin", "sjekk", "sjekk");
        assertEquals(deltager, Bruker.login("sjekk@gmail.com", "admin"));
        assertNotEquals(deltager, (Bruker.login("sjekk@gmail.com", "adminnn")));
        assertNull(Bruker.login("sjekk@hotmail.com", "admin"));
    }
}
