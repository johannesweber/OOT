package thurntaxis.gui.hauptschirm;

import javax.swing.*;

import thurntaxis.spiel.*;

/**
 * @author Gruppe 4 Fragezeichen
 *         <p/>
 *         Klasse um den hauptschirm vom Typ JFrame zu erstellen. der hauptschirm vereint 2 Panels in sich
 *         (Spielbrett und Spielersteuerung)
 */
public class HauptschirmFrame extends JFrame {

    public HauptschirmFrame(Spielleiter spielleiter) {
        super("Thurn & Taxis: Das Brettspiel");

        SpielbrettPanel spielbrettPanel = new SpielbrettPanel(spielleiter);
        SpielersteuerungPanel spielersteuerungPanel = new SpielersteuerungPanel(spielleiter, spielbrettPanel);

        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.add(spielersteuerungPanel);
        this.add(spielbrettPanel);

        this.setSize(800,600);
        this.setVisible(true);
    }

}
