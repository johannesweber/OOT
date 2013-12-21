package thurntaxis.spielbrett;

import java.util.LinkedList;

/**
 * Created by Johannes on 21.12.13.
 */
public class Spielbrett {

    private LinkedList<Land> laender;
    private String name;
    private Auslagestapel auslagestapel;

    public Spielbrett() {
        this.name = "Thurn & Taxis: Das Brettspiel";
        this.laender = new LinkedList<Land>();
        this.auslagestapel = new Auslagestapel();
        this.laenderFuellen();
    }

    private void laenderFuellen(){
        for(LandEnum it : LandEnum.values()){
            this.laender.add(new Land(it));
        }
    }

    @Override
    public String toString() {
        return "Spielbrett{" +
                "laender=" + this.laender +
                '}';
    }
}
