/** 
 * Author: Carlos López
 * Uni: cal2266 
 * Date: 02/05/21 
 *E63e.java 
 **/
// not a single line surpasses 80 characters

import java.util.Scanner;
import java.util.ArrayList; 
public class E63e{
    
    public static void main(String[] args){
        //prompt 
        System.out.println("Enter at least one word and at most a small paragraph: ");
        // scanner 
        Scanner a = new Scanner(System.in);
        // input saved to string input 
        String input = a.nextLine();
        // array lists for indexes are initializes
        ArrayList<Integer> aCount = new ArrayList<Integer>();
        
        ArrayList<Integer> eCount = new ArrayList<Integer>();
        
        ArrayList<Integer> iCount = new ArrayList<Integer>();
        
        ArrayList<Integer> oCount = new ArrayList<Integer>();
        
        ArrayList<Integer> uCount = new ArrayList<Integer>();
        
        int indexCount = 0; 
        
        
        // set input to lowercase to ensure uppercase vowels are not excluded
        input = input.toLowerCase();
       // for loop to iterate through string input 
        for(int i = 0; i < input.length(); i++ ){
           // if branches add the index of the vowel if it appears 
            if(input.charAt(i) == 'a'){
                aCount.add(i);
                
                indexCount++; 
            }
            
            if(input.charAt(i) == 'e'){
              eCount.add(i);
              
              indexCount++; 
            }
            
            
            if(input.charAt(i) == 'i'){
              iCount.add(i);
                
              indexCount++; 
            }
            
            
            if(input.charAt(i) == 'o'){
              oCount.add(i);
                
              indexCount++; 
            }
            
            
            if(input.charAt(i) == 'u'){
              eCount.add(i);
                
              indexCount++; 
                
            }
            
            
            
        }
        // if branah that ensures there are vowels 
        if(indexCount >0){
        // print total index counts
          System.out.print("There are a total of " + indexCount); 
          System.out.println(" index locations in which a vowel appears. ");
          System.out.println("The indexes of the vowels that occur at least once:");
        // if branches to print only the prompts for vowels the appear
          if(aCount.isEmpty() == false){
            System.out.println("- A occurs at the following indexes: " + aCount + ".");
          }
        
          if(eCount.isEmpty() == false){
            System.out.println("- E occurs at the following indexes: " + eCount+ ".");
          }
        
          if(iCount.isEmpty() == false){
            System.out.println("- I occurs at the following indexes: " + iCount + ".");
          }
        
          if(oCount.isEmpty() == false){
            System.out.println("- O occurs at the following indexes: " + oCount + ".");
          }
        
          if(uCount.isEmpty() == false ){
            System.out.println("- U occurs at the following indexes: " + uCount + ".");
          }
        
        }
        // In case there are no vowels
        else{
            System.out.println("There is not a single index location in which a vowel appears.");
            System.out.println("What gibberish did you input?");
            }
    }
}




