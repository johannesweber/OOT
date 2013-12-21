package thurntaxis.bonus;

import thurntaxis.spielbrett.LandEnum;

/**
 * Created by Johannes on 21.12.13.
 */
public abstract class Bonusmarker {

    private int bonuspunkte;
    private LandEnum land;

    protected Bonusmarker(int bonuspunkte, LandEnum land) {
        this.bonuspunkte = bonuspunkte;
        this.land = land;
    }

    public abstract void setPunkte();
}
