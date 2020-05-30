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
public class Seance {
    private int ID;
    private int SEMAINE;
    private String DATE;
    private String HEURE_DEBUT;
    private String HEURE_FIN;
    private int ID_COURS;
    private int ID_TYPE;
    private ArrayList<Integer> ID_GROUPES;
    private ArrayList<Integer> ID_SALLES;
    private ArrayList<Integer> ID_ENSEIGNANTS;
    
    public Seance(int id,int semaine,String date,String heure_debut,String heure_fin,int id_cours,int id_type,ArrayList<Integer> id_groupes,ArrayList<Integer> id_salles,ArrayList<Integer> id_enseigants){
        this.ID = id ;
        this.SEMAINE = semaine ;
        this.DATE = date ;
        this.HEURE_DEBUT = heure_debut ;
        this.HEURE_FIN = heure_fin ;
        this.ID_COURS = id_cours ;
        this.ID_TYPE = id_type ;
        this.ID_GROUPES = id_groupes ;
        this.ID_SALLES = id_salles ;
        this.ID_ENSEIGNANTS = id_enseigants ;
    }
    
    public int GET_ID (){
        return ID;
    }
    public int GET_SEMAINE (){
        return SEMAINE;
    }
    public String GET_DATE (){
        return DATE;
    }
    public String GET_HEURE_DEBUT (){
        return HEURE_DEBUT;
    }
    public String GET_HEURE_FIN (){
        return HEURE_FIN;
    }
    public int GET_ID_COURS (){
        return ID_COURS;
    }
    public int GET_ID_TYPE (){
        return ID_TYPE;
    }
    public ArrayList<Integer> GET_ID_GROUPES (){
        return ID_GROUPES;
    }
    public ArrayList<Integer> GET_ID_SALLES (){
        return ID_SALLES;
    }
    public ArrayList<Integer> GET_ID_ENSEIGNANTS (){
        return ID_ENSEIGNANTS;
    }
    
}
