package thurntaxis.spiel;

import thurntaxis.spieler.Haus;

import java.util.LinkedList;

/**
 * @author Gruppe 4 Fragezeichen
 *         <p/>
 *         Klasse zum erstellen eines stadt objekts. eine stadt besitzt einen name, sie kann beliebig viele haeuser
 *         besitzen und jede stadt hat staedte als nachbarn.
 */
public class Stadt {

    private Spielkarte name;
    private LinkedList<Haus> haeuser;
    private LinkedList<Spielkarte> nachbarn;

    public Stadt(Spielkarte name) {
        this.haeuser = new LinkedList<Haus>();
        this.nachbarn = new LinkedList<Spielkarte>();
        this.name = name;
        this.nachbarnHinzufuegen();
    }

    public Spielkarte getName() {
        return this.name;
    }

    public LandEnum getLand() {
        return this.name.getLand();
    }

    public LinkedList<Haus> getHaeuser() {
        return this.haeuser;
    }

    public LinkedList<Spielkarte> getNachbarn() {
        return this.nachbarn;
    }

    /**
     * diese methode fuegt der stadt ein neues haus hinzu
     *
     * @param haus das haus das gebaut werden soll.
     */
    public void hausBauen(Haus haus) {
        this.haeuser.add(haus);

    }

