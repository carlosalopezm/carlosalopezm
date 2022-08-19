
/**
 * author: Carlos López
 * UNI: cal2266
 * This is the player class that creates a player to gamble.
 * Used in Game.java
 * 
 **/
public class Player {
	
		
    private int bankroll;
    private int bet;

    //you may choose to use more instance variables
		
    public Player(){		
        
        this.bankroll = 100; 
        
        this.bet = 0; 
        
    }
		
    public void bets(int amt){
       boolean valid = true; 
       while(valid){
        if(amt <= 5){
        bet = bet + amt; 
        bankroll = bankroll - bet; 
        valid = false; 
       }
      }
       
    }

    public void winnings(int odds){
        //adjust bankroll if player wins
        bankroll = bankroll + bet * odds; 
    }

    public int getBankroll(){
        
        return bankroll; 
    }

    //you may wish to use more methods here
}



