/**
 * Author: Carlos López 
 * UNI: cal2266 
 * Description:Represent a tweet, including the content, author's username
 * and time when it was posted. 
 */
public class Tweet {
    
    public String user;
    public DateTime datetime; 
    public String content;
    
    public Tweet(String user, DateTime datetime, String content) {
            this.user = user; 
            this.datetime = datetime;
            this.content = content;       
    }
    
    public String toString(){
        return "@"+this.user+" ["+datetime.toString()+"]: "+content;
    }
    
    public int hashCode(){
        int result = this.user.hashCode() + datetime.hashCode() +this.content.hashCode();
        return result; 
    }
    
    
    public boolean equals(Object x){ // does it have to be object? 
        if(this == null || x.getClass() != this.getClass())
            return false; 
        if(this == x)
            return true; 
        return this.hashCode() == x.hashCode();
    }
    
    
}