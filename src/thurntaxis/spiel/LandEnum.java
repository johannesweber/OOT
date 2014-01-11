package thurntaxis.spiel;

/**
 * @author Gruppe 4 Fragezeichen
 *         <p/>
 *         Eine Enumeratons Klasse fuer die 9 Laender.
 */
public enum LandEnum {

    SCHWEIZ(2), TYROL(1), SALZBURG(2), BOEHMEN(2), POLEN(1), BADEN(3), WUERTTEMBERG(2), BAIERN(8), HOHENZOLLERN(1),;

    private int staedte;

    LandEnum(int staedte){
        this.staedte = staedte;
    }

    public int getStaedte() {
        return staedte;
    }
}

