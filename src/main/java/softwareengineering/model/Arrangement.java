package softwareengineering.model;

import softwareengineering.utilities.GoogleMapsApi;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Arrangement implements Serializable {
    public static List<Arrangement> alleArrangement = new ArrayList<>();
    public static int idTeller = 0;
    GoogleMapsApi api = new GoogleMapsApi();
    private int id;

    private String navn;
    private String beskrivelse;
    private LocalDateTime startDate;
    private LocalDateTime sluttDate;
    private String lokasjon;
    private Organiser organiser;
    private ArrayList<Race> raceList = new ArrayList<>();
    private ArrayList<Deltager> deltagerList = new ArrayList<>();
    private String mapsUrl;

    public Arrangement(String navn, String beskrivelse, LocalDateTime startDate, LocalDateTime sluttDate, String lokasjon, Organiser organiser) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.startDate = startDate;
        this.sluttDate = sluttDate;
        this.lokasjon = lokasjon;
        this.organiser = organiser;
        this.mapsUrl = api.getUrl(lokasjon);
        System.out.println(mapsUrl);
        id = idTeller++;
        alleArrangement.add(this);
        organiser.getArrangementListe().add(this);

    }

    @Override
    public String toString() {
        return navn + "\n" + startDate + "\n" + sluttDate + "\n" + lokasjon + "\n" + organiser.toString() + "\n" + raceList.toString();
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDateTime getArrangementStartDate() {
        return startDate;
    }

    public void setArrangementStartDate(LocalDateTime arrangementStartDate) {
        this.startDate = arrangementStartDate;
    }

    public LocalDateTime getSluttDate() {
        return sluttDate;
    }

    public void setSluttDate(LocalDateTime sluttDate) {
        this.sluttDate = sluttDate;
    }

    public String getLokasjon() {
        return lokasjon;
    }

    public void setLokasjon(String lokasjon) {
        this.lokasjon = lokasjon;
    }

    public Organiser getOrganiser() {
        return organiser;
    }

    public void setOrganiser(Organiser organiser) {
        this.organiser = organiser;
    }

    public ArrayList<Race> getRaceList() {
        return raceList;
    }

    public void setRaceList(ArrayList<Race> raceList) {
        this.raceList = raceList;
    }

    public ArrayList<Deltager> getDeltagerList() {
        updateDeltagerList();
        return deltagerList;
    }

    public void setDeltagerList(ArrayList<Deltager> deltagerList) {
        this.deltagerList = deltagerList;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public static List<Arrangement> getAlleArrangement() {
        return alleArrangement;
    }

    public static int getIdTeller() {
        return idTeller;
    }

    public int getId() {
        return id;
    }

    public static Arrangement getArrangementById(int id) {
        Arrangement temp = null;
        for (int i = 0; i < alleArrangement.size(); i++) {
            if (alleArrangement.get(i).getId() == id)
                temp = alleArrangement.get(i);
        }
        return temp;
    }

    public String getMapsUrl() {
        return mapsUrl;
    }

    public void updateDeltagerList() {
        for (Race races : raceList) {
            for (Deltager deltagere : races.getDeltagere()) {
                if (!deltagerList.contains(deltagere)) {
                    deltagerList.add(deltagere);
                }
            }
        }
    }
}
