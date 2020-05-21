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
public class CoursWidget{
    public JPanel pCours;
    public JLabel lNomCours;
    
    public CoursWidget() {
        pCours = new JPanel();
        pCours.setBackground(Color.BLUE);
        
        lNomCours = new JLabel("Yes life");
        pCours.add(lNomCours);
    }

}
