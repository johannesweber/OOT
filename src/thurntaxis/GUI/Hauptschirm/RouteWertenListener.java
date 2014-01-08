package thurntaxis.GUI.hauptschirm;

import thurntaxis.spiel.LandEnum;
import thurntaxis.spiel.Spielleiter;
import thurntaxis.spiel.Stadt;
import thurntaxis.wertverfahren.EineStadtProLandVerfahren;
import thurntaxis.wertverfahren.InnerhalbEinemLandVerfahren;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Klassen um einen Action Listener um die Route werrten lassen zu erstellen.
 * Er wird aktiviert sobald man im hauptschirm auf den Button Route werten klickt.
 */
class RouteWertenListener implements ActionListener {

    private Spielleiter spielleiter;
    private SpielersteuerungPanel spielersteuerungPanel;

    RouteWertenListener(Spielleiter spielleiter, SpielersteuerungPanel spielersteuerungPanel) {
        this.spielleiter = spielleiter;
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

                String meldung = RouteWertenListener.this.spielleiter.routeWerten
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

                JDialog landauswahlDialog = new JDialog();
                JLabel label = new JLabel("Bitte waehlen sie aus in welchem Land sie die Route werten" +
                        "lassen wollen");
                JButton bestaetigenButton = new JButton("Bestaetigen");

                DefaultComboBoxModel defaultlandModel = new DefaultComboBoxModel();
                final JComboBox landBox = new JComboBox(defaultlandModel);

                LinkedList<LandEnum> laender = new LinkedList<LandEnum>();
                laender.add(spielleiter.getIstDran().getRoute().getFirst().getLand());

                for (Stadt it : spielleiter.getIstDran().getRoute()){

                    if(!laender.contains(it.getLand())){
                        defaultlandModel.addElement(it.getLand());
                    }
                }
                bestaetigenButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        LandEnum ausgewaehlt = (LandEnum) landBox.getSelectedItem();

                        String meldung = RouteWertenListener.this.spielleiter.routeWerten
                                (new InnerhalbEinemLandVerfahren(ausgewaehlt));

                        JOptionPane.showMessageDialog(null, meldung);

                        RouteWertenListener.this.spielersteuerungPanel.listenAktualisieren();
                        routeWertenDialog.dispose();
                    }
                });

                landauswahlDialog.setVisible(true);
                landauswahlDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                landauswahlDialog.pack();

                landauswahlDialog.add(label);
                landauswahlDialog.add(landBox);
                landauswahlDialog.add(bestaetigenButton);
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
