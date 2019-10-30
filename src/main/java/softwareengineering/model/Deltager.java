package softwareengineering.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Deltager extends Bruker implements Serializable {
    private String fornavn;
    private String etternavn;
    private ArrayList<Race> races = new ArrayList<>();
    private ArrayList<Arrangement> arrangementListe = new ArrayList<>();


    private HashMap<Race, LocalDateTime> resultatMap = new HashMap<>();

    public Deltager(String email, String password, String navn_f, String navn_e) {
        super(email, password, (navn_f + " " + navn_e));
        fornavn = navn_f;
        etternavn = navn_e;
    }

    public void joinArrangement(Arrangement arrangement) {
        arrangement.getDeltagerList().add(this);
        this.getArrangementListe().add(arrangement);
    }

    public ArrayList<Arrangement> getArrangementListe() {
        return arrangementListe;
    }

    public void setArrangementListe(ArrayList<Arrangement> arrangementListe) {
        this.arrangementListe = arrangementListe;
    }


    public void joinRace(Race race) {
        if (!race.getDeltagere().contains(this)) {
            race.getDeltagere().add(this);
            races.add(race);
        }
    }

    public ArrayList<Race> getRaces() {
        return races;
    }


    public String getNavn_f() {
        return fornavn;
    }

    public String getNavn_e() {
        return etternavn;
    }

    public HashMap<Race, LocalDateTime> getResultatMap() {
        return resultatMap;
    }

/*    public ArrayList<HashMap> hentResultateneForMineRace() {
        ArrayList<HashMap> listeMedResultater = new ArrayList<>();
        for(Arrangement arrangement : this.getArrangementListe()){
            for(Race race : arrangement.getRaceList()){
                listeMedResultater.add(race.getResultatMap());
            }
        }
        return listeMedResultater;
    }*/


}
