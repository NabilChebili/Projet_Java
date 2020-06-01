/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.time.*;
import java.util.ArrayList;

/**
 *
 * @author Nabil WOW
 */
public class Seance {
    private int ID;
    private int SEMAINE;
    private LocalDate DATE;
    private LocalTime HEURE_DEBUT;
    private LocalTime HEURE_FIN;
    private String ETAT;
    private int ID_COURS;
    private int ID_TYPE;
    private ArrayList<Integer> ID_GROUPES;
    private ArrayList<Integer> ID_SALLES;
    private ArrayList<Integer> ID_ENSEIGNANTS;
    
    public Seance(int id,int semaine,LocalDate date,LocalTime heure_debut,LocalTime heure_fin,String etat,int id_cours,int id_type,ArrayList<Integer> id_groupes,ArrayList<Integer> id_salles,ArrayList<Integer> id_enseigants){
        this.ID = id ;
        this.SEMAINE = semaine ;
        this.DATE = date ;
        this.HEURE_DEBUT = heure_debut ;
        this.HEURE_FIN = heure_fin ;
        this.ETAT = etat ;
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
    public LocalDate GET_DATE (){
        return DATE;
    }
    public LocalTime GET_HEURE_DEBUT (){
        return HEURE_DEBUT;
    }
    public LocalTime GET_HEURE_FIN (){
        return HEURE_FIN;
    }
    public String GET_ETAT (){
        return ETAT;
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
