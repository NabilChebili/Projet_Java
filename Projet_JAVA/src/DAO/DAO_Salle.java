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
public class DAO_Salle {
    BDD maconnexion;
    private int ID;
    private String NOM;
    private int CAPACITE;
    private int ID_SITE;
    
    public DAO_Salle(int id){
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
        final String Requete = "SELECT * FROM `utilisateur` WHERE `ID` LIKE " + id;
        try{
            liste = maconnexion.RequeteRetourListe(Requete);
            ID = (int) liste.get(0);
            NOM = (String) liste.get(1);
            CAPACITE = (int) liste.get(2);
            ID_SITE = (int) liste.get(3);
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
        }
        
    }
}
