/*
 * Author: Carlos López 
 * UNI: cal2266
 * Description: This is a Graph class that gets the shortest path for a graph with Edges<V> and Vertices<V>.
 * The method doDjikstra the HeapEntry class is used to avoid the repetition of one element that possess different costs
 * ********** Remeamber to delete AEdges.txt, AVertices.txt, and DisplayTest.java before submission after Bauer's OH. 
 */ 

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Collection;
import java.util.Iterator;
import java.lang.Math;
import java.util.PriorityQueue;
import java.util.NoSuchElementException;
import java.util.Stack; 

public class Graph<V> { 
   
    // Keep an index from node labels to nodes in the map
    protected Map<V, Vertex<V>> vertices; 

    /**
     * Construct an empty Graph.
     */
    public Graph() {
       vertices = new HashMap<V, Vertex<V>>();
    }

    /**
     * Retrieve a collection of vertices. 
     */  
    public Collection<Vertex<V>> getVertices() {
        return vertices.values();
    }

    public void addVertex(V u) {
        addVertex(new Vertex<>(u));
    }
    
    public void addVertex(Vertex<V> v) {
        if (vertices.containsKey(v.name)) 
            throw new IllegalArgumentException("Cannot create new vertex with existing name.");
        vertices.put(v.name, v);
    }

    /**
     * Add a new edge from u to v.
     * Create new nodes if these nodes don't exist yet. 
     * @param u unique name of the first vertex.
     * @param w unique name of the second vertex.
     * @param cost cost of this edge. 
     */
    public void addEdge(V u, V w, Double cost) {
        if (!vertices.containsKey(u))
            addVertex(u);
        if (!vertices.containsKey(w))
            addVertex(w);

        vertices.get(u).addEdge(
            new Edge<>(vertices.get(u), vertices.get(w), cost)); 

    }

    public void addEdge(V u, V w) {
        addEdge(u,w,1.0);
    }

    public void printAdjacencyList() {
        for(V u : vertices.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(u.toString());
            sb.append(" -> [ ");
            for (Edge e : vertices.get(u).getEdges()){
                sb.append(e.target.name);
                sb.append(" ");
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }    
  
   /**
    * Add a bidirectional edge between u and v. Create new nodes if these nodes don't exist
    * yet. This method permits adding multiple edges between the same nodes.
    *
    * @param u  
    *          the name of the source vertex.
    * @param v 
    *          the name of the target vertex.
    * @param cost
    *          the cost of this edge
    */
    public void addUndirectedEdge(V u, V v, Double cost) {
        addEdge(u,v, cost);
        addEdge(v,u, cost);
    }

    /****************************
     * Your code follows here.  *
     ****************************/ 
    
    // Part 1
    public void computeAllEuclideanDistances(){
        for (V u : vertices.keySet()) {
            for (Edge e : vertices.get(u).getEdges()){
                 e.distance = Math.sqrt(Math.pow((e.source.posX - e.target.posX),2) + Math.pow((e.source.posY - e.target.posY),2));
            }
        }
     }
                                     
    // Part 2
    //doDjikstra performs djikstras for vertices in directed and undirected graphs
    public void doDijkstra(V s){
        Vertex<V> start = vertices.get(s); 
        PriorityQueue<HeapEntry<V>> minHeap = new PriorityQueue<HeapEntry<V>>(
            (vertex1, vertex2)-> Double.compare(vertex1.cost, vertex2.cost));
        startVertices(); // initialize the values for vertices
        start.cost = 0; // set a cost of zero 
        HeapEntry<V> start1 = new HeapEntry<V>((Vertex<V>)start, start.cost);
        minHeap.add(start1); //add to minHeap
        while(!minHeap.isEmpty()){ // while the minHeap is not empty
             HeapEntry<V> minV = minHeap.poll();
             minV.vertex.visited = true; 
            for(Edge<V> e: minV.vertex.getEdges()){
                if(!e.target.visited){ // verify if not visited
                    double costVW = e.distance; 
                    if(minV.cost + costVW < e.target.cost){ 
                        e.target.cost = minV.cost + costVW;  // update cost
                        e.target.backpointer = (Vertex<V>)minV.vertex;
                        HeapEntry<V> entry = new HeapEntry<V>( (Vertex<V>)e.target, e.target.cost); // new minHeap Entry
                        minHeap.add(entry);
                    }
                }
            } 
        }    
     }
    
    /* helper method
     * This method updates costs, back pointers, and the visit term
     */ 
    public void startVertices(){
        for(V u: vertices.keySet()){
            vertices.get(u).cost =  Double.POSITIVE_INFINITY;
            vertices.get(u).visited = false; 
            vertices.get(u).backpointer = null; 
        }
    }
    
   /*
    * Nested Class Heap Entry
    * This class HeapEntry is used to avoid using copies of vertices
    */ 
    
   public class HeapEntry<V>{
       public Vertex<V> vertex;
       public Double cost; 
       public HeapEntry(Vertex<V> vertex, Double cost){
           this.vertex = vertex; 
           this.cost = cost; 
       }
       public int compareTo(HeapEntry<V> other) {
          return this.cost.compareTo(other.cost);
       }
  }
    
    
    
    
    // Part 3
    
    //fix
    public List<Edge<V>> getDijkstraPath(V s, V t){
        LinkedList<Edge<V>> result = new LinkedList<Edge<V>>();
        if(vertices.get(s).equals(vertices.get(t)))
            return (List<Edge<V>>)result; 
        doDijkstra(s);
        Vertex<V> curr = vertices.get(t);
        if(curr.backpointer!=null){ 
            Vertex<V> prev = (Vertex<V>) vertices.get(t).backpointer;
            while(prev!=null){ // get edges from last to first (edge from b to c before edge from a to b)
                 curr.cost = curr.cost-prev.cost; 
                 Edge<V> x = (Edge<V>)new Edge<V>(prev, curr, curr.cost);
                 result.addFirst(x); // use add first so edges are in order
                 curr = prev;
                 prev = (Vertex<V>) prev.backpointer; 
            }
        }
        if(!curr.equals(vertices.get(s)) || vertices.get(t).backpointer == null) //ensure path exists
            throw new NoSuchElementException("There is no path");
        return (List<Edge<V>>)result; 
   } 
} 
