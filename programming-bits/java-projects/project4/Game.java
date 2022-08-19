/**
 * Author: Carlos López 
 * UNI: cal2266
 * This is the game class that plays the Poker Game. 
 **/ 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays; 



public class Game {
	// instance variables 
    private Player p;
    private Deck cards;
    private ArrayList<Card> hand; 
    ArrayList<Card> check;
    // contractor for game with TestHand
    public Game(String[] testHand){
        p = new Player(); 
        hand = new ArrayList<Card>();
        int[] suit = convertSuit(testHand); // convert the 1st char to encoded int value
        int[] rank = convertRank(testHand); // convert the substring into integers 
        for(int j = 0; j < testHand.length; j++){
            
            hand.add(new Card(suit[j], rank[j])); // add the values to hand 
            
            }   
        }
     
    
	
    public Game(){
        
        p = new Player(); // construct player 
        cards = new Deck(); // construct deck  
        // This no-argument constructor is to actually play a normal game
        
		
    }
	
   public void play(){ // interactive play method 
        boolean continueG = true; 
        hand = new ArrayList<Card>();
        while(p.getBankroll() > 0 && continueG){ // play until Bankroll = 0 || you stop
          gamble(); 
          cards.resetTop();
          cards.shuffle(); // shuffle 
          dealHelp1();// deal cards with helper method
          p.winnings(checkHand(hand)); // acute cdeckhand
          hand.clear(); // clear hand 
          check.clear(); // clear helper ArrayList
          System.out.print("\nTokens: " + p.getBankroll()); // print bankroll
          System.out.println("\n\n Enter yes to continue and no to stop");
          Scanner answer = new Scanner(System.in); // determine if user wants to stop
          String inAns = answer.nextLine();
             
            if(inAns.equals("yes"))   
                continueG = true;  // choose to stop
            else 
                continueG = false;  // press any key to continue
                
        }
        System.out.println("\n\nGame Over Tahur of Poker");
       
    } 
    
    public void testPlay(){
        p.bets(5);
        p.winnings(checkHand(hand));
        System.out.println("\nTokens: " + p.getBankroll());
        // test play for 
        // this method is used for testing the checkHand method
        // it should evaluate the hand that was passed
        // as a command-line argument and print the result
        
    }
	
	public int checkHand(ArrayList<Card> hand){
        this.hand = hand; // check hand method 
        check = new ArrayList<Card>(hand); // array that is sorted
        Collections.sort(check);
        int x = 0; // holder for multiplier
        if(royalFlush()){ x = 250;} // reverse order to ensure eexecution is correct
        else if(straightFlush()){ x = 50;} 
        else if(fourOfAKind()){ x = 25;}
        else if(fullHouse()){ x = 6;} 
        else if(flush()){ x = 5;} 
        else if(straight()){x = 4;} 
        else if(threeOfAKind()){ x = 3;}
        else if(twoPair()){x = 2;} 
        else if(pair()){ x = 1;}
        printCheckHand(x);
        return x;
        
    }
    
    
 /** 
  * ****** Helper Methods *********
  * 
  * */ 
 
     // ensures that arcades are dealt adequately for each round                 
    public void dealHelp1(){
        int n = 5;
        int round = 1;  // use booleans assuming that it is sorted 
        while(round < 3){   
            if(round == 1){
                dealHelp2();
                for( Card element : hand){
                    System.out.println(element.toString());
                }
                removal(); // removes undesired cards 
                round++;       
            }
            else{ 
                for( Card element : hand){
                    System.out.println(element.toString());
                }
                round++; 
                
            }
          
        }
        
    }
    
    public void dealHelp2(){ // deals cards 
        for(int j = hand.size(); j < 5; j++){
            hand.add(cards.deal());
        }
        
    }
    
    public void removal(){ // uses set to ensure no out of bounds errors occur 
         for(int j = 0; j < 5; j++){
            System.out.println("\n\n Enter \"yes\" to remove card " + (j +1));
            System.out.println("Enter no to hold the card ( order from top to bottom)."); // prompt 
            Scanner a = new Scanner(System.in);
            String input = a.nextLine(); 
            if(input.equals("yes"))
              hand.set(j, cards.deal());        
          }
    }
       
         
  
       
    
    
        
  
                    
   
    private boolean pair(){
        
       Collections.sort(check);
       int count1  = 0; 
       int count2 = 0;
       int count3  = 0; 
       int count4 = 0;   // count for each scenario 
       
       boolean two = false; 
       if(check.get(0).getRank() == check.get(1).getRank()) // checks all scenariois for pair
           count1++; 
       if(check.get(1).getRank() == check.get(2).getRank()){
           count2++; 
       }
       if(check.get(2).getRank() == check.get(3).getRank()){
           count3++; 
       }
       if(check.get(3).getRank() == check.get(4).getRank()){
           count4++; 
       }
       int sum = count1 + count2 + count3 + count4;           
       
        if(sum == 1)
            two = true;
        System.out.print(check);
            
       return two;    
    }          
       
     
    

