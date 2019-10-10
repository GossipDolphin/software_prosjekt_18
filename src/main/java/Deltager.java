import java.util.ArrayList;

public class Deltager extends Bruker{

    private ArrayList<Arrangement> listeMedArrangementer = new ArrayList<>();

    public Deltager(String email, String password, String navn_f, String navn_e) {
        super(email, password, navn_f, navn_e);
    }


    public Arrangement meldMegPaaArangement(Arrangement arrangement) {
        arrangement.getListeMedDeltagere().add(this);
        this.getListeMedArrangementer().add(arrangement);
        return arrangement;
    }

    public ArrayList<Arrangement> HentDeArrangementerJegErMedI() {
        return this.getListeMedArrangementer();
    }

    public ArrayList<Arrangement> getListeMedArrangementer() {
        return listeMedArrangementer;
    }

    public void setListeMedArrangementer(ArrayList<Arrangement> listeMedArrangementer) {
        this.listeMedArrangementer = listeMedArrangementer;
    }


}
