import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Test
public class OrganiserTest {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private Organiser organiser = new Organiser("a", "a", "a");
    private String randomTid = "2019-09-09 10:30";
    LocalDateTime tid = LocalDateTime.parse(randomTid, formatter);
    private Arrangement arrangement = new Arrangement("KekLøpForAlle","dankestrace", LocalDateTime.parse(randomTid, formatter), LocalDateTime.parse(randomTid, formatter), "Halden", organiser);
    private ArrayList<Race> racelist = new ArrayList<>();
    private ArrayList<Deltager> listeMedDeltagere = new ArrayList<>();

    @Test
    public void opprett_arrangement() {
        assertEquals(organiser.opprettArrangement("KekLøpForAlle","dankestrace", LocalDateTime.parse(randomTid, formatter), LocalDateTime.parse(randomTid, formatter), "Halden").toString(), arrangement.toString());
    }

    @Test
    public void test_legg_til_arrangement_i_listen() {
        assertEquals(organiser.leggTilArrangementIListen(arrangement).toString(), organiser.getArrangementArrayList().toString());
    }

    @Test
    public void test_legg_til_race_i_arrangement() {
        Arrangement arrangement = organiser.opprettArrangement("KekLøpForAlle","dankestrace", LocalDateTime.parse(randomTid, formatter), LocalDateTime.parse(randomTid, formatter), "Halden");
        organiser.leggTilArrangementIListen(arrangement);
        Race race = new Race("race number one","raceracerace", LocalDateTime.now(), LocalDateTime.now());

            assertEquals(race.toString() ,organiser.leggTilRaceIArrangement(arrangement, race).toString());
    }


    @Test
    public void opprett_resultater_for_race(){
        Deltager konrad = new Deltager("konrad@gmail.com","admin", "Konrad", "Konradson");
        Deltager petter = new Deltager("konrad@gmail.com","admin", "Petter", "Petterson");
        Arrangement arrangement = organiser.opprettArrangement("KekLøpForAlle","racelist", tid, tid, "Halden");
        Race race = new Race("testrace","Løper for test", tid, tid);
        arrangement.getRaceList().add(race);
        Resultat resultat1 = new Resultat(tid, konrad);
        Resultat resultat2 = new Resultat(tid, petter);

        assertEquals("[2019-09-09T10:30 Konrad Konradson]", organiser.opprettResultatForRace(race,resultat1).toString());
        assertEquals("[2019-09-09T10:30 Konrad Konradson, 2019-09-09T10:30 Petter Petterson]", organiser.opprettResultatForRace(race,resultat2).toString());
    }

}
