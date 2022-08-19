/**
 * Author: Carlos López 
 * UNI: cal2266
 * This class represents the Odd-Even game
 * Part 1 is an interactive Odd-Even Game with a human user.
 * Part 2 is a computer simulated game. 
 * Thus there are two contractors for the game class. 
 * One contractor is for the human vs computer game.
 * One contractor is for the simulation (computer vs computer).
 */
// not a single line surpasses 80 characters 

import java.util.Scanner;  

public class Game{
    
    //part 1 instance variables
    ComputerPlayer cpu;
    private int oddEven; 
    private int gameNum;
    private final double inT = 0.5;
    private int humanTokens = 0;
    //part 2 instance variables 
    ComputerPlayer p1; 
    ComputerPlayer p2;
    private double t1; 
    private double t2; 
    
    
    
    
    
/* this version of the game constructor is for Part 1
 * it takes no parameters */
    public Game(){
        // initialize computer player with a threshold t = 0.5
        cpu = new ComputerPlayer(inT);
        // set human tokens equal to zero
        humanTokens = 0; 
               
    }
    
/* this version of the game constructor is for Part 2
 * It requires two doubles as parameters. You will use 
 * these to set the initial thresholds for you computer players */
  public Game(double t1, double t2){
      this.t1 = t1;
      this.t2  = t2; 
      p1 = new ComputerPlayer(t1); 
      p2 = new ComputerPlayer(t2); 
      
  }
    
/* this version of the play method is for Part 1
 * It takes no parameters and should play one interactive
 * version of the game */
    public void play(){
       rules(); // prints all the rules
       System.out.println("Enter 0 to be odd and 1 to be even: ");
       Scanner a = new Scanner(System.in);// users decides to be odd or even
       oddEven = a.nextInt(); 
        
       int continueG = 1; // integer initialized to one to play at least once
       while(continueG != 0){
       int score1 = calculations(); // decides who wins    
       System.out.println("\n Output of Game: " + score1);
       trackScores1(); // prints who wins 
       System.out.println("Enter 1 to continue and 0 to stop: ");
       continueG = a.nextInt(); //human inputs 1 to continue and 0 to stop
        
    }
  }
    
    
/** this version of the play method is for Part 2
 * It takes a single int as a parameter which is the
 * number of computer vs. computer games that should be played */
   public void play(int games){
     int num = games; 
     while( num > 0){
         // helper method calculates who wins
         calc(); 
         //deacrease num
         num--; 
     }     
        
   }


    
// methods and helper methods 
       
   
   public void rules(){
       // Tells the user all the rules of the game
       String s0 = "******************* Welcome ******************* "; 
       String s1 = "\nBoth players simultaneously declare 1 or 2."; 
       String s2 = "\nPlayer 1 wins if the sum of the two declared numbers is odd.";
       String s3 = "\nPlayer 2 wins if the sum is even."; 
       String s4 = "\nIn either case, the loser pays the winner the value of the sum in tokens.";
       String s5 = "\nThus, Player 1 may have to pay 2 or 4 tokens or may win 3 tokens.";
       String s6 = "\n Computer player will have a threshold variable between 0 and 1.";
       String s7 = "\nIf number > than t, the computer will declare 2.” ";
       String s8 = "\nIf number < t, the computer will declare 1.";
       String s9 = "\n***********************************************";
       String gRules = s0 + s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9; 
       System.out.println(gRules); 
   }
   
   public void userInput(){
       Scanner scan = new Scanner(System.in);
       System.out.println("Enter a 1 or a 2: ");
         gameNum = scan.nextInt();               
   }
   
   // calculates the reslets for part 1 
   // it sets the sum to 2,3, or 4
   public int calculations(){
       userInput();
       int sum = gameNum + cpu.number(); 
       if(oddEven == 1){ if(sum % 2 == 0){ // human player chose even
               humanTokens += sum; 
               cpu.subtract(sum);
           } else{ 
               humanTokens -= sum; 
               cpu.add(sum);
            }
        } else{if(sum % 2 == 0){ // human player chose odd
           humanTokens -= sum; 
           cpu.add(sum);
        } else{
               humanTokens += sum; 
               cpu.subtract(sum);
            }
         }
         return sum; 
     }
    // tracks scores for part 1 
    // print statements are used to enhance the user experience
    // since the user has to see the scores on the output screen. 
    public void trackScores1(){
        if(oddEven == 1){}
     if(oddEven == 1){ 
        System.out.println("-------------------------------------");
        System.out.println("Player 1 and the odd number player tokens (computer): " + cpu.getTokens());
        System.out.println("Player 2 and the even number player tokens (you): " + humanTokens);
        System.out.println("-------------------------------------\n\n");
    }
    else{
       System.out.println("-------------------------------------");
       System.out.println("Player 1 and the odd number player tokens (you): " + humanTokens);
       System.out.println("Player 2 and the even number player tokens (computer): " + cpu.getTokens());
       System.out.println("-------------------------------------\n\n");
        
    }
    
    
   }
  // part 2 methods 
  // calculates all values for the simulation
  // calculaactions fo computer vs computer
  //it sets the sum to 2,3, or 4
  public void calc(){
     int sum = p1.number() + p2.number();
      if(sum % 2 == 0){
          p1.subtract(sum); // even
          p2.add(sum); 
      }
      else{
          p1.add(sum); 
          p2.subtract(sum); //odd
      }
      
  }
  
  /* this method should return the current score (number of tokens)
 * that player 1 has */
 // this is for part 2 
    public int getP1Score(){
        // your code here
       int score = p1.getTokens();
       return score; 
        
   }
   /* this method should return the current score (number of tokens)
 * that player 2 has */
// this is for part 2 
   public int getP2Score(){
        //your code here
        
       int score =  p2.getTokens();
       return score; 
       
        
   }  
    
        
   
}
