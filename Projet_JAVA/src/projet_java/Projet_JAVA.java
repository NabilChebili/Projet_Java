/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_java;
import Controleur.*;
import DAO.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nabil WOW
 */
public class Projet_JAVA {
    public Connexion conn;
    public Recherche recherche;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DAO<Utilisateur> utilisateurdao = new DAO_Utilisateur();
        
        Utilisateur util = utilisateurdao.find(5);
        
        Maj maj = new Maj(util);
        
        int ID = -1;
        int SEMAINE = 10;

        LocalDate DATE = LocalDate.parse("2020-06-07");       
        LocalTime HEURE_DEBUT = LocalTime.parse("13:45");
        LocalTime HEURE_FIN = LocalTime.parse("15:15");
        String ETAT = "En cours";
        int ID_COURS = 2;
        int ID_TYPE = 1;
        ArrayList<Integer> ID_GROUPE = new ArrayList<Integer>();
        ArrayList<Integer> ID_SALLE = new ArrayList<Integer>();
        ArrayList<Integer> ID_ENSEIGNANT = new ArrayList<Integer>();
        ID_GROUPE.add(1);
        ID_GROUPE.add(2);
        //ID_GROUPE.add(3);
        ID_SALLE.add(1);
        ID_ENSEIGNANT.add(3);
    
        
        
        Seance seance = new Seance(ID,SEMAINE,DATE,HEURE_DEBUT,HEURE_FIN,ETAT,ID_COURS,ID_TYPE,ID_GROUPE,ID_SALLE,ID_ENSEIGNANT);
        
        try {
            maj.AjoutUpdateSeance(seance, false);
            
            //seancedao.create(seance);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Erreur Maj");
        }
        
        
        
    }
    
}
