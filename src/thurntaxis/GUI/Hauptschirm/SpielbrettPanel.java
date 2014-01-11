package thurntaxis.gui.hauptschirm;

import thurntaxis.spiel.Land;
import thurntaxis.spiel.Spielleiter;
import thurntaxis.spiel.Spielkarte;
import thurntaxis.spiel.Stadt;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * @author Gruppe 4 Fragezeichen
 *         <p/>
 *         Eine Klasse um das Spielbrett in einem Panel zu erstellen.
 *         Das Spielbrett wird mit einem JTree erzeugt. Unter dem Spielbrett ist der Auslagestapel
 *         mit Hilfer einer ComboBox dargestellt.
 */
class SpielbrettPanel extends JPanel {

    private Spielleiter spielleiter;

    private DefaultComboBoxModel defaultAuslagestapelComboBoxModel = new DefaultComboBoxModel();
    private JComboBox auslagestapelComboBox = new JComboBox(defaultAuslagestapelComboBoxModel);

    private JPanel auslagestapelPanel = new JPanel();
    private JLabel stapelLabel = new JLabel("Auslagestapel");
    private JSeparator seperator = new JSeparator(SwingConstants.HORIZONTAL);

    SpielbrettPanel(Spielleiter spielleiter) {
        this.spielleiter = spielleiter;

        this.auslagestapelPanel.add(auslagestapelComboBox);
        this.defaultAuslagestapelModelFuellen();

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

        this.auslagestapelPanel.add(stapelLabel);
        this.add(new JScrollPane(spielTree));
        this.seperator.setPreferredSize(new Dimension(1, 1));
        this.add(auslagestapelPanel);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
    }

    public void defaultAuslagestapelModelFuellen() {
        this.defaultAuslagestapelComboBoxModel.removeAllElements();
        for (Stadt it : this.spielleiter.getSpielbrett().getAuslagestapel().getAuslagestapel()) {
            this.defaultAuslagestapelComboBoxModel.addElement(it);
        }
    }

    public DefaultComboBoxModel getDefaultAuslagestapelComboBoxModel() {
        return this.defaultAuslagestapelComboBoxModel;
    }
}
