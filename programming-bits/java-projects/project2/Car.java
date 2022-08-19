/*
*
* name: Carlos López
 * UNI: cal2266
 * 
 */

public class Car{
  
    //  for this problem don't worry about the maximum amount of gas
    //  allowed in the tank or tracking the overall miles driven
  
    // instance variables 
    private double gas;
    private double efficiency;
    
    
    public Car(double efficiency){
        // this is the constructor
        // your code here
      gas = 0; 
      this.efficiency = efficiency; 
      
        
    }
    
    
  public void drive(double miles){
        // this is a mutator method
        // that reduces the gas in the tank 
        // your code here
      if((miles/efficiency) > gas){
        double need = (miles/efficiency - gas);
        System.out.print("You need to add " + need + " gallons of gas to drive that far!");
      }
      // proceeds as usual if the ratio of distance and efficiency does not surpass the vaLue of gas
      
      else
        gas = gas - (miles/efficiency); 
       
    }
    
    public void addGas(double gasAmount){
        // this is a mutator method
        // that adds gas to the tank
        // your code here
        gas = gas + gasAmount; 
        
    }
    
    public double getGasInTank(){
        // this is an accessor method for the gas in the tank
        // your code here
      return gas; 
  
        
    }
    
    
    
}
