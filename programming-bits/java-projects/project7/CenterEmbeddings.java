/*
 * Author: Carlos Lopez 
 * UNI: cal2266
 * Description: This class creates a list of relations that are built with sentences that poses one main verb 
 * Verbs are transitive or intransitive
 * The structures are as follows (object, transitive) (object, transitive and subject)
 */
import java.util.LinkedList;
import java.util.*;
public class CenterEmbeddings {

  private static final String[] transitive = {"knew", "chased", "liked", "loved", "saw"};
  private static final String[] intransitive = {"snored", "laughed", "ran"};
  private static final String[] artf = {"the", "that", "a"};
  //ArrayLists are used due to versability of contains method 
  private static final ArrayList<String> art = new ArrayList<String>(Arrays.asList(artf));
  private static final ArrayList<String> t = new ArrayList<String>(Arrays.asList(transitive));
  private static final ArrayList<String> it = new ArrayList<String>(Arrays.asList(intransitive));
  private static class Relation {
    String predicate; 
    String subject; 
    String object;    
    public Relation(String predicate, String subject, String object) {
      this.predicate = predicate; 
      this.subject = subject; 
      this.object = object;
    }
    
    public String toString(){
      if (object != null)
        return "(" + subject + "," + predicate +"," + object +")";
      else
        return "(" + subject + "," + predicate+")";
    }  
  }
  /*
 * @ params sentence
 * @ returns List<Relation> r
 * This method builds a list of relations with three helper methods
 */
  public static List<Relation> parseSentence(String sentence) throws IllegalArgumentException{
    ArrayList<String> w = remove(sentence.trim().split(" ")); // removes articles
    LinkedList<String> s = new LinkedList<>();
    List<Relation> r = new LinkedList<>();
    String trans = null;
    int verbCount = 0; 
    for(int j = 0; j < w.size(); j++){
      if(t.contains(w.get(j))){
        verbCount++; 
        if(s.size() > 1){
          helpTrans(w, s, r, trans, j);
        }else
          trans = w.get(j);
      } 
      else if(it.contains(w.get(j))){
        verbCount++;
        helpIntrans(w, s, r, j);
      }else
        if(!it.contains(w.get(j)) && !t.contains(w.get(j)))
           s.push(w.get(j));
      if(trans != null && s.size() > 1){
        helpTrans(w, s, r, trans, j);
        trans = null; 
      }  
    }
    if(!s.isEmpty() || verbCount != r.size())
          throw new IllegalArgumentException("That is an invalid sentence!"); 
    return r; 
  }
  /*
 * @ params w, s, r, trans j, 
 * This helper method builds a relation with an transitive verb as the predicate and two other nouns
 * 
 */
  private static void helpTrans(ArrayList<String> w, LinkedList<String> s, List<Relation> r, String trans, int j){
    if(trans != null){ // case in which transitive verb is between nouns
      String temp = s.pop();
      r.add(new Relation(trans, s.peek(), temp));
      if(j >= w.size() -1)
        s.pop();
      else{ 
        if(j < w.size()-1){ // push transitive back b/c of additional noun
          if(!it.contains(w.get(j+1)) && !t.contains(w.get(j+1))){
            s.pop();
            s.push(temp);
          }
       }
      }
    }
    else{// if transitive follows nouns execute 
      if(s.size() >= 2){
        String temp = s.pop();
        r.add(new Relation( w.get(j), temp, s.peek()));
        if(j >= w.size() -1)
          s.pop(); 
      }
    }
  }
/*
 * @ params w, s, r, j, 
 * This helper method builds a relation with an intransitive verb as the predicate
 */
  
  private static void helpIntrans(ArrayList<String> w, LinkedList<String> s, List<Relation> r , int j){
    if(s.isEmpty()) // can't pop empty stack 
      throw new  IllegalArgumentException("That is invalid sentence!"); 
    else{
      String temp = s.pop();
      r.add(new Relation(w.get(j), temp, null));
      if(j != w.size()-1) // pushes element back if the instrasitive is not at last index
        s.push(temp); 
    } 
  }
/*
 * @ params w 
 * @returns ArrayList<String> words
 * This helper method removes all articles to ease the analysis. 
 */
  private static ArrayList<String> remove(String[] w){
    ArrayList<String> words = new ArrayList<String>();
    for(int i = 0; i < w.length; i++){
    if(!art.contains(w[i]))
       words.add(w[i]);  
    }
    return words;
  }
 
  
  
  
  
  public static void main(String[] args) {
    
    String test1 = "the child laughed"; // passed 
    String test2 = "the child that the the woman loved laughed";  // passed   
    String test3 = "the child that the the woman that the man knew loved laughed"; // passed   
    String test4 = "the child saw the cat"; // hard  // passed 
    String test5 = "the child that the man knew saw the cat"; // hard //passed
    String test6 = "the child saw the cat that the man loved"; // even harder // passed 
    
    List<Relation> result = parseSentence(test6);
    for (Relation r :result) {
      System.out.println(r);
    } 
  }
  
  
}