/**
 * This program accepts a positive integer as input and
 * determines whether or not the integer is prime.
 * 
 * @author: <Carlos López>
 * @date: <01/23/21>
 */
import java.util.Scanner;
public class Prime{
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in); 
        System.out.println("Enter an intenger from one to two billion: ");
        int n = scan.nextInt();
        int val = 1; 
        
        
         
        
        
        
		for(int j = 2; j <= Math.sqrt( n); j++){
			
			if( (n % j == 0  && n != j) && n != 1) {
			 
				val = 0; 
			 
			}
			
		}
        
        
		
        
		if(val == 1) {
			System.out.print("Prime ");
		}
		else {
			System.out.print("Composite ");
		}
        
        
        
       
    
}
}
