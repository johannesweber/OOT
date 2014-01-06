package thurntaxis.GUI;

import thurntaxis.spiel.Land;
import thurntaxis.spiel.Spielablauf;
import thurntaxis.spiel.Spielkarte;
import thurntaxis.spiel.Stadt;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * Created by Johannes on 04.01.14.
 */
public class SpielbrettPanel extends JPanel {

    JPanel spielbrettPanel = new JPanel();
    JPanel auslagestapelPanel = new JPanel();
    JLabel stapelLabel = new JLabel("Auslagestapel");

    public SpielbrettPanel(Spielablauf spielablauf) {

        DefaultMutableTreeNode wurzel = new DefaultMutableTreeNode("Das Spielbrett");

        for (Land landIt : spielablauf.getSpielbrett().getLaender()) {
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
        JComboBox auslagestapel = new JComboBox(spielablauf.getSpielbrett().getAuslagestapel().getAuslagestapel());

        auslagestapelPanel.add(auslagestapel);
        auslagestapelPanel.add(stapelLabel);
        spielbrettPanel.add(new JScrollPane(baum));
        this.setLayout(new GridLayout(2, 1));
        this.add(spielbrettPanel);
        this.add(auslagestapelPanel);

        this.setVisible(true);
    }
}
