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
public class DAO_Etudiant extends DAO<Etudiant> {

    @Override
    public boolean create(Etudiant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Etudiant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Etudiant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Etudiant find(int id) {
        ArrayList liste;
        final String Requete = "SELECT * FROM `etudiant` WHERE `ID_UTILISATEUR` = " + id;
        try{
            liste = maconnexion.RequeteRetourListe(Requete);
            int ID_UTILISATEUR = Integer.parseInt((String) liste.get(0));
            int NUMERO = Integer.parseInt((String) liste.get(1));
            int ID_GROUPE = Integer.parseInt((String) liste.get(2));
            Etudiant etudiant = new Etudiant(ID_UTILISATEUR,NUMERO,ID_GROUPE);
            return etudiant;

        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
            return null;
        }
    }

    @Override
    public Etudiant find(String email, String passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Etudiant> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
}
