import java.time.LocalDateTime;
import java.util.ArrayList;

public class Race {
    private String raceNavn;
    private LocalDateTime raceStart;
    private LocalDateTime raceSlutt;
    private ArrayList<Deltager> deltagere = new ArrayList<>();
    private Resultat resultat;

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

    public ArrayList<Deltager> getDeltagere() {
        return deltagere;
    }

    public void setDeltagere(ArrayList<Deltager> deltagere) {
        this.deltagere = deltagere;
    }

    public Resultat getResultat() {
        return resultat;
    }

    public void setResultat(Resultat resultat) {
        this.resultat = resultat;
    }

}
