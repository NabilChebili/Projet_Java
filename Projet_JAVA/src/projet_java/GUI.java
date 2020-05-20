package projet_java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Controleur.Connexion;

public class GUI implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel pwdLabel;
    private static JPasswordField pwdText;
    private static JButton button;
    private static JLabel success;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);
        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        pwdLabel = new JLabel("Password");
        pwdLabel.setBounds(10, 50, 80, 25);
        panel.add(pwdLabel);

        pwdText = new JPasswordField();
        pwdText.setBounds(100, 50, 165, 25);
        panel.add(pwdText);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new GUI());
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String pwd = pwdText.getText();

        System.out.println(user + " " + pwd);
           
        if (user.equals("Pierre") && pwd.equals("password")) {
            success.setText("Login successful");
        }
        else {
            success.setText("Error");
        }
    }
}