/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author pierr
 */
public class adminGestion extends JPanel {

    private JLabel ID;
    private JLabel date;
    private JLabel semaine;
    private JLabel heureDebut;
    private JLabel nomCours;
    private JLabel typeCours;
    private JLabel salle;
    private JLabel groupe;
    private JLabel enseignant;
    private JButton supprimer;

    public adminGestion() {
        supprimer = new JButton();
        supprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(ID.getText());
            }
        });
    }
}
