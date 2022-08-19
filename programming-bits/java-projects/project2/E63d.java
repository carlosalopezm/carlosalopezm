/** 
 * Author: Carlos López
 * Uni: cal2266 
 * Date: 02/05/21 
 *E63d.java
 **/ 
// not a single line surpasses 80 characters


import java.util.Scanner; 
public class E63d{
    
    public static void main(String[] args){
        // Ask the user for some input 
        System.out.println("Welcome!");
        System.out.println("Enter at least one word and at most a small paragraph: ");
        
        Scanner a = new Scanner(System.in); 
        String sentence = a.nextLine(); 
        // create the counters for each vowel
        int countA = 0; 
        
        int countE = 0; 
        
        int countI = 0; 
        
        int countO = 0; 
        
        int countU = 0; 
        
        int totalCount = 0; 
        // A for loop that iterates tthorough the String sentence
        for(int i = 0; i < sentence.length(); i++  ){
          
          sentence = sentence.toLowerCase();
          char letter = sentence.charAt(i); 
            
          // if char equals a increment   
            
            if(letter == 'a'){
                
                countA++;
                totalCount++; 
            }
            
            // if char equals e increment   
            
            if(letter == 'e'){
                
                countE++;
                totalCount++; 
            }
            
            // if char equals I increment   
            
            if(letter== 'i'){
                
                countI++;
                totalCount++; 
            }
            
            // if char equals o increment   
            
            if(letter == 'o'){
                
                countO++; 
                totalCount++; 
            }
            
            // if char equals u increment   
            
            if(letter == 'u'){
                
                countU++;
                totalCount++; 
            }
            
           // count is incremented for each to get the total # of vowels 
            
        }
        
        // do not print the count for those which do not appear.
        if(totalCount != 0){ 
          System.out.println("Times vowels occur: " + totalCount );
          System.out.println("The following vowels occur at least once.");
        
        // The following if branches will ensure that only the counters with a value are printed  
          if(countA != 0) 
                System.out.println("Times a occurs: " + countA );
        
          if(countE != 0) 
                System.out.println("Times e occurs: " + countE );
        
          if(countI != 0) 
                System.out.println("Times i occurs: " + countI );
        
          if(countO != 0) 
                System.out.println("Times o occurs: " + countO);
        
          if(countU != 0) 
            System.out.println("Times u occurs: " + countU );
        }
        // in case there are no vowels
        else
            System.out.println("There are no vowels. What gibberish did you input?");
        
      
        
        
        
    }
}
