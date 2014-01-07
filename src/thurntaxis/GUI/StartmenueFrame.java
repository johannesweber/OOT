package thurntaxis.GUI;

import thurntaxis.GUI.Hauptschirm.HauptschirmFrame;
import thurntaxis.spiel.*;
import thurntaxis.spieler.Spieler;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasse um das Startmenue zu realisieren. Das Startmenue besitzt 3 Buttons und wie jede andere Klasse
 * in der GUI auch einen Spielablauf.
 */
public class StartmenueFrame extends JFrame {

    private JButton startButton = new JButton("Spiel starten");
    private JButton fortsetzenButton = new JButton("Spiel fortsetzen");
    public static JButton spielerauswahlButton = new JButton("Spieler auswaehlen");
    private JButton spielregelnButton = new JButton("Spielregeln");
    private JButton beendenButton = new JButton("Programm beenden");
    private Spielablauf spielablauf;


    public StartmenueFrame(Spielablauf spielablauf) {
        super("Thurn & Taxis: Das Brettspiel");
        this.spielablauf = spielablauf;

        this.setLayout(new GridLayout(5, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int spieleranzahl = 0;
                for (Spieler it : StartmenueFrame.this.spielablauf.spieler) {
                    if (it != null) {
                        spieleranzahl++;
                    }
                }
                if (spieleranzahl != 0) {
                    StartmenueFrame.this.spielablauf.spielStarten();
                    StartmenueFrame.this.startButton.setEnabled(false);
                    StartmenueFrame.this.spielablauf.hauptschirm =
                            new HauptschirmFrame(StartmenueFrame.this.spielablauf);
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte zuerst Spieler auswaehlen");
                }
            }
        });

        this.spielerauswahlButton.addActionListener(
                new SpielerauswahlListener(this, this.spielablauf));
        beendenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StartmenueFrame.this.setVisible(false);
                StartmenueFrame.this.dispose();
            }
        });

        this.fortsetzenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (StartmenueFrame.this.spielablauf.hauptschirm != null) {
                    if (!StartmenueFrame.this.spielablauf.hauptschirm.isVisible()) {
                        StartmenueFrame.this.spielablauf.hauptschirm.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Es gibt nichts zum Fortsetzen!");
                }
            }
        });

        this.spielregelnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame spielregelFrame = new JFrame();
                ImageIcon bild = new ImageIcon("/Users/Johannes/Dropbox/IntelliJ/OOT/src/thurntaxis/GUI/spielregeln.jpg");
                JLabel spielregelLabel = new JLabel(bild);

                spielregelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                spielregelFrame.setVisible(true);
                spielregelFrame.add(spielregelLabel);
                spielregelFrame.pack();
            }
        });

        this.add(this.startButton);
        this.add(this.fortsetzenButton);
        this.add(StartmenueFrame.this.spielerauswahlButton);
        this.add(this.beendenButton);
        this.add(this.spielregelnButton);

        this.pack();

    }
}
