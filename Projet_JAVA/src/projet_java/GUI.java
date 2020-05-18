
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pierr
 */
public class GUI implements ActionListener{
    
    int count = 0;
    private JFrame frame;
    private JLabel label;
    private JPanel panel;
    
    public GUI() {
        frame = new JFrame();
        
        JButton button = new JButton("Click me");
        label = new JLabel("Number of clicks: 0");
        button.addActionListener(this);
        
        panel = new JPanel();
        
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our Gui");
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new GUI();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks: " + count);
    }
}
