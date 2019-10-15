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

    public Arrangement opprettArrangement(String arrangementNavn,String arrangementBeskrivelse, LocalDateTime arrangementStartDate, LocalDateTime arrangementSluttDate, String arrangementLokasjon) {

        Arrangement temp = new Arrangement(arrangementNavn,arrangementBeskrivelse,arrangementStartDate,arrangementSluttDate,arrangementLokasjon,this);
        addArrangement(temp);
        return temp;
    }

    public Race addRace(Arrangement arrangementSentMed, Race race) {
        arrangementSentMed.getRaceList().add(race);
        return arrangementSentMed.getRaceList().get(arrangementSentMed.getRaceList().size()-1);

    }

    public HashMap leggTilResultatTilRace(Race race, Deltager deltager, LocalDateTime tid) {
        race.getResultatMap().put(deltager, tid);

        HashMap<Deltager, LocalDateTime> hashMapsomSkalRetur;
        hashMapsomSkalRetur=race.getResultatMap();
        return hashMapsomSkalRetur;

    }

    public ArrayList<Arrangement> getArrangementListe() {
        return arrangementListe;
    }

    public void setArrangementListe(ArrayList<Arrangement> arrangementListe) {
        this.arrangementListe = arrangementListe;
    }



}
