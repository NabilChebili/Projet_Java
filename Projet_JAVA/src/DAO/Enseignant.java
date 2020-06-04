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
public class Enseignant {
    private int ID_UTILISATEUR;
    private ArrayList<Integer> ID_COURS;
    private ArrayList<Integer> ID_SEANCES;
    
    public Enseignant(int id,ArrayList<Integer> id_cours,ArrayList<Integer> id_seances){
        this.ID_UTILISATEUR = id ;
        this.ID_COURS = id_cours ;
        this.ID_SEANCES = id_seances ;
    }
    
    public int GET_ID_UTILISATEUR (){
        return ID_UTILISATEUR;
    }
    public ArrayList<Integer> GET_ID_COURS (){
        return ID_COURS;
    }
    public ArrayList<Integer> GET_ID_SEANCES (){
        return ID_SEANCES;
    }
}
