/**
 * author: Carlos López
 * UNI: cal2266
 * This is the deck class that creates an array of card objects.
 * Used in Game.java
 **/
//add your own banner here
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner; 
public class Deck {
	
    private Card[] cards;
    private int top = 0; //the index of the top of the deck

    //add more instance variables if needed
	// 1 = spades 
    // 2 = hearts 
    // 3 = diamonds 
    // 4 = clubs 
    public Deck(){
        cards = new Card[52];
        int index = 0;  
        for(int j = 1; j < 5; j++){
            for(int k = 1; k < 14; k++){
                
               cards[index] = new Card(j, k);
               index++; 
                
            } 
         
        }
    }
	
    public void shuffle(){
       // Fisher-Yates Shuffle Method Check Sources in ReadMe
       resetTop();
       int j = cards.length -1;
       while(j > 0){
            int x = (int)Math.floor(Math.random()* (j + 1));
            Card temp = cards[j]; 
            cards[j] = cards[x];
            cards[x] = temp;
            j--;
             
          
        }
    }
    
    
   public Card deal(){
           Card x = cards[top];
            top++;
       
   
       return x;
   }
    
    
    public void resetTop(){
        top = 0; 
    }  
    
   
 }
    

