/** 
 * Author: Carlos López
 * Uni: cal2266 
 * Date: 02/05/21 
 * CreditCard.java 
 **/
// the 80 characters limit is not surpassed
public class CreditCard{
    
    private String creditC; 
    private boolean valid = false; 
    private int errorCode = 0; 
    private boolean testFour; 
    private int sumAllDigits = 0; 
    private int sumFirst4 = 0;
    private int sumLast4 = 0; 
    private int product = 0;  
    private int sumTwo = 0; 
    
    public CreditCard(String string){
        
        creditC = string;
        inputCheck();
        // helper method that manipulates strings is called
             
    }
    
    
    public void inputCheck(){
        // check if the string submitted is valid 
        if(creditC.length() == 14 || creditC.length() == 12) {
	        if(creditC.charAt(4) != '-' && creditC.charAt(9) != '-'){
                fix();
	            System.out.print("Dear user,\nYou did not add the two dashes that separate ");
                System.out.println("the sequence of 12 numbers into 3 groups of 4: " + creditC);
                System.out.println("The program will work. Follow instructions next time!");

            }// modify creditC so it is a string without dashes 
         simplify(); 
         } //  if the input length is greater than 14 or 12 the message below appears
		 else
	         System.out.println("Enter a valid sequence of 12 digit with dashes.");
    } 
    
    public void fix(){
        // helper method for inputCheck 
        // Fixes an amendable user error. 
        String first = creditC.substring(0,4);
        String second = creditC.substring(4,8);
        String third = creditC.substring(8, 12);
        creditC = first + "-" + second + "-" + third;
           
    }
    
    public void simplify(){
      // eliminates dashes to handle the strings better
      // substrings are added to simplify
      String  first = creditC.substring(0,4);   
      String second = creditC.substring(5,9);  
      String third = creditC.substring(10,14);
      creditC = first + second + third;
                
    }
    
    public void calculations1(){
     // Helper method for check 1; makes the calculations required for the tests
     // calculation for test 4 
     for(int i = 0; i < creditC.length(); i++){
        sumAllDigits = sumAllDigits + Integer.parseInt(String.valueOf(creditC.charAt(i)));
       }                                      
     // calculation for test 5
     for(int j = 0; j <4; j++){
       sumFirst4 = sumFirst4 + Integer.parseInt(String.valueOf(creditC.charAt(j)));
       sumLast4 = sumLast4 + Integer.parseInt(String.valueOf(creditC.charAt(j + 8)));
     
     // calculation for test 6
     sumTwo = Integer.parseInt(creditC.substring(0,2)) + Integer.parseInt(creditC.substring(6,8));
     }
    }
     
     public void calculations2(){
      
      int fourth = Integer.parseInt(String.valueOf(creditC.charAt(3))); 
      
      int fifth =  Integer.parseInt(String.valueOf(creditC.charAt(4))); 
      
      int first = Integer.parseInt(String.valueOf(creditC.charAt(0))); 
         
      int ninth = Integer.parseInt(String.valueOf(creditC.charAt(8)));
      // calculations test 4
      testFour = fourth != fifth + 1; 
      
      // calculation for test 3
      product =  first * fifth * ninth;
         
     }
       
    
    public void check1(){
      // All last three tests 
      calculations1();   
     
      if( sumTwo != 100)
        errorCode = 6;
    
      if(sumFirst4 + 1 != sumLast4)
        errorCode = 5; 
        
      if(sumAllDigits % 4 != 0)
        errorCode = 4;  
    
    }
    
   public void check2(){ 
     //all first there tests
     calculations2(); 
     
     if( product != 24)
       errorCode = 3;
     
     if(testFour)
       errorCode = 2;
     
     
     if(creditC.charAt(0) != '4')
       errorCode = 1; 
         
   }
    
   public void check(){
       // tests are executed in an inverted order
       // the inverted order ensures that there is accuracy
       check1();
       check2();
       // if none of the branches modify errorCode, valid is true
       if(errorCode == 0)
           valid = true;
           
   }
    
  public boolean isValid(){
        // returns the boolean called valid 
        return valid; 
          
    }
    
    public int getErrorCode(){
        // return the int called getGetErrorCode
        return errorCode; 
        
        
    }
    
}
 
 


