package thurntaxis.spieler;


/**
 * Created by Johannes on 21.12.13.
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
