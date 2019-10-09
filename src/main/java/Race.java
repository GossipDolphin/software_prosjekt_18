import java.time.LocalDateTime;
import java.util.ArrayList;

public class Race {
    private String raceNavn;
    private LocalDateTime raceStart;
    private LocalDateTime raceSlutt;
    private ArrayList<Deltagere> deltagere;

    Race(String raceNavn, LocalDateTime raceStart, LocalDateTime raceSlutt) {
        this.raceNavn = raceNavn;
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

    public ArrayList<Deltagere> getDeltagere() {
        return deltagere;
    }

    public void setDeltagere(ArrayList<Deltagere> deltagere) {
        this.deltagere = deltagere;
    }
}