    /**
     * je nach name der stadt besitzt die stadte andere staedte als nachbarn. diese werden in dieser methode
     * definiert.
     */
    public void nachbarnHinzufuegen() {
        switch (this.name) {
            case MANNHEIM:
                this.nachbarn.add(Spielkarte.CARLSRUHE);
                this.nachbarn.add(Spielkarte.STUTTGART);
                this.nachbarn.add(Spielkarte.WUERZBURG);
                break;
            case WUERZBURG:
                this.nachbarn.add(Spielkarte.MANNHEIM);
                this.nachbarn.add(Spielkarte.STUTTGART);
                this.nachbarn.add(Spielkarte.NUERNBERG);
                break;
            case NUERNBERG:
                this.nachbarn.add(Spielkarte.WUERZBURG);
                this.nachbarn.add(Spielkarte.PILSEN);
                this.nachbarn.add(Spielkarte.REGENSBURG);
                this.nachbarn.add(Spielkarte.INGOLSTADT);
                this.nachbarn.add(Spielkarte.STUTTGART);
                break;
            case PILSEN:
                this.nachbarn.add(Spielkarte.NUERNBERG);
                this.nachbarn.add(Spielkarte.LODZ);
                this.nachbarn.add(Spielkarte.REGENSBURG);
                this.nachbarn.add(Spielkarte.BUDWEIS);
                break;
            case LODZ:
                this.nachbarn.add(Spielkarte.PILSEN);
                break;
            case STUTTGART:
                this.nachbarn.add(Spielkarte.CARLSRUHE);
                this.nachbarn.add(Spielkarte.MANNHEIM);
                this.nachbarn.add(Spielkarte.SIGMARINGEN);
                this.nachbarn.add(Spielkarte.WUERZBURG);
                this.nachbarn.add(Spielkarte.NUERNBERG);
                this.nachbarn.add(Spielkarte.INGOLSTADT);
                this.nachbarn.add(Spielkarte.ULM);
                break;
            case INGOLSTADT:
                this.nachbarn.add(Spielkarte.STUTTGART);
                this.nachbarn.add(Spielkarte.NUERNBERG);
                this.nachbarn.add(Spielkarte.REGENSBURG);
                this.nachbarn.add(Spielkarte.MUENCHEN);
                this.nachbarn.add(Spielkarte.AUGSBURG);
                this.nachbarn.add(Spielkarte.ULM);
                break;
            case REGENSBURG:
                this.nachbarn.add(Spielkarte.INGOLSTADT);
                this.nachbarn.add(Spielkarte.NUERNBERG);
                this.nachbarn.add(Spielkarte.PILSEN);
                this.nachbarn.add(Spielkarte.PASSAU);
                this.nachbarn.add(Spielkarte.MUENCHEN);
                break;
            case BUDWEIS:
                this.nachbarn.add(Spielkarte.PILSEN);
                this.nachbarn.add(Spielkarte.LINZ);
                break;
            case CARLSRUHE:
                this.nachbarn.add(Spielkarte.MANNHEIM);
                this.nachbarn.add(Spielkarte.STUTTGART);
                this.nachbarn.add(Spielkarte.FREIBURG);
                break;
            case FREIBURG:
                this.nachbarn.add(Spielkarte.BASEL);
                this.nachbarn.add(Spielkarte.CARLSRUHE);
                this.nachbarn.add(Spielkarte.SIGMARINGEN);
                this.nachbarn.add(Spielkarte.ZUERICH);
                break;
            case SIGMARINGEN:
                this.nachbarn.add(Spielkarte.FREIBURG);
                this.nachbarn.add(Spielkarte.STUTTGART);
                this.nachbarn.add(Spielkarte.ULM);
                this.nachbarn.add(Spielkarte.ZUERICH);
                this.nachbarn.add(Spielkarte.KEMPTEN);
                break;
            case ULM:
                this.nachbarn.add(Spielkarte.SIGMARINGEN);
                this.nachbarn.add(Spielkarte.STUTTGART);
                this.nachbarn.add(Spielkarte.INGOLSTADT);
                this.nachbarn.add(Spielkarte.AUGSBURG);
                this.nachbarn.add(Spielkarte.KEMPTEN);
                break;
            case AUGSBURG:
                this.nachbarn.add(Spielkarte.KEMPTEN);
                this.nachbarn.add(Spielkarte.ULM);
                this.nachbarn.add(Spielkarte.INGOLSTADT);
                this.nachbarn.add(Spielkarte.MUENCHEN);
                this.nachbarn.add(Spielkarte.INNSBRUCK);
                break;
            case MUENCHEN:
                this.nachbarn.add(Spielkarte.INNSBRUCK);
                this.nachbarn.add(Spielkarte.AUGSBURG);
                this.nachbarn.add(Spielkarte.INGOLSTADT);
                this.nachbarn.add(Spielkarte.REGENSBURG);
                this.nachbarn.add(Spielkarte.PASSAU);
                this.nachbarn.add(Spielkarte.SALZBURG);
                break;
            case PASSAU:
                this.nachbarn.add(Spielkarte.MUENCHEN);
                this.nachbarn.add(Spielkarte.REGENSBURG);
                this.nachbarn.add(Spielkarte.LINZ);
                this.nachbarn.add(Spielkarte.SALZBURG);
                break;
            case LINZ:
                this.nachbarn.add(Spielkarte.SALZBURG);
                this.nachbarn.add(Spielkarte.PASSAU);
                this.nachbarn.add(Spielkarte.BUDWEIS);
                break;
            case SALZBURG:
                this.nachbarn.add(Spielkarte.LINZ);
                this.nachbarn.add(Spielkarte.PASSAU);
                this.nachbarn.add(Spielkarte.MUENCHEN);
                this.nachbarn.add(Spielkarte.INNSBRUCK);
                break;
            case INNSBRUCK:
                this.nachbarn.add(Spielkarte.SALZBURG);
                this.nachbarn.add(Spielkarte.MUENCHEN);
                this.nachbarn.add(Spielkarte.AUGSBURG);
                this.nachbarn.add(Spielkarte.KEMPTEN);
                break;
            case KEMPTEN:
                this.nachbarn.add(Spielkarte.INNSBRUCK);
                this.nachbarn.add(Spielkarte.ZUERICH);
                this.nachbarn.add(Spielkarte.SIGMARINGEN);
                this.nachbarn.add(Spielkarte.ULM);
                this.nachbarn.add(Spielkarte.AUGSBURG);
                break;
            case ZUERICH:
                this.nachbarn.add(Spielkarte.KEMPTEN);
                this.nachbarn.add(Spielkarte.SIGMARINGEN);
                this.nachbarn.add(Spielkarte.FREIBURG);
                this.nachbarn.add(Spielkarte.BASEL);
                break;
            case BASEL:
                this.nachbarn.add(Spielkarte.ZUERICH);
                this.nachbarn.add(Spielkarte.FREIBURG);
                break;
        }
    }

    @Override
    public String toString() {
        return this.name.toString() + " (" + this.getLand().toString() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stadt)) return false;

        Stadt stadt = (Stadt) o;

        if (haeuser != null ? !haeuser.equals(stadt.haeuser) : stadt.haeuser != null) return false;
        if (nachbarn != null ? !nachbarn.equals(stadt.nachbarn) : stadt.nachbarn != null) return false;
        if (name != stadt.name) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (haeuser != null ? haeuser.hashCode() : 0);
        result = 31 * result + (nachbarn != null ? nachbarn.hashCode() : 0);
        return result;
    }
}
