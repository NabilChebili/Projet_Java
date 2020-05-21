/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import DAO.BDD;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nabil WOW
 */
public class Recherche {
    
    private BDD maconnexion;
    
    public Recherche(){
        try{    
            try{
                maconnexion = new BDD("projet_java", "root", "");
            }
            catch(ClassNotFoundException  cnfe){
                System.out.println("Connexion echouee : probleme de classe");
                cnfe.printStackTrace();
            }
        }
        catch(SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
            e.printStackTrace();

        }
            
    }
    
    public ArrayList RechercheTable(String table){
        try{
            String requete;
            requete = "SELECT * FROM " + table;
            return maconnexion.RequeteRetourListe(requete);
        }
        catch(SQLException e){
            System.out.println("Retour de la table impossible : probleme SQL");
            e.printStackTrace();
            return null;
        }
    }
    
    
        
    
    
    
    
}
