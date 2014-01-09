package thurntaxis.spieler;


/**
 * Klasse zum erstellen eines hauses. jede haus besitzt eine Spielerfarbe und jedes haus gibt oder nimmt ein
 * punkt.
 */
public class Haus {

    private Spielerfarbe farbe;
    private int punkte;

    public Haus(Spielerfarbe farbe){
        this.farbe = farbe;
        this.punkte = 1;
    }

    public Spielerfarbe getFarbe() {
        return this.farbe;
    }

    public int getPunkte(){
        return this.punkte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Haus)) return false;

        Haus haus = (Haus) o;

        if (punkte != haus.punkte) return false;
        if (farbe != haus.farbe) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = farbe != null ? farbe.hashCode() : 0;
        result = 31 * result + punkte;
        return result;
    }
}