    private boolean twoPair(){
       // this boolean operators ensure that there are two pairs 
       boolean tPair = false;
       boolean set1 = check.get(0).getRank() == check.get(1).getRank(); // booleans
       boolean set2 = check.get(1).getRank() == check.get(2).getRank();// check all scenarios for twoPair
       boolean set3 = check.get(2).getRank() == check.get(3).getRank();
       boolean set4 = check.get(3).getRank() == check.get(4).getRank(); 
       boolean check1 = check.get(1).getRank() != check.get(3).getRank();
       boolean check2 = check.get(2).getRank() != check.get(3).getRank();
       if((set1 && set3)&& check1)
           tPair = true;
       else if((set2 && set4)&& check2) // booleans to determine if it is true
           tPair = true; 
       else if((set1 && set4)&& check2)
           tPair = true; 
         
       return tPair;   
    }
    
    private boolean threeOfAKind(){
        int counter = 0;
        // boolean methods ensure that there are three of a kind
        boolean valid = false;
        boolean s1=hand.get(0).getRank()==hand.get(1).getRank();
        boolean s2= hand.get(1).getRank()==hand.get(2).getRank(); // compare ranks
        boolean first3 = s1 && s2;
        boolean s3=hand.get(2).getRank()==hand.get(3).getRank();
        boolean s4= hand.get(3).getRank()==hand.get(4).getRank();
        boolean middle3 = s2 && s3; 
        boolean last3 = hand.get(2).getRank() == hand.get(4).getRank();
        boolean first2 =  hand.get(0).getRank() == hand.get(1).getRank();
        if(first3)
            counter++;
        else if(middle3)
            counter++;
        else if(last3)
            counter++; 
        if(counter == 1) // there can only be one group of three 
           valid = true; 
        
        return valid; 
          
    }       
            
    
 
    
    private boolean straight(){
        boolean valid = false; 
        // both sit1 & aceCase verify that the ace precedes a two and goes after a 13 (only in index 1 or 4)
        boolean sit1 = hand.get(0).getRank() == 10 && hand.get(4).getRank() == 1;// compare ranks
        boolean sit2 = hand.get(1).getRank() == 11 && hand.get(2).getRank() == 12;
        boolean sit3 = hand.get(3).getRank() == 13 && hand.get(4).getRank() == 1; // boolean operators to get special straights
        boolean aceCase = hand.get(0).getRank() == 13 && hand.get(1).getRank() ==1;
        boolean aceFollows = hand.get(4).getRank() - hand.get(1).getRank() == 3;
        boolean dec1 = hand.get(0).getRank() - hand.get(1).getRank() == 1; 
        boolean dec2 = hand.get(1).getRank() - hand.get(2).getRank() == 1; // decreasing order 
        boolean dec3 = hand.get(2).getRank() - hand.get(3).getRank() == 1;
        boolean dec4 = (hand.get(3).getRank() - hand.get(4).getRank()) == 1;
        boolean inc1= hand.get(4).getRank() - hand.get(3).getRank() == 1; 
        boolean inc2 = hand.get(3).getRank() - hand.get(2).getRank() == 1;
        boolean inc3 = hand.get(2).getRank() - hand.get(1).getRank() == 1; // increasing order 
        boolean inc4 = hand.get(1).getRank() - hand.get(0).getRank() == 1;
       if((dec1 && dec2) && (dec3 && dec4))
            valid = true; 
       else if((inc1 && inc2) && (inc3 && inc4))
            valid = true;
       else if(sit1 && sit2 && sit3)
               valid = true;
       else if(aceCase && aceFollows )
            valid = true;
        return valid;
   }
    
        
    
    
    private boolean flush(){
        boolean valid = true; 
        int x = hand.get(0).getSuit(); // compare suits
        for(Card element : hand){
            if(element.getSuit() != x)
                valid = false;
        }
        return valid; 
        
        
    }
    
