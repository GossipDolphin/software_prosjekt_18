import org.testng.annotations.Test;
import softwareengineering.model.Deltager;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
}
