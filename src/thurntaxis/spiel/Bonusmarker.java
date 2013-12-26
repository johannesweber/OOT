package thurntaxis.spiel;

/**
 * Created by Johannes on 21.12.13.
 */
public class Bonusmarker {

    private int punkte;

    Bonusmarker(int punkte) {
        this.punkte = punkte;
    }

    public int getPunkte() {
        return punkte;
    }

    @Override
    public String toString() {
        return "Bonusmarker{" +
                "punkte=" + punkte +
                '}';
    }
}
