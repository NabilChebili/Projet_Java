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
public class DAO_Utilisateur extends DAO<Utilisateur> {
    
    public DAO_Utilisateur (){
        super();
    }
    

    @Override
    public boolean create(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur find(int id) {
        ArrayList liste;
        final String Requete = "SELECT * FROM `utilisateur` WHERE `ID` = " + id;
        try{
            liste = maconnexion.RequeteRetourListe(Requete);
            int ID = Integer.parseInt((String) liste.get(0)) ;
            String EMAIL = (String) liste.get(1);
            String PASSWD = (String) liste.get(2);
            String NOM = (String) liste.get(3);
            String PRENOM = (String) liste.get(4);
            int DROIT = Integer.parseInt((String) liste.get(5));
            Utilisateur utilisateur = new Utilisateur(ID,EMAIL,PASSWD,NOM,PRENOM,DROIT);
            return utilisateur;
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
            return null;
        }
    }
    public Utilisateur find(final String email,final String passwd) {
        ArrayList liste;
        final String Requete = "SELECT ID,EMAIL,PASSWD,DROIT FROM `utilisateur` WHERE `EMAIL` LIKE " + email + "AND `PASSWD` LIKE " + passwd;
        try{
            liste = maconnexion.RequeteRetourListe(Requete);
            int ID = Integer.parseInt((String) liste.get(0)) ;
            String EMAIL = (String) liste.get(1);
            String PASSWD = (String) liste.get(2);
            String NOM = (String) liste.get(3);
            String PRENOM = (String) liste.get(4);
            int DROIT = Integer.parseInt((String) liste.get(5));
            Utilisateur utilisateur = new Utilisateur(ID,EMAIL,PASSWD,NOM,PRENOM,DROIT);
            return utilisateur;
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee");
            Utilisateur utilisateur = new Utilisateur();
            return utilisateur;
        }
    }

    @Override
    public ArrayList<Utilisateur> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
