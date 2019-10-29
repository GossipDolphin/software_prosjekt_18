

import org.testng.annotations.Test;
import softwareengineering.model.Arrangement;
import softwareengineering.model.Deltager;
import softwareengineering.model.Organiser;
import softwareengineering.model.Race;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Test
public class Deltagertest {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private String randomTid = "2019-09-09 10:30";
    private LocalDateTime tid = LocalDateTime.parse(randomTid, formatter);
    private Organiser organiser = new Organiser("meOrganiser@gmail.com", "admin", "lordOrganiser");
    private ArrayList<Race> racelist = new ArrayList<>();
    private ArrayList<Deltager> listeMedDeltagere = new ArrayList<>();
    private Arrangement arrangement = new Arrangement("MLG dankløp","dankestrace", tid, tid, "Halden", organiser);
    private Arrangement arrangement2 = new Arrangement("testarrangement", "testing", tid, tid,"halden", organiser);
    private Deltager Kalle = new Deltager("Kalle@hotmail.com", "admin", "Kalle", "Kalleson");


    @Test
    public void legg_meg_til_i_arragement(){
        Kalle.joinArrangement(arrangement);
        assertTrue(arrangement.getDeltagerList().contains(Kalle));
        assertTrue(Kalle.getArrangementListe().contains(arrangement));
    }

    @Test
    public void meld_meg_paa_race_i_arrangement(){
        Race race = new Race("Kan du løpe fortere en hunden min?","dankestrace", tid, tid,arrangement);
//        arrangement.getRaceList().add(race);
        Kalle.joinRace(race);
        assertTrue(race.getDeltagere().contains(Kalle));
    }

    @Test
    public void hent_de_race_jeg_er_med_i(){
        Deltager petter = new Deltager("Petter@hotmail.com", "admin", "Petter", "Petterson");
        Race race1 = new Race("race1 for the stuff","dankestrace",tid,tid,arrangement);


        //Melder petter på racet
        petter.joinRace(race1);
            assertEquals(arrangement.getRaceList(), petter.getRaces());

        //Melder petter på enda et race
        Race race2 = new Race("race2 for the stuff","dankestrace",tid,tid,arrangement);
        petter.joinRace(race2);
            assertEquals(arrangement.getRaceList().toString(), petter.getRaces().toString());

        //Legger til petter i et race i nytt arrangement
        Arrangement arrangement2 = new Arrangement("MLG dankløp","dankestrace", tid, tid, "Halden", organiser);
        Race race3 = new Race("race3 for the stuff","dankestrace",tid,tid,arrangement2);
        petter.joinRace(race3);


        ArrayList<Race> expected = new ArrayList<>();
        expected.add(race1);
        expected.add(race2);
        expected.add(race3);

        //sjekker så at petter får ut alle tre race
            assertEquals(expected, petter.getRaces());
    }

    private Race race1 = new Race("løpløp", "test av løp", tid,tid,arrangement2);
    private Race race2 = new Race("løpløp2", "test av løp2", tid,tid,arrangement2);
    private Deltager petter = new Deltager("Test@gamil.com", "admin1", "petter", "Normann");

    @Test
    public void hent_alle_resultater_til_race_jeg_er_med_i(){

        petter.joinRace(race1);
        petter.joinRace(race2);

        organiser.leggTilResultatTilRace(race1, petter, tid);
        organiser.leggTilResultatTilRace(race2, petter, tid);
        HashMap<Race, LocalDateTime> expectedMap = new HashMap<>();
        expectedMap.put(race1, tid);
        expectedMap.put(race2, tid);

        System.out.println(petter.getResultatMap());

        assertEquals(expectedMap, petter.getResultatMap());
    }

    @Test
    void deltager_blir_paameldt_kun_en_gang() {
        petter.joinRace(race1);
        petter.joinRace(race1);
        ArrayList<Deltager> expectedDeltagere = new ArrayList<>();
        expectedDeltagere.add(petter);

        assertEquals(expectedDeltagere, race1.getDeltagere());
    }

    @Test
    void deltager_sine_paameldte_races_kan_hentes() {
        petter.joinRace(race1);
        petter.joinRace(race2);
        ArrayList<Race> expected = new ArrayList<>();
        expected.add(race1);
        expected.add(race2);

        assertEquals(expected, petter.getRaces());
    }
}
