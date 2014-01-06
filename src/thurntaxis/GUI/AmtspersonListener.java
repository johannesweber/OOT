package thurntaxis.GUI;

import thurntaxis.amtsperson.Amtmann;
import thurntaxis.amtsperson.Postillion;
import thurntaxis.amtsperson.Postmeister;
import thurntaxis.spiel.Spielablauf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Johannes on 06.01.14.
 */
public class AmtspersonListener implements ActionListener {

    private Spielablauf spielablauf;


    public AmtspersonListener(Spielablauf spielablauf){
        this.spielablauf = spielablauf;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        final JDialog personAusspielen = new JDialog();
        personAusspielen.setTitle("Welche Amtsperson moechtest du ausspielen?");
        JButton postillion = new JButton("Postillion");
        JButton amtmann = new JButton("Amtmann");
        JButton postmeister = new JButton("Postmeister");

        JPanel amtsPanel = new JPanel();

        postillion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String meldung = spielablauf.spieler[spielablauf.getIstDran()].amtspersonAusspielen(new Postillion());
                if(meldung != null){
                    JOptionPane.showMessageDialog(null, meldung);
                }
                personAusspielen.dispose();

            }
        });

        amtmann.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String meldung = spielablauf.spieler[spielablauf.getIstDran()].amtspersonAusspielen(new Amtmann());
                if(meldung != null){
                    JOptionPane.showMessageDialog(null, meldung);
                }
                personAusspielen.dispose();
            }
        });

        postmeister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String meldung = spielablauf.spieler[spielablauf.getIstDran()].amtspersonAusspielen(new Postmeister());
                if(meldung != null){
                    JOptionPane.showMessageDialog(null, meldung);
                }
                personAusspielen.dispose();
            }
        });


        amtsPanel.add(postillion);
        amtsPanel.add(postmeister);
        amtsPanel.add(amtmann);
        personAusspielen.add(amtsPanel, BorderLayout.CENTER);
        personAusspielen.pack();
        personAusspielen.setVisible(true);

    }
}
