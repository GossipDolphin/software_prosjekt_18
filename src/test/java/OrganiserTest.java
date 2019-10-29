import org.testng.annotations.Test;
import softwareengineering.model.Arrangement;
import softwareengineering.model.Deltager;
import softwareengineering.model.Organiser;
import softwareengineering.model.Race;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Test
public class OrganiserTest {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private Organiser organiser = new Organiser("a", "a", "a");
    private String randomTid = "2019-09-09 10:30";
    private LocalDateTime tid = LocalDateTime.parse(randomTid, formatter);
    private Arrangement arrangement = new Arrangement("KekLøpForAlle","dankestrace", LocalDateTime.parse(randomTid, formatter), LocalDateTime.parse(randomTid, formatter), "Halden", organiser);


    @Test
    public void test_legg_til_arrangement_i_listen() {
        organiser.addArrangement(arrangement);
        assertEquals(arrangement, organiser.getArrangementListe().get(organiser.getArrangementListe().size()-1));
    }


    private Deltager petter = new Deltager("petter@gmail.com", "admin", "petter", "petterson");
    private Race dummyRace = new Race("race for the stuff","løp som bare faen rundt om kring", tid, tid,arrangement);

    @Test
    public void legg_til_resultat_i_race(){
        petter.joinRace(dummyRace);
        dummyRace.getResultatMap().put(petter, tid);
        organiser.leggTilResultatTilRace(dummyRace, petter, tid);

        HashMap<Deltager, LocalDateTime> expected = new HashMap<>();
        expected.put(petter, tid);

        assertEquals(expected, dummyRace.getResultatMap());
    }

}