    private boolean fullHouse(){
        boolean valid = false;
        boolean set1 =hand.get(0).getRank()==hand.get(1).getRank();// compare ranks
        boolean set2 = hand.get(1).getRank()==hand.get(2).getRank();
        boolean first3 = set1 && set2;
        boolean set3=hand.get(2).getRank()==hand.get(3).getRank();
        boolean set4= hand.get(3).getRank()==hand.get(4).getRank();
         
        
        boolean last3 = set3 && set4;
       
        if((first3 && set4) || (set1 && last3))
            valid = true; 
        return valid; 
        
        
    }
    // use booleans assuming that it is sorted 
    private boolean fourOfAKind(){
       boolean valid = false; // ensures that there are no cards in between 
       // this is due to possible errors in the testHand
       boolean s1 =  check.get(0).getRank() == check.get(1).getRank();
       boolean s2 =  check.get(1).getRank() == check.get(2).getRank(); 
       boolean s3 =  check.get(2).getRank() == check.get(3).getRank();
       boolean s4 =  check.get(3).getRank() == check.get(4).getRank();
       boolean first = (s1 && s2) && (s2 && s3);
       boolean last =  (s3 && s4)  && (s2 && s3);
       if(first || last)
           valid = true; 
       return valid;
    }
       
   
    
    private boolean straightFlush(){
        // straight and flush 
        boolean valid = straight() && flush(); 
        return valid; 
           
    }
    
    
     private boolean royalFlush(){ // suits and straight 
        boolean firstPair = hand.get(0).getRank() == 10 && hand.get(1).getRank() == 11;  
        boolean secondPair = (hand.get(2).getRank() == 12 && hand.get(3).getRank() == 13);
        boolean last = hand.get(4).getRank() == 1; 
        boolean valid = (firstPair && secondPair && last) && flush(); // order and see suits 
        return valid; 
           
    }
    
    
	
    private void gamble(){
        boolean noAns = true; 
        while(noAns){ // this method interacts with the user to get a bet
          System.out.print("\n\nEnter any amount of tokens from 1-5 to bet: ");
          Scanner a = new Scanner(System.in);
          int input = a.nextInt(); 
          
          if(input > 0 && input <= 5){ 
            p.bets(input);
            noAns = false; 
          }// it will not stop until a correct value is submitted
          else
            System.out.println("\n\nPlease a value between 1 and 5"); 
          }
          
      }
      
   
    // converts suits for the game(String[] testHand) constructor
    private int[] convertSuit(String[] s1){
       int[] num = new int[5];
        for(int j = 0; j < num.length; j++){
            
              if(s1[j].substring(0,1).equals("c")){
                  num[j] = 1; 
              }
              else if(s1[j].substring(0,1).equals("d")){
                  num[j] = 2; 
              } 
            else if(s1[j].substring(0,1).equals("h") ){
                 num[j] = 3; 
              }
            else if(s1[j].substring(0,1).equals("s")){
                   num[j] = 4; 
            } 
            else{
                System.out.println("\n\nYou submitted an invalid card.");  
            }
            
       }
       return num; 
    }
     // converts ranks for the game(String[] testHand) constructor
    private int[] convertRank(String[] s1){
        int[] num = new int[5];
        for(int j = 0; j < s1.length; j++){
            if(s1[j].length() == 2){
                num[j] = Integer.parseInt(s1[j].substring(1,2));
            }
            else if(s1[j].length() == 3){
                num[j] = Integer.parseInt(s1[j].substring(1,3));
            }
            else{
                System.out.println("\n\nYou submitted an invalid card.");  
            }     
    }
        return num; 
 }
    // prints statements for checkHand
    private void printCheckHand(int num){
      int x = num; 
        if(x == 250){ // reverse order is used to ensure the correct branch executes
            System.out.print("\n\nWinner winner, chicken dinner! Royal Flush!");
            System.out.println(" You get a 24900% return!");
        }
        else if(x == 50)
            System.out.println("Straight Flush! You get a 4900% return!");
        else if(x == 25)
            System.out.println("\n\nFour of a Kind! You get a 2400% return!");
        else if(x == 6)
            System.out.println("\n\nFull House! You get a 500% return!");
        else if(x == 5)
            System.out.println("\n\nFlush! You get a 400% return!");
        else if(x == 4)
            System.out.println("Straight! You get a 300% return!");
        
         else if(x == 2)
            System.out.println("\n\nTwo pair! You get a 100% return!");
        else if(x == 3)
            System.out.println("\n\nThree of a kind! You get a 200% return!");
        else if(x == 1) // change order   
            System.out.println("\n\nPair! You get your tokens back!");
        else if(x == 0){
            System.out.println("\n\nLucky you! 0% return!");
            System.out.print("You're lucky because money is the root of all evil ");
            System.out.println("and now you got 0 tokens which means 0 evil. Genius!");   
        }
        System.out.println("\n" + check);   
  }
    
    
    
    
  
         
}


  
        


