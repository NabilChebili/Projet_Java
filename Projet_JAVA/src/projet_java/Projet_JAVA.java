/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_java;
import Controleur.*;
import DAO.*;
import Vue.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nabil WOW
 */
public class Projet_JAVA {

    /**
     * @param args the command line arguments
     */
    public static int getNumWeekYearOfDate(Date dateInc) {
        Calendar cal = Calendar.getInstance(Locale.FRANCE);
        cal.setTime(dateInc);
 
        return Calendar.WEEK_OF_YEAR;
        
   }
    public static void main(String[] args) {
        // TODO code application logic here
        
       
        
        GUIConnection myGUI = new GUIConnection();
        
        
    }
    
    
    
}
