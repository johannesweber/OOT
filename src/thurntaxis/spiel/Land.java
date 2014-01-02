package thurntaxis.spiel;

import java.util.LinkedList;

/**
 * Eine Klasse fuer ein Land. Ein Land besitzt einen Namen und eine bestimmte Anzahl an Staedte.
 * Die Klasse und der Konstrukor haben default-Sichtbarkeit.
 */
class Land {

    private String name;
    private LinkedList<Stadt> staedte;

    Land(LandEnum name) {
        this.name = name.toString();
        this.staedte = new LinkedList<Stadt>();
        this.staedteHinzufuegen(name);
    }

    /**
     * Diese Methode fuegt jedem Land, seine Staedte hinzu. Je nach dem welches Land gerade uebergeben wird
     * sind es andere Staedte. Diese Methode wird sofort ausgefuehrt wenn ein Land Objekt erstellt wird.
     *
     * @param name der name des Landes welchem die staedte hinzugefuegt werden.
     */
    private void staedteHinzufuegen(LandEnum name) {
        switch (name) {
            case BADEN:
                this.staedte.add(new Stadt(Spielkarte.MANNHEIM));
                this.staedte.add(new Stadt(Spielkarte.CARLSRUHE));
                this.staedte.add(new Stadt(Spielkarte.FREIBURG));
                break;
            case HOHENZOLLERN:
                this.staedte.add(new Stadt(Spielkarte.SIGMARINGEN));
                break;
            case WUERTTEMBERG:
                this.staedte.add(new Stadt(Spielkarte.STUTTGART));
                this.staedte.add(new Stadt(Spielkarte.ULM));
                break;
            case BAIERN:
                this.staedte.add(new Stadt(Spielkarte.WUERZBURG));
                this.staedte.add(new Stadt(Spielkarte.NUERNBERG));
                this.staedte.add(new Stadt(Spielkarte.REGENSBURG));
                this.staedte.add(new Stadt(Spielkarte.INGOLSTADT));
                this.staedte.add(new Stadt(Spielkarte.AUGSBURG));
                this.staedte.add(new Stadt(Spielkarte.KEMPTEN));
                this.staedte.add(new Stadt(Spielkarte.MUENCHEN));
                this.staedte.add(new Stadt(Spielkarte.PASSAU));
                break;
            case POLEN:
                this.staedte.add(new Stadt(Spielkarte.LODS));
                break;
            case BOEHMEN:
                this.staedte.add(new Stadt(Spielkarte.PILSEN));
                this.staedte.add(new Stadt(Spielkarte.BUDWEIS));
                break;
            case SALZBURG:
                this.staedte.add(new Stadt(Spielkarte.SALZBURG));
                this.staedte.add(new Stadt(Spielkarte.LINZ));
                break;
            case TYROL:
                this.staedte.add(new Stadt(Spielkarte.INNSBRUCK));
                break;
            case SCHWEIZ:
                this.staedte.add(new Stadt(Spielkarte.BASEL));
                this.staedte.add(new Stadt(Spielkarte.ZUERICH));
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
