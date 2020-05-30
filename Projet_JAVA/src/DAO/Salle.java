/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author Nabil WOW
 */
public class Salle {
    private int ID;
    private String NOM;
    private int CAPACITE;
    private int ID_SITE;
    private ArrayList<Integer> ID_SEANCES;
    
    public Salle(int id,String nom,int capacite,int id_site,ArrayList<Integer> id_cours){
        this.ID = id ;
        this.NOM = nom ;
        this.CAPACITE = capacite ;
        this.ID_SITE = id_site ;
        this.ID_SEANCES = id_cours ;
    }
    
    public int GET_ID (){
        return ID;
    }
    public String GET_NOM (){
        return NOM;
    }
    public int GET_CAPACITE (){
        return CAPACITE;
    }
    public int GET_ID_SITE (){
        return ID_SITE;
    }
    public ArrayList<Integer> GET_ID_SEANCES (){
        return ID_SEANCES;
    }
}
