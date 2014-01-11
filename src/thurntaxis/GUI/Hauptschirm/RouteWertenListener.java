package thurntaxis.gui.hauptschirm;

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
 * @author Gruppe 4 Fragezeichen
 *         <p/>
 *         Klassen fuer den Action Listener um die Route werten lassen zu erstellen.
 *         Er wird aktiviert sobald man im hauptschirm auf den Button Route werten klickt.
 *         In dem Menue welches sich oeffnet kann man das genaue Wertverfahren mit welchem man
 *         werten will aussuchen.
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

        if (this.spielleiter.getIstDran().getRoute().size() >= 3) {
            final JDialog routeWertenDialog = new JDialog();
            JButton eineStadtProLandButton = new JButton("Eine Stadt pro Land legen");
            JButton innerhalbEinemLandButon = new JButton("Innerhalb einem Land legen");

            eineStadtProLandButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    String meldung = RouteWertenListener.this.spielleiter.routeWerten
                            (new EineStadtProLandVerfahren());
                    JOptionPane.showMessageDialog(null, meldung);
                    RouteWertenListener.this.spielersteuerungPanel.listenAktualisieren();
                    routeWertenDialog.dispose();
                }
            });

            innerhalbEinemLandButon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    final JDialog landauswahlDialog = new JDialog();
                    JLabel label = new JLabel("In welchem Land wollen sie werten?");
                    final JButton bestaetigenButton = new JButton("Bestaetigen");

                    DefaultComboBoxModel defaultLandComboBoxModel = new DefaultComboBoxModel();
                    final JComboBox landComboBox = new JComboBox(defaultLandComboBoxModel);

                    LinkedList<LandEnum> laenderListe = new LinkedList<LandEnum>();
                    if (!spielleiter.getIstDran().getRoute().isEmpty()) {
                        laenderListe.add(spielleiter.getIstDran().getRoute().getFirst().getLand());
                        defaultLandComboBoxModel.addElement(laenderListe.getFirst());
                        for (Stadt it : spielleiter.getIstDran().getRoute()) {
                            if (!laenderListe.contains(it.getLand())) {
                                defaultLandComboBoxModel.addElement(it.getLand());
                            }
                        }
                    }
                    bestaetigenButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            LandEnum ausgewaehlt = (LandEnum) landComboBox.getSelectedItem();

                            String meldung = RouteWertenListener.this.spielleiter.routeWerten
                                    (new InnerhalbEinemLandVerfahren(ausgewaehlt));

                            JOptionPane.showMessageDialog(null, meldung);

                            RouteWertenListener.this.spielersteuerungPanel.listenAktualisieren();
                            landauswahlDialog.dispose();
                            routeWertenDialog.dispose();

                            bestaetigenButton.setToolTipText("Auswahl bestaetigen");
                        }
                    });

                    label.setHorizontalAlignment(JLabel.CENTER);
                    landComboBox.setAlignmentY(JComboBox.CENTER_ALIGNMENT);
                    bestaetigenButton.setAlignmentY(JButton.CENTER);

                    landauswahlDialog.add(label);
                    landauswahlDialog.add(landComboBox);
                    landauswahlDialog.add(bestaetigenButton);

                    landauswahlDialog.setLayout(new GridLayout(3, 1));
                    landauswahlDialog.setVisible(true);
                    landauswahlDialog.setLocationRelativeTo(null);
                    landauswahlDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    landauswahlDialog.setSize(410, 100);
                }
            });

            innerhalbEinemLandButon.setToolTipText("Damit wertest du deine Route innerhalb einem Land");
            eineStadtProLandButton.setToolTipText("Damit wertest du pro Land eine Stadt");

            routeWertenDialog.setLocationRelativeTo(null);
            routeWertenDialog.setTitle("Wie moechtest du deine Route werten lassen?");
            routeWertenDialog.setLayout(new GridLayout(2, 1));
            routeWertenDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            routeWertenDialog.add(eineStadtProLandButton);
            routeWertenDialog.add(innerhalbEinemLandButon);
            routeWertenDialog.setSize(410, 100);
            routeWertenDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Deine Route muss eine Mindestlaenge von 3 Karten haben!");
        }
    }
}