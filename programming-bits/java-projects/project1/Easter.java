/**
 * This program implements the algorithm created by Fredrich Gauss 
 * for determining the date of Easter
 * 
 * @author: <Carlos López>
 * @date: <01/23/21>
 * 
 */

import java.util.Scanner;
import java.util.Arrays;
public class Easter{
  
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //step 1 get the year 
        System.out.println("Pretty please enter a year: ");
        int y = in.nextInt();
	//Step 2 divide the year number by 19 
     int a = y % 19;
     // Step 3 get the quotient of y/100.0 and the remainder of y/100
     int b = y / 100;
     int c = y % 100;
     // step 4 divide b by 4 to get a quotient d and set the var e to the vaLue of the remtinder; 
     
     int d = b/4;
     int e = b%4; 
     //step 5 set the var g equal to  8 * b + 13 by 25 
     
     int g = (8*b +13)/25; 
     
     //Step 6 Divide 19 * a + b - d - g + 15 by 30 to get a remainder h.
     int h = (19*a + b -d -g + 15) %30; 
     
     int j = c/4; 
         
     int k = c%4; 
         
         // Step 8 Divide a + 11 * h by 319 to get a quotient m.
       int m = (a + 11*h)/319;
       
         // Step 9 Divide 2 * e + 2 * j - k - h + m + 32 by 7 to get a remainder r
         int r = (2*e + 2*j - k - h + m +32 )%7;
         
         
         // Step 10 Divide h - m + r + 90 by 25 to get a quotient number
         
         int n = (h - m + r + 90)/25; 
         
         // Step 11 h - m + r + n + 19 by 32 to get a remainder p 
         int p =(h - m + r + n + 19)%32;
         
         int month_index = (int) n -1 ; 
         int day_index = (int) p -1; 
         String[] month = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
         
         int[] day = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31}; 
         // Print the date of Easter for the corresponding year. 
         System.out.print("For the year " + y + ", Easter will occur on " + month[month_index] + " "+  day[day_index] + ".");
         
         
        
        
        
        
        
        

        
        
    }

}	
