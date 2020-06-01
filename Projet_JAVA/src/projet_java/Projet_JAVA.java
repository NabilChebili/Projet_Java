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
        
        Utilisateur uti1 = new Utilisateur();
        DAO<Seance> seancedao = new DAO_Seance();
        
        int ID = -1;
        int SEMAINE = 10;

        LocalDate DATE = LocalDate.parse("1999-11-11");  
        LocalTime HEURE_DEBUT = LocalTime.parse("10:10");
        LocalTime HEURE_FIN = LocalTime.parse("20:15");
        String ETAT = "validee";
        int ID_COURS = 1;
        int ID_TYPE = 1;
        ArrayList<Integer> ID_GROUPE = new ArrayList<Integer>();
        ArrayList<Integer> ID_SALLE = new ArrayList<Integer>();
        ArrayList<Integer> ID_ENSEIGNANT = new ArrayList<Integer>();
        ID_GROUPE.add(1);
        ID_GROUPE.add(2);
        ID_GROUPE.add(3);
        ID_SALLE.add(1);
        ID_SALLE.add(2);
        ID_SALLE.add(3);
        ID_ENSEIGNANT.add(1);
        ID_ENSEIGNANT.add(2);
        ID_ENSEIGNANT.add(3);
        
        
        Seance seance = new Seance(ID,SEMAINE,DATE,HEURE_DEBUT,HEURE_FIN,ETAT,ID_COURS,ID_TYPE,ID_GROUPE,ID_SALLE,ID_ENSEIGNANT);
        
        seancedao.create(seance);
        
        
    }
    
}
