package thurntaxis.GUI.Hauptschirm;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import thurntaxis.spiel.*;
import thurntaxis.spieler.Spieler;

/**
 * Klasse vom Typ JPanel, welche die verfuegbaren Buttons, die Hand und die Route des Spielers,
 * sowie das Spielbrett anzeigt.
 */
class SpielersteuerungPanel extends JPanel {

    private Spielablauf spielablauf;
    private SpielbrettPanel spielbrettPanel;

    private JButton karteZiehenButton = new JButton("Karte ziehen");
    private JButton karteAblegenButton = new JButton("Karte ablegen");
    private JButton amtspersonAusspielenButton = new JButton("Amtsperson auspielen");
    private JButton routeWertenButton = new JButton("Route werten");
    private JButton naechsterSpielerButton = new JButton("naechster Spieler");
    private JButton spielBeendenButton = new JButton("Spiel beenden");

    private JPanel buttonPanel = new JPanel();
    private JPanel handPanel = new JPanel();
    private JPanel routenPanel = new JPanel();
    private JPanel beides = new JPanel();

    private JLabel spielersteuerungLabel;
    private JLabel deineRouteLabel = new JLabel("Deine Route");
    private JLabel deineHandLabel = new JLabel("Deine Hand");

    private DefaultListModel defaultRouteModel = new DefaultListModel();
    private JList routeList = new JList(defaultRouteModel);

    private DefaultListModel defaultHandModel = new DefaultListModel();
    private JList handList = new JList(defaultHandModel);

    SpielersteuerungPanel(Spielablauf spielablauf, SpielbrettPanel spielbrettPanel) {
        this.spielablauf = spielablauf;
        this.spielbrettPanel = spielbrettPanel;

        this.spielersteuerungLabel = new JLabel("Spieler " + spielablauf.getIstDran().getFarbe().toString());

        this.karteAblegenButton.setEnabled(false);
        this.buttonPanel.setLayout(new GridLayout(6, 1));

        this.spielersteuerungLabel.setHorizontalAlignment(JLabel.CENTER);
        this.buttonPanel.add(spielersteuerungLabel);
        this.buttonPanel.add(karteZiehenButton);
        this.buttonPanel.add(karteAblegenButton);
        this.buttonPanel.add(amtspersonAusspielenButton);
        this.buttonPanel.add(routeWertenButton);
        this.buttonPanel.add(naechsterSpielerButton);

        this.handList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.handList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                karteAblegenButton.setEnabled(true);
            }
        });

        this.handPanel.add(deineHandLabel);
        this.handPanel.add(handList);

        this.routenPanel.add(deineRouteLabel);
        this.routenPanel.add(routeList);

        this.beides.setLayout(new GridLayout(2, 1));
        this.beides.add(handPanel);
        this.beides.add(routenPanel);

        this.karteAblegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String ausgewaehlteKarte = defaultHandModel.get(handList.getSelectedIndex()).toString();
                handList.clearSelection();
                karteAblegenButton.setEnabled(false);
                String meldung = SpielersteuerungPanel.this.spielablauf.getIstDran().karteAblegen
                        (SpielersteuerungPanel.this.getStadtAnhandString(ausgewaehlteKarte));
                if (meldung != null) {
                    JOptionPane.showMessageDialog(null, meldung);
                    SpielersteuerungPanel.this.listenAktualisieren();
                } else {
                    SpielersteuerungPanel.this.listenAktualisieren();
                }
            }
        });

        this.karteZiehenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int karte = SpielersteuerungPanel.this.spielbrettPanel.getDefaultAuslagestapelComboBoxModel().
                        getIndexOf(SpielersteuerungPanel.this.spielbrettPanel.getDefaultAuslagestapelComboBoxModel().
                                getSelectedItem());

                String meldung = SpielersteuerungPanel.this.spielablauf.getIstDran().karteZiehen(karte);
                if (meldung != null) {
                    JOptionPane.showMessageDialog(null, meldung);
                } else {
                    SpielersteuerungPanel.this.defaultHandFuellen();
                    SpielersteuerungPanel.this.spielbrettPanel.defaultAuslagestapelModelFuellen();
                }
            }
        });

        this.amtspersonAusspielenButton.addActionListener(new AmtspersonListener(this.spielablauf, this.spielbrettPanel));

        this.routeWertenButton.addActionListener(new RouteWertenListener(this.spielablauf));

        this.naechsterSpielerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String meldung = SpielersteuerungPanel.this.spielablauf.naechsterSpieler();
                JOptionPane.showMessageDialog(null, meldung);
                spielersteuerungLabel.setText("Spieler " +
                        SpielersteuerungPanel.this.spielablauf.getIstDran().getFarbe().toString());
                spielersteuerungLabel.validate();
                spielersteuerungLabel.repaint();
                SpielersteuerungPanel.this.listenAktualisieren();

            }
        });

        this.add(buttonPanel);
        this.add(beides);

        this.setLayout(new GridLayout(1, 2));
        this.handPanel.setVisible(true);
        this.buttonPanel.setVisible(true);
        this.routenPanel.setVisible(true);
        this.beides.setVisible(true);
        this.setVisible(true);
    }

    private void listenAktualisieren(){
        this.defaultHandFuellen();
        this.defaultRouteFuellen();
    }

    /**
     * Hilfsmethode um die Hand neu zu fuellen bzw. zu aktualisieren
     */
    private void defaultHandFuellen() {
        this.defaultHandModel.clear();
        if (!spielablauf.getIstDran().getHand().isEmpty()) {
            for (Stadt it : spielablauf.getIstDran().getHand()) {
                defaultHandModel.addElement(it.toString());
            }
        }
    }

    /**
     * Hilfsmethode um die Route neu zu fuellen bzw. zu aktualisieren
     */
    private void defaultRouteFuellen() {
        this.defaultRouteModel.clear();
        if (!spielablauf.getIstDran().getRoute().isEmpty()) {
            this.defaultRouteModel.clear();
            for (Stadt it : spielablauf.getIstDran().getRoute()) {
                defaultRouteModel.addElement(it.toString());
            }
        }
    }

    /**
     * Sucht ein Stadt Objekt anhand einer uebergebenen String
     *
     * @param ausgewaehlteKarte die ausgewaehlte Karte als String
     * @return die ausgewaehlte karte als Stadt Objekt
     */
    private Stadt getStadtAnhandString(String ausgewaehlteKarte) {
        Stadt stadt = null;
        for (Stadt it : spielablauf.getIstDran().getHand()) {
            if (ausgewaehlteKarte.equals(it.toString())) {
                stadt = it;
            }
        }
        return stadt;
    }
}
