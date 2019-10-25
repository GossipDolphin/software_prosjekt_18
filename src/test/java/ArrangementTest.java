import org.testng.annotations.Test;
import softwareengineering.model.Arrangement;
import softwareengineering.model.Deltager;
import softwareengineering.model.Organiser;
import softwareengineering.model.Race;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Test
public class ArrangementTest {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private String randomTid = "2019-09-09 10:30";
    private LocalDateTime tid = LocalDateTime.parse(randomTid, formatter);
    private Organiser organiser = new Organiser("meOrganiser@gmail.com", "admin", "lordOrganiser");
    private Arrangement arrangement = new Arrangement("MLG dankløp","dankestrace", tid, tid, "Halden", organiser);
    private Deltager Kalle = new Deltager("Kalle@hotmail.com", "admin", "Kalle", "Kalleson");
    private Race race = new Race("Kan du løpe fortere en hunden min?","dankestrace", tid, tid,arrangement);
    private Race race2 = new Race("sdjsfdkjlkljdfskjldsf","dankestrace", tid, tid,arrangement);

    @Test
    void oppdater_deltagere() {
        arrangement.getRaceList().add(race);
        Kalle.joinRace(race);
        System.out.println(arrangement.getDeltagerList());
        assertTrue(arrangement.getDeltagerList().contains(Kalle));
    }

    @Test
    void hent_arrangement_med_id(){
        int id = arrangement.getId();
        assertEquals(arrangement, Arrangement.getArrangementById(id));
    }

    @Test
    void liste_med_race_kan_hentes() {

        ArrayList<Race> expected = new ArrayList<>();
        Kalle.joinRace(race);
        Kalle.joinRace(race2);

        assertEquals(expected, arrangement.getRaceList());
    }

}