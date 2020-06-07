/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import static Vue.CoursWidget.setFontSizeMax;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author pierr
 */
public class adminGestion extends JPanel {

    public JPanel ligne;

    private JLabel ID;
    private JLabel date;
    private JLabel semaine;
    private JLabel heureDebut;
    private JLabel nomCours;
    private JLabel typeCours;
    private JLabel salle;
    private JLabel groupe;
    private JLabel enseignant;
    private JLabel etat;

    public adminGestion(int x, int y, String idS, String dateS, String semaineS, String heureDebutS, String nomCoursS, String typeCoursS, String salleS, String groupeS, String enseignantS, String etatS) {

        Color gris = Color.decode("#303a52");
        Color grisFonce = Color.decode("#202a42");
        Color blanc = Color.decode("#e2f3f5");
        Color bleu = Color.decode("#1f4287");

        this.ligne = new JPanel();
        this.ligne.setLayout(null);
        
        this.ligne.setBackground(gris);
        this.ligne.setSize(1200-50, 60);
        this.ligne.setLocation(x ,y);
        
        this.ID = new JLabel(idS);
        this.ID.setBounds( 5, 10, 100, 40);
        setFontSizeMax(this.ID);
        ID.setForeground(blanc);
        
        this.date = new JLabel(dateS);
        this.date.setBounds( 5  , 10, 100, 40);
        setFontSizeMax(this.date);
        date.setForeground(blanc);
        
        this.semaine = new JLabel(semaineS);
        this.semaine.setBounds( 5 , 10, 100, 40);
        setFontSizeMax(this.semaine);
        semaine.setForeground(blanc);
        
        this.heureDebut = new JLabel(heureDebutS);
        this.heureDebut.setBounds( 5, 10, 100, 40);
        setFontSizeMax(this.heureDebut);
        heureDebut.setForeground(blanc);
        
        this.nomCours = new JLabel(nomCoursS);
        this.nomCours.setBounds( 5, 10, 100, 40);
        setFontSizeMax(this.nomCours);
        nomCours.setForeground(blanc);
        
        this.typeCours = new JLabel(typeCoursS);
        this.typeCours.setBounds( 5, 10, 100, 40);
        setFontSizeMax(this.typeCours);
        typeCours.setForeground(blanc);
        
        this.salle = new JLabel(salleS);
        this.salle.setBounds( 5 0, 10, 100, 40);
        setFontSizeMax(this.salle);
        salle.setForeground(blanc);
        
        this.groupe = new JLabel(groupeS);
        this.groupe.setBounds( 5 , 10, 100, 40);
        setFontSizeMax(this.groupe);
        groupe.setForeground(blanc);
        
        this.enseignant = new JLabel(enseignantS);
        this.enseignant.setBounds( 5 , 10, 100, 40);
        setFontSizeMax(this.enseignant);
        enseignant.setForeground(blanc);
        
        this.etat = new JLabel(etatS);
        this.etat.setBounds( 5 , 10, 100, 40);
        setFontSizeMax(this.etat);
        etat.setForeground(blanc);
        
        this.ligne.add(ID);
        this.ligne.add(date);
        this.ligne.add(semaine);
        this.ligne.add(heureDebut);
        this.ligne.add(nomCours);
        this.ligne.add(typeCours);
        this.ligne.add(groupe);
        this.ligne.add(salle);
        this.ligne.add(enseignant);
    }
    
    public JPanel getCours() {
        return this.ligne;
    }
}
