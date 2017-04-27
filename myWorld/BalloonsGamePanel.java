/*
  Author:   Solehjon Ruziboev
  Date:     21.03.2016
  Version:  1.0
 */

import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import myWorld.*;
import shapes.*;

public class BalloonsGamePanel extends JPanel{
       private final static int NUMBER_OF_BALLOONS = 25, WIDTH = 500, HEIGHT = 800, DELAY = 50, TIME = 30;
       private ShapeContainer balloons;
       private javax.swing.Timer t;
       private int points, ellapsedTime;
       private JLabel labelPoints;
       
       public BalloonsGamePanel(){
              balloons = new ShapeContainer();
              setPreferredSize(new Dimension(HEIGHT, WIDTH));
              setBackground(Color.BLACK);
              points = ellapsedTime = 0;
              labelPoints = new JLabel("Points: " + points + "      Time Left: " + TIME);
              labelPoints.setForeground(Color.GREEN);
              
              add(labelPoints);
              /*
              for (int i = 0; i < NUMBER_OF_BALLOONS; i++){
                  balloons.addShape(new Balloon((int)(Math.random()*(HEIGHT + 1)), (int)(Math.random()*(WIDTH + 1))));
              }
              */
              event e = new event();
              t = new javax.swing.Timer(DELAY, e);
              t.setRepeats(true);
              t.start();
              
              boom hey = new boom();
              addMouseListener(hey);
       }
       
       public class event implements ActionListener{
              int response;
              Iterator ind = balloons.iterator();
              
              public void actionPerformed(ActionEvent e){
                     ellapsedTime += DELAY;
                     for (int i = 0; i < balloons.getSize(); i++){
                         ((Balloon)balloons.getLinkOf(i)).grow();
                         if (((Balloon)balloons.getLinkOf(i)).isExploded()){
                            balloons.removeAt(i);
                            i--;
                         }
                     }
                     if (NUMBER_OF_BALLOONS - balloons.getSize() > 0){
                        balloons.addShape(new Balloon((int)(Math.random()*(HEIGHT + 1)), (int)(Math.random()*(WIDTH + 1))));
                     }
                     if (ellapsedTime % 1000 == 0){
                        labelPoints.setText("Points: " + points + "      Time Left: " + (TIME - (ellapsedTime/1000)));
                     }
                     repaint();
                     
                     if (ellapsedTime >= TIME * 1000){
                        //flag= false; 
                        t.stop();
                        response = JOptionPane.showConfirmDialog(null, "Play again?", "GAME OVER", JOptionPane.YES_NO_OPTION);
                        if (response == JOptionPane.YES_OPTION){
                           balloons.clear();                          
                           ellapsedTime = 0; 
                           t.start();
                           points = 0;
                           labelPoints.setText("Points: " + points + "      Time Left: " + TIME);
                        }
                        else{
                           System.exit(0);
                        }
                     }
                     
              }   
       }
       
       public class boom implements MouseListener{
              public void mousePressed(MouseEvent e) {
                     int cur = 0;
                     if (ellapsedTime < TIME * 1000){
                         cur = balloons.selectAllAt(e.getX(), e.getY());
                         balloons.removeAllSelectedShapes(); 
                     }
                     if (cur > 1){
                        points += cur;
                        labelPoints.setText("Points: " + points + "      Time Left: " + (TIME - (ellapsedTime/1000)));
                     }
              }
              
              public void mouseReleased(MouseEvent e) {

              }
              
              public void mouseEntered(MouseEvent e) {

              }
              
              public void mouseExited(MouseEvent e) {
                
              }
              
              public void mouseClicked(MouseEvent e) {

              }
       }
       
       public void paintComponent(Graphics g){
              super.paintComponent(g);
              for (int i = 0; i < balloons.getSize(); i++){
                  ((Drawable)balloons.getLinkOf(i)).draw(g);
              }
       }
}
