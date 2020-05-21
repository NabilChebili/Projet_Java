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
public class DAO_Groupe {
    BDD maconnexion;
    private int ID;
    private String NOM;
    private int ID_PROMOTION;
    
    public DAO_Groupe(int id){
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
        final String Requete = "SELECT * FROM `groupe` WHERE `ID` LIKE " + id;
        try{
            liste = maconnexion.RequeteRetourListe(Requete);
            ID = (int) liste.get(0);
            NOM = (String) liste.get(1);
            ID_PROMOTION = (int) liste.get(2);
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
        }
        
    }
    
    public int GET_ID (){
        return ID;
    }
    public String GET_NOM (){
        return NOM;
    }
    public int GET_ID_PROMOTION (){
        return ID_PROMOTION;
    }
}
