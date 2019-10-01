import java.time.LocalDateTime;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        Organiser organiser = new Organiser("mmollevik@hotmail.com", "admin", "Magnus", "Mollevik");
        ArrayList<Race> racelist = new ArrayList<>();

        racelist.add(new Race("kek1", LocalDateTime.now(), LocalDateTime.now()));
        racelist.add(new Race("kek2", LocalDateTime.now(), LocalDateTime.now()));
        racelist.add(new Race("kek3", LocalDateTime.now(), LocalDateTime.now()));

        organiser.leggTilArrangement("KekLøpForAlle", LocalDateTime.now(), LocalDateTime.now(), "Halden", organiser, racelist);
    }
}
