package thurntaxis.bonus;

import thurntaxis.spielbrett.LandEnum;
import java.util.LinkedList;

/**
 * Created by Johannes on 21.12.13.
 */
public class Laenderbonus extends Bonusmarker{

    private LinkedList<LandEnum> laender;

    public Laenderbonus(int bonuspunkte, LandEnum land) {
        super(bonuspunkte, land);
        this.laender = new LinkedList<LandEnum>();
    }

    @Override
    public void setPunkte() {

    }
}
