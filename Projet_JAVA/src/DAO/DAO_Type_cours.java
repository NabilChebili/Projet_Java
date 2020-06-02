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
public class DAO_Type_cours extends DAO<Type_cours> {

    @Override
    public boolean create(Type_cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Type_cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Type_cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type_cours find(int id) {
        ArrayList liste;
        final String Requete = "SELECT * FROM `type_cours` WHERE `ID` = " + id;
        try{
            liste = maconnexion.RequeteRetourListe(Requete);
            int ID = Integer.parseInt((String) liste.get(0));
            String NOM = (String) liste.get(1);
            Type_cours type_cours = new Type_cours(ID,NOM);
            return type_cours;
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Type_cours find(String email, String passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Type_cours> all() {
        ArrayList liste;
        final String Requete1 = "SELECT * FROM `type_cours`";
        try{
            liste = maconnexion.RequeteRetourListe(Requete1);
            ArrayList<Type_cours> listtype_cours = new ArrayList(); 
            for(int i=0;i<liste.size();i+=3)
            {
                int ID = Integer.parseInt((String) liste.get(0));
                String NOM = (String) liste.get(1);
                Type_cours type_cours = new Type_cours(ID,NOM);
                listtype_cours.add(type_cours);
            }
            return listtype_cours;
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
            e.printStackTrace();
            return null;
        }    
    }   
    
}
