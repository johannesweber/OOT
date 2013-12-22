package thurntaxis.bonus;

/**
 * Created by Johannes on 21.12.13.
 */
public class RoutenlaengeBonus extends Bonusmarker {

    private int laenge;
    private static int punkte = 5;
    private static boolean gesetzt = false;
    private static boolean gesetzt2 = false;
    private static boolean gesetzt3 = false;

    public RoutenlaengeBonus(int laenge) {
        this.laenge = laenge;
        if (laenge == 5) {
            if (!this.gesetzt) {
                this.punkte = 3;
                this.gesetzt = true;
            }
        }
        if (laenge == 6) {
            if (!this.gesetzt2) {
                this.punkte = 4;
                this.gesetzt2 = true;
            }
        }
        if (laenge == 7) {
            if (!this.gesetzt3) {
                this.punkte = 4;
                this.gesetzt3 = true;
            }
        }
        this.punkte--;
        if (this.punkte < 0) {
            this.punkte = 0;
        }
    }

    @Override
    public String toString() {
        return "RoutenlaengeBonus{" +
                "laenge=" + this.laenge +
                "punkte=" + this.punkte +
                '}';
    }
}
