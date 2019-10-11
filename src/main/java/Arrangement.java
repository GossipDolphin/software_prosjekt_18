import java.time.LocalDateTime;
import java.util.ArrayList;

public class Arrangement {

    private String arrangementNavn;
    private String arrangementBeskrivelse;
    private LocalDateTime arrangementStartDate;
    private LocalDateTime arrangementSluttDate;
    private String arrangementLokasjon;
    private Organiser organiser;
    private ArrayList<Race> raceList = new ArrayList<>();
    private ArrayList<Deltager> listeMedDeltagere = new ArrayList<>();

    Arrangement(String arrangementNavn,String arrangementBeskrivelse, LocalDateTime arrangementStartDate, LocalDateTime arrangementSluttDate, String arrangementLokasjon, Organiser organiser) {
        this.arrangementNavn = arrangementNavn;
        this.arrangementBeskrivelse = arrangementBeskrivelse;
        this.arrangementStartDate = arrangementStartDate;
        this.arrangementSluttDate = arrangementSluttDate;
        this.arrangementLokasjon = arrangementLokasjon;
        this.organiser = organiser;
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

    public String getArrangementBeskrivelse() {
        return arrangementBeskrivelse;
    }

    public void setArrangementBeskrivelse(String arrangementBeskrivelse) {
        this.arrangementBeskrivelse = arrangementBeskrivelse;
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
