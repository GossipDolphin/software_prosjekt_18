package softwareengineering.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Organiser extends Bruker implements Serializable {

    private ArrayList<Arrangement> arrangementListe = new ArrayList<>();
    public Organiser(String email, String password, String navn) {
        super(email, password, navn);
    }

    public void addArrangement(Arrangement arrangement){
        arrangementListe.add(arrangement);
    }

    public void leggTilResultatTilRace(Race race, Deltager deltager, LocalDateTime tid) {
        race.getResultatMap().put(deltager, tid);
        deltager.getResultatMap().put(race, tid);
    }

    public ArrayList<Arrangement> getArrangementListe() {
        return arrangementListe;
    }

    public void setArrangementListe(ArrayList<Arrangement> arrangementListe) {
        this.arrangementListe = arrangementListe;
    }
}
