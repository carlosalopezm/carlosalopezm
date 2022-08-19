/**
 * Author: Carlos López 
 * UNI: cal2266
 * This class represents a computer player in the Odd-Even game.
 * The class has all methods required to create and modify a computer player. 
 *  
 */
//not a single line is over 80 characters (not counting spaces before the line)
public class ComputerPlayer{
    private double t;
    private int tokenBalance;
    
    public ComputerPlayer(double threshold){
        t=threshold;//t is initialized to equal the double entered
        tokenBalance=0; // token balance set to 0
    }
    
      
    // your code here
    //This method provides the # computer enters.
    public int number(){
       double number = Math.random() * 1; // random gets values in [0,1)
       int declare = 0; 
       
       if(number < t){
           declare = 1; // it will return 1
       }
       
       else{
           declare = 2;// it will return 2
       }
        
      return declare; // returns 1 or 2
       
        
    }
    // this method returns the computer's tokens
    public int getTokens(){
        return tokenBalance; 
    }
    
    // adds tokens to token balance   
    public void add(int amt){
        
        tokenBalance += amt; 
    }
   // removes tokens from token balance 
   public void subtract( int amt){
       tokenBalance -= amt;     
   }
    
   
    
    
}
