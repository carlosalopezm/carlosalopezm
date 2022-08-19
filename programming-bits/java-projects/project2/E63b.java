/** 
 * Author: Carlos López
 * Uni: cal2266 
 * Date: 02/05/21 
 *E63b.java
 **/ 
// not a single line surpasses 80 characters
import java.util.Scanner; 
public class E63b{
    
    public static void main(String[] args){
        //prompt 
        System.out.println("Enter at least one word and at most one paragraph: ");
        Scanner a = new Scanner(System.in); //scanner for input 
        String sentence = a.nextLine(); 
        // input is saved in string input 
        String second = ""; 
        int i = 1;
        // while loop that iterates through the string 
        while( i < sentence.length()-1){
            second = second + sentence.charAt(i);
            // increment by two to get second letters/charcters
            i += 2; 
        }
        // verifies that there will be enough chars 
        if(second.length() >= 1){
          System.out.print("All second letters of the input are the following: "); 
          System.out.println( second + ".");
        }
        else
          System.out.println("There are no second letters!");
        // prints if there is one char or no chars 
            
    }
}
