import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime randomtid = LocalDateTime.parse("2019-09-09 10:30", formatter);


        Organiser Ola = new Organiser("Ola@hotmail.com", "admin", "Ola", "Normann", new ArrayList<>());
        Arrangement HelseArrangement = Ola.opprettArrangement("Helse arrangement","The dankest race of all time", randomtid, randomtid, "Halden", Ola, new ArrayList<>(), new ArrayList<>());
        Ola.leggTilArrangementIListen(HelseArrangement);
        Race race1 = new Race("ungdom 05 løp1" ,"raceracerace", randomtid, randomtid, new ArrayList<>());
        Ola.leggTilRaceIArrangement(HelseArrangement, race1);
    }
}
