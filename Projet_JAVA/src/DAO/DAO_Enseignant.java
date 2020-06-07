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
public class DAO_Enseignant extends DAO<Enseignant> {

    @Override
    public boolean create(Enseignant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Enseignant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Enseignant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enseignant find(int id) {
        ArrayList liste;
        final String Requete1 = "SELECT `#ID_UTILISATEUR` FROM `enseignant` WHERE `#ID_UTILISATEUR` = " + id;
        final String Requete2 = "SELECT `#ID_COURS` FROM `enseignant` WHERE `#ID_UTILISATEUR` = " + id;
        final String Requete3 = "SELECT `#ID_SEANCE` FROM `seance_enseignants` WHERE `#ID_ENSEIGNANT` = " + id;
        try{
            liste = maconnexion.RequeteRetourListe(Requete1);
            int ID_utilisateur = Integer.parseInt((String) liste.get(0));
            
            liste = maconnexion.RequeteRetourListe(Requete2);
            ArrayList<Integer> ID_Cours = new ArrayList<Integer>();
            System.out.println("Connexion echouee : probleme SQL");
            for(int i=0;i<liste.size();i++)
            {
                ID_Cours.add(Integer.parseInt((String) liste.get(i)));
            }
            
            liste = maconnexion.RequeteRetourListe(Requete3);
            ArrayList<Integer> ID_Seances = new ArrayList<Integer>();
            
            for(int i=0;i<liste.size();i++)
            {
                ID_Seances.add(Integer.parseInt((String) liste.get(i)));
            }
            
            Enseignant enseignant = new Enseignant(ID_utilisateur,ID_Cours,ID_Seances);
            return enseignant;
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Enseignant find(String email, String passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Enseignant> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

