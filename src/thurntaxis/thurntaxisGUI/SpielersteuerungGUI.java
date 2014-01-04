package thurntaxis.thurntaxisGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Johannes on 04.01.14.
 */
public class SpielersteuerungGUI extends JInternalFrame {

    JButton karteZiehen = new JButton("Karte ziehen");
    JButton karteAblegen = new JButton("Karte ablegen");
    JButton amtspersonAusspielen = new JButton("Amtsperson auspielen");
    JButton routeWerten = new JButton("Route werten");
    JButton rundeBeenden = new JButton("Runde beenden");
    JList hand = new JList(HauptmenueGUI.spieler[0].getHand().toArray());
    JList route = new JList(HauptmenueGUI.spieler[0].getRoute().toArray());
    JPanel buttonPanel = new JPanel();
    JPanel handPanel = new JPanel();

    public SpielersteuerungGUI(){
        super ("Spieler" + HauptmenueGUI.spieler[0].getFarbe().toString());
        buttonPanel.add(karteZiehen);
        buttonPanel.add(karteAblegen);
        buttonPanel.add(amtspersonAusspielen);
        buttonPanel.add(routeWerten);
        buttonPanel.add(rundeBeenden);
        handPanel.add(hand);
        handPanel.add(route);

        karteZiehen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                HauptmenueGUI.spieler[0].karteZiehen(2);
            }
        });

        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(handPanel, BorderLayout.EAST);
        this.setVisible(true);
    }
}
