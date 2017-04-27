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

public class Lab04b{
       public static void main(String args[]){
              JFrame main = new JFrame("Ballons");
              BalloonsGamePanel panel1 = new BalloonsGamePanel();
              
              main.add(panel1);
              main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              main.setVisible(true);
              main.pack();
       }
}
