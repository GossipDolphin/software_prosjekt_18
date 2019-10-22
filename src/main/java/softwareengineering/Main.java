package softwareengineering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import softwareengineering.model.Arrangement;
import softwareengineering.model.Deltager;
import softwareengineering.model.Organiser;
import softwareengineering.model.Race;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime randomtid = LocalDateTime.parse("2019-09-09 10:30", formatter);

        Organiser Ola = new Organiser("Ola@hotmail.com", "admin", "Halden skiklubb");
        Deltager petter = new Deltager("petter@gmail.com", "admin","Petter", "Petterson");
        Arrangement HelseArrangement = Ola.opprettArrangement("Helse arrangement","dankestrace", randomtid, randomtid, "BRA Veien 6b, 1783 Halden");
        Arrangement skiLoep = Ola.opprettArrangement("Halden Skirenn", "Langrenn",randomtid,randomtid,"Walkers gate 4, 1771 Halden");
        Race race1 = new Race("ungdom 05 løp1" ,"raceracerace", randomtid, randomtid, HelseArrangement);
        Race race2 = new Race("ungdom 05 løp2" ,"raceracerace", randomtid, randomtid, HelseArrangement);
        Race race3 = new Race("barneskiren 05 løp2" ,"Petter Northug knuser alle kidza", randomtid, randomtid, skiLoep);
        Ola.addRace(HelseArrangement, race1);
        Ola.addRace(HelseArrangement, race2);
        Ola.addRace(skiLoep, race3);

        petter.joinArrangement(HelseArrangement);
        petter.joinRace(HelseArrangement, race1);

        SpringApplication.run(Main.class);
    }
}
