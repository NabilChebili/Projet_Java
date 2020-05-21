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
public class DAO_Etudiant {
    BDD maconnexion;
    private int ID_UTILISATEUR;
    private int NUMERO;
    private int ID_GROUPE;
    
    public DAO_Etudiant(int id){
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
        final String Requete = "SELECT * FROM `etudiant` WHERE `ID_UTILISATEUR` LIKE " + id;
        try{
            liste = maconnexion.RequeteRetourListe(Requete);
            ID_UTILISATEUR = (int) liste.get(0);
            NUMERO = (int) liste.get(1);
            ID_GROUPE = (int) liste.get(2);
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
        }     
    }
    
    public int GET_ID_UTILISATEUR (){
        return ID_UTILISATEUR;
    }
    public int GET_NUMERO (){
        return NUMERO;
    }
    public int GET_ID_GROUPE() {
        return ID_GROUPE;
    }  
}
