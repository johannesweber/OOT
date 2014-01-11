package thurntaxis.gui;

import thurntaxis.gui.hauptschirm.HauptschirmFrame;
import thurntaxis.spiel.*;
import thurntaxis.spieler.Spieler;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 4 Fragezeichen
 *         <p/>
 *         Klasse um das Startmenue zu realisieren. Das Startmenue besitzt 3 Buttons und wie jede andere Klasse
 *         in der GUI auch einen Spielleiter um ueber diesen alles zu steuern.
 */
public class StartmenueFrame extends JFrame {

    private Spielleiter spielleiter;

    private JButton startButton = new JButton("Spiel starten");
    private JButton fortsetzenButton = new JButton("Spiel fortsetzen");
    public static JButton spielerauswahlButton = new JButton("Spieler auswaehlen");
    private JButton spielablaufButton = new JButton("Spielablauf");
    private JButton beendenButton = new JButton("Programm beenden");
    private JPanel wappenPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();

    public StartmenueFrame(Spielleiter spielablauf) {
        super("Thurn & Taxis: Das Brettspiel");
        this.spielleiter = spielablauf;

        ImageIcon wappen = new ImageIcon(getClass().getResource("startbild.jpg"));
        JLabel wappenLabel = new JLabel(wappen);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int spieleranzahl = 0;
                for (Spieler it : StartmenueFrame.this.spielleiter.spieler) {
                    if (it != null) {
                        spieleranzahl++;
                    }
                }
                if (spieleranzahl >= 2) {
                    StartmenueFrame.this.spielleiter.spielStarten();
                    StartmenueFrame.this.startButton.setEnabled(false);
                    StartmenueFrame.this.spielleiter.hauptschirm =
                            new HauptschirmFrame(StartmenueFrame.this.spielleiter);
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte zuerst Spieler auswaehlen");
                }
            }
        });

        this.spielerauswahlButton.addActionListener(
                new SpielerauswahlListener(this, this.spielleiter));

        beendenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StartmenueFrame.this.setVisible(false);
                System.exit(0);
            }
        });

        this.fortsetzenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (StartmenueFrame.this.spielleiter.hauptschirm != null) {
                    if (!StartmenueFrame.this.spielleiter.hauptschirm.isVisible()) {
                        StartmenueFrame.this.spielleiter.hauptschirm.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Es gibt nichts zum Fortsetzen!");
                }
            }
        });

        this.spielablaufButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog spielablaufDialog = new JDialog();

                ImageIcon spielablauf = new ImageIcon(getClass().getResource("spielablauf.jpg"));

                JLabel spielablaufLabel = new JLabel(spielablauf);

                spielablaufDialog.add(spielablaufLabel);

                spielablaufDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                spielablaufDialog.setVisible(true);
                spielablaufDialog.pack();
            }
        });


        this.startButton.setToolTipText("Spiel starten");
        this.fortsetzenButton.setToolTipText("Spiel fortsetzen");
        this.spielablaufButton.setToolTipText("Ein kleiner Ueberblick des Spielablaufs");
        this.beendenButton.setToolTipText("Willst du das wirklich?");
        this.spielerauswahlButton.setToolTipText("Spieler auswaehlen");

        this.wappenPanel.add(wappenLabel);
        this.buttonPanel.add(this.startButton);
        this.buttonPanel.add(this.fortsetzenButton);
        this.buttonPanel.add(StartmenueFrame.this.spielerauswahlButton);
        this.buttonPanel.add(this.beendenButton);
        this.buttonPanel.add(this.spielablaufButton);

        this.buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        this.add(wappenPanel, BorderLayout.WEST);
        this.add(buttonPanel, BorderLayout.CENTER);

        this.pack();

    }
}
