/*
 * Author: Carlos Lopez 
 * UNI: cal2266
 * Description: This class creates binary trees that store nodes with 
 * integers as data.
 */ 

import java.util.LinkedList;
import java.util.Deque;
import java.util.List;

public class BinaryTree {
  
  private Node root = null; 
  
  
  private static class Node{  // represents an individual node
    Integer data; 
    Node left; 
    Node right;
    
    public Node(Integer data, Node left, Node right){
      this.data = data; 
      this.left = left; 
      this.right = right;
    }
    
    public Node(Integer data) {
      this.data = data; 
      this.left = null; 
      this.right = null;
    }
        
  }

  
  public BinaryTree(Node node) {
    this.root = node;
  }
  
  /**
   * Returns the sum of the integer values in the tree.
   */
  public Integer sumTree() {
    return sumTreeRec(root);
  }
  
  /**
   * Helper method to perform the recursive tree traversal.
   */
  public Integer sumTreeRec(Node node) {
    if (node == null)
      return 0;
    /*if(node != null){
      System.out.print(node.left.data + " ");
      System.out.println(node.right.data + " ");
      System.out.println(node.data + " ");
    } */ 
    return sumTreeRec(node.left) + sumTreeRec(node.right) + node.data;        
  }
   
  /**
   * uses postorder to get the sum
   * TODO: write this method. Use a stack to perform the recursive tree traversal. 
   */
  public Integer sumTreeStack() {
    Integer sum = 0; 
    Stack<Node> sumVal= new ArrayStack<Node>();
    Node curr = root; 
    Node prev = null; // while terminates once post order is finished
    while(curr != null || !sumVal.isEmpty()){ 
      if(curr != null){
        sumVal.push(curr);
        curr = curr.left;
       }else{
        curr = sumVal.top();
        if(curr.right == null || curr.right == prev){
          sum += sumVal.pop().data;
          prev = curr;
          curr = null;  
        }else
          if(curr.data != null )
             curr = curr.right; 
      } 
    }
    return sum; 
  }
  
  

 
  /**
   * uses preorder traversal to get the level order
   * TODO: write this method. Use a queue to print the integer values in level order. 
   */  
  public List<Integer> levelOrder() {
   java.util.Queue<Node> q1 = new LinkedList<Node>();
    List<Integer> result = new LinkedList<>();
    q1.add(root);
    while(!q1.isEmpty()){
      Node curr = q1.poll();
      if(curr != null)
        result.add(curr.data); 
      if(curr.left != null){
        q1.add(curr.left);
      }
      if(curr.right != null){
        q1.add(curr.right);
      }
    }    
    return result;     
  }
  
  
  
  /**
   * Factory method that creates a new BinaryTree with two subtrees.
   * The two btree methods make it possible to easily construt binary trees like this:
   * BinaryTree t = btree(1,btree(2,btree(3),btree(4)),btree(5));
   * @return a new BinaryTree with two children.
   */    
   public static BinaryTree btree(Integer data, BinaryTree t1, BinaryTree t2) {
     Node tLeft = null;
     Node tRight = null;
     if(t1 != null)
       tLeft = t1.root;
     if(t2 != null)
        tRight = t2.root;
     Node root = new Node(data, tLeft, tRight);
     return new BinaryTree(root);
   }
   
   public static BinaryTree btree(Integer data) {
        Node root = new Node(data);
        return new BinaryTree(root);
   }
            
   public static void main(String[] args){
          
     BinaryTree tree = btree(1, btree(2, btree(3), btree(4)), btree(5));
     System.out.println(tree.sumTreeStack());     
     System.out.println(tree.levelOrder());
     
   }
    
}