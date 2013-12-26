package thurntaxis.spiel;

import thurntaxis.spieler.Haus;

import java.util.LinkedList;

/**
 * Created by Johannes on 21.12.13.
 */
public class Stadt {

    private StadtEnum name;
    private LinkedList<Haus> haeuser;
    private LinkedList<StadtEnum> nachbarn;

    Stadt(StadtEnum name) {
        this.haeuser = new LinkedList<Haus>();
        this.nachbarn = new LinkedList<StadtEnum>();
        this.name = name;
        this.nachbarnHinzufuegen();
    }

    public String getName() {
        return this.name.toString();
    }

    public LinkedList<Haus> getHaeuser() {
        return this.haeuser;
    }

    public LinkedList<StadtEnum> getNachbarn() {
        return this.nachbarn;
    }

    public void hausBauen(Haus haus){
        this.haeuser.add(haus);

    }

    public void nachbarnHinzufuegen(){
        switch (this.name){
            case MANNHEIM:
                this.nachbarn.add(StadtEnum.CARLSRUHE);
                this.nachbarn.add(StadtEnum.STUTTGART);
                this.nachbarn.add(StadtEnum.WUERZBURG);
                break;
            case WUERZBURG:
                this.nachbarn.add(StadtEnum.MANNHEIM);
                this.nachbarn.add(StadtEnum.STUTTGART);
                this.nachbarn.add(StadtEnum.NUERNBERG);
                break;
            case NUERNBERG:
                this.nachbarn.add(StadtEnum.WUERZBURG);
                this.nachbarn.add(StadtEnum.PILSEN);
                this.nachbarn.add(StadtEnum.REGENSBURG);
                this.nachbarn.add(StadtEnum.INGOLSTADT);
                this.nachbarn.add(StadtEnum.STUTTGART);
                break;
            case PILSEN:
                this.nachbarn.add(StadtEnum.NUERNBERG);
                this.nachbarn.add(StadtEnum.LODS);
                this.nachbarn.add(StadtEnum.REGENSBURG);
                this.nachbarn.add(StadtEnum.BUDWEIS);
                break;
            case LODS:
                this.nachbarn.add(StadtEnum.PILSEN);
                break;
            case STUTTGART:
                this.nachbarn.add(StadtEnum.CARLSRUHE);
                this.nachbarn.add(StadtEnum.MANNHEIM);
                this.nachbarn.add(StadtEnum.SIGMARINGEN);
                this.nachbarn.add(StadtEnum.WUERZBURG);
                this.nachbarn.add(StadtEnum.NUERNBERG);
                this.nachbarn.add(StadtEnum.INGOLSTADT);
                this.nachbarn.add(StadtEnum.ULM);
                break;
            case INGOLSTADT:
                this.nachbarn.add(StadtEnum.STUTTGART);
                this.nachbarn.add(StadtEnum.NUERNBERG);
                this.nachbarn.add(StadtEnum.REGENSBURG);
                this.nachbarn.add(StadtEnum.MUENCHEN);
                this.nachbarn.add(StadtEnum.AUGSBURG);
                this.nachbarn.add(StadtEnum.ULM);
                break;
            case REGENSBURG:
                this.nachbarn.add(StadtEnum.INGOLSTADT);
                this.nachbarn.add(StadtEnum.NUERNBERG);
                this.nachbarn.add(StadtEnum.PILSEN);
                this.nachbarn.add(StadtEnum.PASSAU);
                this.nachbarn.add(StadtEnum.MUENCHEN);
                break;
            case BUDWEIS:
                this.nachbarn.add(StadtEnum.PILSEN);
                this.nachbarn.add(StadtEnum.LINZ);
                break;
            case CARLSRUHE:
                this.nachbarn.add(StadtEnum.MANNHEIM);
                this.nachbarn.add(StadtEnum.STUTTGART);
                this.nachbarn.add(StadtEnum.FREIBURG);
                break;
            case FREIBURG:
                this.nachbarn.add(StadtEnum.BASEL);
                this.nachbarn.add(StadtEnum.CARLSRUHE);
                this.nachbarn.add(StadtEnum.SIGMARINGEN);
                this.nachbarn.add(StadtEnum.ZUERICH);
                break;
            case SIGMARINGEN:
                this.nachbarn.add(StadtEnum.FREIBURG);
                this.nachbarn.add(StadtEnum.STUTTGART);
                this.nachbarn.add(StadtEnum.ULM);
                this.nachbarn.add(StadtEnum.ZUERICH);
                this.nachbarn.add(StadtEnum.KEMPTEN);
                break;
            case ULM:
                this.nachbarn.add(StadtEnum.SIGMARINGEN);
                this.nachbarn.add(StadtEnum.STUTTGART);
                this.nachbarn.add(StadtEnum.INGOLSTADT);
                this.nachbarn.add(StadtEnum.AUGSBURG);
                this.nachbarn.add(StadtEnum.KEMPTEN);
                break;
            case AUGSBURG:
                this.nachbarn.add(StadtEnum.KEMPTEN);
                this.nachbarn.add(StadtEnum.ULM);
                this.nachbarn.add(StadtEnum.INGOLSTADT);
                this.nachbarn.add(StadtEnum.MUENCHEN);
                this.nachbarn.add(StadtEnum.INNSBRUCK);
                break;
            case MUENCHEN:
                this.nachbarn.add(StadtEnum.INNSBRUCK);
                this.nachbarn.add(StadtEnum.AUGSBURG);
                this.nachbarn.add(StadtEnum.INGOLSTADT);
                this.nachbarn.add(StadtEnum.REGENSBURG);
                this.nachbarn.add(StadtEnum.PASSAU);
                this.nachbarn.add(StadtEnum.SALZBURG);
                break;
            case PASSAU:
                this.nachbarn.add(StadtEnum.MUENCHEN);
                this.nachbarn.add(StadtEnum.REGENSBURG);
                this.nachbarn.add(StadtEnum.LINZ);
                this.nachbarn.add(StadtEnum.SALZBURG);
                break;
            case LINZ:
                this.nachbarn.add(StadtEnum.SALZBURG);
                this.nachbarn.add(StadtEnum.PASSAU);
                this.nachbarn.add(StadtEnum.BUDWEIS);
                break;
            case SALZBURG:
                this.nachbarn.add(StadtEnum.LINZ);
                this.nachbarn.add(StadtEnum.PASSAU);
                this.nachbarn.add(StadtEnum.MUENCHEN);
                this.nachbarn.add(StadtEnum.INNSBRUCK);
                break;
            case INNSBRUCK:
                this.nachbarn.add(StadtEnum.SALZBURG);
                this.nachbarn.add(StadtEnum.MUENCHEN);
                this.nachbarn.add(StadtEnum.AUGSBURG);
                this.nachbarn.add(StadtEnum.KEMPTEN);
                break;
            case KEMPTEN:
                this.nachbarn.add(StadtEnum.INNSBRUCK);
                this.nachbarn.add(StadtEnum.ZUERICH);
                this.nachbarn.add(StadtEnum.SIGMARINGEN);
                this.nachbarn.add(StadtEnum.ULM);
                this.nachbarn.add(StadtEnum.AUGSBURG);
                break;
            case ZUERICH:
                this.nachbarn.add(StadtEnum.KEMPTEN);
                this.nachbarn.add(StadtEnum.SIGMARINGEN);
                this.nachbarn.add(StadtEnum.FREIBURG);
                this.nachbarn.add(StadtEnum.BASEL);
                break;
            case BASEL:
                this.nachbarn.add(StadtEnum.ZUERICH);
                this.nachbarn.add(StadtEnum.FREIBURG);
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
