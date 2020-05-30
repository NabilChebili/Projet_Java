/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_java;
import Controleur.*;
import DAO.*;
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
    public void main(String[] args) {
        // TODO code application logic here
        conn = new Connexion();
        Utilisateur uti1 = new Utilisateur();
        
        conn.connexion("nabil", "coucou");
        System.out.println(conn.uti.GET_ID()+","+uti1.GET_EMAIL()+","+uti1.GET_DROIT());
        
    }
    
}
