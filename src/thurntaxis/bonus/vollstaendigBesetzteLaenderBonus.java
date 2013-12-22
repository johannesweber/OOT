package thurntaxis.bonus;

import thurntaxis.spielbrett.LandEnum;

import java.util.LinkedList;

/**
 * Created by Johannes on 21.12.13.
 */
public class VollstaendigBesetzteLaenderBonus extends Bonusmarker {

    private LinkedList<LandEnum> laender;

    public VollstaendigBesetzteLaenderBonus(LandEnum land1, LandEnum land2, int punkte){
        this.laender = new LinkedList<LandEnum>();
        this.punkte = punkte;
        this.laender.add(land1);
        this.laender.add(land2);
    }

    public VollstaendigBesetzteLaenderBonus(LandEnum land, int punkte){
        this.laender = new LinkedList<LandEnum>();
        this.punkte = punkte;
        this.laender.add(land);
    }
}
