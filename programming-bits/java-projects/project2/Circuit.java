/* 
 * This is the Circuit class that you have to create
 * for problem E3.4
 * 
 * name: Carlos López
 * UNI: cal2266
 * 
 */

public class Circuit{
    // instance variables 
    private int firstSwitchState;
    private int secondSwitchState;
    private int lampState;
    
  
  
    
    public Circuit(){
        // this is the constructor
        // initialize all switches to down and light to off
        // your code here
      firstSwitchState = 0; 
      secondSwitchState= 0; 
      lampState = 0; 
        
    }
    
    public void toggleFirstSwitch(){
        // this is a mutator method
        // that toggles the first switch
        // your code here
      if(firstSwitchState == 0){
        // switch goes up
        firstSwitchState = 1;
         // check if both are up
        if(firstSwitchState == secondSwitchState)
          
          // lamp is turned off if they are equal 
          lampState = 0;
        else
          lampState = 1;
          // lamp is on if I they are not equal 
      }
        
      
      
       else{
         
         firstSwitchState = 0;
          // check if both are down
         
         if(firstSwitchState == secondSwitchState)
           lampState = 0;
         // lamp is turned off if they are equal
         
         else
           lampState = 1;
         // lamp is on if I they are not equal 
          
        
        
      
       
       }
      
    }
    
    public void toggleSecondSwitch(){
        // this is a mutator method
        // that toggles the second switch
        // your code here
      if(secondSwitchState == 0){
        secondSwitchState = 1;
        // check if both are up
        if(firstSwitchState == secondSwitchState)
          lampState = 0;
          // lamp is turned off if they are equal
        else
          lampState = 1;
          // lamp is on if I they are not equal
      }
      
      else{
        secondSwitchState = 0; 
        // check if both are down
        if(firstSwitchState == secondSwitchState)
          lampState = 0;
          // lamp is turned of if they are equal
        else
          lampState = 1;
        // lamp is on if I they are not equal
        
      }
        
          
          
      
        
        
        
    }
    
    public int getLampState(){
        // this is an accessor method for the lamp state
        // your code here
      
      return lampState; 
          
    }
  
    public int getFirstSwitchState(){
        // this is an accessor method for the first switch
        // your code here
      
      return firstSwitchState; 
      
    }    
   
  
    public int getSecondSwitchState(){
        // this is an accessor method for the second switch
        // your code here
      String result; 
      
      
      
      return secondSwitchState; 
      
       
    }
  

}

