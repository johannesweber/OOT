package thurntaxis.GUI;

import thurntaxis.spieler.Spieler;
import thurntaxis.spieler.Spielerfarbe;
import thurntaxis.spiel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasse SpielerauswahlListener welche vom Typ ActionListener ist. Dieser ActionListener generiert eineen
 * neuen JDialog, welcher aus 5 Buttons besteht. Mit diesen Buttons werden die Spieler fuer die naechste Partie
 * ausgewaehlt. Diese klasse tritt ihn Kraft wenn man den Button Spieler auswaehlen im Startmenue drueckt.
 */
class SpielerauswahlListener implements ActionListener {


    private int index = 0;
    private int ausgewaehlt = 0;
    private JFrame parent;
    private Spielablauf spielablauf;

    SpielerauswahlListener(StartmenueFrame startmenue, Spielablauf spielablauf) {
        this.parent = startmenue;
        this.spielablauf = spielablauf;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        final JDialog spielerauswahlDialog = new JDialog(parent, "Bitte Spieler waehlen", true);
        JPanel spielerButtonPanel = new JPanel();
        JPanel fertigButtonPanel = new JPanel();
        JButton fertigButton = new JButton("Fertig");
        final JButton gruenButton = new JButton("Spieler Gruen");
        final JButton gelbButton = new JButton("Spieler Gelb");
        final JButton rotButton = new JButton("Spieler Rot");
        final JButton blauButton = new JButton("Spieler Blau");

        fertigButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (ausgewaehlt >= 2) {
                    spielerauswahlDialog.setVisible(false);
                    StartmenueFrame.spielerauswahlButton.setEnabled(false);
                    spielerauswahlDialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Es muessen noch weitere Spieler ausgewaehlt werden.");
                }
            }
        });

        gruenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                spielablauf.spieler[index] = new Spieler(Spielerfarbe.GRUEN);
                index++;
                ausgewaehlt++;
                gruenButton.setEnabled(false);
            }
        });

        gelbButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                spielablauf.spieler[index] = new Spieler(Spielerfarbe.GELB);
                index++;
                ausgewaehlt++;
                gelbButton.setEnabled(false);
            }
        });

        rotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                spielablauf.spieler[index] = new Spieler(Spielerfarbe.ROT);
                index++;
                ausgewaehlt++;
                rotButton.setEnabled(false);
            }
        });

        blauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                spielablauf.spieler[index] = new Spieler(Spielerfarbe.BLAU);
                index++;
                ausgewaehlt++;
                blauButton.setEnabled(false);
            }
        });

        spielerauswahlDialog.setLocationRelativeTo(this.parent);
        spielerauswahlDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        spielerButtonPanel.add(fertigButton);
        fertigButtonPanel.add(gruenButton);
        fertigButtonPanel.add(gelbButton);
        fertigButtonPanel.add(rotButton);
        fertigButtonPanel.add(blauButton);

        spielerauswahlDialog.add(spielerButtonPanel, BorderLayout.SOUTH);
        spielerauswahlDialog.add(fertigButtonPanel, BorderLayout.NORTH);

        spielerauswahlDialog.pack();
        spielerauswahlDialog.setVisible(true);
    }
}
