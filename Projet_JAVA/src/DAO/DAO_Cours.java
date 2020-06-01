/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nabil WOW
 */
public class DAO_Cours extends DAO<Cours> {
    
    

    @Override
    public boolean create(Cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cours find(int id) {
        ArrayList liste;
        final String Requete = "SELECT * FROM `cours` WHERE `ID` = " + id;
        try{
            liste = maconnexion.RequeteRetourListe(Requete);
            int ID = Integer.parseInt((String) liste.get(0));
            String NOM = (String) liste.get(1);
            Cours cours = new Cours(ID,NOM);
            return cours;
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
            return null;
        }
    }

    @Override
    public Cours find(String email, String passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cours> all() {
        ArrayList liste;
        final String Requete1 = "SELECT * FROM `groupe`";
        try {
            liste = maconnexion.RequeteRetourListe(Requete1);
            ArrayList<Cours> listcours = new ArrayList();
            for(int i=0;i<liste.size();i+=2)
            {
                int ID = Integer.parseInt((String) liste.get(i));
                String NOM = (String) liste.get(i+1);
                Cours cours = new Cours(ID,NOM);
                listcours.add(cours);
            }
            return listcours;
        } catch (SQLException ex) {
            System.out.println("Connexion echouee : probleme SQL");
            ex.printStackTrace();
            return null;
        }
        
    }
}
