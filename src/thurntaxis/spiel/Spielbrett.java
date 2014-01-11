package thurntaxis.spiel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @author Gruppe 4 Fragezeichen
 *
 * Eine Klasse um das Spielbrett zu erstellen. Da Spielbrett besitzt Laender, ein Auslagestapel
 * und die drei verschiedenen Bonusmarkern.
 */
public class Spielbrett {

    private LinkedList<Land> laender;
    private Auslagestapel auslagestapel;
    private Stack<Bonusmarker> siegplaettchen;
    private Stack<Bonusmarker> alleLaenderBesetztBoni;
    private Map<Integer, Stack> routenlaengeBoni;
    private Map<LandEnum, Stack> vollstaendigBesetzteLaenderBoni;

    Spielbrett() {
        this.laender = new LinkedList<Land>();
        this.auslagestapel = new Auslagestapel();
        this.siegplaettchen = new Stack<Bonusmarker>();
        siegplaettchen.add(new Bonusmarker(1));
        this.alleLaenderBesetztBoni = new Stack<Bonusmarker>();
        this.vollstaendigBesetzteLaenderBoni = new HashMap<LandEnum, Stack>();
        this.routenlaengeBoni = new HashMap<Integer, Stack>();
        this.laenderFuellen();
        this.boniFuellen();
    }

    public Stack<Bonusmarker> getAlleLaenderBesetztBoni() {
        return this.alleLaenderBesetztBoni;
    }

    public Map<LandEnum, Stack> getVollstaendigBesetzteLaenderBoni() {
        return this.vollstaendigBesetzteLaenderBoni;
    }

    public Map<Integer, Stack> getRoutenlaengeBoni() {
        return this.routenlaengeBoni;
    }

    public Stack<Bonusmarker> getSiegplaettchen() {
        return this.siegplaettchen;
    }

    public LinkedList<Land> getLaender() {
        return this.laender;
    }

    public Auslagestapel getAuslagestapel() {
        return this.auslagestapel;
    }

    /**
     * Mit dieser privaten methoden werden die laender zu dem spielbrett hinzugefuegt. Diese Methode
     * wird nur im Konstruktor eines Spielbretts aufgerufen.
     */
    private void laenderFuellen() {
            for (LandEnum it : LandEnum.values()) {
                this.laender.add(new Land(it));
        }
    }

    /**
     * In dieser Methode werden, mit Hilfe der Methoden rotenlaengeBoniFuellen(),
     * vollstaendigBesetzteLaenderBonusFuellen() und routenlaengeBoniFuellen()
     * die Liste der Bonusmarker gefuellt.
     */
    private void boniFuellen() {
        this.alleLaenderBesetztBoniFuellen();
        this.vollstaendigBesetzteLaenderBonusFuellen();
        this.routenlaengeBoniFuellen();
    }

    private void routenlaengeBoniFuellen() {
        Stack<Bonusmarker> laengeFuenf = new Stack<Bonusmarker>();
        laengeFuenf.add(new Bonusmarker(1));
        laengeFuenf.add(new Bonusmarker(2));
        this.routenlaengeBoni.put(5, laengeFuenf);

        Stack<Bonusmarker> laengeSechs = new Stack<Bonusmarker>();
        laengeSechs.addAll(laengeFuenf);
        laengeSechs.add(new Bonusmarker(3));
        this.routenlaengeBoni.put(6, laengeSechs);

        Stack<Bonusmarker> laengeSieben = new Stack<Bonusmarker>();
        laengeSieben.addAll(laengeSechs);
        laengeSieben.add(new Bonusmarker(4));
        this.routenlaengeBoni.put(7, laengeSieben);
    }

    private void vollstaendigBesetzteLaenderBonusFuellen() {
        Stack<Bonusmarker> punkte1 = new Stack<Bonusmarker>();
        punkte1.add(new Bonusmarker(1));
        punkte1.add(new Bonusmarker(2));
        punkte1.add(new Bonusmarker(3));
        this.vollstaendigBesetzteLaenderBoni.put(LandEnum.SCHWEIZ, punkte1);
        this.vollstaendigBesetzteLaenderBoni.put(LandEnum.WUERTTEMBERG, punkte1);
        this.vollstaendigBesetzteLaenderBoni.put(LandEnum.BADEN, punkte1);

        Stack<Bonusmarker> punkte2 = new Stack<Bonusmarker>();
        punkte2.add(new Bonusmarker(2));
        punkte2.add(new Bonusmarker(3));
        punkte2.add(new Bonusmarker(4));
        this.vollstaendigBesetzteLaenderBoni.put(LandEnum.BOEHMEN, punkte2);

        Stack<Bonusmarker> punkte3 = new Stack<Bonusmarker>();
        punkte3.addAll(punkte2);
        punkte3.add(new Bonusmarker(5));
        this.vollstaendigBesetzteLaenderBoni.put(LandEnum.BAIERN, punkte3);
    }

    private void alleLaenderBesetztBoniFuellen() {
        this.alleLaenderBesetztBoni.add(new Bonusmarker(3));
        this.alleLaenderBesetztBoni.add(new Bonusmarker(4));
        this.alleLaenderBesetztBoni.add(new Bonusmarker(5));
        this.alleLaenderBesetztBoni.add(new Bonusmarker(6));
    }

    @Override
    public String toString() {
        return "HauptschirmGUI{" +
                "laender=" + this.laender +
                '}';
    }
}
