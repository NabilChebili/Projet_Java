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
public abstract class DAO<T> {
    protected BDD maconnexion;

    protected DAO(){
      try{    
            try{
                maconnexion = new BDD("projet_java", "root", "");
            }
            catch(final ClassNotFoundException  cnfe){
                System.out.println("Connexion echouee : probleme de classe");
                cnfe.printStackTrace();
            }
        }
        catch(final SQLException e){
            System.out.println("Connexion echouee : probleme SQL");
            e.printStackTrace();

        }
    }

    /**
    * Méthode de création
    * @param obj
    * @return boolean 
    */
    public abstract boolean create(T obj);

    /**
    * Méthode pour effacer
    * @param obj
    * @return boolean 
    */
    public abstract boolean delete(T obj);

    /**
    * Méthode de mise à jour
    * @param obj
    * @return boolean
    */
    public abstract boolean update(T obj);

    /**
    * Méthode de recherche des informations
    * @param id
    * @return T
    */
    public abstract T find(int id);
    public abstract T find(final String email,final String passwd);
    
    public abstract ArrayList<T> all();
}
