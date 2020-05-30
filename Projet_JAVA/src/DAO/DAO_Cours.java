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
public class DAO_Cours extends DAO<Cours> {
    
    

    @Override
    public boolean create() {
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
}
