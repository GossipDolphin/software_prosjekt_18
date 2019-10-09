import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime randomtid = LocalDateTime.parse("2019-09-09 10:30", formatter);


        Organiser Ola = new Organiser("Ola@hotmail.com", "admin", "Ola", "Normann", new ArrayList<>());
        Arrangement HelseArrangement = Ola.opprettArrangement("Helse arrangement", randomtid, randomtid, "Halden", Ola, new ArrayList<>());
        Ola.leggTilArrangementIListen(HelseArrangement);
        Race race1 = new Race("ungdom 05 løp1" , randomtid, randomtid);
        Ola.leggTilRaceIArrangement(HelseArrangement, race1);

        System.out.println(Ola.getArrangementArrayList().toString());
    }
}
