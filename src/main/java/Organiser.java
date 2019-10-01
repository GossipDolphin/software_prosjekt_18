import java.time.LocalDateTime;
import java.util.ArrayList;

public class Organiser extends Bruker{


    public Organiser(String email, String password, String navn_f, String navn_e) {
        super(email, password, navn_f, navn_e);
    }

    public Object leggTilArrangement(String arrangementNavn, LocalDateTime arrangementStartDate, LocalDateTime arrangementSluttDate, String arrangementLokasjon, Organiser organiser, ArrayList<Race> raceList){

        Arrangement arrangement = new Arrangement(arrangementNavn, arrangementStartDate, arrangementSluttDate, arrangementLokasjon, organiser, raceList);
        System.out.println(arrangement.toString());
        return arrangement;
    }
}
