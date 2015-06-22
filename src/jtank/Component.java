/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Ali salmani
 */
public class Component extends JFrame {
   
    //private ImageIcon backgroundImage1;
    private JButton startButton;
    private JButton exitButton;
    private JButton player1s;
    private JLabel title;
    private Start start;
    static int players = 0;
    static Select select;
    
    public Component(){
        
        super ("JTank");
        start = new Start();
        //selections = new String[] {"T1","T1","B1"};
        ButtonHandler buttonHandler = new ButtonHandler();
        
        start.setLayout(null);
        title = new JLabel("BATTLE TANKS");
        startButton = new JButton("2Players");
        player1s = new JButton("1Player");
        exitButton = new JButton("EXIT");
        title.setForeground(Color.RED);
        startButton.setBackground(new Color(238, 238, 238));
        player1s.setBackground(new Color(238, 238, 238));
        exitButton.setBackground(new Color(238, 238, 238));
        title.setFont(new Font("Serif", Font.BOLD, 60));
        startButton.setFont(new Font("Serif", Font.BOLD, 20));
        player1s.setFont(new Font("Serif", Font.BOLD, 20));
        exitButton.setFont(new Font("Serif", Font.BOLD, 20));
        startButton.addMouseListener(buttonHandler);
        player1s.addMouseListener(buttonHandler);
        exitButton.addMouseListener(buttonHandler);
        start.add(title);
        start.add(player1s);
        start.add(startButton);
        start.add(exitButton);
        start.getComponent(0).setBounds(30, 30, 500, 60);
        start.getComponent(1).setBounds(200, 150, 110, 50);
        start.getComponent(2).setBounds(200, 210, 110, 50);
        start.getComponent(3).setBounds(200, 300, 110, 50);
        
        
        
        setLayout(new BorderLayout());
        
        add ( start ,BorderLayout.CENTER);
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(JTank.class.getResource("homeIcon.jpg")));
        setSize(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        /*
        game = new Game(selections);
        add(game,BorderLayout.CENTER);
        select = new Select();
        add( select ,BorderLayout.CENTER);
        //remove(start);*/
    }


    private class ButtonHandler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()==startButton || e.getSource()==player1s){
                if(e.getSource()==startButton)
                    players=2;
                else
                    players=1;
                
                remove(start);
                select = new Select();
                add( select ,BorderLayout.CENTER);
                validate();
                
            }
            else{
                System.exit(0);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource()==startButton ){
                startButton.setBackground(Color.GREEN);
            }
            else if(e.getSource()==player1s){
                player1s.setBackground(Color.GREEN);
            }
            else{
                exitButton.setBackground(Color.red);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource()==startButton){
                startButton.setBackground(new Color(238, 238, 238));
            }
            else if(e.getSource()==player1s){
                player1s.setBackground(new Color(238, 238, 238));
            }
            else{
                exitButton.setBackground(new Color(238, 238, 238));
            }
        }
        
    }
    
    
    
    
    }
    
    
    

