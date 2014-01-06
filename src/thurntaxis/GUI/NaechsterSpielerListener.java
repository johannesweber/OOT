package thurntaxis.GUI;

import thurntaxis.spiel.Spielablauf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Johannes on 06.01.14.
 */
public class NaechsterSpielerListener implements ActionListener {

    private static Spielablauf spielablauf;

    public NaechsterSpielerListener(Spielablauf ablauf){
        this.spielablauf = ablauf;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String meldung = NaechsterSpielerListener.this.spielablauf.naechsteRunde();
        JOptionPane.showMessageDialog(null, meldung);
        new SpielersteuerungPanel(NaechsterSpielerListener.spielablauf.spieler[NaechsterSpielerListener.spielablauf.getIstDran()], NaechsterSpielerListener.spielablauf);
    }
}
