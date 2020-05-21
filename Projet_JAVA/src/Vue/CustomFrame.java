/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.*;
import java.util.*;

/**
 *
 * @author pierr
 */
public class CustomFrame extends JFrame{
    
    public static void main(String args[]) {
        new CustomFrame().setVisible(true);
    }
    
    public CustomFrame() {
        initEDT();
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
            System.out.println(((i*(255/6))/255));
            System.out.println(i);
        }
        
        /* JPanel pElem = new JPanel();
        pElem.setSize(300, 200);
        pElem.setLocation(500, 200);
        //pElem.setLocation(0,0);
        pElem.setBackground(Color.blue);
        pContent.add(pElem, 0); */
        
        fMain.add(pMenu);
        fMain.add(pContent);
    }
    
    private void initArray(ArrayList<JPanel> today, int x, int y, int gap, int nbColumn, Color color) {
        for (int i = 0; i < nbColumn; i++) {
            JPanel pElem = new JPanel();
            pElem.setSize(100, 80);
            pElem.setLocation(x, y  + (100 + gap)*i + gap*2);
            //pElem.setLocation(0,0);
            pElem.setBackground(color);
            
            today.add(pElem);
        }
    }
    
    private void linkArray(ArrayList<JPanel> from, JLayeredPane to) {
        for (int i = 0; i< from.size(); i++) {
            to.add(from.get(i), 2);
        }
    }
    
    private JFrame fMain;
    private JPanel pMenu;
    private JLayeredPane pContent;
}
