package thurntaxis.spielbrett;

import thurntaxis.bonus.RoutenlaengeBonus;
import thurntaxis.bonus.alleLaenderBesetztBonus;
import thurntaxis.bonus.vollstaendigBesetzteLaenderBonus;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Johannes on 21.12.13.
 */
public class Spielbrett {

    private LinkedList<Land> laender;
    private String name;
    private Auslagestapel auslagestapel;
    private Stack<alleLaenderBesetztBonus> alleLaenderBoni;
    private Stack<vollstaendigBesetzteLaenderBonus> besetzteLaenderboni;
    private Stack<RoutenlaengeBonus> routenlaengeboni;

    public Spielbrett() {
        this.name = "Thurn & Taxis: Das Brettspiel";
        this.laender = new LinkedList<Land>();
        this.auslagestapel = new Auslagestapel();
        this.alleLaenderBoni = new Stack<alleLaenderBesetztBonus>();
        this.besetzteLaenderboni = new Stack<vollstaendigBesetzteLaenderBonus>();
        this.routenlaengeboni = new Stack<RoutenlaengeBonus>();
        this.laenderFuellen();
    }

    public LinkedList<Land> getLaender() {
        return this.laender;
    }

    public Auslagestapel getAuslagestapel() {
        return this.auslagestapel;
    }

    private void laenderFuellen(){
        for(LandEnum it : LandEnum.values()){
            this.laender.add(new Land(it));
        }
    }

    private void boniFuellen(){

    }

    @Override
    public String toString() {
        return "Spielbrett{" +
                "laender=" + this.laender +
                '}';
    }
}
