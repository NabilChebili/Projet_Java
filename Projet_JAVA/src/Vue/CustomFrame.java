/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.*;
import DAO.*;
import static Vue.CoursWidget.setFontSizeMax;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.*;
import static javax.swing.JFrame.*;
import java.util.*;

/**
 *
 * @author pierr
 */
public class CustomFrame extends JFrame implements ActionListener {

    private JFrame fMain;
    private JPanel pMenu;
    private JLayeredPane pContent;

    private ArrayList<CoursWidget> pSemaine;

    private JButton yes;
    private JButton no;

    final private int height = 1000;
    final private int width = 1600;
    final private int menu = 400;
    final static private int sizeX = 175;
    final static private int sizeY = 100;

    public static void main(String args[]) {
        new CustomFrame().setVisible(true);
    }

    public CustomFrame() {
        initEDT();
    }

    public static int getSizeX() {
        return sizeX;
    }

    public static int getSizeY() {
        return sizeY;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Yes")) {
            System.out.println("Yes Button pressed!");
            toggleVisibility();
        } else if (action.equals("No")) {
            System.out.println("No Button pressed!");
            pSemaine.get(0).getCours().setVisible(false);
            pSemaine.get(3).setNomCours("COMMENT");
        } else if (action.equals("Rechercher")) {
            System.out.println("Recherche");
        }
    }

    private void initEDT() {

        fMain = new JFrame("ECE-Agenda");
        fMain.setSize(width, height);
        fMain.setLocation((1920 / 2) - (width / 2), (1080 / 2) - (height / 2));
        fMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fMain.setVisible(true);
        fMain.setResizable(false);

        pMenu = new JPanel();
        pMenu.setSize(menu, height);
        pMenu.setLocation(0, 0);
        pMenu.setBackground(Color.BLACK);
        pMenu.setLayout(null);

        pContent = new JLayeredPane();
        pContent.setSize(width - menu, height);
        pContent.setLocation(menu, 0);
        pContent.setBackground(Color.WHITE);

        fMain.add(pMenu);
        fMain.add(pContent);

        //DAO<Seance> seancedao = new DAO_Seance();
        // Import cours
        /**
         * DAO<Seance> seancedao = new DAO_Seance(); int ID = -1; int SEMAINE =
         * 10; LocalDate DATE = LocalDate.parse("1999-11-11"); LocalTime
         * HEURE_DEBUT = LocalTime.parse("10:10"); LocalTime HEURE_FIN =
         * LocalTime.parse("20:15"); String ETAT = "validee"; int ID_COURS = 1;
         * int ID_TYPE = 1; ArrayList<Integer> ID_GROUPE = new
         * ArrayList<Integer>(); ArrayList<Integer> ID_SALLE = new
         * ArrayList<Integer>(); ArrayList<Integer> ID_ENSEIGNANT = new
         * ArrayList<Integer>(); ID_GROUPE.add(1); ID_GROUPE.add(2);
         * ID_GROUPE.add(3); ID_SALLE.add(1); ID_SALLE.add(2); ID_SALLE.add(3);
         * ID_ENSEIGNANT.add(1); ID_ENSEIGNANT.add(2); ID_ENSEIGNANT.add(3);
         *
         * Seance seance = new
         * Seance(ID,SEMAINE,DATE,HEURE_DEBUT,HEURE_FIN,ETAT,ID_COURS,ID_TYPE,ID_GROUPE,ID_SALLE,ID_ENSEIGNANT);
         *
         * seancedao.create(seance);*
         */
        DAO<Utilisateur> utilisateurDao = new DAO_Utilisateur();
        System.out.println("1");
        Utilisateur tmpUser = utilisateurDao.find(9);
        System.out.println("2");
        Recherche tmpRechercher = new Recherche(tmpUser);
        System.out.println("3");
        ArrayList<Seance> arraySeance = new ArrayList<>();
        try {
            arraySeance = tmpRechercher.RechercheSeanceUti();
            System.out.println("4");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(arraySeance.get(0).GET_ID());
        // Fin import
        
        
        
        
        
        
        
        pSemaine = new ArrayList<>();

        ArrayList test = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                test.add("Bonjour");
            }
        }
        ArrayList prof = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                prof.add("Mockber");
            }
        }
        test.set(5, "Java");
        test.set(6, "Match");
        test.set(15, "Java");
        test.set(7, "ELEC");
        test.set(9, "Java");
        test.set(13, "proba");
        test.set(2, "Java");

        initArray(pSemaine, 0, 115, 5, 7, Color.PINK, test, prof);

        Grille tmp = new Grille(menu + 10, sizeY, Color.BLUE, sizeX);
        tmp.addPanel(pContent);

        JLabel semaineRecherche = new JLabel("Semaine: ");
        JTextField semaineText = new JTextField();
        JButton semaineButton = new JButton("Rechercher");
        semaineButton.addActionListener(this);
        semaineRecherche.setBounds( menu + 10, 10, 100, 20);
        semaineText.setBounds( menu + 120, 10, 50, 20);
        semaineButton.setBounds( menu + 180, 10, 35, 20);
        pContent.add(semaineRecherche);
        pContent.add(semaineText);
        pContent.add(semaineButton);

        JButton bYes = new JButton("Yes");
        JButton bNo = new JButton("No");
        bYes.addActionListener(this);
        bNo.addActionListener(this);
        bYes.setBounds(0, 100, menu, 50);
        bNo.setBounds(0, 200, menu, 50);
        pMenu.add(bYes);
        pMenu.add(bNo);

        JPanel menuB = new JPanel();
        menuB.setLayout(null);
        menuB.setBounds(0, 300, menu, 50);
        menuB.setBackground(Color.yellow);

        JLabel p = new JLabel("BOUTTON");
        p.setBounds(0, 0, menu, 50);
        setFontSizeMax(p);
        menuB.add(p);

        pMenu.add(menuB);

        pMenu.revalidate();
        pMenu.repaint();
        pContent.revalidate();
        pContent.repaint();
        // TODO: Ajouter le menu left, sous formes de Jpanel prennant toute la largeur, pour le moment le new JPanel supprime les précédents

    }

    private void initArray(ArrayList<CoursWidget> semaine, int x, int y, int gap, int nbColumn, Color color, ArrayList<String> myLabel, ArrayList<String> myProf) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < nbColumn; j++) {
                CoursWidget pElem = new CoursWidget(myLabel.get(i * nbColumn + j), myProf.get(i * nbColumn + j), color, sizeX, sizeY, menu + 80 + (sizeX + 10) * i, y + (sizeY + gap * 4) * j, gap);
                semaine.add(pElem);
            }
        }
        linkArray(semaine, pContent);
    }

    private void linkArray(ArrayList<CoursWidget> from, JLayeredPane to) {
        for (int i = 0; i < from.size(); i++) {
            to.add(from.get(i).getCours(), 2);
        }
    }

    public void toggleVisibility() {
        if (pContent.isVisible()) {
            pContent.setVisible(false);
        } else {
            pContent.setVisible(true);
        }
    }
}
