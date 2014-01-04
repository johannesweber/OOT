package thurntaxis.thurntaxisGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Johannes on 03.01.14.
 */
public class HauptschirmGUI implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        HauptmenueGUI.spielerauswahl.setEnabled(false);
        HauptmenueGUI.start.setEnabled(false);

        JFrame hauptschirm = new JFrame("Thurn & Taxis: Das Brettspiel");
        SpielersteuerungGUI spielersteuerung = new SpielersteuerungGUI();
        SpielbrettGUI spielbrett = new SpielbrettGUI();

        hauptschirm.add(spielersteuerung, BorderLayout.EAST);
        hauptschirm.add(spielbrett, BorderLayout.CENTER);

        hauptschirm.pack();
        hauptschirm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hauptschirm.setVisible(true);


    }
}
