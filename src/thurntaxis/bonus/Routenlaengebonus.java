package thurntaxis.bonus;

/**
 * Created by Johannes on 21.12.13.
 */
public class RoutenlaengeBonus extends Bonusmarker {

    private int laenge;

    public RoutenlaengeBonus(int laenge, int punkte) {
        this.punkte = punkte;
        this.laenge = laenge;
    }

    public int getLaenge() {
        return laenge;
    }
}
