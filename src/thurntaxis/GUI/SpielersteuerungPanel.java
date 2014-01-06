package thurntaxis.GUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import thurntaxis.spiel.*;
import thurntaxis.spieler.Spieler;

/**
 * Created by Johannes on 04.01.14.
 */
public class SpielersteuerungPanel extends JPanel {

    private static Spielablauf spielablauf;
    private static Spieler spieler;

    JButton karteZiehen = new JButton("Karte ziehen");
    JButton karteAblegen = new JButton("Karte ablegen");
    JButton amtspersonAusspielen = new JButton("Amtsperson auspielen");
    JButton routeWerten = new JButton("Route werten");
    JButton naechsterSpieler = new JButton("naechster Spieler");

    JPanel buttonPanel = new JPanel();
    JPanel handPanel = new JPanel();
    JPanel routenPanel = new JPanel();
    JPanel beides = new JPanel();

    JLabel spielersteuerung;
    JLabel deineRoute = new JLabel("Deine Route");
    JLabel deineHand = new JLabel("Deine Hand");

    DefaultListModel defaultRoute = new DefaultListModel();
    JList routeList = new JList(defaultRoute);

    DefaultListModel defaultHand = new DefaultListModel();
    JList handList = new JList(defaultHand);

    public SpielersteuerungPanel(Spieler spieler, Spielablauf spielablauf) {
        this.spielablauf = spielablauf;
        this.spieler = spieler;
        spielersteuerung = new JLabel("Spieler " + spielablauf.spieler[spielablauf.getIstDran()].getFarbe().toString());
        karteAblegen.setEnabled(false);

        buttonPanel.setLayout(new GridLayout(6, 1));
        spielersteuerung.setHorizontalAlignment(JLabel.CENTER);
        buttonPanel.add(spielersteuerung);
        buttonPanel.add(karteZiehen);
        buttonPanel.add(karteAblegen);
        buttonPanel.add(amtspersonAusspielen);
        buttonPanel.add(routeWerten);
        buttonPanel.add(naechsterSpieler);

        handList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        handList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                karteAblegen.setEnabled(true);
            }
        });

        handPanel.add(deineHand);
        handPanel.add(handList);

        routenPanel.add(deineRoute);
        routenPanel.add(routeList);

        beides.setLayout(new GridLayout(2, 1));
        beides.add(handPanel);
        beides.add(routenPanel);

        karteAblegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String ausgewaehlteKarte = defaultHand.get(handList.getSelectedIndex()).toString();
                handList.clearSelection();
                karteAblegen.setEnabled(false);
                String meldung = SpielersteuerungPanel.this.spielablauf.spieler[SpielersteuerungPanel.this.spielablauf.getIstDran()].karteAblegen
                        (SpielersteuerungPanel.this.getStadtAnhandString(ausgewaehlteKarte));
                if (meldung != null) {
                    JOptionPane.showMessageDialog(null, meldung);
                }
                SpielersteuerungPanel.this.defaultRouteFuellen();
                SpielersteuerungPanel.this.defaultHandFuellen();

            }
        });

        karteZiehen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String meldung = SpielersteuerungPanel.this.spielablauf.spieler[SpielersteuerungPanel.this.spielablauf.getIstDran()].karteZiehen(1);
                if (meldung != null) {
                    JOptionPane.showMessageDialog(null, meldung);
                } else {
                    SpielersteuerungPanel.this.defaultHandFuellen();
                }
            }
        });

        amtspersonAusspielen.addActionListener(new AmtspersonListener(this.spielablauf));

        routeWerten.addActionListener(new RouteWertenListener(this.spielablauf));

        naechsterSpieler.addActionListener(new NaechsterSpielerListener(this.spielablauf));


        this.setLayout(new GridLayout(1, 2));
        handPanel.setVisible(true);
        buttonPanel.setVisible(true);
        routenPanel.setVisible(true);
        beides.setVisible(true);
        this.add(buttonPanel);
        this.add(beides);
        this.setVisible(true);
    }

    private void defaultHandFuellen() {
        this.defaultHand.clear();
        if (!spielablauf.spieler[spielablauf.getIstDran()].getHand().isEmpty()) {
            for (Stadt it : spielablauf.spieler[spielablauf.getIstDran()].getHand()) {
                defaultHand.addElement(it.toString());
            }
        }
    }

    private void defaultRouteFuellen() {
        this.defaultRoute.clear();
        if (!spielablauf.spieler[spielablauf.getIstDran()].getRoute().isEmpty()) {
            this.defaultRoute.clear();
            for (Stadt it : spielablauf.spieler[spielablauf.getIstDran()].getRoute()) {
                defaultRoute.addElement(it.toString());
            }
        }
    }

    private Stadt getStadtAnhandString(String ausgewaehlteKarte) {
        Stadt stadt = null;
        for (Stadt it : spielablauf.spieler[spielablauf.getIstDran()].getHand()) {
            if (ausgewaehlteKarte.equals(it.toString())) {
                stadt = it;
            }
        }
        return stadt;
    }
}
