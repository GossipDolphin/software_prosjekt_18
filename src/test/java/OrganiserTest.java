import org.testng.annotations.Test;
import softwareengineering.model.Arrangement;
import softwareengineering.model.Deltager;
import softwareengineering.model.Organiser;
import softwareengineering.model.Race;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Test
public class OrganiserTest {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private Organiser organiser = new Organiser("a", "a", "a");
    private String randomTid = "2019-09-09 10:30";
    private LocalDateTime tid = LocalDateTime.parse(randomTid, formatter);
    private Arrangement arrangement = new Arrangement("KekLøpForAlle","dankestrace", LocalDateTime.parse(randomTid, formatter), LocalDateTime.parse(randomTid, formatter), "Halden", organiser);

    @Test
    public void opprett_arrangement() {
        assertEquals(organiser.opprettArrangement("KekLøpForAlle","dankestrace", LocalDateTime.parse(randomTid, formatter), LocalDateTime.parse(randomTid, formatter), "Halden").toString(), arrangement.toString());
    }

    @Test
    public void test_legg_til_arrangement_i_listen() {
        organiser.addArrangement(arrangement);
        assertEquals(arrangement, organiser.getArrangementListe().get(organiser.getArrangementListe().size()-1));
    }

    @Test
    public void test_legg_til_race_i_arrangement() {
        Arrangement arrangement = organiser.opprettArrangement("KekLøpForAlle","dankestrace", LocalDateTime.parse(randomTid, formatter), LocalDateTime.parse(randomTid, formatter), "Halden");
        organiser.addArrangement(arrangement);
        Race race = new Race("race number one","raceracerace", LocalDateTime.now(), LocalDateTime.now(),arrangement);

           assertEquals(race.toString() ,organiser.addRace(arrangement, race).toString());
    }

    @Test
    public void legg_til_resultat_i_race(){
        Deltager petter = new Deltager("petter@gmail.com", "admin", "petter", "petterson");
        Race race = new Race("race for the stuff","løp som bare faen rundt om kring", tid, tid,arrangement);
        petter.joinRace(race);
        race.getResultatMap().put(petter, tid);

            assertEquals(organiser.leggTilResultatTilRace(race, petter, tid),race.getResultatMap());
    }

}
