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
public class DAO_Groupe extends DAO<Groupe> {

    @Override
    public boolean create(Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Groupe find(int id) {
        ArrayList liste;
        final String Requete1 = "SELECT * FROM `groupe` WHERE `ID` = " + id;
        final String Requete2 = "SELECT `#ID_SEANCE` FROM `seance_groupes` WHERE `#ID_GROUPE` = " + id;
        try{
            liste = maconnexion.RequeteRetourListe(Requete1);
            int ID = Integer.parseInt((String) liste.get(0));
            String NOM = (String) liste.get(1);
            int ID_PROMOTION = Integer.parseInt((String) liste.get(2));
            
           liste = maconnexion.RequeteRetourListe(Requete2);
           ArrayList<Integer> ID_Seances = new ArrayList<Integer>();
            
            for(int i=0;i<liste.size();i++)
            {
                ID_Seances.add(Integer.parseInt((String) liste.get(i)));
            }
            
            Groupe groupe = new Groupe(ID,NOM,ID_PROMOTION,ID_Seances);
            return groupe;
        }
        catch(final SQLException e){
            e.printStackTrace();
            System.out.println("Connexion echouee : probleme SQL groupe");
            return null;
        }
    }

    @Override
    public Groupe find(String email, String passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Groupe> all() {
        ArrayList liste;
        final String Requete1 = "SELECT * FROM `groupe`";
        try{
            liste = maconnexion.RequeteRetourListe(Requete1);
            ArrayList<Groupe> listgrp = new ArrayList();            
            for(int i=0;i<liste.size();i+=3)
            {
                int ID = Integer.parseInt((String) liste.get(i));
                String NOM = (String) liste.get(i+1);
                int ID_PROMOTION = Integer.parseInt((String) liste.get(i+2));

                final String Requete2 = "SELECT `#ID_SEANCE` FROM `seance_groupes` WHERE `#ID_GROUPE` = " + ID;
                ArrayList liste2;
                liste2 = maconnexion.RequeteRetourListe(Requete2);
                ArrayList<Integer> ID_Seances = new ArrayList<Integer>();

                for(int j=0;j<liste2.size();j++)
                {
                    ID_Seances.add(Integer.parseInt((String) liste.get(j)));
                }

                Groupe groupe = new Groupe(ID,NOM,ID_PROMOTION,ID_Seances);
                listgrp.add(groupe);
            }
            return listgrp;
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
            e.printStackTrace();
            return null;
        }
    }
    
}
