package thurntaxis.bonus;

import thurntaxis.spielbrett.LandEnum;

import java.util.LinkedList;

/**
 * Created by Johannes on 21.12.13.
 */
public class Laenderbonus {

    private LinkedList<LandEnum> land;
    private int punkte;

    public Laenderbonus(LandEnum land, int punkte){
        this.land.add(land);
        this.punkte = punkte;
    }

    public Laenderbonus(LandEnum land1,LandEnum land2, int punkte){
        this.land.add(land1);
        this.land.add(land2);
        this.punkte = punkte;
    }

    public int getPunkte() {
        return punkte;
    }
}
