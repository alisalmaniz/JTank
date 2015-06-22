/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.tan;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ali salmani
 */
public class Game extends JPanel {
    
    private ImageIcon backgroundImage3;
    private ImageIcon tank1;
    private ImageIcon tank2;
    private ImageIcon tube1;
    private ImageIcon tube2;
    private ImageIcon shot;
    
    private JLabel player1;
    private JLabel player2;
    private JLabel status1;
    private JLabel status2;
    
    private String[] selections;

    private int x1;
    private int x2;
    double tank1rotate;
    double tank2rotate;
    double tube1rotate;
    double tube2rotate;
    private Random rand;
    private int health1;
    private int health2;
    private int turn;
    
    private int shotX;
    private int shotY;
    private boolean is1Shot;
    private boolean is2Shot;
    
    public Game(String[] selections) {
        setLayout(null);
        
        KeyHandler keyHandler = new KeyHandler(this);
        this.addKeyListener(keyHandler);
        
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.selections= new String[5];
        this.selections=selections;
        
        turn=0;
        is1Shot=false;
        is2Shot=false;
        
        rand = new Random();
        
        x1=  rand.nextInt(1300/2);
        x2= (1300/2) + rand.nextInt(1300/2);
        
        shotX=0;
        shotY=0;
        
        tank1rotate = rotate(x1);
        tank2rotate = rotate(x2);
        tube1rotate = tank1rotate;
        tube2rotate = tank2rotate;
        health1 = 100;
        health2 = 100;
        player1 = new JLabel(selections[3]);
        player2 = new JLabel(selections[4]);
        status1 = new JLabel("Health = "+ health1 );
        status2 = new JLabel("Health = "+ health2 );
        player1.setForeground(Color.RED);
        player2.setForeground(Color.RED);
        status1.setForeground(Color.RED);
        status2.setForeground(Color.RED);
        
        
        
        add(player1);
        add(player2);
        add(status1);
        add(status2);
        getComponent(0).setBounds(10, 10, 200, 10);
        getComponent(1).setBounds(1100, 10, 200, 10);
        getComponent(2).setBounds(10, 25, 200, 10);
        getComponent(3).setBounds(1100, 25, 200, 10);
        
        for(int x=0;x<1000;x++){
            System.out.println(setY(x));
            
        }
    }
        
        
    
    
    public int setY (int x){
        double y=0;

        if(x<=450)
            y=-0.47*x +420;
        else if(x<=463)
            y=-x+658;
        else if (x<=480)
            y=195;
        else if (x<600)
            y=0.25*x + 75;
        else if (x<835)
            y=0.1*x + 163;
        else if (x<900)
            y=0.5*x -171;
        else if (x<1000)
            y=0.6*x -261;
        else if (x<1160)
            y=0.4*x -61;
        else
            y=0.2*x +171;
       
        return (int)y;
    }
    public double rotate(int x){
        double r=0;
        
        if(x<440)
            r=0.4;
        else if(x<470)
            r=-(0.4/30)*(x-439)+0.4;
        else if (x<=490)
            r=0;
        else if (x<510)
            r=-(0.3/20)*(x-490);
        else if (x<=600)
            r=-0.3;
        else if (x<610)
            r=+(0.1/10)*(x-600)-0.3;
        else if (x<830)
            r=-0.2;
        else if (x<850)
            r=-(0.2/20)*(x-830)-0.2;
        else if (x<900)
            r=-0.4;
        else if (x<920)
            r=-(0.3/20)*(x-899)-0.4;
        else if (x<1000)
            r=-0.7;
        else if (x<1010)
            r=+(0.2/10)*(x-999)-0.7;
        else if (x<1070)
            r=-0.5;
        else if (x<1090)
            r=+(0.2/20)*(x-1069)-0.5;
        else
            r=-0.3;
        
        return r;
    }
    
    
    @Override
    public void paintComponent( Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2d = ( Graphics2D ) g;
        
        
        backgroundImage3 = new ImageIcon(this.getClass().getResource(selections[2]+".jpg"));
        backgroundImage3.paintIcon(this, g, 0, 0);
        
        tank1 = new ImageIcon(this.getClass().getResource(selections[0]+".png"));
        tank2 = new ImageIcon(this.getClass().getResource(selections[1]+".png"));
        tube1 = new ImageIcon(this.getClass().getResource("tube1.png"));
        tube2 = new ImageIcon(this.getClass().getResource("tube2.png"));
        shot = new ImageIcon(this.getClass().getResource("shotS.png"));
        
        
        
            
            g2d.rotate(-tank1rotate, x1+25, setY(x1)+4);
            tank1.paintIcon(this, g, x1, setY(x1));
            //tube1.paintIcon(this, g, x1+31, setY(x1)+4);
            g2d.rotate(tank1rotate, x1+25, setY(x1)+4);
            
            
            
            g2d.rotate(-tank2rotate, x2+25, setY(x2)+4);
            tank2.paintIcon(this, g, x2, setY(x2));
            //tube2.paintIcon(this, g, x2-31, setY(x2)+4);
            //shot.paintIcon(this, g2d, x2+25,setY(x2)+4);
            g2d.rotate(tank2rotate, x2+25, setY(x2)+4);
        
        
        
        if(is1Shot){
            if(tube1rotate<3.14/2)
                g2d.rotate(-tube1rotate, x1+25, setY(x1)+4);
            else
                g2d.rotate(3.14-tube1rotate, x1+25, setY(x1)+4);
            
            shot.paintIcon(this, g2d, shotX,shotY);
            if(tube1rotate<3.14/2)
                g2d.rotate(tube1rotate, x1+25, setY(x1)+4);
            else
                g2d.rotate(tube1rotate-3.14, x1+25, setY(x1)+4);
            is1Shot= false;
        }
        else if(is2Shot){
            if(tube2rotate>-3.14/2)
                g2d.rotate(-tube2rotate, x2+25, setY(x2)+4);
            else
                g2d.rotate(3.14+tube2rotate, x2+25, setY(x2)+4);
            shot.paintIcon(this, g2d, shotX,shotY);
            if(tube2rotate>-3.14/2)
                g2d.rotate(tube2rotate, x2+25, setY(x2)+4);
            else
                g2d.rotate(-tube2rotate-3.14, x2+25, setY(x2)+4);
            is2Shot= false;
        }
        g2d.rotate(-tube1rotate, x1+25, setY(x1)+4);
        tube1.paintIcon(this, g, x1+25, setY(x1)+2);
        g2d.rotate(tube1rotate, x1+25, setY(x1)+4);
        
        g2d.rotate(-tube2rotate, x2+25, setY(x2)+4);
        tube2.paintIcon(this, g, x2-33, setY(x2)+2);
        g2d.rotate(tube2rotate, x2+25, setY(x2)+4);
        //g2d.setPaint( Color.RED );
        //g2d.draw (new Rectangle2D.Double (80,30,45,100) );*/
        
    }

