/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author Nabil WOW
 */
public class DAO_Seance {
    BDD maconnexion;
    private int ID;
    private int SEMAINE;
    private String DATE;
    private String HEURE_DEBUT;
    private String HEURE_FIN;
    private int ID_COURS;
    private int ID_TYPE;
    
    public DAO_Seance(int id){
        try{    
            try{
                maconnexion = new BDD("projet_java", "root", "");
            }
            catch(final ClassNotFoundException  cnfe){
                System.out.println("Connexion echouee : probleme de classe");
                cnfe.printStackTrace();
            }
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
            e.printStackTrace();

        }
        
        ArrayList liste;
        final String Requete = "SELECT * FROM `seance` WHERE `ID` LIKE " + id;
        try{
            liste = maconnexion.RequeteRetourListe(Requete);
            ID = (int) liste.get(0);
            SEMAINE = (int) liste.get(1);
            DATE = (String) liste.get(2);
            HEURE_DEBUT = (String) liste.get(3);
            HEURE_FIN = (String) liste.get(4);
            ID_COURS = (int) liste.get(5);
            ID_TYPE = (int) liste.get(6);
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
        }
        
    }
}
