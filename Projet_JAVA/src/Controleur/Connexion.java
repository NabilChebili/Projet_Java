/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import BDD.BDD;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nabil WOW
 */
public class Connexion {
    
    private int Id;
    private int Droit;
    
    private BDD maconnexion;
    
    public Connexion(){
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
    
    public String connexion (String Idtest, String Mdptest){
        ArrayList login;
        String Requete = "SELECT ID,EMAIL,PASSWD,DROIT FROM `utilisateur` WHERE `EMAIL` LIKE "+ Idtest ;
        try{
            login = maconnexion.RequeteRetourListe(Requete);
            if(login.get(3) == Mdptest)
            {
                Id = (int) login.get(1);
                Droit = (int) login.get(4);
                return "Connexion reussie";
            }
            else
            {
                return "Mauvais mot de passe";
            }
        }
        catch(SQLException e){
            return "probleme SQL : connexion impossible";
        }        
    }
    
    
}
