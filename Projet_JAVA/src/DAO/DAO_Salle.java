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
public class DAO_Salle extends DAO<Salle> {

    @Override
    public boolean create(Salle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Salle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Salle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Salle find(int id) {
    ArrayList liste;
        final String Requete1 = "SELECT * FROM `salle` WHERE `ID` = " + id;
        final String Requete2 = "SELECT `#ID_SEANCE` FROM `seance_salles` WHERE `#ID_SALLE` = " + id;
        try{
            liste = maconnexion.RequeteRetourListe(Requete1);
            int ID = Integer.parseInt((String) liste.get(0));
            String NOM = (String) liste.get(1);
            int CAPACITE = Integer.parseInt((String) liste.get(2));
            int ID_SITE = Integer.parseInt((String) liste.get(3));
            
            liste = maconnexion.RequeteRetourListe(Requete2);
            ArrayList<Integer> ID_Seances = new ArrayList<Integer>();
            
            for(int i=0;i<liste.size();i++)
            {
                ID_Seances.add(Integer.parseInt((String) liste.get(i)));
            }
            
            Salle salle = new Salle(ID,NOM,CAPACITE,ID_SITE,ID_Seances);
            return salle;
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Salle find(String email, String passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Salle> all() {
        ArrayList liste;
        final String Requete1 = "SELECT * FROM `salle`";
        
        try{
            liste = maconnexion.RequeteRetourListe(Requete1);
            ArrayList<Salle> listsalle = new ArrayList();            
            for(int i=0;i<liste.size();i+=4)
            {
                int ID = Integer.parseInt((String) liste.get(i));
                String NOM = (String) liste.get(i+1);
                int CAPACITE = Integer.parseInt((String) liste.get(i+2));
                int ID_SITE = Integer.parseInt((String) liste.get(i+3));
                final String Requete2 = "SELECT `#ID_SEANCE` FROM `seance_salles` WHERE `#ID_SALLE` = " + ID;
                
                ArrayList liste2;
                liste2 = maconnexion.RequeteRetourListe(Requete2);
                ArrayList<Integer> ID_Seances = new ArrayList<Integer>();

                for(int j=0;j<liste2.size();j++)
                {
                    ID_Seances.add(Integer.parseInt((String) liste2.get(j)));
                }

                Salle salle = new Salle(ID,NOM,CAPACITE,ID_SITE,ID_Seances);
                listsalle.add(salle);
            }
            return listsalle;
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
            e.printStackTrace();
            return null;
        }
        
    }
    
}
