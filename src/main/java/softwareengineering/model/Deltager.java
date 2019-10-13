package softwareengineering.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Deltager extends Bruker implements Serializable {
    private String fornavn;
    private String etternavn;

    private ArrayList<Arrangement> arrangementListe = new ArrayList<>();

    public Deltager(String email, String password, String navn_f, String navn_e) {
        super(email, password, (navn_f + " " + navn_e));
        fornavn = navn_f;
        etternavn = navn_e;
    }



    public Arrangement joinArrangement(Arrangement arrangement) {
        arrangement.getDeltagerList().add(this);
        this.getArrangementListe().add(arrangement);
        return arrangement;
    }

    public ArrayList<Arrangement> getArrangementListe() {
        return arrangementListe;
    }

    public void setArrangementListe(ArrayList<Arrangement> arrangementListe) {
        this.arrangementListe = arrangementListe;
    }


    public Race joinRace(Arrangement arrangement, Race race) {
        Race racetSomSkalReturners = null;
        for (Race racet : arrangement.getRaceList()){
            if (racet.equals(race)){
                race.getDeltagere().add(this);
                racetSomSkalReturners = racet;
            }
        }
        return racetSomSkalReturners;
    }

    public ArrayList<Race> hentMineRace() {
        ArrayList<Race> mineRace = new ArrayList<>();

        for (Arrangement arrangement : getArrangementListe()){
            for (Race race : arrangement.getRaceList()){
                for (Deltager deltager : race.getDeltagere()){
                    if (this.getEmail().equals(deltager.getEmail())){
                        mineRace.add(race);
                    }
                }
            }
        }
        return mineRace;
    }

    public String getNavn_f(){
        return fornavn;
    }
    public String getNavn_e(){
        return etternavn;    }
}
