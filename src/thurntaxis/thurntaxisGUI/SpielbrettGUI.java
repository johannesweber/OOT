package thurntaxis.thurntaxisGUI;

import thurntaxis.spiel.Land;
import thurntaxis.spiel.Spiel;
import thurntaxis.spiel.Spielkarte;
import thurntaxis.spiel.Stadt;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * Created by Johannes on 04.01.14.
 */
public class SpielbrettGUI extends JInternalFrame {

    JPanel spielbrettPanel = new JPanel();
    JPanel auslagestapelPanel = new JPanel();
    JLabel stapelLabel = new JLabel("Auslagestapel");
    static Spiel thurntaxis = new Spiel(HauptmenueGUI.spieler);

    public SpielbrettGUI() {
        super("Das Spielbrett");
        thurntaxis.spielStarten();

        DefaultMutableTreeNode wurzel = new DefaultMutableTreeNode("Die Städte");

        for (Land landIt : thurntaxis.getSpielbrett().getLaender()) {
            for (Stadt stadtIt : landIt.getStaedte()) {
                DefaultMutableTreeNode stadt = new DefaultMutableTreeNode(stadtIt.toString());
                wurzel.add(stadt);
                for (Spielkarte NachbarIt : stadtIt.getNachbarn()) {
                    DefaultMutableTreeNode nachbar = new DefaultMutableTreeNode(NachbarIt.toString());
                    stadt.add(nachbar);
                }
            }
        }

        JTree baum = new JTree(wurzel);
        JComboBox auslagestapel = new JComboBox(thurntaxis.getSpielbrett().getAuslagestapel().getAuslagestapel());

        auslagestapelPanel.add(auslagestapel);
        auslagestapelPanel.add(stapelLabel);
        spielbrettPanel.add(new JScrollPane(baum));
        this.add(spielbrettPanel, BorderLayout.CENTER);
        this.add(auslagestapelPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
