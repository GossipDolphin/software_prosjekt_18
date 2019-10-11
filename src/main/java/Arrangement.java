import java.time.LocalDateTime;
import java.util.ArrayList;

public class Arrangement {

    private String arrangementNavn;
    private LocalDateTime arrangementStartDate;
    private LocalDateTime arrangementSluttDate;
    private String arrangementLokasjon;
    private Organiser organiser;
    private ArrayList<Race> raceList;
    private ArrayList<Deltager> listeMedDeltagere;

    Arrangement(String arrangementNavn, LocalDateTime arrangementStartDate, LocalDateTime arrangementSluttDate, String arrangementLokasjon, Organiser organiser, ArrayList<Race> raceList, ArrayList<Deltager> listeMedDeltagere) {
        this.arrangementNavn = arrangementNavn;
        this.arrangementStartDate = arrangementStartDate;
        this.arrangementSluttDate = arrangementSluttDate;
        this.arrangementLokasjon = arrangementLokasjon;
        this.organiser = organiser;
        this.raceList = raceList;
        this.listeMedDeltagere = listeMedDeltagere;
    }

    @Override
    public String toString(){
        return arrangementNavn + "\n" + arrangementStartDate + "\n" + arrangementSluttDate + "\n" + arrangementLokasjon + "\n" + organiser.toString() + "\n" + raceList.toString();
    }

    public String getArrangementNavn() {
        return arrangementNavn;
    }

    public void setArrangementNavn(String arrangementNavn) {
        this.arrangementNavn = arrangementNavn;
    }

    public LocalDateTime getArrangementStartDate() {
        return arrangementStartDate;
    }

    public void setArrangementStartDate(LocalDateTime arrangementStartDate) {
        this.arrangementStartDate = arrangementStartDate;
    }

    public LocalDateTime getArrangementSluttDate() {
        return arrangementSluttDate;
    }

    public void setArrangementSluttDate(LocalDateTime arrangementSluttDate) {
        this.arrangementSluttDate = arrangementSluttDate;
    }

    public String getArrangementLokasjon() {
        return arrangementLokasjon;
    }

    public void setArrangementLokasjon(String arrangementLokasjon) {
        this.arrangementLokasjon = arrangementLokasjon;
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

    public ArrayList<Deltager> getListeMedDeltagere() {
        return listeMedDeltagere;
    }

    public void setListeMedDeltagere(ArrayList<Deltager> listeMedDeltagere) {
        this.listeMedDeltagere = listeMedDeltagere;
    }
}
