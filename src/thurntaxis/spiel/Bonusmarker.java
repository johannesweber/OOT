package thurntaxis.spiel;

/**
 * Klasse um ein Bonusmarker zu erstellen. Ein Bonusmarker besitzt nur eine Punktzahl.
 */
public class Bonusmarker {

    private int punkte;

    Bonusmarker(int punkte) {
        this.punkte = punkte;
    }

    /**
     *
     * @return die anzahl der punkte
     */
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
