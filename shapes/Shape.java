import java.util.*;
import java.lang.*;

/*
 * 
 Author: Ruziboev Solehjon
 Date: 29.02.2016
 Version: 1.0
 */

public abstract class Shape implements Locatable{
       
       // properties
       protected double x, y;
  
       // methods
       public abstract double getArea();
       
       public void draw(){
       
       }

       public void setLocation(double x, double y){
              this.x = x;
              this.y = y;
       }
       
       public double getX(){
              return x;
       }
       
       public double getY(){
              return y; 
       }
} 