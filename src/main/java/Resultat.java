import java.time.LocalDateTime;

public class Resultat {

    private LocalDateTime tidAnnkommetMaal;
    private Deltager deltager;

    public Resultat(LocalDateTime tidAnnkommetMaal, Deltager deltager){
        this.tidAnnkommetMaal = tidAnnkommetMaal;
        this.deltager = deltager;
    }

    public LocalDateTime getTidAnnkommetMaal() {
        return tidAnnkommetMaal;
    }

    public void setTidAnnkommetMaal(LocalDateTime tidAnnkommetMaal) {
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
