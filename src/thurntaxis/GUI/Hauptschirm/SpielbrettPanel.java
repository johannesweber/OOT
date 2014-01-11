package thurntaxis.gui.hauptschirm;

import thurntaxis.spiel.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Gruppe 4 Fragezeichen
 *         <p/>
 *         Eine Klasse um das Spielbrett in einem Panel zu erstellen.
 *         Das Spielbrett wird mit einem JTree erzeugt. Unter dem Spielbrett ist der Auslagestapel
 *         mit Hilfer einer ComboBox dargestellt.
 */
class SpielbrettPanel extends JPanel {

    private Spielleiter spielleiter;
    protected SpielersteuerungPanel spielersteuerungPanel;

    private DefaultComboBoxModel defaultAuslagestapelComboBoxModel = new DefaultComboBoxModel();
    private JComboBox auslagestapelComboBox = new JComboBox(defaultAuslagestapelComboBoxModel);

    private JPanel auslagestapelPanel = new JPanel();
    private JLabel auslagestapelLabel = new JLabel("Auslagestapel");

    private JButton verdeckterStapelButton = new JButton("verdeckter Stapel");

    SpielbrettPanel(Spielleiter spielleiter) {
        this.spielleiter = spielleiter;

        this.auslagestapelPanel.add(verdeckterStapelButton);
        this.auslagestapelPanel.add(auslagestapelLabel);
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

        this.verdeckterStapelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Stadt ausgewaehlt = SpielbrettPanel.this.spielleiter.getSpielbrett().getAuslagestapel().
                        getDeck().pop();

                SpielbrettPanel.this.spielleiter.getIstDran().getHand().add(ausgewaehlt);
                SpielbrettPanel.this.spielleiter.getIstDran().zaehlerKartenZiehenVerringern();
                SpielbrettPanel.this.spielersteuerungPanel.listenAktualisieren();

            }
        });

        this.verdeckterStapelButton.setToolTipText("Damit ziehst du eine Karte aus dem verdeckten Stapel");

        this.add(new JScrollPane(spielTree));
        this.add(auslagestapelPanel);

        this.auslagestapelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
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
