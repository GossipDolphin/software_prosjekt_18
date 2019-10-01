import java.time.LocalDateTime;
import java.util.ArrayList;

public class Race {
    public String raceNavn;
    public LocalDateTime raceStart;
    public LocalDateTime raceSlutt;
    public ArrayList<Deltagere> deltagere;

    public Race(String raceNavn, LocalDateTime raceStart, LocalDateTime raceSlutt) {
        this.raceNavn = raceNavn;
        this.raceStart = raceStart;
        this.raceSlutt = raceSlutt;
    }

    @Override
    public String toString(){
        return raceNavn + " " + raceStart + " " + raceSlutt;
    }
}
