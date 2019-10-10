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
    private Organiser organiser = new Organiser("a", "a", "a", "a", new ArrayList<>());
    private ArrayList<Race> racelist = new ArrayList<>();
    private ArrayList<Deltager> listeMedDeltagere = new ArrayList<>();
    private Arrangement arrangement = new Arrangement("MLG dankløp", tid, tid, "Halden", organiser, racelist, listeMedDeltagere);
    private Deltager Kalle = new Deltager("Kalle@hotmail.com", "admin", "Kalle", "Kalleson");

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

}
