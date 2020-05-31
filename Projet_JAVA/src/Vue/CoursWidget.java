/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author pierr
 */
public class CoursWidget extends JPanel{
    public JPanel pCours;
    private final JLabel lNomCours;
    private final Color cCours;
    
    public CoursWidget(String myLabel, Color myColor,int sizeX, int sizeY, int x, int y, int gap) {
        this.pCours = new JPanel();
        this.pCours.setLayout(null);
        
        this.lNomCours = new JLabel(myLabel);
        this.lNomCours.setBounds(25,5,50,10);
        
        this.cCours = myColor;
        this.pCours.setBackground(myColor);
        
        this.pCours.setSize(CustomFrame.getSizeX(), CustomFrame.getSizeY());
        this.pCours.setLocation(x, y);

        this.pCours.add(this.lNomCours);
    }
    
    public void setNomCours(String newLabel) {
        this.lNomCours.setText(newLabel);
        
        this.pCours.repaint();
        this.pCours.revalidate();
    }
    
    public JPanel getCours() {
        return this.pCours;
    }
}
