package thurntaxis.GUI.Hauptschirm;

import thurntaxis.Wertverfahren.eineStadtProLand;
import thurntaxis.Wertverfahren.innerhalbEinemLand;
import thurntaxis.spiel.Spielablauf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klassen um einen Action Listener um die Route werrten lassen zu erstellen.
 * Er wird aktiviert sobald man im Hauptschirm auf den Button Route werten klickt.
 */
class RouteWertenListener implements ActionListener {

    private Spielablauf spielablauf;

    RouteWertenListener(Spielablauf spielablauf) {
        this.spielablauf = spielablauf;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        final JDialog routeWertenDialog = new JDialog();
        JButton eineStadtProLandButton = new JButton("Eine Stadt pro Land legen");
        JButton innerhalbEinemLandButon = new JButton("Innerhalb einem Land legen");

        eineStadtProLandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RouteWertenListener.this.spielablauf.spieler
                        [RouteWertenListener.this.spielablauf.getIstDran()].routeWerten
                        (new eineStadtProLand());
                routeWertenDialog.dispose();
            }
        });

        innerhalbEinemLandButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RouteWertenListener.this.spielablauf.spieler
                        [RouteWertenListener.this.spielablauf.getIstDran()].routeWerten
                        (new innerhalbEinemLand());
                routeWertenDialog.dispose();
            }
        });

        routeWertenDialog.setTitle("Wie moechtest du deine Route werten lassen?");
        routeWertenDialog.setLayout(new GridLayout(2, 1));
        routeWertenDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        routeWertenDialog.add(eineStadtProLandButton);
        routeWertenDialog.add(innerhalbEinemLandButon);
        routeWertenDialog.pack();
        routeWertenDialog.setVisible(true);
    }
}
