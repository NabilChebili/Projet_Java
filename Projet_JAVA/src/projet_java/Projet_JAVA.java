/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_java;
import Controleur.Recherche;
import java.util.ArrayList;

/**
 *
 * @author Nabil WOW
 */
public class Projet_JAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Recherche r = new Recherche(){};
        ArrayList b = r.RechercheTable("Cours");
        System.out.println(b);
    }
    
}