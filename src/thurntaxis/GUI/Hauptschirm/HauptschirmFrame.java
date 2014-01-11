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

    private SpielbrettPanel spielbrettPanel;
    private SpielersteuerungPanel spielersteuerungPanel;

    public HauptschirmFrame(Spielleiter spielleiter) {
        super("Thurn & Taxis: Das Brettspiel");

        this.spielbrettPanel = new SpielbrettPanel(spielleiter);
        this.spielersteuerungPanel = new SpielersteuerungPanel(spielleiter, this.spielbrettPanel);
        this.spielbrettPanel.spielersteuerungPanel = this.spielersteuerungPanel;

        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.add(spielersteuerungPanel);
        this.add(spielbrettPanel);

        this.setSize(800,600);
        this.setVisible(true);
    }

}
