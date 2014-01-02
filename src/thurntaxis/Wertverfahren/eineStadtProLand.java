package thurntaxis.Wertverfahren;

import thurntaxis.spiel.Stadt;
import thurntaxis.spieler.Haus;
import thurntaxis.spieler.Spieler;

import java.util.LinkedList;

/**
 * Created by Johannes on 22.12.13.
 */
public class EineStadtProLand implements Wertverfahren {

    @Override
    public void werten(Spieler spieler, LinkedList<Stadt> route) {
        LinkedList<Stadt> gelegteRoute = spieler.getGelegteRoute();
        for(Stadt it : gelegteRoute){
            if(!it.getHaeuser().contains(new Haus(spieler.getFarbe())))
                it.hausBauen(spieler.getHaeuser().pop());
        }
    }

    @Override
    public void kartePruefen(Spieler spieler, Stadt karte) {
        if (spieler.getGelegteRoute() == null) {
            spieler.getGelegteRoute().add(karte);
        } else {
            if (!spieler.getGelegteRoute().contains(karte.getLand())) {
                spieler.getGelegteRoute().add(karte);
            }else{
                System.out.println("Pro Route muessen alle Staedte einem anderen Land zugehoeren.");
            }
        }
    }
}
