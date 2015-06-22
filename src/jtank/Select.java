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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.*;
import static jtank.Component.select;

/**
 *
 * @author Ali salmani
 */
public class Select extends JPanel{
    
    private ImageIcon backgroundImage2;
    private JLabel selT1Label;
    private JLabel selT2Label;
    private JLabel selB3Label;
    private JLabel selT1LabelTxt;
    private JLabel selT2LabelTxt;
    private JLabel selB3LabelTxt;
    private JTextField player1Name;
    private JTextField player2Name;
    private Icon[] selT1Icon;
    private Icon[] selT2Icon;
    private Icon[] selB3Icon;
    private String[] tank1Array;
    private String[] tank2Array;
    private String[] background3Array;
    private JComboBox selT1Box;
    private JComboBox selT2Box;
    private JComboBox selB3Box;
    private JButton play;
    private String[] selections;
    

    public Select() {
        
        setLayout(null);
        ButtonHandler buttonHandler = new ButtonHandler();
        ComboBoxHandler comboBoxHandler = new ComboBoxHandler();
        tank1Array = new String[] {"T11", "T21", "T31", "T41", "T51"};
        tank2Array = new String[] {"T12", "T22", "T32", "T42", "T52"};
        background3Array = new String[] {"B1", "B2", "B3", "B4", "B5"};
        
        
        selections = new String[] {tank1Array[0],tank2Array[0],background3Array[0],"Ali","Salmani"};
        
        player1Name = new JTextField(200);
        player2Name = new JTextField(200);
        selT1LabelTxt = new JLabel("Player1:");
        selT2LabelTxt = new JLabel("Player2:");
        selB3LabelTxt = new JLabel("Background:");
        selT1Label = new JLabel();
        selT2Label = new JLabel();
        selB3Label = new JLabel();
        selT1Icon = new Icon[] {new ImageIcon(getClass().getResource(tank1Array[0]+"S.jpg")),new ImageIcon(getClass().getResource(tank1Array[1]+"S.jpg")),new ImageIcon(getClass().getResource(tank1Array[2]+"S.jpg")),new ImageIcon(getClass().getResource(tank1Array[3]+"S.jpg")),new ImageIcon(getClass().getResource(tank1Array[4]+"S.jpg"))};
        selT2Icon = new Icon[] {new ImageIcon(getClass().getResource(tank2Array[0]+"S.jpg")),new ImageIcon(getClass().getResource(tank2Array[1]+"S.jpg")),new ImageIcon(getClass().getResource(tank2Array[2]+"S.jpg")),new ImageIcon(getClass().getResource(tank2Array[3]+"S.jpg")),new ImageIcon(getClass().getResource(tank2Array[4]+"S.jpg"))};
        selB3Icon = new Icon[] {new ImageIcon(getClass().getResource(background3Array[0]+"S.jpg")),new ImageIcon(getClass().getResource(background3Array[1]+"S.jpg")),new ImageIcon(getClass().getResource(background3Array[2]+"S.jpg")),new ImageIcon(getClass().getResource(background3Array[3]+"S.jpg")),new ImageIcon(getClass().getResource(background3Array[4]+"S.jpg"))};
        selT1Label.setIcon(selT1Icon[0]);
        selT2Label.setIcon(selT2Icon[0]);
        selB3Label.setIcon(selB3Icon[0]);
        
        
        selT1Box = new JComboBox(tank1Array);
        selT2Box = new JComboBox(tank2Array);
        selB3Box = new JComboBox(background3Array);
        selT1Box.setMaximumRowCount(4);
        selT2Box.setMaximumRowCount(4);
        selB3Box.setMaximumRowCount(4);
        selT1Box.addItemListener(comboBoxHandler);
        selT2Box.addItemListener(comboBoxHandler);
        selB3Box.addItemListener(comboBoxHandler);
        
        
        
        
        play = new JButton("PLAY");
        play.setBackground(new Color(238, 238, 238));
        play.setFont(new Font("Serif", Font.BOLD, 20));
        play.addMouseListener(buttonHandler);
        add(selT1LabelTxt);
        add(selT2LabelTxt);
        add(selB3LabelTxt);
        add(player1Name);
        add(player2Name);
        add(selT1Label);
        add(selT2Label);
        add(selB3Label);
        add(selT1Box);
        add(selT2Box);
        add(selB3Box);
        add(play);
        getComponent(0).setBounds(50, 255, 100, 15);
        getComponent(1).setBounds(950, 255, 100, 15);
        getComponent(2).setBounds(400, 30, 100, 15);
        getComponent(3).setBounds(50, 275, 200, 20);
        getComponent(4).setBounds(950, 275, 200, 20);
        getComponent(5).setBounds(50, 300, 300, 200);
        getComponent(6).setBounds(950, 300, 300, 200);
        getComponent(7).setBounds(400, 50, 500, 300);
        getComponent(8).setBounds(50, 520, 300, 25);
        getComponent(9).setBounds(950, 520, 300, 25);
        getComponent(10).setBounds(400, 370, 500, 25);
        getComponent(11).setBounds(1200, 50, 120, 50);
        
    }
    
    
    
    @Override
    public void paintComponent( Graphics g){

        super.paintComponent(g);
        
        Graphics2D g2d = ( Graphics2D ) g;
        
        
        backgroundImage2 = new ImageIcon(this.getClass().getResource("home2.jpg"));
        backgroundImage2.paintIcon(this, g, 0, 0);
        
        g2d.setPaint( Color.RED );
        //g2d.draw (new Rectangle2D.Double (80,30,45,100) );
    }
    
    private class ComboBoxHandler implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getSource()==selT1Box){
                if(e.getStateChange()== ItemEvent.SELECTED){
                    selT1Label.setIcon(selT1Icon[selT1Box.getSelectedIndex()]);
                    selections[0]=tank1Array[selT1Box.getSelectedIndex()];
                }
            }
            else if(e.getSource()==selT2Box){
                if(e.getStateChange()== ItemEvent.SELECTED){
                    selT2Label.setIcon(selT2Icon[selT2Box.getSelectedIndex()]);
                    selections[1]=tank2Array[selT2Box.getSelectedIndex()];
                }
            }
            else{
                if(e.getStateChange()== ItemEvent.SELECTED){
                    selB3Label.setIcon(selB3Icon[selB3Box.getSelectedIndex()]);
                    selections[2]=background3Array[selB3Box.getSelectedIndex()];
                }
            }
        }
        
    }
    
    private class ButtonHandler implements MouseListener{
        
        
        @Override
        public void mouseClicked(MouseEvent e) {
                selections[3]=player1Name.getText();
                selections[4]=player2Name.getText();
                Game game = new Game(selections);
                JTank.component.add( game ,BorderLayout.CENTER);
                JTank.component.remove(select);
                JTank.component.validate();
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
            play.setBackground(Color.BLUE);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            play.setBackground(new Color(238, 238, 238));
        }
        
        
    }
    
    
    
}

