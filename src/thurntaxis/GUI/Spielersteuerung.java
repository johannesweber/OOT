package thurntaxis.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import thurntaxis.spiel.*;
/**
 * Created by Johannes on 04.01.14.
 */
public class Spielersteuerung extends JInternalFrame {
	Spielablauf spielablauf = new Spielablauf();
    JButton karteZiehen = new JButton("Karte ziehen");
    JButton karteAblegen = new JButton("Karte ablegen");
    JButton amtspersonAusspielen = new JButton("Amtsperson auspielen");
    JButton routeWerten = new JButton("Route werten");
    JButton rundeBeenden = new JButton("Runde beenden");
    JList hand = new JList(Spielablauf.spieler[0].getHand().toArray());
    JList route = new JList(Spielablauf.spieler[0].getRoute().toArray());
    JPanel buttonPanel = new JPanel();
    JPanel handPanel = new JPanel();

    public Spielersteuerung(Spielablauf spielablauf){
    	super ("Spieler" + Spielablauf.spieler[0].getFarbe().toString());
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
                Spielablauf.spieler[0].karteZiehen(2);
            }
        });

        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(handPanel, BorderLayout.EAST);
        this.setVisible(true);
    }
}
