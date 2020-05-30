/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Nabil WOW
 */
public class Utilisateur {
    private int ID = -1;
    private String EMAIL = "";
    private String PASSWD = "";
    private String NOM = "";
    private String PRENOM = "";
    private int DROIT = -1;
    
    public Utilisateur(int id,String email,String passwd,String nom,String prenom,int droit){
        this.ID = id ;
        this.EMAIL = email ;
        this.PASSWD = passwd ;
        this.NOM = nom ;
        this.PRENOM = prenom ;
        this.DROIT = droit ;
    }

    public Utilisateur() {
    }
    
    public int GET_ID (){
        return ID;
    }
    public String GET_EMAIL (){
        return EMAIL;
    }
    public String GET_PASSWD() {
        return PASSWD;
    }
    public String GET_NOM (){
        return NOM;
    }
    public String GET_PRENOM (){
        return PRENOM;
    }
    public int GET_DROIT (){
        return DROIT;
    }
}
