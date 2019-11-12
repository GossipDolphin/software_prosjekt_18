package softwareengineering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import softwareengineering.model.Arrangement;
import softwareengineering.model.Deltager;
import softwareengineering.model.Organiser;
import softwareengineering.model.Race;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws IOException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime randomtid = LocalDateTime.parse("2019-09-09 10:30", formatter);

        Organiser Ola = new Organiser("ola@gmail.com", "test1", "Halden skiklubb");
        Deltager petter = new Deltager("petter@gmail.com", "test2","Petter", "Petterson");
        Arrangement HelseArrangement = new Arrangement("Helse arrangement","Løp til du blir ekstra sliten", randomtid, randomtid, "BRA Veien 6b, 1783 Halden", Ola);
        Arrangement skiLoep = new Arrangement("Halden Skirenn", "Langrenn",randomtid,randomtid,"Walkers gate 4, 1771 Halden", Ola);
        Race race1 = new Race("ungdom 05 løp1" ,"la ungdommen løpe!", randomtid, randomtid, HelseArrangement);
        Race race2 = new Race("ungdom 05 løp2" ,"la ungdommen løpe", randomtid, randomtid, HelseArrangement);
        Race race3 = new Race("barneskiren 05 løp2" ,"Petter Northug knuser alle kidza", randomtid, randomtid, skiLoep);

        petter.joinArrangement(HelseArrangement);
        petter.joinRace(race1);

        SpringApplication.run(Main.class);
        openHomePage();
    }
    private static void openHomePage() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080");
    }
}
