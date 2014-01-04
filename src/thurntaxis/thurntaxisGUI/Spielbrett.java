package thurntaxis.thurntaxisGUI;

import thurntaxis.spiel.Land;
import thurntaxis.spiel.Spiel;
import thurntaxis.spiel.Spielkarte;
import thurntaxis.spiel.Stadt;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Johannes on 03.01.14.
 */
public class Spielbrett implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        Spiel thurntaxis = new Spiel(ThurnTaxisGUI.spieler);
        JFrame spielbrett = new JFrame("Thurn & Taxis: Das Brettspiel");
        spielbrett.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        DefaultMutableTreeNode wurzel = new DefaultMutableTreeNode("Spielbrett");

        for (Land landIt : thurntaxis.getSpielbrett().getLaender()) {
            for (Stadt stadtIt : landIt.getStaedte()) {
                DefaultMutableTreeNode stadt = new DefaultMutableTreeNode(stadtIt.toString());
                wurzel.add(stadt);
                for (Spielkarte NachbarIt : stadtIt.getNachbarn()) {
                    DefaultMutableTreeNode nachbar = new DefaultMutableTreeNode(NachbarIt.toString());
                    stadt.add(nachbar);
                }
            }
        }

        JTree baum = new JTree(wurzel);
        spielbrett.add(new JScrollPane(baum));

        spielbrett.pack();
        spielbrett.setVisible(true);

        baum.getSelectionModel().addTreeSelectionListener(
                new TreeSelectionListener() {
                    @Override
                    public void valueChanged(TreeSelectionEvent e) {
                        TreePath pfad = e.getNewLeadSelectionPath();
                        System.out.println(pfad);
                    }
                });
    }
}
