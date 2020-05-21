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
public class DAO_Utilisateur {
    BDD maconnexion;
    private int ID;
    private String EMAIL;
    private String PASSWD;
    private String NOM;
    private String PRENOM;
    private int DROIT;
    
    public DAO_Utilisateur(int id){
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
            EMAIL = (String) liste.get(1);
            PASSWD = (String) liste.get(2);
            NOM = (String) liste.get(3);
            PRENOM = (String) liste.get(4);
            DROIT = (int) liste.get(5);
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
        }
        
    }
    
    public DAO_Utilisateur(final String email,final String passwd){
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
        final String Requete = "SELECT ID,EMAIL,PASSWD,DROIT FROM `utilisateur` WHERE `EMAIL` LIKE " + email + "AND `PASSWD` LIKE " + passwd;
        try{
            liste = maconnexion.RequeteRetourListe(Requete);
            ID = (int) liste.get(0);
            EMAIL = (String) liste.get(1);
            PASSWD = (String) liste.get(2);
            NOM = (String) liste.get(3);
            PRENOM = (String) liste.get(4);
            DROIT = (int) liste.get(5);
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
        }
    }
    
    public int GET_ID (){
        return ID;
    }
    public String GET_EMAIL (){
        return EMAIL;
    }
    public String GET_PASSWD() {
        return PASSWD;
    }
    public String GET_NOM (){
        return NOM;
    }
    public String GET_PRENOM (){
        return PRENOM;
    }
    public int GET_DROIT (){
        return DROIT;
    }
    
}
