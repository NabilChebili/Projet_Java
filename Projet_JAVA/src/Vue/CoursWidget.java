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
public final class CoursWidget extends JPanel {

    public JPanel pCours;
    private final JLabel lNomCours;
    private final JLabel lProf;
    private final Color cCours;

    public CoursWidget(String myLabel, String myProf, Color myColor, int sizeX, int sizeY, int x, int y, int gap) {
        this.pCours = new JPanel();
        this.pCours.setLayout(null);

        this.lNomCours = new JLabel(myLabel);
        this.lNomCours.setBounds( 0, 10, sizeX, sizeY / 2);

        this.lProf = new JLabel(myProf);
        this.lProf.setBounds( 0, sizeY / 2, sizeX/2, sizeY / 2);

        this.cCours = myColor;
        this.pCours.setBackground(myColor);

        this.pCours.setSize(CustomFrame.getSizeX(), CustomFrame.getSizeY());
        this.pCours.setLocation(x, y);
        
        setFontSizeMax(this.lNomCours);
        setFontSizeMax(this.lProf);

        this.pCours.add(this.lNomCours);
        this.pCours.add(this.lProf);
    }

    //Fonction pour set le font à la grandeur maximum pour prendre tout l'espace disponible
    // StackOverFLow: https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size
    public static void setFontSizeMax(JLabel label) {
        Font labelFont = label.getFont();
        String labelText = label.getText();

        int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = label.getWidth();

        // Find out how much the font can grow in width.
        double widthRatio = (double) componentWidth / (double) stringWidth;

        int newFontSize = (int) (labelFont.getSize() * widthRatio);
        int componentHeight = label.getHeight();

        // Pick a new font size so it will not be larger than the height of label.
        int fontSizeToUse = Math.min(newFontSize, componentHeight);

        // Set the label's font size to the newly determined size.
        label.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
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
