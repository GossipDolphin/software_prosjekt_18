import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Organiser extends Bruker{

    private ArrayList<Arrangement> arrangementArrayList = new ArrayList<>();

    Organiser(String email, String password, String navn) {
        super(email, password, navn);
    }

    public ArrayList<Arrangement> leggTilArrangementIListen(Arrangement arrangement){

        arrangementArrayList.add(arrangement);
        return arrangementArrayList;
    }

    public Arrangement opprettArrangement(String arrangementNavn,String arrangementBeskrivelse, LocalDateTime arrangementStartDate, LocalDateTime arrangementSluttDate, String arrangementLokasjon) {
        return new Arrangement(arrangementNavn,arrangementBeskrivelse,arrangementStartDate,arrangementSluttDate,arrangementLokasjon,this);
    }

    public Race leggTilRaceIArrangement(Arrangement arrangementSentMed, Race race) {

        Race racet = null;
        for (Arrangement arrangementetIListen : this.arrangementArrayList) {
            if (arrangementetIListen.equals(arrangementSentMed)) {
                arrangementetIListen.getRaceList().add(race);
                racet = race;
            }
        }
        return racet;
    }

    public ArrayList<Arrangement> getArrangementArrayList() {
        return arrangementArrayList;
    }

    public void setArrangementArrayList(ArrayList<Arrangement> arrangementArrayList) {
        this.arrangementArrayList = arrangementArrayList;
    }


    public HashMap leggTilResultatTilRace(Race race, Deltager deltager, LocalDateTime tid) {
        race.getResultatMap().put(deltager, tid);

        HashMap<Deltager, LocalDateTime> hashMapsomSkalRetur;
        hashMapsomSkalRetur=race.getResultatMap();
        return hashMapsomSkalRetur;

    }
}