    private class KeyHandler implements KeyListener{

        private Game game;
        public KeyHandler(Game game) {
            this.game = game;
        }

        
        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            double tank1rotateChange=0;
            double tank2rotateChange=0;
            if(e.getKeyCode()==KeyEvent.VK_SPACE){
                Graphics2D g2d = (Graphics2D) game.getGraphics();
                if(turn%2==0){
                    if(tube1rotate<3.14/2){
                        shotX=x1+85;
                        shotY=setY(x1)+2;
                    }
                    else{
                        shotX=x1-35;
                        shotY=setY(x1)+2;
                    }
                    for(int f=0; f<1000; f++){
                        is1Shot=true;
                        try {
                            Thread.sleep(3);                 
                        } catch(InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                           //(int)((1.0/10)*(shotX*shotX-400*shotX));           //+(int)(setY(x1)+2-sin(tube1rotate)));
                        game.paintImmediately(0, 0, 1360, 700);
                        if(tube1rotate<3.14/2){
                            shotX++;
                            
                        }
                        else{
                            shotX--;
                           
                        }
                        shotY=(int)(   (1.0/1000)*(f*f-10*f)    +setY(x1)+2 );
                        
                    }
                    if(Component.players==2)
                        turn++;
                    else{
                        shotX=x2-33;
                        shotY=setY(x2)+2;
                        for(int f=0; f<1000; f++){
                        is2Shot=true;
                        try {
                            Thread.sleep(3);                 
                        } catch(InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                           //(int)((1.0/10)*(shotX*shotX-400*shotX));           //+(int)(setY(x1)+2-sin(tube1rotate)));
                        game.paintImmediately(0, 0, 1360, 700);
                        shotX--;
                        shotY=(int)(   (1.0/1000)*(f*f-10*f)    +setY(x2)+2 );
                        }
                    }
                }
                else{
                    
                    
                    if(tube2rotate>-3.14){
                        shotX=x2-33;
                        shotY=setY(x2)+2;
                    }
                    else{
                        shotX=x2+85;
                        shotY=setY(x2)+2;
                    }
                    for(int f=0; f<1000; f++){
                        is2Shot=true;
                        try {
                            Thread.sleep(3);                 
                        } catch(InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                           //(int)((1.0/10)*(shotX*shotX-400*shotX));           //+(int)(setY(x1)+2-sin(tube1rotate)));
                        game.paintImmediately(0, 0, 1360, 700);
                        
                        if(tube2rotate>-3.14)
                            shotX--;
                        else
                            shotX++;
                        shotY=(int)(   (1.0/1000)*(f*f-10*f)    +setY(x2)+2 );
                        //System.out.println(shotY);
                    }
                                        
                    turn++;
                }
                
            }
            else if(e.getKeyCode()==KeyEvent.VK_UP){
                if(turn%2==0){
                    if(tube1rotate<3.14+tank1rotate)
                        tube1rotate+=0.1;
                }
                else{System.out.println(tube2rotate);
                    if(tube2rotate>tank2rotate-3.14)
                        tube2rotate-=0.1;
                }
                game.repaint();
                
            }
            else if(e.getKeyCode()==KeyEvent.VK_DOWN){
                if(turn%2==0){
                    if(tube1rotate>tank1rotate)
                        tube1rotate-=0.1;
                }
                else{
                    if(tube2rotate<tank2rotate)
                    tube2rotate+=0.1;
                }
                game.repaint();
            }
            else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                
                if(turn%2==0){
                    if(x1<1300){
                        tank1rotateChange=tank1rotate;
                        x1++;
                        tank1rotate = rotate(x1);
                        tank1rotateChange=tank1rotate-tank1rotateChange;
                        tube1rotate+=tank1rotateChange;
                    }
                }
                else{
                    if(x2<1300){
                        tank2rotateChange=tank2rotate;
                        x2++;
                        tank2rotate = rotate(x2);
                        tank2rotateChange=tank2rotate-tank2rotateChange;
                        tube2rotate+=tank2rotateChange;
                    }
                }
                
//                Graphics2D g2d = (Graphics2D) game.getGraphics();
                game.repaint();
            }
            else if(e.getKeyCode()==KeyEvent.VK_LEFT){
                if(turn%2==0){
                    if(x1>0){
                        tank1rotateChange=tank1rotate;
                        x1--;
                        tank1rotate = rotate(x1);
                        tank1rotateChange=tank1rotate-tank1rotateChange;
                        tube1rotate+=tank1rotateChange;
                    }
                }
                else{
                    if(x2>0){
                        tank2rotateChange=tank2rotate;
                        x2--;
                        tank2rotate = rotate(x2);
                        tank2rotateChange=tank2rotate-tank2rotateChange;
                        tube2rotate+=tank2rotateChange;
                    }
                }
                
//                Graphics2D g2d = (Graphics2D) game.getGraphics();
                game.repaint();
            }
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
    }
}
