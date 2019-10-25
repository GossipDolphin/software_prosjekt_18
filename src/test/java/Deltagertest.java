

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
    private Race race = new Race("Kan du løpe fortere en hunden min?","dankestrace", tid, tid,arrangement);


    @Test
    public void legg_meg_til_i_arragement(){
        Kalle.joinArrangement(arrangement);
        assertTrue(arrangement.getDeltagerList().contains(Kalle));
        assertTrue(Kalle.getArrangementListe().contains(arrangement));
    }

    @Test
    public void meld_meg_paa_race_i_arrangement(){
        arrangement.getRaceList().add(race);
        Kalle.joinRace(race);
        assertTrue(race.getDeltagere().contains(Kalle));
    }

    @Test
    public void hent_de_race_jeg_er_med_i(){
        Deltager petter = new Deltager("Petter@hotmail.com", "admin", "Petter", "Petterson");
        Race race1 = new Race("race1 for the stuff","dankestrace",tid,tid,arrangement);
        Race race2 = new Race("race2 for the stuff","dankestrace",tid,tid,arrangement);
        Race race3 = new Race("race3 for the stuff","dankestrace",tid,tid,arrangement);
        Arrangement arrangement2 = new Arrangement("MLG dankløp","dankestrace", tid, tid, "Halden", organiser);

        //Legger til et race i listen til arrangementet og melder petter på racet
        arrangement.getRaceList().add(race1);
        petter.joinArrangement(arrangement);
        petter.joinRace(race1);
            assertEquals(arrangement.getRaceList().toString(), petter.hentMineRace().toString());

        //Legger til ENDA et race i listen til arrangementet og melder petter på racet
        arrangement.getRaceList().add(race2);
        petter.joinRace(race2);
            assertEquals(arrangement.getRaceList().toString(), petter.hentMineRace().toString());

        //melder petter på et annet arrangement og legger til petter i et race i det nye arrangementet
        arrangement2.getRaceList().add(race3);
        petter.joinRace(race3);
        // legger til det nye racet i listen til det forrige arrangementet for å få listen til å inneholde alle tre race
        arrangement.getRaceList().add(arrangement2.getRaceList().get(0));
        //sjekker så at petter får ut alle tre race og at det er racene som ligger i den nye listen
            assertEquals(arrangement.getRaceList().toString(), petter.hentMineRace().toString());
    }

    private Race race1 = new Race("løpløp", "test av løp", tid,tid,arrangement2);
    private Race race2 = new Race("løpløp2", "test av løp2", tid,tid,arrangement2);
    private Deltager petter = new Deltager("Test@gamil.com", "admin1", "petter", "Normann");

    @Test
    public void hent_alle_resultater_til_race_jeg_er_med_i(){
        //Organiser organiser1 = new Organiser("test@gmail.com", "admin", "konrad");

        /*
        organiser.addArrangement(arrangement2);
        organiser.addRace(arrangement2, race);
        organiser.addRace(arrangement2, race2);
        */

     //   petter.joinArrangement(arrangement2);
        petter.joinRace(race1);
        petter.joinRace(race2);

        organiser.leggTilResultatTilRace(race, petter, tid);
        organiser.leggTilResultatTilRace(race2, petter, tid);
        HashMap<Race, LocalDateTime> expectedMap = new HashMap<>();
        expectedMap.put(race, tid);
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
}
