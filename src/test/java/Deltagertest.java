import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Test
public class Deltagertest {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private String randomTid = "2019-09-09 10:30";
    private LocalDateTime tid = LocalDateTime.parse(randomTid, formatter);
    private Organiser organiser = new Organiser("meOrganiser@gmail.com", "admin", "lordOrganiser", "TheFifth", new ArrayList<>());
    private ArrayList<Race> racelist = new ArrayList<>();
    private ArrayList<Deltager> listeMedDeltagere = new ArrayList<>();
    private Arrangement arrangement = new Arrangement("MLG dankløp", tid, tid, "Halden", organiser, racelist, listeMedDeltagere);
    private Deltager Kalle = new Deltager("Kalle@hotmail.com", "admin", "Kalle", "Kalleson", new ArrayList<>());
    private Race race = new Race("Kan du løpe fortere en hunden min?", tid, tid, listeMedDeltagere);


    @Test
    public void legg_meg_til_i_arragement(){
        assertEquals(Kalle.meldMegPaaArangement(arrangement).toString(), arrangement.toString());
    }

    @Test
    public void hent_de_arrangementer_jeg_er_med_i(){
        Kalle.meldMegPaaArangement(arrangement);
        ArrayList<Arrangement> listeMedArrangement = new ArrayList<>();
        listeMedArrangement.add(arrangement);

        assertEquals(Kalle.HentDeArrangementerJegErMedI().toString(), listeMedArrangement.toString());
    }
    @Test
    public void meld_meg_paa_race_i_arrangement(){
        arrangement.getRaceList().add(race);

        assertEquals(Kalle.meldMegPaaRaceIArrangement(arrangement, race).toString(), race.toString());
    }

    @Test
    public void hent_de_race_jeg_er_med_i(){
        Deltager petter = new Deltager("Petter@hotmail.com", "admin", "Petter", "Petterson", new ArrayList<>());
        Race race1 = new Race("race1 for the stuff",tid,tid,new ArrayList<>());
        Race race2 = new Race("race2 for the stuff",tid,tid,new ArrayList<>());
        Race race3 = new Race("race3 for the stuff",tid,tid,new ArrayList<>());
        Arrangement arrangement2 = new Arrangement("MLG dankløp", tid, tid, "Halden", organiser, new ArrayList<>(), new ArrayList<>());

        //Legger til et race i listen til arrangementet og melder petter på racet
        arrangement.getRaceList().add(race1);
        petter.meldMegPaaArangement(arrangement);
        petter.meldMegPaaRaceIArrangement(arrangement, race1);
            assertEquals(arrangement.getRaceList().toString(), petter.hentMineRace().toString());

        //Legger til ENDA et race i listen til arrangementet og melder petter på racet
        arrangement.getRaceList().add(race2);
        petter.meldMegPaaRaceIArrangement(arrangement, race2);
            assertEquals(arrangement.getRaceList().toString(), petter.hentMineRace().toString());

        //melder petter på et annet arrangement og legger til petter i et race i det nye arrangementet
        arrangement2.getRaceList().add(race3);
        petter.meldMegPaaRaceIArrangement(arrangement2, race3);
        // legger til det nye racet i listen til det forrige arrangementet for å få listen til å inneholde alle tre race
        arrangement.getRaceList().add(arrangement2.getRaceList().get(0));
        //sjekker så at petter får ut alle tre race og at det er racene som ligger i den nye listen
            assertEquals(arrangement.getRaceList().toString(), petter.hentMineRace().toString());
    }



}
