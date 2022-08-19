/*
* Author: Carlos Lopez 
* UNI: cal2266
* Description: This class creates binary trees that store nodes with 
* generics as data. GetRange returns a list with comparable any types 
* within the range. The smallestGreaterThan returns the 
* smallest value greeter than the one specified
*/ 
import java.util.List;
import java.util.*;
import java.io.*; 
import java.util.NoSuchElementException;


public class BetterBST<T extends Comparable<? super T>> extends BinarySearchTree<T> {
    
 // return smaller value greater than T low 
 // or a NOSuchElmentException if val remains null   
    @Override
	T smallestGreaterThan(T low) {
        BinaryNode<T> curr = this.root;
        T val = null;
        while(curr != null){
            if( curr != null && curr.data.compareTo(low) > 0){
            val = curr.data;
            curr = curr.left; 
            }
            if(curr != null && curr.data.compareTo(low) <= 0)
                curr = curr.right; 
        }
        if(val == null)
            throw new NoSuchElementException("There is no smallest value greater than " + low);
        return val;
    }
// this methods returns an ordered list of generics for a range [T low, T high) 
// [  signifies low is included and ) signifies high is excluded
    @Override
    List<T> getRange(T low, T high) {
       List<T> l = new ArrayList<T>();
       BinaryNode<T> x = this.root;
       getRange(low, high, x, l); 
       return l; 
       // returns an empty list if no values lie within the range
    }
// this helper method uses an infix traversal to return an ordered list of generics
    private void getRange(T low, T high, BinaryNode<T> n, List<T> l){
        if(n == null)
            ;
        else{
          getRange(low, high, n.left, l);
          if(n.data.compareTo(low) >=0 && n.data.compareTo(high) < 0)
             l.add(n.data);
          getRange(low, high, n.right, l);
        }
        
    }
    
    public static void main(String[] args ){
       /*
        BetterBST<Integer> btree = new BetterBST<Integer>();
        btree.insert(10);
        btree.insert(14);
        btree.insert(6);
        btree.insert(8);
        btree.insert(1);
        btree.insert(3);
        btree.insert(5);
        int target = 3;
        System.out.println("Target: " + target);
        System.out.println("Successor: " + btree.smallestGreaterThan(target));
        System.out.println(btree.getRange(2, 10));
       */
    }
    
    
            
}