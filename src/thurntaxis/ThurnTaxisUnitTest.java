package thurntaxis;

import org.junit.Test;
import thurntaxis.spiel.LandEnum;
import thurntaxis.spiel.Spielkarte;
import thurntaxis.spiel.Spielleiter;
import thurntaxis.spiel.Stadt;
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

    LinkedList<Stadt> innerhalbEinemLandTestListe = new LinkedList<Stadt>();
    LinkedList<Stadt> eineStadtProLandTestListe = new LinkedList<Stadt>();
    LinkedList<Stadt> leereListe = new LinkedList<Stadt>();

    @Test
    public void routeWertenTest() {

        this.spielleiter = new Spielleiter();

        InnerhalbEinemLandVerfahren verfahren = new InnerhalbEinemLandVerfahren(LandEnum.BADEN);
        EineStadtProLandVerfahren verfahren1 = new EineStadtProLandVerfahren();

        spielleiter.spieler[0] = johannes;

        spielleiter.spielStarten();

        innerhalbEinemLandTestListe.add(new Stadt(Spielkarte.MANNHEIM));
        innerhalbEinemLandTestListe.add(new Stadt(Spielkarte.CARLSRUHE));
        innerhalbEinemLandTestListe.add(new Stadt(Spielkarte.PILSEN));

        eineStadtProLandTestListe.add(new Stadt(Spielkarte.MANNHEIM));
        eineStadtProLandTestListe.add(new Stadt(Spielkarte.WUERZBURG));
        eineStadtProLandTestListe.add(new Stadt(Spielkarte.PILSEN));

        johannes.getRoute().addAll(eineStadtProLandTestListe);

        assertEquals(eineStadtProLandTestListe, johannes.getRoute());

        spielleiter.routeWerten(verfahren1);

        assertEquals(17, johannes.getHaeuser().size());
        assertEquals(leereListe, johannes.getRoute());
    }
}
