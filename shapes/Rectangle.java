import java.util.*;
import java.lang.*;

/*
 * 
 Author: Ruziboev Solehjon
 Date: 29.02.2016
 Version: 1.0
 */

public class Rectangle extends Shape implements Selectable  {
        
       // properties
       private int width, height;
       private boolean selected;
       
       // constructors
       public Rectangle (int width, int height, double x, double y){
              this.width = width;
              this.height = height;
              
              this.x = x;
              this.y = y;
              
              selected = false;
       } 
     
       // methods
       public double getArea(){
              return (double)(width * height);
       }
       
       public int getWidth(){
              return width;
       }
       
       public int getHeight(){
              return height;
       }
       
       public boolean getSelected(){
              return selected;
       }
       
       public void setSelected(boolean x){
              selected = x;
       }
       
       public Shape contains(int x, int y){
              if (this.x <= x && this.y <= y && this.x + height >= x && this.y + width >= y)
                 return this;
              else
                 return null;
       }
       
       public String toString (){
              return "Shape - Rectangle\nThe area is - " + getArea() + "\nThe width and height are - " + getWidth() + ", " + getHeight() + "\nThe state of selected: " + selected + "\nThe location is - " + x + ", " + y + "\n\n";
              
       }
} 