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
public class DAO_Seance extends DAO<Seance> {

    @Override
    public boolean create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance find(int id) {
        ArrayList liste;
        final String Requete1 = "SELECT * FROM `seance` WHERE `ID` = " + id;
        final String Requete2 = "SELECT #ID_GROUPE FROM `seance_groupes` WHERE `#ID_SEANCE` = " + id;
        final String Requete3 = "SELECT #ID_SALLE FROM `seance_salles` WHERE `#ID_SEANCE` = " + id;
        final String Requete4 = "SELECT #ID_ENSEIGNANT FROM `seance_enseignants` WHERE `#ID_SEANCE` = " + id;
        try{
            liste = maconnexion.RequeteRetourListe(Requete1);
            int ID = Integer.parseInt((String) liste.get(0));
            int SEMAINE = Integer.parseInt((String) liste.get(1));
            String DATE = (String) liste.get(2);
            String HEURE_DEBUT = (String) liste.get(3);
            String HEURE_FIN = (String) liste.get(4);
            int ID_COURS = Integer.parseInt((String) liste.get(5));
            int ID_TYPE = Integer.parseInt((String) liste.get(6));
            
            liste = maconnexion.RequeteRetourListe(Requete2);
            ArrayList<Integer> ID_GROUPE = new ArrayList<Integer>();
            for(int i=0;i<liste.size();i++)
            {
                ID_GROUPE.add(Integer.parseInt((String) liste.get(0)));
            }
            
            liste = maconnexion.RequeteRetourListe(Requete3);
            ArrayList<Integer> ID_SALLE = new ArrayList<Integer>();
            
            for(int i=0;i<liste.size();i++)
            {
                ID_SALLE.add(Integer.parseInt((String) liste.get(0)));
            }
            
            liste = maconnexion.RequeteRetourListe(Requete4);
            ArrayList<Integer> ID_ENSEIGNANT = new ArrayList<Integer>();
            
            for(int i=0;i<liste.size();i++)
            {
                ID_ENSEIGNANT.add(Integer.parseInt((String) liste.get(0)));
            }
            
            Seance seance = new Seance(ID,SEMAINE,DATE,HEURE_DEBUT,HEURE_FIN,ID_COURS,ID_TYPE,ID_GROUPE,ID_SALLE,ID_ENSEIGNANT);
            return seance;
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
            return null;
        }
    }

    @Override
    public Seance find(String email, String passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
