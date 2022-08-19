/**
 * Author: Carlos López 
 * UNI: cal2266 
 * Description: Represent a timestamp consisting of a date (day/month/year) and time 
 * in hours and minutes (24h format).
 */
public class DateTime implements Comparable<DateTime> { //For part 4
    
    public int year;
    public int month;
    public int day; 
    public int hours;
    public int minutes;    
    public int seconds;
    public boolean pm; 

    
    public DateTime(int year, int day, int month, int h, int m) {        
        this.year = year; 
        this.month = month; 
        this.day = day;     
        this.hours = h; 
        this.minutes = m;                
    }
    
    public DateTime(String datetime) {
        String[] fields = datetime.split(" ");
        String[] dateFields = fields[0].split("/");
        month = Integer.parseInt(dateFields[0]);
        day = Integer.parseInt(dateFields[1]);
        year = Integer.parseInt(dateFields[2]);
        
        String[] timeFields = fields[1].split(":"); 
        hours = Integer.parseInt(timeFields[0]);
        minutes = Integer.parseInt(timeFields[1]);;
    }
    
    public String toString() {
        return Integer.toString(month)+"/"+Integer.toString(day)+"/"+Integer.toString(year)+"  "+
            String.format("%02d" , hours)+":"+String.format("%02d", minutes);
    }
    
    public int compareTo(DateTime x){
        if(this.year > x.year)
            return 1; 
        if(this.year < x.year)
            return -1; 
        else{
            if(this.month > x.month)
                return 1; 
            if(this.month < x.month)
                return -1; 
        else{
            if(this.month > x.month)
                return 1; 
            if(this.month < x.month)
                return -1;
            else{
                if(this.day > x.day)
                  return 1; 
                if(this.day < x.day)
                return -1;
                else{
                    if(this.hours > x.hours)
                        return 1; 
                    if(this.hours < x.hours)
                        return -1;
                    else{
                        if(this.minutes > x.minutes)
                          return 1; 
                        if(this.minutes < x.minutes)
                          return -1;
                        else
                            return 0;   
                    }
                }
                
            }
         }
            
      }
    }
    
    public int hashCode(){
        int result = this.year * 151 + this.month * 31 + this.day * 7 + this.hours * 23 + this.minutes * 59;
        return result; 
    }
    
    public boolean equals(Object x){ // does it have to be object?  
        if(x == null || x.getClass() != this.getClass())
            return false; 
        if(this == x)
            return true;
        return this.hashCode() == x.hashCode();
    }
    
    
}