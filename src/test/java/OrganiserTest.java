import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@Test
public class OrganiserTest {

    public void testLeggTilArrangement(){
        Organiser organiser = new Organiser("a","a", "a", "a");
        Race race = new Race("a", LocalDateTime.now(), LocalDateTime.now());
        ArrayList<Race> racelist = new ArrayList<>();
        racelist.add(race);
        Arrangement arrangement = new Arrangement("a", LocalDateTime.now(), LocalDateTime.now(),"a", organiser, racelist);

        assertEquals(organiser.leggTilArrangement("a", LocalDateTime.now(), LocalDateTime.now(),"a", organiser, racelist).toString(), arrangement.toString());
    }
}
