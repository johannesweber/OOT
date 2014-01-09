package thurntaxis.gui.hauptschirm;

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

    private Spielleiter spielleiter;

    private DefaultComboBoxModel defaultAuslagestapelComboBoxModel = new DefaultComboBoxModel();
    private JComboBox auslagestapelComboBox = new JComboBox(defaultAuslagestapelComboBoxModel);

    private JPanel auslagestapelPanel = new JPanel();
    private JLabel stapelLabel = new JLabel("Auslagestapel");
    JSeparator seperator = new JSeparator(SwingConstants.HORIZONTAL);

    public DefaultComboBoxModel getDefaultAuslagestapelComboBoxModel() {
        return this.defaultAuslagestapelComboBoxModel;
    }

    public void defaultAuslagestapelModelFuellen() {
        this.defaultAuslagestapelComboBoxModel.removeAllElements();
        for (Stadt it : this.spielleiter.getSpielbrett().getAuslagestapel().getAuslagestapel()) {
            this.defaultAuslagestapelComboBoxModel.addElement(it);
        }
    }

    SpielbrettPanel(Spielleiter spielleiter) {
        this.spielleiter = spielleiter;

        DefaultMutableTreeNode wurzel = new DefaultMutableTreeNode("Das Spielbrett");

        for (Land landIt : spielleiter.getSpielbrett().getLaender()) {
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
        this.add(new JScrollPane(spielTree));
        seperator.setPreferredSize(new Dimension(1,1));
        this.add(seperator);
        this.add(auslagestapelPanel);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
    }
}
