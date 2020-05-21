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
public class CustomFrame extends JFrame implements ActionListener{
    
    public static void main(String args[]) {
        new CustomFrame().setVisible(true);
    }
    
    public CustomFrame() {
        initEDT();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Yes")) {
            System.out.println("Yes Button pressed!");
            toggleVisibility();
        }
        else if (action.equals("No")) {
            System.out.println("No Button pressed!");
            pContent.add(new JLabel("test"));
        }
    }
    
    private void initEDT() {
        fMain = new JFrame();
        fMain.setSize(1200, 800);
        fMain.setLocation((1920/2) - (1200/2), (1080/2) - (800/2));
        fMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fMain.setVisible(true);
        
        pMenu = new JPanel();
        pMenu.setSize(400, 800);
        pMenu.setLocation(0, 0);
        pMenu.setBackground(Color.BLACK);
        pContent = new JLayeredPane();
        pContent.setSize(800, 800);
        pContent.setLocation(400, 0);
        pContent.setBackground(Color.WHITE);
        
        for (int i=0 ;i< 6; i++) {
            ArrayList<JPanel> jour = new ArrayList<JPanel>();
            initArray(jour, 410 + (100+20)*i, 0, 5, 7, new Color(((i*(255/6))),120,220));
            linkArray(jour, pContent);
        }
        
        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");
        yes.addActionListener(this);
        no.addActionListener(this);

        pMenu.add(yes);
        pMenu.add(no);
        
        fMain.add(pMenu);
        fMain.add(pContent);
    }
    
    private void initArray(ArrayList<JPanel> today, int x, int y, int gap, int nbColumn, Color color) {
        for (int i = 0; i < nbColumn; i++) {
            JPanel pElem = new JPanel();
            // TODO: Implement CoursWidget
            //CoursWidget pElem = new CoursWidget("Bonjour", Color.RED);
            pElem.setSize(100, 80);
            pElem.setLocation(x, y  + (100 + gap)*i + gap*2);
            //pElem.setLocation(0,0);
            pElem.setBackground(color);
            pElem.add(new JLabel("Comment tu vas mon chères amis, moi pour le moment ça va bien hamdoula"));
            pElem.add(new JLabel());
            today.add(pElem);
        }
    }
    
    private void linkArray(ArrayList<JPanel> from, JLayeredPane to) {
        for (int i = 0; i< from.size(); i++) {
            to.add(from.get(i), 2);
        }
    }
    
    public void toggleVisibility (){
        if (pContent.isVisible()) {
            pContent.setVisible(false);
        } else {
            pContent.setVisible(true);
        }
    }
    
    private JFrame fMain;
    private JPanel pMenu;
    private JLayeredPane pContent;
    
    private JButton yes;
    private JButton no;
}
