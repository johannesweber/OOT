package thurntaxis.gui.hauptschirm;

import thurntaxis.spiel.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Gruppe 4 Fragezeichen
 *         <p/>
 *         Klasse vom Typ JPanel, welche die verfuegbaren Buttons, die Hand und die Route des Spielers anzeigt.
 *         Der Spieler verfuegt insgesamt ueber 9 Buttons. die Buttons sind seperat in einem JPanel untergebracht.
 *         Die Listen fuer die Hand und die Route befinden sich ebenfalls in einem JPanel. Diese JPanel werden
 *         widerum in dem Hauptpanel untergebracht.
 */
class SpielersteuerungPanel extends JPanel {

    private Spielleiter spielleiter;
    private SpielbrettPanel spielbrettPanel;

    private JButton karteZiehenButton = new JButton("Karte ziehen");
    private JButton karteAblegenButton = new JButton("Karte ablegen");
    private JButton amtspersonAusspielenButton = new JButton("Amtsperson auspielen");
    private JButton routeWertenButton = new JButton("Route werten");
    private JButton naechsterSpielerButton = new JButton("naechster Spieler");
    private JButton landkarteButton = new JButton("Landkarte");
    private JButton punktestandButton = new JButton("Punktestand");

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

    private JDialog landkarteDialog = new JDialog();

