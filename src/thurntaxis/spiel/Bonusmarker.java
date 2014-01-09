package thurntaxis.spiel;

/**
 * Klasse um ein Bonusmarker zu erstellen. Ein Bonusmarker besitzt nur eine Punktzahl.
 */
public class Bonusmarker {

    private int punkte;

    public Bonusmarker(int punkte) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bonusmarker)) return false;

        Bonusmarker that = (Bonusmarker) o;

        if (punkte != that.punkte) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return punkte;
    }
}
