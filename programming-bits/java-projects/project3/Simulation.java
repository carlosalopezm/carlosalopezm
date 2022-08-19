/**
 * Author: Carlos López 
 * UNI: cal2266
 * This class should run simulations to determine
 * whether or not the Odd-Even game is fair and if
 * not who has the advantage and what is a strategy
 * that will realize that adavantage.
 * 
 * 
 */
// not a single line surpasses 80 characters 
import java.util.List; 
import java.util.ArrayList;
import java.util.Collections;
public class Simulation{
    
    
    public static void main(String[] args){
        int minTemp = 300000; 
        List<Double> listT1 = new ArrayList<Double>();
        List<Integer> listMin = new ArrayList<Integer>();
        double t1;
        double t2;
        System.out.println("The simulation is loading...");
        for(t1 =0.0 ; t1 <=1; t1 += 0.02){
            for(t2 = 0.0; t2 <=1; t2 += 0.02){
                Game g = new Game(t1,t2); 
                g.play(100000); // play 100000 games.
                
                if(g.getP1Score() < minTemp){
                      minTemp = g.getP1Score();//determines the min value for the outer loop iteration
                   }
          } 
            listT1.add(t1); // adds the respective threshold
            listMin.add(minTemp);//
            minTemp = 300000;
              
          }
        // gets the maximum minimum
        int maxMin = Collections.max(listMin); 
        // gets the threshold associated with that value
        double t1Max = listT1.get(listMin.indexOf(maxMin)); 
        // prints conclusion on best threshold
        System.out.printf("P1's best strategy is a threshold equal to %.2f ",t1Max); 
        System.out.print("since the minimum score for the row is " + maxMin);
        System.out.print(", which is the greatest minimum score. Consequently, ");  
        System.out.print("the game is unfair for p2 when p1 has this threshold value.\n");
        // correction the main method cannot have more than 20 lines 
          
        }
        
     
 }
        
        
        
        

