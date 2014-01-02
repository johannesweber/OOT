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

    public int getPunkte(){
        return this.punkte;
    }
}
