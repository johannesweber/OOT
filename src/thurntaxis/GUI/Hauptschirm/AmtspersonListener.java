package thurntaxis.GUI.Hauptschirm;

import thurntaxis.amtsperson.Amtmann;
import thurntaxis.amtsperson.Postillion;
import thurntaxis.amtsperson.Postmeister;
import thurntaxis.spiel.Spiel;
import thurntaxis.spiel.Spielablauf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasse fuer einen ActionListener wenn man auf den Button Amtsperson ausspielen drueckt.
 */
class AmtspersonListener implements ActionListener {

    private Spielablauf spielablauf;
    private SpielbrettPanel spielbrettPanel;


    AmtspersonListener(Spielablauf spielablauf,SpielbrettPanel spielbrettPanel) {
        this.spielablauf = spielablauf;
        this.spielbrettPanel = spielbrettPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        final JDialog personAusspielenDialog = new JDialog();
        personAusspielenDialog.setTitle("Welche Amtsperson moechtest du ausspielen?");
        JButton postillionButton = new JButton("Postillion");
        JButton amtmannButton = new JButton("Amtmann");
        JButton postmeisterButton = new JButton("Postmeister");
        JPanel amtsPanel = new JPanel();

        personAusspielenDialog.setLocationRelativeTo(null);
        personAusspielenDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        postillionButton.setToolTipText("Der Postillion erlaubt es dir eine weitere Karte abzulegen.");
        amtmannButton.setToolTipText("Der Amtmann tauscht alle Karten auf dem Auslagestapel aus.");
        postmeisterButton.setToolTipText("Der Postmeister erlaubt es dir eine weitere Karte zu ziehen.");

        postillionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String meldung = spielablauf.getIstDran().amtspersonAusspielen(new Postillion());
                if (meldung != null) {
                    JOptionPane.showMessageDialog(null, meldung);
                }
                personAusspielenDialog.dispose();

            }
        });

        amtmannButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String meldung = spielablauf.getIstDran().amtspersonAusspielen(new Amtmann());
                AmtspersonListener.this.spielbrettPanel.defaultAuslagestapelModelFuellen();
                if (meldung != null) {
                    JOptionPane.showMessageDialog(null, meldung);
                }
                personAusspielenDialog.dispose();
            }
        });

        postmeisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String meldung = spielablauf.getIstDran().amtspersonAusspielen(new Postmeister());
                if (meldung != null) {
                    JOptionPane.showMessageDialog(null, meldung);
                }
                personAusspielenDialog.dispose();
            }
        });

        amtsPanel.add(postillionButton);
        amtsPanel.add(postmeisterButton);
        amtsPanel.add(amtmannButton);
        personAusspielenDialog.add(amtsPanel, BorderLayout.CENTER);
        personAusspielenDialog.pack();
        personAusspielenDialog.setVisible(true);

    }
}
