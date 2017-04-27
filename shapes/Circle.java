import java.util.*;
import java.lang.*;

/*
 * 
 Author: Ruziboev Solehjon
 Date: 29.02.2016
 Version: 1.0
 */

public class Circle extends Shape implements Selectable {
       
       // constants
       final static double P = 3.14159;
      
       // properties
       protected int radius;
       protected boolean selected;
       
       // constructors
       public Circle (int radius, double x, double y){
              this.radius = radius;
              
              this.x = x;
              this.y = y;
              
              selected = false;
       } 
       
       // methods
       public double getArea(){
              return P * radius * radius;
       }
       
       public double getRadius(){
              return radius;
       }

       public boolean getSelected(){
              return selected;
       }
       
       public void setSelected(boolean x){
              selected = x;
       }
       
       public Shape contains(int x, int y){
              if (((x - this.x)*(x - this.x)) + ((y - this. y)*(y - this.y)) <= (radius*radius))
                 return this;
              return null;
       }
       
       public String toString (){
              return "Shape - Circle\nThe area is - " + getArea() + "\nThe radius is - " + getRadius() + "\nThe state of selected: " + selected + "\nThe location is - " + x + ", " + y + "\n\n";
              
       }
} 