import java.time.LocalDateTime;
import java.util.ArrayList;

public class Organiser extends Bruker{

    private ArrayList<Arrangement> arrangementArrayList;

    Organiser(String email, String password, String navn_f, String navn_e, ArrayList<Arrangement> arrangementArrayList) {
        super(email, password, navn_f, navn_e);
        this.arrangementArrayList=arrangementArrayList;
    }

    public ArrayList<Arrangement> leggTilArrangementIListen(Arrangement arrangement){

        arrangementArrayList.add(arrangement);
        return arrangementArrayList;
    }

    public Arrangement opprettArrangement(String arrangementNavn,String arrangementBeskrivelse, LocalDateTime arrangementStartDate, LocalDateTime arrangementSluttDate, String arrangementLokasjon, Organiser organiser, ArrayList<Race> raceList,ArrayList<Deltager> deltagerList) {
        return new Arrangement(arrangementNavn,arrangementBeskrivelse,arrangementStartDate,arrangementSluttDate,arrangementLokasjon,organiser,raceList,deltagerList);
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

    public Resultat setResultatForRace(Race race, Resultat resultat) {
        race.setResultat(resultat);
        return race.getResultat();
    }
}
