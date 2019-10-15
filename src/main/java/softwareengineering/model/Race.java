package softwareengineering.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Race implements Serializable {
    public static List<Race> alleRace = new ArrayList<>();
    private String raceNavn;
    private String raceBeskrivelse;
    private LocalDateTime raceStart;
    private LocalDateTime raceSlutt;
    private ArrayList<Deltager> deltagere = new ArrayList<>();
    private HashMap<Deltager, LocalDateTime> resultatMap = new HashMap<>();
    public static int idTeller = 0;
    private int id;

    public Race(String raceNavn, String raceBeskrivelse, LocalDateTime raceStart, LocalDateTime raceSlutt) {
        this.raceNavn = raceNavn;
        this.raceBeskrivelse = raceBeskrivelse;
        this.raceStart = raceStart;
        this.raceSlutt = raceSlutt;
        id = idTeller++;
        alleRace.add(this);
    }

    public static Race getAlleRace(int id){
        Race temp = null;
        for(int i = 0;i<alleRace.size();i++)
        {
            if(alleRace.get(i).getId()==id)
                temp = alleRace.get(i);
        }
        System.out.println();
        return temp;
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

    public static int getIdTeller() {
        return idTeller;
    }

    public static void setIdTeller(int idTeller) {
        Race.idTeller = idTeller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
