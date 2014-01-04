package thurntaxis.thurntaxisGUI;

import thurntaxis.spieler.Spieler;
import thurntaxis.spieler.Spielerfarbe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Johannes on 03.01.14.
 */
public class Spielerauswahl implements ActionListener {

    int index = 0;
    public int ausgewaehlt = 0;
    private JFrame parent;

    public Spielerauswahl(JFrame parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        final JDialog spielerauswahl = new JDialog(parent, "Bitte zuerst Spieler auswählen", true);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        spielerauswahl.setLocationRelativeTo(parent);

        JButton fertig = new JButton("Fertig");
        final JButton gruen = new JButton("Spieler Grün");
        final JButton gelb = new JButton("Spieler Gelb");
        final JButton rot = new JButton("Spieler Rot");
        final JButton blau = new JButton("Spieler Blau");

        fertig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (ausgewaehlt >= 2){
                    spielerauswahl.setVisible(false);
                    ThurnTaxisGUI.start.setEnabled(true);
                    spielerauswahl.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Es müssen noch weitere Spieler ausgewählt werden.");
                }
            }
        });

        gruen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    ThurnTaxisGUI.spieler[index] = new Spieler(Spielerfarbe.GRUEN);
                    index++;
                    ausgewaehlt++;
                    gruen.setEnabled(false);
            }
        });

        gelb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    ThurnTaxisGUI.spieler[index] = new Spieler(Spielerfarbe.GELB);
                    index++;
                    ausgewaehlt++;
                    gelb.setEnabled(false);
            }
        });

        rot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    ThurnTaxisGUI.spieler[index] = new Spieler(Spielerfarbe.ROT);
                    index++;
                    ausgewaehlt++;
                    rot.setEnabled(false);
            }
        });

        blau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    ThurnTaxisGUI.spieler[index] = new Spieler(Spielerfarbe.BLAU);
                    index++;
                    ausgewaehlt++;
                    blau.setEnabled(false);
            }
        });

        panel1.add(fertig);
        panel2.add(gruen);
        panel2.add(gelb);
        panel2.add(rot);
        panel2.add(blau);

        spielerauswahl.add(panel1, BorderLayout.SOUTH);
        spielerauswahl.add(panel2, BorderLayout.NORTH);

        spielerauswahl.pack();
        spielerauswahl.setVisible(true);
    }
}
