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
    private Arrangement arrangement = new Arrangement("KekLøpForAlle", LocalDateTime.parse(randomTid, formatter), LocalDateTime.parse(randomTid, formatter), "Halden", organiser, new ArrayList<>());

    @Test
    public void opprett_arrangement() {
        ArrayList<Race> racelist = new ArrayList<>();
        assertEquals(organiser.opprettArrangement("KekLøpForAlle", LocalDateTime.parse(randomTid, formatter), LocalDateTime.parse(randomTid, formatter), "Halden", organiser, racelist).toString(), arrangement.toString());
    }

    @Test
    public void test_legg_til_arrangement_i_listen() {
        assertEquals(organiser.leggTilArrangementIListen(arrangement).toString(), organiser.getArrangementArrayList().toString());
    }

    @Test
    public void test_legg_til_race_i_arrangement() {
        ArrayList<Race> racelist = new ArrayList<>();
        Arrangement arrangement = organiser.opprettArrangement("KekLøpForAlle", LocalDateTime.parse(randomTid, formatter), LocalDateTime.parse(randomTid, formatter), "Halden", organiser, racelist);
        organiser.leggTilArrangementIListen(arrangement);
        Race race = new Race("race number one", LocalDateTime.now(), LocalDateTime.now());
        assertEquals(race.toString() ,organiser.leggTilRaceIArrangement(arrangement, race).toString());
    }

}
