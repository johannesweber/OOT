package thurntaxis.spielbrett;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Johannes on 21.12.13.
 */
public class Land {

    private String name;
    private LinkedList<Stadt> staedte;
    private Stack<Laenderbonus> laenderboni;

    protected Land(LandEnum name) {
        this.name = name.toString();
        this.staedte = new LinkedList<Stadt>();
        this.laenderboni = new Stack<Laenderbonus>();
        this.staedteHinzufuegen(name);
    }

    private void staedteHinzufuegen(LandEnum name){
        switch(name){
            case BADEN:
                this.staedte.add(new Stadt(Stadtkarte.MANNHEIM));
                this.staedte.add(new Stadt(Stadtkarte.CARLSRUHE));
                this.staedte.add(new Stadt(Stadtkarte.FREIBURG));
                break;
            case HOHENZOLLERN:
                this.staedte.add(new Stadt(Stadtkarte.SIGMARINGEN));
                break;
            case WUERTTEMBERG:
                this.staedte.add(new Stadt(Stadtkarte.STUTTGART));
                this.staedte.add(new Stadt(Stadtkarte.ULM));
                break;
            case BAIERN:
                this.staedte.add(new Stadt(Stadtkarte.WUERZBURG));
                this.staedte.add(new Stadt(Stadtkarte.NUERNBERG));
                this.staedte.add(new Stadt(Stadtkarte.REGENSBURG));
                this.staedte.add(new Stadt(Stadtkarte.INGOLSTADT));
                this.staedte.add(new Stadt(Stadtkarte.AUGSBURG));
                this.staedte.add(new Stadt(Stadtkarte.KEMPTEN));
                this.staedte.add(new Stadt(Stadtkarte.MUENCHEN));
                this.staedte.add(new Stadt(Stadtkarte.PASSAU));
                break;
            case POLEN:
                this.staedte.add(new Stadt(Stadtkarte.LODS));
                break;
            case BOEHMEN:
                this.staedte.add(new Stadt(Stadtkarte.PILSEN));
                this.staedte.add(new Stadt(Stadtkarte.BUDWEIS));
                break;
            case SALZBURG:
                this.staedte.add(new Stadt(Stadtkarte.SALZBURG));
                this.staedte.add(new Stadt(Stadtkarte.LINZ));
                break;
            case TYROL:
                this.staedte.add(new Stadt(Stadtkarte.INNSBRUCK));
                break;
            case SCHWEIZ:
                this.staedte.add(new Stadt(Stadtkarte.BASEL));
                this.staedte.add(new Stadt(Stadtkarte.ZUERICH));
                break;
        }
    }

    public LinkedList<Stadt> getStaedte(){
        return this.staedte;
    }

    @Override
    public String toString() {
        return "Land{" +
                "name='" + name + '\'' +
                ", staedte=" + staedte +
                '}';
    }
}
