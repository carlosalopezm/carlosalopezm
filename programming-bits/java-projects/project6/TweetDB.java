/*
* Author: Carlos Lopez 
* UNI: cal2266
* Description: This class creates TweetDB objects that return 
* a list of tweets associated with a keyword, a username, and a range of dates. 
*/ 
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap; 
import java.util.TreeMap; 
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.*; 
import static java.util.stream.Collectors.*;
import java.util.NoSuchElementException; 

public class TweetDB {
   
    
    HashMap<String, List<Tweet>> tweetsPerUser;
    HashMap<String, List<Tweet>> tweetsPerKeyword;  
    TreeMap<DateTime, List<Tweet>> tweetsByTime;
/**
 *First, in the TweetDB class, complete the constructor. The parameter to the constructor is the pathname of a data file (such as "coachella_tweets.csv").
Using a CsvReader, read through the input file and convert each row into a Tweet instance.
Then, insert each Tweet into the tweetsPerUser hash map, indexed by the username. 
Recall that the values in the hash map should be Lists of Tweets (a user may have tweeted multiple times).
Finally, write the method. public List<Tweet> getTweetsByUser(String user) that returns all tweets written by a user. 
You can test the functionality in the main method, but the graders will call your methods from their own tester program. 
 */
    public TweetDB(String pathToFile) throws FileNotFoundException, IOException{
        tweetsPerUser = new HashMap<>();               
        tweetsPerKeyword = new HashMap<>();   
        tweetsByTime = new TreeMap<>();  
        BufferedReader br = new BufferedReader(new FileReader(pathToFile));
        CsvReader csv = new CsvReader(br);
        String[] fields = csv.nextLine();       
        while (fields != null){
            System.out.println(Arrays.toString(fields));
            userConstructor(fields, tweetsPerUser); 
            // constructs the HashMap with (k keyword, v tweets)
            keywordConstructor(fields, tweetsPerKeyword);
            // constructs the TreeMap with (k keyword, v tweets)
            rangeConstructor(fields, tweetsByTime); 
            fields = csv.nextLine();
       }   
     } 
//public List<Tweet> getTweetsByUser(String user) returns all tweets written by a user.     
    public List<Tweet> getTweetsByUser(String user){
        
        if(tweetsPerUser.containsKey(user))
            return hashSetAndList(tweetsPerUser.get(user)); 
        else{
            List<Tweet> l = new LinkedList<Tweet>();
            return l;
            // returns an empty list if the username does not appear. 
        }
            
    }
    
// public userConstructor adds List<Tweet> associated to a username to the hashmap it received as a parameter 
    public void userConstructor(String[] f,HashMap<String, List<Tweet>> m){
      if(m.containsKey(f[0])){
          DateTime date = new DateTime(f[2]);
          Tweet g = new Tweet(f[0], date, f[1]); 
          m.get(f[0]).add(g);
      }else{
          List<Tweet> l = new LinkedList<Tweet>();
          m.put(f[0], l);
          DateTime date = new DateTime(f[2]);
          Tweet g = new Tweet(f[0], date, f[1]); 
          m.get(f[0]).add(g);
      }
  }
    
    
/*
 * the method returns the tweet list of the corresponding key;
 */
    
    public List<Tweet> getTweetsByKeyword(String kw){
        if(tweetsPerKeyword.containsKey(kw))
            return hashSetAndList(tweetsPerKeyword.get(kw)); 
        else{
            List<Tweet> l = new LinkedList<Tweet>();
            return l;
            // returns an error with an empty list if the keyword does not appear. 
        }
            
    }
    
    /*
 * The method constructs a hasmap of tweet lists with keywords as keys
 */
    public void keywordConstructor(String[] f, HashMap<String, List<Tweet>> m){
      String temp = f[1].replaceAll("[\\p{P}&&[^\u0027]]"," ");
      String[] words = temp.split(" ");
      for(String e: words){
        if(m.containsKey(e)){
          DateTime date = new DateTime(f[2]);
          Tweet g = new Tweet(f[0], date, f[1]); 
          m.get(e).add(g);
        }else{
          List<Tweet> l = new LinkedList<Tweet>();
          tweetsPerKeyword.put(e, l);
          DateTime date = new DateTime(f[2]);
          Tweet g = new Tweet(f[0], date, f[1]); 
          m.get(e).add(g);
        }
      }
    }
/*
* the method public List<Tweet> getTweetsInRange(DateTime start, DateTime end) returns a list of all tweets between 
*a start time (inclusive) and end time (exclusive).
*/
     public List<Tweet> getTweetsInRange(DateTime start, DateTime end){
        if(start.compareTo(end) >= 0) // verify that start is not >= to end
              throw new IllegalArgumentException("Invalid Range: Start cannot be greater than or equal to end"); 
         List<Tweet> l = new LinkedList<Tweet>();
         SortedMap<DateTime,List<Tweet>> range = tweetsByTime.subMap(start, true, end, false);
         for(List<Tweet> e : range.values()){
           l.addAll(e); // this method runs in O(N) and will run in O(N^2) under another for loop
         }  
            // returns an empty list if the ranges possess no values. 
         return hashSetAndList(l); 
        }
    
    /*
 * This method contracts a list of tweets associated with a date
 */
    public void rangeConstructor(String[] f, TreeMap<DateTime, List<Tweet>> m){
      DateTime date = new DateTime(f[2]);
      if(m.containsKey(date)){
          Tweet g = new Tweet(f[0], date, f[1]); 
          m.get(date).add(g);
      }else{
          List<Tweet> l = new LinkedList<Tweet>();
          m.put(date, l);
          Tweet g = new Tweet(f[0], date, f[1]); 
          m.get(date).add(g);
      }
    }
    
// ************* Part 4 
/*
 * this method coaverts a list into a hashSet and reconverts it into a list
 * This helps remove duplicates
 */
    public List<Tweet> hashSetAndList(List<Tweet> l){
      HashSet<Tweet> tweetSet = new HashSet<Tweet>(l);
      List<Tweet> setList = new LinkedList<Tweet>(tweetSet);
      return setList;   
  }
    
    
  
    
    
    public static void main(String[] args) {
       /**  
        try {
          //part1 
       
          TweetDB tdb = new TweetDB("coachella_tweets.csv");
       
         System.out.println("**********************************************");
            System.out.println("**********************************************");
            System.out.println("**********************************************");
            System.out.println("**********************************************");
          
         //part2    
          
            for(Tweet t : tdb.getTweetsByUser("hannahfrog"))
                System.out.println(t);
          System.out.println("**********************************************");
            System.out.println("**********************************************");
            System.out.println("**********************************************");
            System.out.println("**********************************************");
            
           
           //Part 2: Search by keyword
            for(Tweet t : tdb.getTweetsByKeyword("music"))
                System.out.println(t);
            
            System.out.println("**********************************************");
            System.out.println("**********************************************");
            System.out.println("**********************************************");
            System.out.println("**********************************************");
            
            
           //Part 3: Search by date/time interval          
        for(Tweet t : tdb.getTweetsInRange(new DateTime("1/7/15 15:02"), new DateTime("1/7/15 15:02")))
            System.out.println(t);
       
              
        } catch (FileNotFoundException e) {
            System.out.println(".csv File not found.");
        } catch (IOException e) {
            System.out.println("Error reading from .csv file.");
        }
        */
       
          
    }
}
    
