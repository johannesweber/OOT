package thurntaxis.GUI.hauptschirm;

import thurntaxis.spiel.Land;
import thurntaxis.spiel.Spielleiter;
import thurntaxis.spiel.Spielkarte;
import thurntaxis.spiel.Stadt;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * Eine Klasse um das Spielbrett in einem Panel zu erstellen.
 * Das Spielbrett wird mit einem JTree erzeugt.
 */
class SpielbrettPanel extends JPanel {

    private Spielleiter spielablauf;
    private DefaultComboBoxModel defaultAuslagestapelComboBoxModel = new DefaultComboBoxModel();
    private JComboBox auslagestapelComboBox = new JComboBox(defaultAuslagestapelComboBoxModel);
    private JPanel spielbrettPanel = new JPanel();
    private JPanel auslagestapelPanel = new JPanel();
    private JLabel stapelLabel = new JLabel("Auslagestapel");

    public DefaultComboBoxModel getDefaultAuslagestapelComboBoxModel() {
        return this.defaultAuslagestapelComboBoxModel;
    }

    SpielbrettPanel(Spielleiter spielablauf) {
        this.spielablauf = spielablauf;

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

        JTree spielTree = new JTree(wurzel);
        this.defaultAuslagestapelModelFuellen();

        this.auslagestapelPanel.add(auslagestapelComboBox);
        this.auslagestapelPanel.add(stapelLabel);
        this.spielbrettPanel.add(new JScrollPane(spielTree));
        this.add(spielbrettPanel);
        this.add(auslagestapelPanel);

        this.setLayout(new GridLayout(2, 1));
        this.setVisible(true);
    }

    public void defaultAuslagestapelModelFuellen() {
        this.defaultAuslagestapelComboBoxModel.removeAllElements();
        for (Stadt it : this.spielablauf.getSpielbrett().getAuslagestapel().getAuslagestapel()) {
            this.defaultAuslagestapelComboBoxModel.addElement(it);
        }

    }
}
