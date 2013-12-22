package thurntaxis.spielbrett;

import thurntaxis.bonus.*;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Johannes on 21.12.13.
 */
public class Spielbrett {

    private LinkedList<Land> laender;
    private String name;
    private Auslagestapel auslagestapel;

    private Stack<AlleLaenderBesetztBonus> alleLaenderBesetztBoni;
    private Stack<RoutenlaengeBonus> laengeSiebenBoni;
    private Stack<RoutenlaengeBonus> laengeSechsBoni;
    private Stack<RoutenlaengeBonus> laengeFuenfBoni;

    public Spielbrett() {
        this.name = "Thurn & Taxis: Das Brettspiel";
        this.laender = new LinkedList<Land>();
        this.auslagestapel = new Auslagestapel();
        this.alleLaenderBesetztBoni = new Stack<AlleLaenderBesetztBonus>();
        this.laengeSiebenBoni = new Stack<RoutenlaengeBonus>();
        this.laengeSechsBoni = new Stack<RoutenlaengeBonus>();
        this.laengeFuenfBoni = new Stack<RoutenlaengeBonus>();
        this.laenderFuellen();
        this.boniFuellen();
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
        this.alleLaenderBesetztBoniFuellen();
        this.laengeFuenfBoniFuellen();
        this.laengeSechsBoniFuellen();
        this.laengeSiebenBoniFuellen();
    }

    private void alleLaenderBesetztBoniFuellen(){
        this.alleLaenderBesetztBoni.add(new AlleLaenderBesetztBonus(3));
        this.alleLaenderBesetztBoni.add(new AlleLaenderBesetztBonus(4));
        this.alleLaenderBesetztBoni.add(new AlleLaenderBesetztBonus(5));
        this.alleLaenderBesetztBoni.add(new AlleLaenderBesetztBonus(6));
    }

    private void laengeSiebenBoniFuellen(){
        this.laengeSiebenBoni.add(new RoutenlaengeBonus(7,1));
        this.laengeSiebenBoni.add(new RoutenlaengeBonus(7,2));
        this.laengeSiebenBoni.add(new RoutenlaengeBonus(7,3));
        this.laengeSiebenBoni.add(new RoutenlaengeBonus(7,4));
    }

    private void laengeSechsBoniFuellen(){
        this.laengeSechsBoni.add(new RoutenlaengeBonus(6,1));
        this.laengeSechsBoni.add(new RoutenlaengeBonus(6,2));
        this.laengeSechsBoni.add(new RoutenlaengeBonus(6,3));
    }

    private void laengeFuenfBoniFuellen(){
        this.laengeFuenfBoni.add(new RoutenlaengeBonus(5,1));
        this.laengeFuenfBoni.add(new RoutenlaengeBonus(5,2));
    }

    @Override
    public String toString() {
        return "Spielbrett{" +
                "laender=" + this.laender +
                '}';
    }
}
