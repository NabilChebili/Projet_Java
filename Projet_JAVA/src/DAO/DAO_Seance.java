/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Nabil WOW
 */
public class DAO_Seance extends DAO<Seance> {

    @Override
    public boolean create(Seance obj) {
        try {
            int semaine = obj.GET_SEMAINE();
            String date = obj.GET_DATE().toString();
            String heuredebut = obj.GET_HEURE_DEBUT().toString();
            String heurefin = obj.GET_HEURE_FIN().toString();
            String etat = obj.GET_ETAT();
            int idcours = obj.GET_ID_COURS();
            int idtype = obj.GET_ID_TYPE();
            final String Requete1 = "INSERT INTO `seance` (`ID`, `SEMAINE`, `DATE`, `HEURE_DEBUT`, `HEURE_FIN`, `ETAT`, `#ID_COURS`, `#ID_TYPE`) VALUES (NULL,'"+ semaine +"', '"+ date +"', '"+ heuredebut +"', '"+ heurefin +"', '"+ etat +"', '"+ idcours +"','"+ idtype +"')";
            maconnexion.Update(Requete1);
            final String Requete2 = "SELECT `ID` FROM `seance` WHERE `SEMAINE` = '"+ semaine +"'  AND `DATE` = '"+ date +"'  AND `HEURE_DEBUT` = '"+ heuredebut +"'  AND `HEURE_FIN` = '"+ heurefin +"'  AND `ETAT` = '"+ etat +"'  AND `#ID_COURS` = '"+ idcours +"'  AND `#ID_TYPE` = '"+ idtype +"'";
            ArrayList liste;
            System.out.println(Requete2);
            liste = maconnexion.RequeteRetourListe(Requete2);   
            int id = Integer.parseInt((String) liste.get(0));
            
        
            
            ArrayList<Integer> ID_Groupe = new ArrayList<Integer>();
            ID_Groupe = obj.GET_ID_GROUPES();
            ArrayList<Integer> ID_Salle = new ArrayList<Integer>();
            ID_Salle = obj.GET_ID_SALLES();
            ArrayList<Integer> ID_Enseignant = new ArrayList<Integer>();
            ID_Enseignant = obj.GET_ID_ENSEIGNANTS();
            for(int i=0;i<ID_Groupe.size();i++)
            {
                final String Requete3 = "INSERT INTO `seance_groupes`(`#ID_SEANCE`, `#ID_GROUPE`) VALUES ("+ id +","+ ID_Groupe.get(i) +")";
                maconnexion.Update(Requete3);
            }
            for(int i=0;i<ID_Salle.size();i++)
            {
                final String Requete4 = "INSERT INTO `seance_salles`(`#ID_SEANCE`, `#ID_SALLE`) VALUES ("+ id +","+ ID_Salle.get(i) +")";
                maconnexion.Update(Requete4);
            }
            for(int i=0;i<ID_Enseignant.size();i++)
            {
                final String Requete5 = "INSERT INTO `seance_enseignants`(`#ID_SEANCE`, `#ID_ENSEIGNANT`) VALUES ("+ id +","+ ID_Enseignant.get(i) +")";
                maconnexion.Update(Requete5);
            }
            
            
            return true;
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
        
    }

    @Override
    public boolean delete(Seance obj) {
        int id = obj.GET_ID();
        final String Requete1 = "DELETE FROM `seance` WHERE ID = " + id;
        try {
            maconnexion.Update(Requete1);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Seance obj) {
        int id = obj.GET_ID();
        int semaine = obj.GET_SEMAINE();
        String date = obj.GET_DATE().toString();
        String heuredebut = obj.GET_HEURE_DEBUT().toString();
        String heurefin = obj.GET_HEURE_FIN().toString();
        String etat = obj.GET_ETAT();
        int idcours = obj.GET_ID_COURS();
        int idtype = obj.GET_ID_TYPE(); 
        final String Requete1 = "UPDATE `seance` SET `SEMAINE`='"+ semaine +"',`DATE`='"+ date +"',`HEURE_DEBUT`='"+ heuredebut +"',`HEURE_FIN`='"+ heurefin +"',`ETAT`='"+ etat +"',`#ID_COURS`='"+ idcours +"',`#ID_TYPE`='"+ idtype +"' WHERE ID = " + id;
        
        System.out.println(Requete1);
        
        try {
            maconnexion.Update(Requete1);
            final String Requetedel1 = "DELETE FROM `seance_groupes` WHERE `#ID_SEANCE` = " + id;
            maconnexion.Update(Requetedel1);
            final String Requetedel2 = "DELETE FROM `seance_salles` WHERE `#ID_SEANCE` = " + id;
            maconnexion.Update(Requetedel2);
            final String Requetedel3 = "DELETE FROM `seance_enseignants` WHERE `#ID_SEANCE` = " + id;
            maconnexion.Update(Requetedel3);
            
            maconnexion.Update(Requete1);
            ArrayList<Integer> ID_Groupe = new ArrayList<Integer>();
            ID_Groupe = obj.GET_ID_GROUPES();
            ArrayList<Integer> ID_Salle = new ArrayList<Integer>();
            ID_Salle = obj.GET_ID_SALLES();
            ArrayList<Integer> ID_Enseignant = new ArrayList<Integer>();
            ID_Enseignant = obj.GET_ID_ENSEIGNANTS();
            for(int i=0;i<ID_Groupe.size();i++)
            {
                final String Requete3 = "INSERT INTO `seance_groupes`(`#ID_SEANCE`, `#ID_GROUPE`) VALUES ("+ id +","+ ID_Groupe.get(i) +")";
                maconnexion.Update(Requete3);
            }
            for(int i=0;i<ID_Salle.size();i++)
            {
                final String Requete4 = "INSERT INTO `seance_salles`(`#ID_SEANCE`, `#ID_SALLE`) VALUES ("+ id +","+ ID_Salle.get(i) +")";
                maconnexion.Update(Requete4);
            }
            for(int i=0;i<ID_Enseignant.size();i++)
            {
                final String Requete5 = "INSERT INTO `seance_enseignants`(`#ID_SEANCE`, `#ID_ENSEIGNANT`) VALUES ("+ id +","+ ID_Enseignant.get(i) +")";
                maconnexion.Update(Requete5);
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
    }

    @Override
    public Seance find(int id) {
        ArrayList liste;
        final String Requete1 = "SELECT * FROM `seance` WHERE `ID` = " + id;
        final String Requete2 = "SELECT `#ID_GROUPE` FROM `seance_groupes` WHERE `#ID_SEANCE` = " + id;
        final String Requete3 = "SELECT `#ID_SALLE` FROM `seance_salles` WHERE `#ID_SEANCE` = " + id;
        final String Requete4 = "SELECT `#ID_ENSEIGNANT` FROM `seance_enseignants` WHERE `#ID_SEANCE` = " + id;
        try{
            liste = maconnexion.RequeteRetourListe(Requete1);
            /*if(!liste.isEmpty())
            {*/
                int ID = Integer.parseInt((String) liste.get(0));
                int SEMAINE = Integer.parseInt((String) liste.get(1));

                LocalDate DATE = LocalDate.parse((String) liste.get(2));  
                LocalTime HEURE_DEBUT = LocalTime.parse((String) liste.get(3));
                LocalTime HEURE_FIN = LocalTime.parse((String) liste.get(4));
                String ETAT = (String) liste.get(5);
                int ID_COURS = Integer.parseInt((String) liste.get(6));
                int ID_TYPE = Integer.parseInt((String) liste.get(7));

                liste = maconnexion.RequeteRetourListe(Requete2);
                ArrayList<Integer> ID_GROUPE = new ArrayList<Integer>();
                for(int i=0;i<liste.size();i++)
                {
                    ID_GROUPE.add(Integer.parseInt((String) liste.get(i)));
                }

                liste = maconnexion.RequeteRetourListe(Requete3);
                ArrayList<Integer> ID_SALLE = new ArrayList<Integer>();

                for(int i=0;i<liste.size();i++)
                {
                    ID_SALLE.add(Integer.parseInt((String) liste.get(i)));
                }

                liste = maconnexion.RequeteRetourListe(Requete4);
                ArrayList<Integer> ID_ENSEIGNANT = new ArrayList<Integer>();

                for(int i=0;i<liste.size();i++)
                {
                    ID_ENSEIGNANT.add(Integer.parseInt((String) liste.get(i)));
                }

                Seance seance = new Seance(ID,SEMAINE,DATE,HEURE_DEBUT,HEURE_FIN,ETAT,ID_COURS,ID_TYPE,ID_GROUPE,ID_SALLE,ID_ENSEIGNANT);
                return seance;
            /*}
            else{
                System.out.println("Aucune Seance trouvée");
                return null;
            }*/
            
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

    @Override
    public ArrayList<Seance> all() {
        ArrayList liste;
        final String Requete1 = "SELECT * FROM `seance`";
        
        try{
            liste = maconnexion.RequeteRetourListe(Requete1);
            ArrayList<Seance> listgrp = new ArrayList();  
            
            for(int i=0;i<liste.size();i+=8)
            {
                int ID = Integer.parseInt((String) liste.get(i));
                int SEMAINE = Integer.parseInt((String) liste.get(i+1));

                LocalDate DATE = LocalDate.parse((String) liste.get(i+2));  
                LocalTime HEURE_DEBUT = LocalTime.parse((String) liste.get(i+3));
                LocalTime HEURE_FIN = LocalTime.parse((String) liste.get(i+4));
                String ETAT = (String) liste.get(i+5);
                int ID_COURS = Integer.parseInt((String) liste.get(i+6));
                int ID_TYPE = Integer.parseInt((String) liste.get(i+7));
                
                final String Requete2 = "SELECT `#ID_GROUPE` FROM `seance_groupes` WHERE `#ID_SEANCE` = " + ID;
                final String Requete3 = "SELECT `#ID_SALLE` FROM `seance_salles` WHERE `#ID_SEANCE` = " + ID;
                final String Requete4 = "SELECT `#ID_ENSEIGNANT` FROM `seance_enseignants` WHERE `#ID_SEANCE` = " + ID;
                
                ArrayList liste2 = new ArrayList(); 
                liste2 = maconnexion.RequeteRetourListe(Requete2);
                ArrayList<Integer> ID_GROUPE = new ArrayList<Integer>();
                for(int j=0;j<liste2.size();j++)
                {
                    ID_GROUPE.add(Integer.parseInt((String) liste2.get(j)));
                }

                liste2 = maconnexion.RequeteRetourListe(Requete3);
                ArrayList<Integer> ID_SALLE = new ArrayList<Integer>();

                for(int k=0;k<liste2.size();k++)
                {
                    ID_SALLE.add(Integer.parseInt((String) liste2.get(k)));
                }

                liste2 = maconnexion.RequeteRetourListe(Requete4);
                ArrayList<Integer> ID_ENSEIGNANT = new ArrayList<Integer>();

                for(int l=0;l<liste2.size();l++)
                {
                    ID_ENSEIGNANT.add(Integer.parseInt((String) liste2.get(l)));
                }
                
                
                
                Seance seance = new Seance(ID,SEMAINE,DATE,HEURE_DEBUT,HEURE_FIN,ETAT,ID_COURS,ID_TYPE,ID_GROUPE,ID_SALLE,ID_ENSEIGNANT);
                listgrp.add(seance);
                
                
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
