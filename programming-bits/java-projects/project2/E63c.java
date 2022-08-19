/**
 * Author: Carlos López
 * Uni: cal2266 
 * Date: 02/05/21 
 *E63C.java
 **/ 
// not a single line surpasses 80 characters
import java.util.Scanner; 
public class E63c{
    
    public static void main(String[] args){
        System.out.println("Enter at least one word and at most a small paragraph: ");
        Scanner a = new Scanner(System.in); 
        // store the input of the user in the string input 
        String input = a.nextLine(); 
        int count = 0; 
        char [] ch = input.toCharArray();
        input = input.toLowerCase();
        // The for loop iterates through all characters, replacing vowels for underscores. 
        // the int count will increase for every swap undertaken. 
        for(int i = 0; i < input.length(); i++){
            
            if(input.charAt(i) == 'a'){
                ch[i] = '_';
                count++;    
            }
            
            if(input.charAt(i) == 'e'){
                ch[i] = '_';
                count++;    
            }
            
            if(input.charAt(i) == 'i'){
                ch[i] = '_';
                count++;    
            }
            
            if(input.charAt(i) == 'o'){
                ch[i] = '_';
                count++;    
            }
            
            if(input.charAt(i) == 'u'){
                ch[i] = '_';
                count++;    
            }
               
            
        }
        
        // This branches verify if a swap was peformed. 
        if(count > 0){
          // modify the string so values appear as letters 
          String result = String.valueOf(ch);
          // print the final modified string
          System.out.print("This is the input when all vowels are replaced ");  
          System.out.println("with an underscore: " + result);
        }
        // if the user doesn't follow instructions this will print
        else 
            System.out.println("There are no vowels. What gibberish did you input?"); 
  }
}
