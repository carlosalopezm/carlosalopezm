/**
 * Author: Carlos López
 * Uni: cal2266 
 * Date: 02/05/21 
 *E63a 
 **/ 
// not a single line surpasses 80 characters

import java.util.Scanner; 
 
public class E63a{ 
    public static void main(String[] args){
        // Initialize the string  
        String capCount = "";
        
        // Allows the user to enter input 
        System.out.println("Please enter at most one paragraph: ");
        Scanner a = new Scanner(System.in);
            String input = a.nextLine(); 
        
        // This for loop is intended to iterate through the whole string to search fr uppercase letters 
        for(int i = 0; i < input.length(); i++){
             // this line sets the current char 
              if(Character.isUpperCase(input.charAt(i))){
                  // adds the characer to the list if it is an uppercase letter 
                  capCount = capCount + " " + input.charAt(i);      

              }

        }
      // verifies that there are capital letters 
      if(capCount.length() > 0){
        System.out.print("The capital/uppercase letters that appear");
        System.out.println(" on the input are the following: " + capCount + ".");
      }
      // if there are no capital letters this brach executes
      else
          System.out.println("There are no capital/uppercase letters.");
    }

}

