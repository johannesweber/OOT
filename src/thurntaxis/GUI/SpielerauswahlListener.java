package thurntaxis.GUI;

import thurntaxis.spieler.Spieler;
import thurntaxis.spieler.Spielerfarbe;
import thurntaxis.spiel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Johannes on 03.01.14.
 */
public class SpielerauswahlListener implements ActionListener {
	

    private int index = 0;
    private int ausgewaehlt = 0;
    private JFrame parent;
    private Spielablauf spielablauf;

    public SpielerauswahlListener(StartmenueFrame startmenue) {
        this.parent = startmenue;
        this.spielablauf = startmenue.spielablauf;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        final JDialog spielerauswahl = new JDialog(parent, "Bitte zuerst Spieler auswaehlen", true);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        spielerauswahl.setLocationRelativeTo((JFrame)parent);

        JButton fertig = new JButton("Fertig");
        final JButton gruen = new JButton("Spieler Gruen");
        final JButton gelb = new JButton("Spieler Gelb");
        final JButton rot = new JButton("Spieler Rot");
        final JButton blau = new JButton("Spieler Blau");

        fertig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (ausgewaehlt >= 2){
                    spielerauswahl.setVisible(false);
                    StartmenueFrame.start.setEnabled(true);
                    spielerauswahl.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Es muessen noch weitere Spieler ausgewaehlt werden.");
                }
            }
        });

        gruen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    spielablauf.spieler[index] = new Spieler(Spielerfarbe.GRUEN);
                    index++;
                    ausgewaehlt++;
                    gruen.setEnabled(false);
            }
        });

        gelb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	spielablauf.spieler[index] = new Spieler(Spielerfarbe.GELB);
                    index++;
                    ausgewaehlt++;
                    gelb.setEnabled(false);
            }
        });

        rot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	spielablauf.spieler[index] = new Spieler(Spielerfarbe.ROT);
                    index++;
                    ausgewaehlt++;
                    rot.setEnabled(false);
            }
        });

        blau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	spielablauf.spieler[index] = new Spieler(Spielerfarbe.BLAU);
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
