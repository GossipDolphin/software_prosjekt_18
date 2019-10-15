import java.util.ArrayList;
import java.util.HashMap;

public class Deltager extends Bruker{
    private String fornavn;
    private String etternavn;

    private ArrayList<Arrangement> listeMedArrangementer = new ArrayList<>();

    public Deltager(String email, String password, String navn_f, String navn_e) {
        super(email, password, (navn_f + " " + navn_e));
        fornavn = navn_f;
        etternavn = navn_e;
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


    public Race meldMegPaaRaceIArrangement(Arrangement arrangement, Race race) {
        Race racetSomSkalReturners = null;
        for (Race racet : arrangement.getRaceList()){
            if (racet.equals(race)){
                race.getDeltagere().add(this);
                racetSomSkalReturners = racet;
            }
        }
        return racetSomSkalReturners;
    }

    public ArrayList<Race> hentMineRace() {
        ArrayList<Race> mineRace = new ArrayList<>();

        for (Arrangement arrangement : this.HentDeArrangementerJegErMedI()){
            for (Race race : arrangement.getRaceList()){
                for (Deltager deltager : race.getDeltagere()){
                    if (this.getEmail().equals(deltager.getEmail())){
                        mineRace.add(race);
                    }
                }
            }
        }
        return mineRace;
    }
    public String getNavn_f(){
        return fornavn;
    }
    public String getNavn_e(){
        return etternavn;    }

    public ArrayList<HashMap> hentResultateneForMineRace() {
        ArrayList<HashMap> listeMedResultater = new ArrayList<>();
        for(Arrangement arrangement : this.getListeMedArrangementer()){
            for(Race race : arrangement.getRaceList()){
                listeMedResultater.add(race.getResultatMap());
            }
        }
        return listeMedResultater;
    }
}
