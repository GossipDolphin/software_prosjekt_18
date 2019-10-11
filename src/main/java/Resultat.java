import java.time.LocalDate;

public class Resultat {

    private LocalDate tidAnnkommetMaal;
    private Deltager deltager;

    public Resultat(LocalDate tidAnnkommetMaal, Deltager deltager){
        this.tidAnnkommetMaal = tidAnnkommetMaal;
        this.deltager = deltager;
    }

    public LocalDate getTidAnnkommetMaal() {
        return tidAnnkommetMaal;
    }

    public void setTidAnnkommetMaal(LocalDate tidAnnkommetMaal) {
        this.tidAnnkommetMaal = tidAnnkommetMaal;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public void setDeltager(Deltager deltager) {
        this.deltager = deltager;
    }

    @Override
    public String toString(){
        return tidAnnkommetMaal + " " + deltager.getNavn_f() + " " + deltager.getNavn_e();
    }
}
