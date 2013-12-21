package thurntaxis.spielbrett;

import thurntaxis.bonus.Laenderbonus;
import thurntaxis.bonus.Routenlaengebonus;
import thurntaxis.bonus.Streckenpostenbonus;

import java.util.LinkedList;

/**
 * Created by Johannes on 21.12.13.
 */
public class Spielbrett {

    private LinkedList<Land> laender;
    private String name;
    private Auslagestapel auslagestapel;
    private LinkedList<Laenderbonus> laenderbonus;
    private LinkedList<Streckenpostenbonus> streckenpostenbonus;
    private LinkedList<Routenlaengebonus> routenlaengebonus;

    public Spielbrett() {
        this.name = "Thurn & Taxis: Das Brettspiel";
        this.laender = new LinkedList<Land>();
        this.auslagestapel = new Auslagestapel();
        //this.laenderbonus = new LinkedList();
        //this.routenlaengebonus = new LinkedList<Routenlaengebonus>();
        //this.streckenpostenbonus = new LinkedList<Streckenpostenbonus>();
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
