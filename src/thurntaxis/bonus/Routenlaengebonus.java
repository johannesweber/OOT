package thurntaxis.bonus;

/**
 * Created by Johannes on 21.12.13.
 */
public class Routenlaengebonus{

    private int punkte;
    private int laenge;

    public Routenlaengebonus(int laenge,int punkte){
        this.punkte = punkte;
        this.laenge = laenge;
    }

    public int getPunkte() {
        return punkte;
    }
}
