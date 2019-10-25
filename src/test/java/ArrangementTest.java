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

    @Test
    void Arrangement_blir_lagt_til_en_og_bare_en_gang_i_lista_over_alle_arrangementer_naar_arrangementet_opprettes() {
        Arrangement dummyAarr = new Arrangement("navnemann", "løping", tid, tid, "Gjøvik", organiser);
        ArrayList<Arrangement> excpectedValue = new ArrayList<>();
        ArrayList<Arrangement> actualValue = new ArrayList<>();
        int antallGangerArrangementetErLagtTil = 0;
        excpectedValue.add(dummyAarr);


        for (Arrangement arrangement : Arrangement.getAlleArrangement()) {
            if (arrangement == dummyAarr) {
                antallGangerArrangementetErLagtTil++;
                actualValue.add(arrangement);
            }
        }
        System.out.println("Arrangementet er lagt til " + antallGangerArrangementetErLagtTil + " gang(er).");
        assertEquals(excpectedValue, actualValue);
    }

}