/**
 * author: Carlos López
 * UNI: cal2266
 * This is the card class that creates card objects.
 * Used in Game.java
 **/
public class Card implements Comparable<Card>{
	
    private int suit; //use integers 1-4 to encode the suit
   
    private int rank; //use integers 1-13 to encode the rank
    //11 == Joker 
    //12 = Queen 
    // 13 = King
	
    public Card(int s, int r){
        //make a card with suit s and rank r
        
        suit = s; 
        rank = r; 
        
        
    }
	
    
    public int compareTo(Card c){
        int x;
        if(this.getRank() == c.getRank()){
            if(this.getSuit() < c.getRank() )
                return -1; 
            else 
                return 1; 
        }  
        else if(this.getRank() < c.getRank())
            x = -1; 
               
        else
            x = 1; 
            
        return x; 
          

    }
    
	
    public String toString(){
        //use this method to easily print a Card object
        String card = ""; 
        int x = this.getRank();
        if( this.getSuit() == 1){
            if(x == 1 || x > 10)
                card = this.helpToString();   
            else    
              card = x + " of Clubs";
        }
        
        else if(this.getSuit() == 2){
            if(x == 1 || x > 10)
              card =   this.helpToString();
            else    
              card = x + " of Diamonds";
        }
        else if(this.getSuit() == 3){
            if(x == 1 || x > 10)
              card =   this.helpToString();
            else    
              card = this.getRank() + " of Hearts";
        }
        else if(this.getSuit() == 4){
            if(x == 1 || x > 10)
              card = this.helpToString();
            else    
              card = this.getRank() + " of Spades"; 
        }
        
        return card;
    }
    
    //add some more methods here if needed
    
    public int getSuit(){
        
        return suit; 
        
    }
    
    public int getRank(){
        
        return rank; 
        
        
    }
    
    public String helpToString(){
        String altCard = "";
        int x = this.getRank();
        String[] suitArr = {" of Clubs", " of Diamonds", " of Hearts", " of Spades"};
        String[] specialCards = {"Ace", "Joker", "Queen", "King"};
        
        if(x > 10)
              altCard = specialCards[x -10] + suitArr[this.getSuit() - 1];
        else 
           altCard = specialCards[x -1] + suitArr[this.getSuit() - 1]; 
        
        return altCard;
        
    }
    

}
 
