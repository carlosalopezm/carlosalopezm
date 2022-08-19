//*************************************
//
//  WordLists.java
//
//  Class to aid with Scrabble
//  Programming Project 5, COMS W1004
//
//
//  Your Name: Carlos López 
//  Your Uni: cal2266
//  
//  This the program that creates the word list for the Scrabble Dictionary Helper.  
//**************************************
/**
* Your class should contain the following methods:
.
*/

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

 

public class WordLists{ //done 
  // only instance variable
  private ArrayList<String> scrabbleDic; 
  //constructor for dictionary
  public WordLists(String fileName) throws FileNotFoundException, IllegalArgumentException, NullPointerException{
      
      scrabbleDic = new ArrayList<String>();  
      File dictionaryFile = new File(fileName); 
      Scanner input = new Scanner(dictionaryFile);
      while(input.hasNext()){
          scrabbleDic.add(input.next());
      }

  }

//lengthN(int n): returns an ArrayList of all length n words
// (Strings) in the dictionary file.
  public ArrayList<String> lengthN(int n){ // done 
    intError(n);
    ArrayList<String> lengthN = new ArrayList<String>(); 
    for(String element : scrabbleDic){
        if(element.length() == n){  
            lengthN.add(element);   
        }
    } 
    
    return lengthN; 
  }


  public ArrayList<String> endsWith(char lastLetter, int n){ // done 
    char x = lastLetter; 
    char lastL = Character.toLowerCase(x); 
    letter(lastL); // checks for erros 
    intError(n);
    ArrayList<String> endsWith = new ArrayList<String>(); 
    for(String element : scrabbleDic){ // enhanced for loop 
        int len = element.length(); // sets length 
        if(len == n && element.charAt(len -1) == lastL){
            endsWith.add(element); // add element 
        }
    }
    return endsWith; 
  }


  public ArrayList<String> containsLetter(char included, int index, int n){
    char x = included;
    char inc = Character.toLowerCase(x);
    letter(inc); // check for errors 
    indexError(index);
    intError(n);
    ArrayList<String> containsLetter = new ArrayList<String>(); 
    for(String element : scrabbleDic){
        int len = element.length(); // 
        boolean contains = stringContains(element, inc, index, n );
        if(contains){
            containsLetter.add(element); // add to list 
        }  
   }
     return containsLetter;   
   }

  public ArrayList<String> multiLetter(int m, char included){
    char x = included;
    char inc = Character.toLowerCase(x);
    letter(inc); 
    intError(m);
    ArrayList<String> multiLetter = new ArrayList<String>(); 
    for(String element : scrabbleDic){
        int len = element.length();
        boolean contains = numContains(element, m, inc );
        if(contains){
            multiLetter.add(element);
        }
    }  
    
    return multiLetter; 
    
 }
    
// *************Helper methods*************
  
  // verifies which words fit the criteria for the method containsLetter
   private boolean stringContains( String word, char inc, int index, int n ){ 
      boolean valid = false; 
      for(int j = 0; j < word.length(); j++){
          if(word.charAt(j) == inc && (j == index && word.length() == n))
                valid = true; 
      }
      return valid;
    }
    
    // verifies which words fit the criteria for the method multiLetter
    private boolean numContains(String word, int m, char inc){
      boolean valid = false;
      int counter = 0; 
      for(int j = 0; j < word.length(); j++){
          if(word.charAt(j) == inc)
                counter++; 
      }
      if(counter == m)
        valid = true; 
      return valid;   
    }
   // this helper methods is run to create a file 
   public void test(String name, ArrayList<String> list){
     try{
       PrintWriter output = new PrintWriter(name);
			for (int i = 0; i < list.size(); i++) {
				output.println(list.get(i));
			}
			output.close();
     }
     catch(FileNotFoundException a){
         System.out.println("Please try again with correct input file name");
     } 
    
   } 
   // verifies if int argaments are 
   public void intError(int n){ // verifyes n > 0
       if(n < 1) {
	     throw new IllegalArgumentException("Enter values <= 1");  
     } 
   }
    
   public void letter(char c){ // checks if type is char 
    if(Character.getType(c) == Character.CONTROL) {
	  throw new IllegalArgumentException("Enter a char with single quotes ('a')");  
    } 
  }
  
    public void indexError(int n){ // verifyes n > 0
       if(n < 0) {
	     throw new IllegalArgumentException("Enter an index value greater than 0");  
        }
    }
    
} // end of class











