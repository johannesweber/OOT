package thurntaxis.spielbrett;

import thurntaxis.spieler.Haus;

import java.util.LinkedList;

/**
 * Created by Johannes on 21.12.13.
 */
public class Stadt {

    private Stadtkarte name;
    private LinkedList<Haus> haeuser;
    private LinkedList<Stadtkarte> nachbarn;

    protected Stadt(Stadtkarte name) {
        this.haeuser = new LinkedList<Haus>();
        this.nachbarn = new LinkedList<Stadtkarte>();
        this.name = name;
        this.nachbarnHinzufuegen();
    }

    public String getName() {
        return this.name.toString();
    }

    public LinkedList<Haus> getHaeuser() {
        return this.haeuser;
    }

    public LinkedList<Stadtkarte> getNachbarn() {
        return this.nachbarn;
    }

    public void hausBauen(Haus haus){
        this.haeuser.add(haus);

    }

    public void nachbarnHinzufuegen(){
        switch (this.name){
            case MANNHEIM:
                this.nachbarn.add(Stadtkarte.CARLSRUHE);
                this.nachbarn.add(Stadtkarte.STUTTGART);
                this.nachbarn.add(Stadtkarte.WUERZBURG);
                break;
            case WUERZBURG:
                this.nachbarn.add(Stadtkarte.MANNHEIM);
                this.nachbarn.add(Stadtkarte.STUTTGART);
                this.nachbarn.add(Stadtkarte.NUERNBERG);
                break;
            case NUERNBERG:
                this.nachbarn.add(Stadtkarte.WUERZBURG);
                this.nachbarn.add(Stadtkarte.PILSEN);
                this.nachbarn.add(Stadtkarte.REGENSBURG);
                this.nachbarn.add(Stadtkarte.INGOLSTADT);
                this.nachbarn.add(Stadtkarte.STUTTGART);
                break;
            case PILSEN:
                this.nachbarn.add(Stadtkarte.NUERNBERG);
                this.nachbarn.add(Stadtkarte.LODS);
                this.nachbarn.add(Stadtkarte.REGENSBURG);
                this.nachbarn.add(Stadtkarte.BUDWEIS);
                break;
            case LODS:
                this.nachbarn.add(Stadtkarte.PILSEN);
                break;
            case STUTTGART:
                this.nachbarn.add(Stadtkarte.CARLSRUHE);
                this.nachbarn.add(Stadtkarte.MANNHEIM);
                this.nachbarn.add(Stadtkarte.SIGMARINGEN);
                this.nachbarn.add(Stadtkarte.WUERZBURG);
                this.nachbarn.add(Stadtkarte.NUERNBERG);
                this.nachbarn.add(Stadtkarte.INGOLSTADT);
                this.nachbarn.add(Stadtkarte.ULM);
                break;
            case INGOLSTADT:
                this.nachbarn.add(Stadtkarte.STUTTGART);
                this.nachbarn.add(Stadtkarte.NUERNBERG);
                this.nachbarn.add(Stadtkarte.REGENSBURG);
                this.nachbarn.add(Stadtkarte.MUENCHEN);
                this.nachbarn.add(Stadtkarte.AUGSBURG);
                this.nachbarn.add(Stadtkarte.ULM);
                break;
            case REGENSBURG:
                this.nachbarn.add(Stadtkarte.INGOLSTADT);
                this.nachbarn.add(Stadtkarte.NUERNBERG);
                this.nachbarn.add(Stadtkarte.PILSEN);
                this.nachbarn.add(Stadtkarte.PASSAU);
                this.nachbarn.add(Stadtkarte.MUENCHEN);
                break;
            case BUDWEIS:
                this.nachbarn.add(Stadtkarte.PILSEN);
                this.nachbarn.add(Stadtkarte.LINZ);
                break;
            case CARLSRUHE:
                this.nachbarn.add(Stadtkarte.MANNHEIM);
                this.nachbarn.add(Stadtkarte.STUTTGART);
                this.nachbarn.add(Stadtkarte.FREIBURG);
                break;
            case FREIBURG:
                this.nachbarn.add(Stadtkarte.BASEL);
                this.nachbarn.add(Stadtkarte.CARLSRUHE);
                this.nachbarn.add(Stadtkarte.SIGMARINGEN);
                this.nachbarn.add(Stadtkarte.ZUERICH);
                break;
            case SIGMARINGEN:
                this.nachbarn.add(Stadtkarte.FREIBURG);
                this.nachbarn.add(Stadtkarte.STUTTGART);
                this.nachbarn.add(Stadtkarte.ULM);
                this.nachbarn.add(Stadtkarte.ZUERICH);
                this.nachbarn.add(Stadtkarte.KEMPTEN);
                break;
            case ULM:
                this.nachbarn.add(Stadtkarte.SIGMARINGEN);
                this.nachbarn.add(Stadtkarte.STUTTGART);
                this.nachbarn.add(Stadtkarte.INGOLSTADT);
                this.nachbarn.add(Stadtkarte.AUGSBURG);
                this.nachbarn.add(Stadtkarte.KEMPTEN);
                break;
            case AUGSBURG:
                this.nachbarn.add(Stadtkarte.KEMPTEN);
                this.nachbarn.add(Stadtkarte.ULM);
                this.nachbarn.add(Stadtkarte.INGOLSTADT);
                this.nachbarn.add(Stadtkarte.MUENCHEN);
                this.nachbarn.add(Stadtkarte.INNSBRUCK);
                break;
            case MUENCHEN:
                this.nachbarn.add(Stadtkarte.INNSBRUCK);
                this.nachbarn.add(Stadtkarte.AUGSBURG);
                this.nachbarn.add(Stadtkarte.INGOLSTADT);
                this.nachbarn.add(Stadtkarte.REGENSBURG);
                this.nachbarn.add(Stadtkarte.PASSAU);
                this.nachbarn.add(Stadtkarte.SALZBURG);
                break;
            case PASSAU:
                this.nachbarn.add(Stadtkarte.MUENCHEN);
                this.nachbarn.add(Stadtkarte.REGENSBURG);
                this.nachbarn.add(Stadtkarte.LINZ);
                this.nachbarn.add(Stadtkarte.SALZBURG);
                break;
            case LINZ:
                this.nachbarn.add(Stadtkarte.SALZBURG);
                this.nachbarn.add(Stadtkarte.PASSAU);
                this.nachbarn.add(Stadtkarte.BUDWEIS);
                break;
            case SALZBURG:
                this.nachbarn.add(Stadtkarte.LINZ);
                this.nachbarn.add(Stadtkarte.PASSAU);
                this.nachbarn.add(Stadtkarte.MUENCHEN);
                this.nachbarn.add(Stadtkarte.INNSBRUCK);
                break;
            case INNSBRUCK:
                this.nachbarn.add(Stadtkarte.SALZBURG);
                this.nachbarn.add(Stadtkarte.MUENCHEN);
                this.nachbarn.add(Stadtkarte.AUGSBURG);
                this.nachbarn.add(Stadtkarte.KEMPTEN);
                break;
            case KEMPTEN:
                this.nachbarn.add(Stadtkarte.INNSBRUCK);
                this.nachbarn.add(Stadtkarte.ZUERICH);
                this.nachbarn.add(Stadtkarte.SIGMARINGEN);
                this.nachbarn.add(Stadtkarte.ULM);
                this.nachbarn.add(Stadtkarte.AUGSBURG);
                break;
            case ZUERICH:
                this.nachbarn.add(Stadtkarte.KEMPTEN);
                this.nachbarn.add(Stadtkarte.SIGMARINGEN);
                this.nachbarn.add(Stadtkarte.FREIBURG);
                this.nachbarn.add(Stadtkarte.BASEL);
                break;
            case BASEL:
                this.nachbarn.add(Stadtkarte.ZUERICH);
                this.nachbarn.add(Stadtkarte.FREIBURG);
                break;
        }
    }

    @Override
    public String toString() {
        return "Stadt{" +
                "name=" + name +
                ", nachbarn=" + nachbarn +
                '}';
    }
}
