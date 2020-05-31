/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.*;
import java.util.*;

/**
 *
 * @author pierr
 */
public class CustomFrame extends JFrame implements ActionListener {

    final private int height = 1000;
    final private int width = 1600;
    final private int menu = 400;
    final static private int sizeX = 175;
    final static private int sizeY = 100;

    public static void main(String args[]) {
        new CustomFrame().setVisible(true);
    }

    public CustomFrame() {
        initEDT();
    }
    
    public static int getSizeX() {
        return sizeX;
    }
    
    public static int getSizeY() {
        return sizeY;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Yes")) {
            System.out.println("Yes Button pressed!");
            toggleVisibility();
        } else if (action.equals("No")) {
            System.out.println("No Button pressed!");
            pSemaine.get(0).setVisible(false);
        }
    }

    private void initEDT() {

        fMain = new JFrame("ECE-Agenda");
        fMain.setSize(width, height);
        fMain.setLocation((1920 / 2) - (width / 2), (1080 / 2) - (height / 2));
        fMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fMain.setVisible(true);
        //fMain.setResizable(false);

        pMenu = new JPanel();
        pMenu.setSize(menu, height);
        pMenu.setLocation(0, 0);
        pMenu.setBackground(Color.BLACK);
        pContent = new JLayeredPane();
        pContent.setSize(width - menu, height);
        pContent.setLocation(menu, 0);
        pContent.setBackground(Color.WHITE);

        pSemaine = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
                   //(ArrayList<JPanel> today, int x, int y, int gap, int nbColumn, Color color, String myLabel)
            initArray(pSemaine, menu + 80 + (sizeX + 10) * i, 115, 5, 7, new Color(((i * (255 / 6))), 120, 220), "Bonjour");
            linkArray(pSemaine, pContent);
        }
        
        Grille tmp = new Grille(menu + 10, sizeY, Color.BLUE, sizeX);
        tmp.addPanel(pContent);

        JButton bYes = new JButton("Yes");
        JButton bNo = new JButton("No");
        bYes.addActionListener(this);
        bNo.addActionListener(this);
        
        /*for (int i = 0; i < 7; i++) {
            JPanel test = new JPanel();
            test.setLocation(menu +10, 10 + (sizeY + 5 * 4) * i + 100);
            test.setBackground(Color.BLACK);
            test.setSize(1200 , 5);
            pContent.add(test);
        }
        for (int i = 0; i < 8; i++) {
            JPanel test = new JPanel();
            test.setLocation(menu +15, 15 + sizeY + (sizeY + 5 * 4) * i + 100);
            test.setBackground(Color.BLACK);
            test.setSize(1200 , 5);
            pContent.add(test);
        }*/ 
        
        /*JLabel test = new JLabel("Bonjour");
        test.setBounds(menu + 20 ,10 , 500, 20);
        pContent.add(test);*/
        
        
        pMenu.add(bYes);
        pMenu.add(bNo);

        fMain.add(pMenu);
        fMain.add(pContent);

        fMain.repaint();
        fMain.revalidate();
    }

    private void initArray(ArrayList<JPanel> today, int x, int y, int gap, int nbColumn, Color color, String myLabel) {
        for (int i = 0; i < nbColumn; i++) {
            CoursWidget pElem = new CoursWidget(myLabel, color, sizeX, sizeY, x, y + (sizeY + gap*4) * i, gap);
            today.add(pElem.getCours());
        }
    }

    private void linkArray(ArrayList<JPanel> from, JLayeredPane to) {
        for (int i = 0; i < from.size(); i++) {
            to.add(from.get(i), 2);
        }
    }

    public void toggleVisibility() {
        if (pContent.isVisible()) {
            pContent.setVisible(false);
        } else {
            pContent.setVisible(true);
        }
    }

    private JFrame fMain;
    private JPanel pMenu;
    private JLayeredPane pContent;

    private ArrayList<JPanel> pSemaine;

    private JButton yes;
    private JButton no;
}


/*main () {
    vue maVue = new vue();
    model monModel = new model();
    controleur monControleur = new controleur();
}

class vue {
    private JPanel affichage;
    public void setCours(Liste Cours) {
        ... Modifie l'interface
    }
    
    private button;
    public clickButton() {
        Controleur.monControler.click();
    }

}

class model {
    public void seConnecter(nom, pwd) {
        ..requete database
                
        vue.setCours(Mes nouveaux cours);
    }
}

class controleur { 
    
    public click() {
        Model.monModel.seConnecter();
    }
}*/
