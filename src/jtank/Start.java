/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.Window;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import sun.java2d.pipe.DrawImage;

/**
 *
 * @author Ali salmani
 */
public class Start extends JPanel{

    private ImageIcon backgroundImage1;
    
    /*
    private JButton startButton;
    private JButton exiteButton;
    private JPanel startPanel;
    
   
    public Start() {
        

        ButtonHandler buttonHandler = new ButtonHandler();
        
        setLayout(null);
        startButton = new JButton("START");
        exiteButton = new JButton("EXITE");
        //startButton.setForeground(Color.WHITE);
        //exiteButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Serif", Font.BOLD, 20));
        exiteButton.setFont(new Font("Serif", Font.BOLD, 20));
        startButton.addMouseListener(buttonHandler);
        exiteButton.addMouseListener(buttonHandler);
        add(startButton);
        add(exiteButton);
        getComponent(0).setBounds(60, 50, 110, 50);
        getComponent(1).setBounds(60, 130, 110, 50);
        
    }


    private class ButtonHandler extends JTank implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()==startButton){
                Select select = new Select();
                //component.add(select,BorderLayout.CENTER);
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
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
*/    
    
    @Override
    public void paintComponent( Graphics g){

        super.paintComponent(g);
        
        Graphics2D g2d = ( Graphics2D ) g;
        
        
        backgroundImage1 = new ImageIcon(this.getClass().getResource("home.jpg"));
        backgroundImage1.paintIcon(this, g, 0, 0);
        
        g2d.setPaint( Color.RED );
        //g2d.draw (new Rectangle2D.Double (80,30,45,100) );
    }
    
}
