package thurntaxis;

import org.junit.Test;
import thurntaxis.spiel.*;
import thurntaxis.spieler.Spieler;
import thurntaxis.spieler.Spielerfarbe;
import thurntaxis.wertverfahren.EineStadtProLandVerfahren;
import thurntaxis.wertverfahren.InnerhalbEinemLandVerfahren;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Johannes on 08.01.14.
 */
public class ThurnTaxisUnitTest {

    Spielleiter spielleiter;
    Spieler johannes = new Spieler(Spielerfarbe.GELB);
    Spieler jessica = new Spieler(Spielerfarbe.ROT);

    LinkedList<Stadt> innerhalbEinemLandTestListe = new LinkedList<Stadt>();
    LinkedList<Stadt> eineStadtProLandTestListe = new LinkedList<Stadt>();
    LinkedList<Stadt> leereListe = new LinkedList<Stadt>();

    @Test
    public void routeWertenTest() {

        this.spielleiter = new Spielleiter();

        InnerhalbEinemLandVerfahren innerhalbEinemLandVerfahren = new InnerhalbEinemLandVerfahren(LandEnum.BAIERN);
        EineStadtProLandVerfahren eineStadtProLandVerfahren = new EineStadtProLandVerfahren();

        spielleiter.spieler[0] = johannes;
        spielleiter.spieler[1] = jessica;

        spielleiter.spielStarten();

        innerhalbEinemLandTestListe.add(new Stadt(Spielkarte.WUERZBURG));
        innerhalbEinemLandTestListe.add(new Stadt(Spielkarte.NUERNBERG));
        innerhalbEinemLandTestListe.add(new Stadt(Spielkarte.REGENSBURG));
        innerhalbEinemLandTestListe.add(new Stadt(Spielkarte.INGOLSTADT));
        innerhalbEinemLandTestListe.add(new Stadt(Spielkarte.NUERNBERG));
        innerhalbEinemLandTestListe.add(new Stadt(Spielkarte.AUGSBURG));
        innerhalbEinemLandTestListe.add(new Stadt(Spielkarte.MUENCHEN));
        innerhalbEinemLandTestListe.add(new Stadt(Spielkarte.PASSAU));

        eineStadtProLandTestListe.add(new Stadt(Spielkarte.FREIBURG));
        eineStadtProLandTestListe.add(new Stadt(Spielkarte.SIGMARINGEN));
        eineStadtProLandTestListe.add(new Stadt(Spielkarte.ZUERICH));
        eineStadtProLandTestListe.add(new Stadt(Spielkarte.KEMPTEN));
        eineStadtProLandTestListe.add(new Stadt(Spielkarte.INNSBRUCK));
        eineStadtProLandTestListe.add(new Stadt(Spielkarte.SALZBURG));

        LinkedList<Bonusmarker> bonusmarkerTestListe = new LinkedList<Bonusmarker>();
        bonusmarkerTestListe.add(new Bonusmarker(4));

        johannes.getRoute().addAll(innerhalbEinemLandTestListe);
        jessica.getRoute().addAll(eineStadtProLandTestListe);

        assertEquals(innerhalbEinemLandTestListe, johannes.getRoute());
        assertEquals(leereListe, johannes.getBoni());

        spielleiter.routeWerten(innerhalbEinemLandVerfahren);
        spielleiter.naechsterSpieler();
        spielleiter.routeWerten(eineStadtProLandVerfahren);

        assertEquals(12, johannes.getHaeuser().size());
        assertEquals(leereListe, johannes.getRoute());
        assertEquals(Spielerfarbe.GELB, johannes.getHaeuser().peek().getFarbe());
        assertEquals(bonusmarkerTestListe, johannes.getBoni());
        johannes.punkteErmitteln();
        assertEquals(12, johannes.getPunktstand());

        assertEquals(johannes, spielleiter.gewinnerErmitteln());

    }
}
