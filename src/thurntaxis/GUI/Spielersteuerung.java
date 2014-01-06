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

    DefaultListModel defaultHand = new DefaultListModel();
    JList handList = new JList(defaultHand);

    DefaultListModel defaultRoute = new DefaultListModel();
    JList routeList = new JList(defaultRoute);

    public void setSpielablauf(Spielablauf spielablauf) {
        this.spielablauf = spielablauf;
    }

    public Spielersteuerung(Spielablauf spielablauf){
        super ("Spielersteuerung");
        this.spielablauf = spielablauf;

        buttonPanel.add(karteZiehen);
        buttonPanel.add(karteAblegen);
        buttonPanel.add(amtspersonAusspielen);
        buttonPanel.add(routeWerten);
        buttonPanel.add(rundeBeenden);
        handPanel.add(handList);
        handPanel.add(routeList);

        karteZiehen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String karte = Spielersteuerung.this.spielablauf.spieler[0].karteZiehen(2);
                if(karte != null){
                    defaultHand.addElement(karte);
                }else{
                    JOptionPane.showMessageDialog(null, "Du darfst keine Karte mehr ziehen");
                }
            }
        });

        karteAblegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            }
        });

        handPanel.setVisible(true);
        buttonPanel.setVisible(true);
        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(handPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}
