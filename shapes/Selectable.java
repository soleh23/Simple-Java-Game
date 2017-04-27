import java.util.*;
import java.lang.*;

/*
 * 
 Author: Ruziboev Solehjon
 Date: 29.02.2016
 Version: 1.0
 */

public interface Selectable{
       public boolean getSelected();
       public void setSelected (boolean x);
       public Shape contains(int x, int y);
}