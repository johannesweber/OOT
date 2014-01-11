package thurntaxis.gui.hauptschirm;

import thurntaxis.spiel.Spielleiter;
import thurntaxis.spiel.Stadt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Gruppe 4 Fragezeichen
 */
class PunktestandListener implements ActionListener {

    private Spielleiter spielleiter;

    private JDialog punktestandDialog = new JDialog();
    private JPanel gewerteteKartenPanel = new JPanel();

    PunktestandListener(Spielleiter spielleiter) {
        this.spielleiter = spielleiter;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        JLabel gewertetenKartenLabel = new JLabel("Deine bisher gewerteten Karten");

        JLabel bonuspunkteLabel = new JLabel("Punkte aller Bonusmarker: " +
                this.spielleiter.getIstDran().getBonuspunkte());
        JLabel haeuserpunkteLabel = new JLabel("Punkte fuer gebaute Haeuser: " +
                this.spielleiter.getIstDran().getHaeuserpunkte());

        DefaultListModel gewerteteKartenModel = new DefaultListModel();
        JList gewerteteKartenList = new JList(gewerteteKartenModel);

        for (Stadt it : this.spielleiter.getIstDran().getGewerteteKarten()) {
            gewerteteKartenModel.addElement(it);
        }

        gewerteteKartenList.revalidate();
        gewerteteKartenList.repaint();
        bonuspunkteLabel.validate();
        bonuspunkteLabel.repaint();
        haeuserpunkteLabel.validate();
        haeuserpunkteLabel.repaint();

        this.gewerteteKartenPanel.add(gewertetenKartenLabel);
        this.gewerteteKartenPanel.add(gewerteteKartenList);

        this.punktestandDialog.add(haeuserpunkteLabel);
        this.punktestandDialog.add(bonuspunkteLabel);
        this.punktestandDialog.add(this.gewerteteKartenPanel);

        bonuspunkteLabel.setHorizontalAlignment(JLabel.CENTER);
        bonuspunkteLabel.setVerticalAlignment(JLabel.CENTER);

        haeuserpunkteLabel.setHorizontalAlignment(JLabel.CENTER);
        haeuserpunkteLabel.setVerticalAlignment(JLabel.CENTER);

        gewerteteKartenList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        gewerteteKartenList.setPreferredSize(new Dimension(200, 100));

        this.punktestandDialog.setLocationRelativeTo(null);
        this.punktestandDialog.setLayout(new GridLayout(3, 1));
        this.punktestandDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.punktestandDialog.pack();
        this.punktestandDialog.setVisible(true);
    }
}

