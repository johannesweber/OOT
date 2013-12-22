package thurntaxis.bonus;

/**
 * Created by Johannes on 21.12.13.
 */
public class alleLaenderBesetztBonus extends Bonusmarker {

    private static int punkte = 6;

    private alleLaenderBesetztBonus() {
        this.punkte--;
        if (this.punkte < 3) {
            this.punkte = 0;
        }
    }

    @Override
    public String toString() {
        return "alleLaenderBesetztBonus{" +
                "punkte=" + this.punkte +
                '}';
    }
}
