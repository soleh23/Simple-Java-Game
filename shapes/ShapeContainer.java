import java.util.*;
import java.lang.*;

/*
 * 
 Author: Ruziboev Solehjon
 Date: 29.02.2016
 Version: 1.0
 */

public class ShapeContainer implements Iterable{
        
       // properties
       private ArrayList<Shape>list;
       
       // constructors
       public ShapeContainer(){
              list = new ArrayList<Shape>();
       } 
     
       // methods
       public void addShape(Shape x){
              list.add(x);
       }
       
       public double getArea(){
              double totalArea = 0; 
              for (int i = 0; i < list.size(); i++){
                  totalArea += list.get(i).getArea();
              }
              
              return totalArea;
       }
       public void clear(){
         while (list.size() > 0){
               list.remove(0);
         }
       }
       
       public void removeAt(int ind){
              if (ind < list.size())
                 list.remove(ind);
       }
       
       public int getSize(){
              return list.size();
       }
       
       public Shape getLinkOf(int ind){
              return list.get(ind);
       }
       
       // changes the state of the first shape that contains (x, y)
       public void markShape (int x, int y){ 
              for (int i = 0; i < list.size(); i++){
                  if (((Selectable)list.get(i)).contains(x, y) != null){
                     ((Selectable)list.get(i)).setSelected(!((Selectable)list.get(i)).getSelected());
                     i = list.size();
                  }
              }
       }
       
       // removes the selected shapes
       public void removeAllSelectedShapes(){
              for (int i = 0; i < list.size(); i++){
                  if (((Selectable)list.get(i)).getSelected()){
                     list.remove(i);
                     i--;
                  }
              }
       }
       
       public String toString(){
              String res = "";
              for (int i = 0; i < list.size(); i++){
                  res += list.get(i).toString();
              }
              
              return res;
       }
       
       public Iterator iterator(){
              return new ShapeContainerIterator();              
       }
       
       public int selectAllAt(int x, int y){
              int cnt = 0;
              for (int i = 0; i < list.size(); i++){
                  if (((Selectable)list.get(i)).contains(x, y) != null){
                     cnt++;
                     ((Selectable)list.get(i)).setSelected(true);
                  }
              }  
              return cnt;
       }
       
       public class ShapeContainerIterator implements Iterator{
              private int ind;
              public ShapeContainerIterator (){
                     ind = 0;
              }
              
              //methods
              public boolean hasNext(){
                     return (ind < list.size());
              }
              
              public Shape next(){
                     if (hasNext()){
                        return list.get(ind++);
                     }
                     return null;
              }
              
              public void remove(){
                     if (ind > 0){
                        list.remove(ind - 1);
                     }
              }
              
       }
       
} 