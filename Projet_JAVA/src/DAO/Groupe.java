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
public class Groupe {
    private int ID;
    private String NOM;
    private int ID_PROMOTION;
    private ArrayList<Integer> ID_SEANCES;
    
    public Groupe(int id,String nom,int id_promotion,ArrayList<Integer> id_seances){
        this.ID = id ;
        this.NOM = nom ;
        this.ID_PROMOTION = id_promotion ;
        this.ID_SEANCES = id_seances ;
    }
    
    public int GET_ID (){
        return ID;
    }
    public String GET_NOM (){
        return NOM;
    }
    public int GET_ID_PROMOTION (){
        return ID_PROMOTION;
    }
    public ArrayList<Integer> GET_ID_SEANCES (){
        return ID_SEANCES;
    }
}
