package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph<T> {
    Map<T , ArrayList<T>> adj = new HashMap<>();
    // private T value; 

    public Graph(){}

    public void addEdge(T u, T v , boolean direction){
        // direction == true ? Directed graph
        // direction == false ? Undirected graph

        //Create an edge from u to v 
        if(adj.get(u) != null){
            ArrayList<T> list = adj.get(u);
            list.add(v);
            adj.put(u, list);
        }
        else {
            ArrayList<T> list = new ArrayList<>();
            list.add(v);
            adj.put(u, list);
        }
        
        //If un-directed graph, then only add v to u also
        if(!direction){
            this.addEdge(v, u, true);
        }
    }

    public void printAdjList(){
        for (Map.Entry<T,ArrayList<T>> entry : adj.entrySet()){
            System.out.print("Key = " + entry.getKey());
            for (T li : entry.getValue()) {
                System.out.print(" Value = "+li);
            }
            System.out.println("");
        }     
    }
}