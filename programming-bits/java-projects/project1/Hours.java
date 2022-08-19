/**
 * This program converts a number of days and weeks into the
 * equivalent number of hours
 * 
 * @author: <Carlos López>
 * @date: <01/23/21>
 */
import java.util.Scanner;
public class Hours{
    
    
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        // gets the number of days 
        System.out.println("Enter a number of days that is not greater than six because seven days is equal to a week: "); 
        int days = input.nextInt();
        // gets the number of weeks 
        System.out.println(" Enter a number of weeks: ");
        int weeks = input.nextInt();
        // If the user does not follow the rules this is ensures that the correct number of days and weeks are submitted. 
        if(days >= 7){
            System.out.println("You love rules don't you? Well I was cautious enough to ensure that if you added more days the equivalent in weeks would be added to the variable weeks."); 
            weeks = weeks + days/7; 
            days = days%7;
            System.out.println("Thus, you would end up with " + days + " days and " + weeks + " weeks as your answer.");
        }
        
       
        
        
        
       int weeksToDays = weeks*7;
       int bothToHours = (weeksToDays + days)*24;
        
       System.out.println("There are a total of " +bothToHours + " hours in " + weeks +" weeks and " + days + " days.");
        
        
    }
}
