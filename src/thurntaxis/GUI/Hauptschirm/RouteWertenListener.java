package thurntaxis.GUI.hauptschirm;

import thurntaxis.spiel.Spielleiter;
import thurntaxis.wertverfahren.EineStadtProLandVerfahren;
import thurntaxis.wertverfahren.InnerhalbEinemLandVerfahren;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klassen um einen Action Listener um die Route werrten lassen zu erstellen.
 * Er wird aktiviert sobald man im hauptschirm auf den Button Route werten klickt.
 */
class RouteWertenListener implements ActionListener {

    private Spielleiter spielablauf;
    private SpielersteuerungPanel spielersteuerungPanel;

    RouteWertenListener(Spielleiter spielablauf, SpielersteuerungPanel spielersteuerungPanel) {
        this.spielablauf = spielablauf;
        this.spielersteuerungPanel = spielersteuerungPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        final JDialog routeWertenDialog = new JDialog();
        JButton eineStadtProLandButton = new JButton("Eine Stadt pro Land legen");
        JButton innerhalbEinemLandButon = new JButton("Innerhalb einem Land legen");

        eineStadtProLandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String meldung = RouteWertenListener.this.spielablauf.routeWerten
                        (new EineStadtProLandVerfahren());
                if(meldung != null){
                    JOptionPane.showMessageDialog(null, meldung);
                }
                RouteWertenListener.this.spielersteuerungPanel.listenAktualisieren();
                routeWertenDialog.dispose();
            }
        });

        innerhalbEinemLandButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String meldung = RouteWertenListener.this.spielablauf.routeWerten
                        (new InnerhalbEinemLandVerfahren());
                if(meldung != null){
                    JOptionPane.showMessageDialog(null, meldung);
                }
                RouteWertenListener.this.spielersteuerungPanel.listenAktualisieren();
                routeWertenDialog.dispose();
            }
        });

        routeWertenDialog.setLocationRelativeTo(null);
        routeWertenDialog.setTitle("Wie moechtest du deine Route werten lassen?");
        routeWertenDialog.setLayout(new GridLayout(2, 1));
        routeWertenDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        routeWertenDialog.add(eineStadtProLandButton);
        routeWertenDialog.add(innerhalbEinemLandButon);
        routeWertenDialog.pack();
        routeWertenDialog.setVisible(true);
    }
}
