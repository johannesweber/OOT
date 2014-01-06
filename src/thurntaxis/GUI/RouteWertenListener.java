package thurntaxis.GUI;

import thurntaxis.Wertverfahren.eineStadtProLand;
import thurntaxis.Wertverfahren.innerhalbEinemLand;
import thurntaxis.spiel.Spielablauf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Johannes on 06.01.14.
 */
public class RouteWertenListener implements ActionListener {

    private Spielablauf spielablauf;

    public RouteWertenListener(Spielablauf spielablauf) {
        this.spielablauf = spielablauf;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        final JDialog routeWertenDialog = new JDialog();
        routeWertenDialog.setTitle("Wie moechtest du deine Route werten lassen?");
        JButton eineStadtProLandButton = new JButton("Eine Stadt pro Land legen");
        JButton innerhalbEinemLandButon = new JButton("Innerhalb einem Land legen");

        eineStadtProLandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RouteWertenListener.this.spielablauf.spieler[0].routeWerten(new eineStadtProLand());
                routeWertenDialog.dispose();
            }
        });

        innerhalbEinemLandButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RouteWertenListener.this.spielablauf.spieler[0].routeWerten(new innerhalbEinemLand());
                routeWertenDialog.dispose();
            }
        });

        routeWertenDialog.setLayout(new GridLayout(2,1));
        routeWertenDialog.add(eineStadtProLandButton);
        routeWertenDialog.add(innerhalbEinemLandButon);
        routeWertenDialog.pack();
        routeWertenDialog.setVisible(true);
    }
}
