package softwareengineering.model;

import softwareengineering.model.Deltager;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Race implements Serializable {
    private String raceNavn;
    private String raceBeskrivelse;
    private LocalDateTime raceStart;
    private LocalDateTime raceSlutt;
    private ArrayList<Deltager> deltagere = new ArrayList<>();
    private HashMap<Deltager, LocalDateTime> resultatMap = new HashMap<>();

    public Race(String raceNavn, String raceBeskrivelse, LocalDateTime raceStart, LocalDateTime raceSlutt) {
        this.raceNavn = raceNavn;
        this.raceBeskrivelse = raceBeskrivelse;
        this.raceStart = raceStart;
        this.raceSlutt = raceSlutt;
    }

    @Override
    public String toString(){
        return raceNavn + " " + raceStart + " " + raceSlutt;
    }

    public String getRaceNavn() {
        return raceNavn;
    }

    public void setRaceNavn(String raceNavn) {
        this.raceNavn = raceNavn;
    }

    public String getRaceBeskrivelse() {
        return raceBeskrivelse;
    }

    public void setRaceBeskrivelse(String raceBeskrivelse) {
        this.raceBeskrivelse = raceBeskrivelse;
    }

    public LocalDateTime getRaceStart() {
        return raceStart;
    }

    public void setRaceStart(LocalDateTime raceStart) {
        this.raceStart = raceStart;
    }

    public LocalDateTime getRaceSlutt() {
        return raceSlutt;
    }

    public void setRaceSlutt(LocalDateTime raceSlutt) {
        this.raceSlutt = raceSlutt;
    }

    public ArrayList<Deltager> getDeltagere() {
        return deltagere;
    }

    public void setDeltagere(ArrayList<Deltager> deltagere) {
        this.deltagere = deltagere;
    }
    public HashMap<Deltager, LocalDateTime> getResultatMap() {
        return resultatMap;
    }

    public void setResultatMap(HashMap<Deltager, LocalDateTime> resultatMap) {
        this.resultatMap = resultatMap;
    }

}
