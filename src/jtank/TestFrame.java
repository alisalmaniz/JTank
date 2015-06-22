/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtank;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Ali salmani
 */
public class TestFrame extends JFrame{

    private String[] selections;
    
    
    public TestFrame(){
        
        setLayout(new BorderLayout());
        selections = new String[] {"T1","T1","B1","Ali","Salmani"};
        Game game = new Game(selections);
        add(game, BorderLayout.CENTER);
        
        setSize(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

}
