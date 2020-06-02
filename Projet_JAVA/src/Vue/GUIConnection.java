package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Controleur.Connexion;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class GUIConnection extends JFrame implements ActionListener {
    
    private JFrame fMain;
    private JPanel pMenu;
    private JPanel pContent;

    private JButton yes;
    private JButton no;
    
    
    final private int height = 1000;
    final private int width = 1600;
    final private int menu = 400;
    final static private int sizeX = 175;
    final static private int sizeY = 100;

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel pwdLabel;
    private static JPasswordField pwdText;
    private static JButton button;
    private static JLabel success;

    public static void main(String[] args) {
        GUIConnection myGUI = new GUIConnection();
    }
    
    public GUIConnection() {
        initConnection();
    }
    
    private void initConnection() {
        fMain = new JFrame("ECE-Agenda");
        fMain.setSize(width, height);
        fMain.setLocation((1920 / 2) - (width / 2), (1080 / 2) - (height / 2));
        fMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fMain.setVisible(true);
        fMain.setResizable(false);

        pContent = new JPanel();
        pContent.setBackground(Color.WHITE);
        pContent.setLayout(null);
        
        userLabel = new JLabel("User");
        userLabel.setBounds(width/2 -80, height/2 -15 + 20, 80, 30);
        pContent.add(userLabel);

        userText = new JTextField();
        userText.setBounds(width/2, height/2 -15 + 20, 165, 30);
        pContent.add(userText);

        pwdLabel = new JLabel("Password");
        pwdLabel.setBounds(width/2 -80, height/2 -15 + 70, 80, 30);
        pContent.add(pwdLabel);

        pwdText = new JPasswordField();
        pwdText.setBounds(width/2, height/2 -15 + 70, 165, 30);
        pContent.add(pwdText);

        button = new JButton("Login");
        button.setBounds(width/2, height/2 -15 + 120, 80, 25);
        button.addActionListener(this);
        pContent.add(button);

        success = new JLabel("");
        success.setBounds(width/2, height/2 -15 + 170, 300, 25);
        pContent.add(success);
        
        //fMain.add(pMenu);
        fMain.add(pContent);

        fMain.repaint();
        fMain.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String pwd = pwdText.getText();

        System.out.println(user + " " + pwd);
        
        Connexion myCo = new Connexion();
  
        if (myCo.connexion(user, pwd)) {
        //if ("p".equals(user) && "p".equals(pwd)) {
            success.setText("Login successful");
            new CustomFrame().setVisible(true);
            fMain.setVisible(false);
        }
        else {
            success.setText("Error");
        }
    }
}