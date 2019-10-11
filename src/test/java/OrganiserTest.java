import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Test
public class OrganiserTest {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private Organiser organiser = new Organiser("a", "a", "a", "a", new ArrayList<>());
    private String randomTid = "2019-09-09 10:30";
    private LocalDateTime tid = LocalDateTime.parse(randomTid, formatter);
    private Arrangement arrangement = new Arrangement("KekLøpForAlle", LocalDateTime.parse(randomTid, formatter), LocalDateTime.parse(randomTid, formatter), "Halden", organiser, new ArrayList<>());
    private ArrayList<Race> racelist = new ArrayList<>();
    private ArrayList<Deltager> listeMedDeltagere = new ArrayList<>();

    @Test
    public void opprett_arrangement() {

        assertEquals(organiser.opprettArrangement("KekLøpForAlle", LocalDateTime.parse(randomTid, formatter), LocalDateTime.parse(randomTid, formatter), "Halden", organiser, racelist).toString(), arrangement.toString());
    }

    @Test
    public void test_legg_til_arrangement_i_listen() {
        assertEquals(organiser.leggTilArrangementIListen(arrangement).toString(), organiser.getArrangementArrayList().toString());
    }

    @Test
    public void test_legg_til_race_i_arrangement() {
        Arrangement arrangement = organiser.opprettArrangement("KekLøpForAlle", LocalDateTime.parse(randomTid, formatter), LocalDateTime.parse(randomTid, formatter), "Halden", organiser, racelist);
        organiser.leggTilArrangementIListen(arrangement);
        Race race = new Race("race number one", LocalDateTime.now(), LocalDateTime.now());
        assertEquals(race.toString() ,organiser.leggTilRaceIArrangement(arrangement, race).toString());
    }

    @Test
    public void opprett_resultat_for_race(){
        Arrangement arrangement = organiser.opprettArrangement("Kek Kekersen Sitt Arrangement", LocalDateTime.parse(randomTid, formatter), LocalDateTime.parse(randomTid, formatter), "Halden", organiser, racelist);
        Race race = new Race("Kek løp for alle", tid, tid);
        organiser.leggTilRaceIArrangement(arrangement, race);
        Deltager deltager = new Deltager("konrad@gmail.com", "admin", "Konrad", "Konradson");
        Resultat resultat = new Resultat(tid, deltager);
        race.setResultat(resultat);

        assertEquals(organiser.setResultatForRace(race, resultat).toString(), race.getResultat().toString());
    }

}
