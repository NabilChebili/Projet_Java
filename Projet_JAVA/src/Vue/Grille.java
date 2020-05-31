/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author pierr
 */
public final class Grille extends JPanel {

    final private ArrayList<JPanel> panel;
    final private ArrayList<JLabel> label;

    public Grille(int x, int y, Color color, int sizeX) {

        panel = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            JPanel test = new JPanel();
            test.setLocation(x, 13 + (y + 5 * 4) * i + 100);
            test.setBackground(color);
            test.setSize(1200, 2);
            panel.add(test);
        }
        for (int i = 0; i < 8; i++) {
            JPanel test = new JPanel();
            test.setLocation(x, 15 + y + (y + 5 * 4) * i + 100);
            test.setBackground(color);
            test.setSize(1200, 2);
            panel.add(test);
        }

        label = new ArrayList<>();
        for (int i = 1; i < 16; i+=2) {
            JLabel test = new JLabel(staticHeure(i));
            test.setBounds(x, 13 + (y + 5 * 4) * ((i-1)/2) + 100 + 3, 50 ,10);
            label.add(test);
        }
        for (int i = 2; i < 15; i+=2) {
            JLabel test = new JLabel(staticHeure(i));
            test.setBounds(x, 15 + y + (y + 5 * 4) * ((i-1)/2) + 100 - 12, 50 ,10);
            label.add(test);
        }
        for (int i = 1 ; i < 7 ; i++) {
            JLabel test = new JLabel(staticNom(i));
            test.setBounds(x - 100 + (sizeX + 10) * i, 100, 80 ,10);
            label.add(test);
            
        }
    }

    public void addPanel(JLayeredPane input) {
        for (int i = 0; i < this.panel.size(); i++) {
            input.add(panel.get(i));
        }
        for (int i = 0; i < this.label.size(); i++) {
            input.add(label.get(i));
        }
    }

    public String staticNom(int i) {
        switch (i) {
            case 1:
                return "Lundi";
            case 2:
                return "Mardi";
            case 3:
                return "Mercredi";
            case 4:
                return "Jeudi";
            case 5:
                return "Vendredi";
            case 6:
                return "Samedi";

        }
        return "Error static nom";
    }

    public String staticHeure(int i) {
        switch (i) {
            case 1:
                return "8H30";
            case 2:
                return "10H00";
            case 3:
                return "10H15";
            case 4:
                return "11H45";
            case 5:
                return "12H00";
            case 6:
                return "13H30";
            case 7:
                return "13H45";
            case 8:
                return "15H15";
            case 9:
                return "15H30";
            case 10:
                return "17H00";
            case 11:
                return "17H15";
            case 12:
                return "18H45";
            case 13:
                return "19H";
            case 14:
                return "20H30";

        }
        return "Error static Heure";
    }

}