    SpielersteuerungPanel(Spielleiter spielleiter, SpielbrettPanel spielbrettPanel) {
        this.spielleiter = spielleiter;
        this.spielbrettPanel = spielbrettPanel;

        this.spielersteuerungLabel = new JLabel("Spieler " +
                spielleiter.getIstDran().getFarbe().toString());

        this.buttonPanel.add(spielersteuerungLabel);
        this.buttonPanel.add(karteZiehenButton);
        this.buttonPanel.add(karteAblegenButton);
        this.buttonPanel.add(amtspersonAusspielenButton);
        this.buttonPanel.add(routeWertenButton);
        this.buttonPanel.add(landkarteButton);
        this.buttonPanel.add(punktestandButton);
        this.buttonPanel.add(naechsterSpielerButton);

        this.handPanel.add(deineHandLabel, BorderLayout.NORTH);
        this.handPanel.add(handList);

        this.routenPanel.add(deineRouteLabel,BorderLayout.NORTH);
        this.routenPanel.add(routeList);

        this.beides.add(handPanel);
        this.beides.add(routenPanel);

        this.add(buttonPanel);
        this.add(beides);

        this.handList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                karteAblegenButton.setEnabled(true);
            }
        });

        this.karteAblegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Object kartenObject = handList.getSelectedValue();
                if (kartenObject != null) {
                    Stadt ausgewaehlteKarte = getStadtAnhandString((String) kartenObject);
                    karteAblegenButton.setEnabled(false);
                    int meldung = SpielersteuerungPanel.this.spielleiter.getIstDran().karteAblegen
                            (ausgewaehlteKarte);

                    switch (meldung) {
                        case 1:
                            int eingabe0 = JOptionPane.showConfirmDialog(null, "Karte kann nicht gelegt werden." +
                                    "Keine direkte Verbindung. Willst du sie aus deiner Hand entfernen?", "Hinweis",
                                    JOptionPane.YES_NO_OPTION);
                            switch (eingabe0) {
                                case 0:
                                    SpielersteuerungPanel.this.spielleiter.getIstDran().getHand().
                                            remove(ausgewaehlteKarte);
                                    SpielersteuerungPanel.this.spielleiter.getIstDran().
                                            zaehlerKartenAblegenVerringern();
                                    SpielersteuerungPanel.this.listenAktualisieren();
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 2:
                            int eingabe1 = JOptionPane.showConfirmDialog(null,
                                    "Diese Karte ist schon in deiner Route enthalten!" +
                                            "Willst du sie aus deiner Hand entfernen?"
                                    , "Hinweis",
                                    JOptionPane.YES_NO_CANCEL_OPTION);
                            switch (eingabe1) {
                                case 0:
                                    SpielersteuerungPanel.this.spielleiter.getIstDran().getHand().
                                            remove(ausgewaehlteKarte);
                                    SpielersteuerungPanel.this.spielleiter.getIstDran().
                                            zaehlerKartenAblegenVerringern();
                                    SpielersteuerungPanel.this.listenAktualisieren();
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Du darfst keine Karte mehr ablegen.");
                            break;
                    }
                    SpielersteuerungPanel.this.listenAktualisieren();
                } else {
                    JOptionPane.showMessageDialog(null, "Du hast keine Karte ausgewaehlt");
                }
                SpielersteuerungPanel.this.handList.clearSelection();
            }
        });

        this.karteZiehenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (SpielersteuerungPanel.this.spielbrettPanel.
                        getDefaultAuslagestapelComboBoxModel().getSelectedItem() != null) {
                    int karte = SpielersteuerungPanel.this.spielbrettPanel.
                            getDefaultAuslagestapelComboBoxModel().
                            getIndexOf(SpielersteuerungPanel.this.spielbrettPanel.
                                    getDefaultAuslagestapelComboBoxModel().
                                    getSelectedItem());

                    String meldung = SpielersteuerungPanel.this.spielleiter.getIstDran().karteZiehen(karte);
                    if (meldung != null) {
                        JOptionPane.showMessageDialog(null, meldung);
                    } else {
                        SpielersteuerungPanel.this.defaultHandFuellen();
                        SpielersteuerungPanel.this.spielbrettPanel.defaultAuslagestapelModelFuellen();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Du hast keine Karte ausgewaehlt");
                }
            }
        });

        this.amtspersonAusspielenButton.addActionListener(new AmtspersonListener(this.spielleiter, this.spielbrettPanel));

        this.routeWertenButton.addActionListener(new RouteWertenListener(this.spielleiter, this));

        this.naechsterSpielerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String meldung = SpielersteuerungPanel.this.spielleiter.naechsterSpieler();
                JOptionPane.showMessageDialog(null, meldung);
                spielersteuerungLabel.setText("Spieler " +
                        SpielersteuerungPanel.this.spielleiter.getIstDran().getFarbe().toString());

                spielersteuerungLabel.validate();
                spielersteuerungLabel.repaint();

                SpielersteuerungPanel.this.listenAktualisieren();

            }
        });

        this.landkarteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                ImageIcon landkarte = new ImageIcon(getClass().getResource("landkarte.jpg"));

                JLabel landkarteLabel = new JLabel(landkarte);

                landkarteDialog.add(landkarteLabel);

                landkarteDialog.setLocationRelativeTo(SpielersteuerungPanel.this);
                landkarteDialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                landkarteDialog.setVisible(true);
                landkarteDialog.pack();
            }
        });

        this.punktestandButton.addActionListener(new PunktestandListener(this.spielleiter));

        this.karteZiehenButton.setToolTipText("Hiermit ziehst du eine Karte aus dem" +
                " Auslagestapel");
        this.karteAblegenButton.setToolTipText("Hiermit legst du eine Karte von deiner Hand in" +
                " deine Route");
        this.amtspersonAusspielenButton.setToolTipText("Mit diesem Button spielst du eine Amtsperson aus");
        this.routeWertenButton.setToolTipText("Wertet deine aktuelle Route und verteilt Bonusmarker" +
                " (falls gewonnen)");
        this.naechsterSpielerButton.setToolTipText("Zum naechsten Spieler wechseln");
        this.landkarteButton.setToolTipText("Zeigt die Landkarte des heiligen roemischen Reichs" +
                " deutscher Nation");
        this.punktestandButton.setToolTipText("Zeigt dir deinen aktuellen Punktestand an");

        this.handList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.landkarteDialog.setVisible(false);

        this.spielersteuerungLabel.setHorizontalAlignment(JLabel.CENTER);

        this.buttonPanel.setLayout(new GridLayout(8, 1));
        this.buttonPanel.setVisible(true);

        this.handPanel.setVisible(true);
        this.routenPanel.setVisible(true);

        this.beides.setLayout(new GridLayout(2,1));
        this.beides.setVisible(true);

        this.setLayout(new GridLayout(1, 2));
        this.setVisible(true);
    }


    /**
     * Methode welche mit Hilfe der privaten Methoden defaultHandFuellen() und defaultRouteFuellen() die Hand
     * und die Route des Spielers aktualisiert.
     */
    protected void listenAktualisieren() {
        this.defaultHandFuellen();
        this.defaultRouteFuellen();
    }

    /**
     * Hilfsmethode um die Hand neu zu fuellen bzw. zu aktualisieren
     */
    private void defaultHandFuellen() {
        this.defaultHandModel.clear();
        if (!spielleiter.getIstDran().getHand().isEmpty()) {
            for (Stadt it : spielleiter.getIstDran().getHand()) {
                defaultHandModel.addElement(it.toString());
            }
        }
    }

    /**
     * Hilfsmethode um die Route neu zu fuellen bzw. zu aktualisieren
     */
    private void defaultRouteFuellen() {
        this.defaultRouteModel.clear();
        if (!this.spielleiter.getIstDran().getRoute().isEmpty()) {
            this.defaultRouteModel.clear();
            for (Stadt it : this.spielleiter.getIstDran().getRoute()) {
                this.defaultRouteModel.addElement(it.toString());
            }
        }
    }

    /**
     * Sucht ein Stadt Objekt anhand einem uebergebenen String
     *
     * @param ausgewaehlteKarte die ausgewaehlte Karte als String
     * @return die ausgewaehlte karte als Stadt Objekt
     */
    private Stadt getStadtAnhandString(String ausgewaehlteKarte) {
        Stadt stadt = null;
        for (Stadt it : this.spielleiter.getIstDran().getHand()) {
            if (ausgewaehlteKarte.equals(it.toString())) {
                stadt = it;
            }
        }
        return stadt;
    }
}
