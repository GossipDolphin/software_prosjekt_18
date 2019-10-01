import java.time.LocalDateTime;
import java.util.ArrayList;

public class Arrangement {

    public String arrangementNavn;
    public LocalDateTime arrangementStartDate;
    public LocalDateTime arrangementSluttDate;
    public String arrangementLokasjon;
    public Organiser organiser;
    public ArrayList<Race> raceList;

    public Arrangement(String arrangementNavn, LocalDateTime arrangementStartDate, LocalDateTime arrangementSluttDate, String arrangementLokasjon, Organiser organiser, ArrayList<Race> raceList) {
        this.arrangementNavn = arrangementNavn;
        this.arrangementStartDate = arrangementStartDate;
        this.arrangementSluttDate = arrangementSluttDate;
        this.arrangementLokasjon = arrangementLokasjon;
        this.organiser = organiser;
        this.raceList = raceList;
    }

    @Override
    public String toString(){
        return arrangementNavn + "\n" + arrangementStartDate + "\n" + arrangementSluttDate + "\n" + arrangementLokasjon + "\n" + organiser.toString() + "\n" + raceList.toString();
    }
}
