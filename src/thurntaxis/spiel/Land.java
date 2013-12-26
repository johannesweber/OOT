package thurntaxis.spiel;

import java.util.LinkedList;

/**
 * Created by Johannes on 21.12.13.
 */
class Land {

    private String name;
    private LinkedList<Stadt> staedte;

    Land(LandEnum name) {
        this.name = name.toString();
        this.staedte = new LinkedList<Stadt>();
        this.staedteHinzufuegen(name);
    }

    private void staedteHinzufuegen(LandEnum name) {
        switch (name) {
            case BADEN:
                this.staedte.add(new Stadt(StadtEnum.MANNHEIM));
                this.staedte.add(new Stadt(StadtEnum.CARLSRUHE));
                this.staedte.add(new Stadt(StadtEnum.FREIBURG));
                break;
            case HOHENZOLLERN:
                this.staedte.add(new Stadt(StadtEnum.SIGMARINGEN));
                break;
            case WUERTTEMBERG:
                this.staedte.add(new Stadt(StadtEnum.STUTTGART));
                this.staedte.add(new Stadt(StadtEnum.ULM));
                break;
            case BAIERN:
                this.staedte.add(new Stadt(StadtEnum.WUERZBURG));
                this.staedte.add(new Stadt(StadtEnum.NUERNBERG));
                this.staedte.add(new Stadt(StadtEnum.REGENSBURG));
                this.staedte.add(new Stadt(StadtEnum.INGOLSTADT));
                this.staedte.add(new Stadt(StadtEnum.AUGSBURG));
                this.staedte.add(new Stadt(StadtEnum.KEMPTEN));
                this.staedte.add(new Stadt(StadtEnum.MUENCHEN));
                this.staedte.add(new Stadt(StadtEnum.PASSAU));
                break;
            case POLEN:
                this.staedte.add(new Stadt(StadtEnum.LODS));
                break;
            case BOEHMEN:
                this.staedte.add(new Stadt(StadtEnum.PILSEN));
                this.staedte.add(new Stadt(StadtEnum.BUDWEIS));
                break;
            case SALZBURG:
                this.staedte.add(new Stadt(StadtEnum.SALZBURG));
                this.staedte.add(new Stadt(StadtEnum.LINZ));
                break;
            case TYROL:
                this.staedte.add(new Stadt(StadtEnum.INNSBRUCK));
                break;
            case SCHWEIZ:
                this.staedte.add(new Stadt(StadtEnum.BASEL));
                this.staedte.add(new Stadt(StadtEnum.ZUERICH));
                break;
        }
    }

    @Override
    public String toString() {
        return "Land{" +
                "name='" + name + '\'' +
                ", staedte=" + staedte +
                '}';
    }
}
