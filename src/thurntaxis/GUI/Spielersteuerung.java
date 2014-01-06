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
    private Spielablauf spielablauf;

    JButton karteZiehen = new JButton("Karte ziehen");
    JButton karteAblegen = new JButton("Karte ablegen");
    JButton amtspersonAusspielen = new JButton("Amtsperson auspielen");
    JButton routeWerten = new JButton("Route werten");
    JButton rundeBeenden = new JButton("Runde beenden");

    JPanel buttonPanel = new JPanel();
    JPanel handPanel = new JPanel();

    JList hand;
    JList route;

    public Spielersteuerung(Spielablauf spielablauf){
        super ("Spielersteuerung");
        this.spielablauf = spielablauf;
        this.hand = new JList(spielablauf.spieler[0].getHand().toArray());
        this.route = new JList(spielablauf.spieler[0].getHand().toArray());

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
                Spielersteuerung.this.spielablauf.spieler[0].karteZiehen(2);
            }
        });

        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(handPanel, BorderLayout.EAST);
        this.setVisible(true);
    }
}
