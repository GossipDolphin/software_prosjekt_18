package softwareengineering.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Deltager extends Bruker implements Serializable {
    private String fornavn;
    private String etternavn;

    private ArrayList<Arrangement> arrangementListe = new ArrayList<>();

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


    public void joinRace(Race race) { // har tatt vekk første parameter: Arrangement
        /*
        for (Race racet : arrangement.getRaceList()){
            if (racet.equals(race)){
                race.getDeltagere().add(this);
            }
        }
        */
        race.getDeltagere().add(this);
        //arrangement.updateDeltagerList();
    }


    /* Denne metoden gjør det samme som joinRace(Race race), og er der kun for de som av gammel vane trenger å skrive inn arrangementet i tillegg til racet.
        Den bruker ikke arrangement-parameteret til noe, og hele metoden kan fjernes så fort alle vender seg til å kun bruke racet som argument.
     */
    public void joinRace(Arrangement arrangement, Race race) {
        race.getDeltagere().add(this);
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

    public ArrayList<HashMap> hentResultateneForMineRace() {
        ArrayList<HashMap> listeMedResultater = new ArrayList<>();
        for(Arrangement arrangement : this.getArrangementListe()){
            for(Race race : arrangement.getRaceList()){
                listeMedResultater.add(race.getResultatMap());
            }
        }
        return listeMedResultater;
    }


}
