package thurntaxis.bonus;

import thurntaxis.spielbrett.LandEnum;

import java.util.LinkedList;

/**
 * Created by Johannes on 21.12.13.
 */
public class vollstaendigBesetzteLaenderBonus extends Bonusmarker {

    private LinkedList<LandEnum> land;
private static int punkte = 6;
private static boolean gesetzt = false;
private static boolean gesetzt2 = false;
private static boolean gesetzt3 = false;

    public vollstaendigBesetzteLaenderBonus(LandEnum land) {
        this.land = new LinkedList<LandEnum>();
        if (land == LandEnum.BADEN) {
            if (!this.gesetzt) {
                this.punkte = 4;
                this.gesetzt = true;
            }
            this.punkte--;
            if (this.punkte < 0) {
                this.punkte = 0;
            }
        } else {
            this.punkte--;
            if (this.punkte < 2) {
                this.punkte = 0;
            }
        }
        this.land.add(land);
    }

    public vollstaendigBesetzteLaenderBonus(LandEnum land1, LandEnum land2) {
        this.land = new LinkedList<LandEnum>();
        if (land1 == LandEnum.BOEHMEN) {
            if (!this.gesetzt3) {
                this.punkte = 5;
                this.gesetzt3 = true;
            }
            this.punkte--;
            if (this.punkte < 2) {
                this.punkte = 0;
            }
        } else {
            if (!this.gesetzt2) {
                this.punkte = 4;
                this.gesetzt2 = true;
            }
            this.punkte--;
            if (this.punkte < 0) {
                this.punkte = 0;
            }
        }
        this.land.add(land1);
        this.land.add(land2);
    }

    @Override
    public String toString() {
        return "vollstaendigBesetzteLaenderBonus{" +
                "land=" + land +
                "punkte=" + this.punkte +
                '}';
    }
}
