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
public class Cours {
    private int ID;
    private String NOM;
    
    public Cours(int id,String nom){
        this.ID = id ;
        this.NOM = nom ;
    }
    
    public int GET_ID (){
        return ID;
    }
    public String GET_NOM (){
        return NOM;
    }
}
