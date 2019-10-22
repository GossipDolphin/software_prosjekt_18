package softwareengineering.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private String randomTid = "2020-12-09 08:30";
    private LocalDateTime dummyTid = LocalDateTime.parse(randomTid, formatter);

    private Organiser dummyOrganiser = new Organiser("post@tufte.no", "HeiaTufte", "Tufte IL");
    private Arrangement dummyarrangement = new Arrangement("Tuftes årlige joggekonkurranse", "Velkommen til vår årlige joggekonkurranse. Vi håper at dette blir året vi får en vinner som klarer å jogge frem til målstreken.", dummyTid, dummyTid, "Østensjøvannet", dummyOrganiser);
    Race dummyRace = new Race("Joggekonkurranse", "Deltakerne jogger så fort og langt de kan i samme retning", dummyTid, dummyTid, dummyarrangement);

    @Test
    void getRaceById() {


    }
}