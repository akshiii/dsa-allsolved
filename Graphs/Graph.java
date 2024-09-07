package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class WeightedPair<T> {
    T node;
    T weight;
    
    public WeightedPair(T node, T weight){
        this.node = node;
        this.weight = weight;
    }
}
public class Graph<T> {
    Map<T , ArrayList<T>> adj = new HashMap<>();
    Map<T , ArrayList<WeightedPair<T>>> weightedAdj = new HashMap<>();
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

    //Weighted edges
    public void addWeightedEdge(T u, T v, T weight, boolean direction){
        if(weightedAdj.get(u) != null){
            ArrayList<WeightedPair<T>> list = weightedAdj.get(u);
            WeightedPair<T> weightedPair = new WeightedPair(v, weight);
            list.add(weightedPair);
            weightedAdj.put(u, list);
        }
        else{
            ArrayList<WeightedPair<T>> list =  new ArrayList<>();
            WeightedPair<T> weightedPair = new WeightedPair(v, weight);
            list.add(weightedPair);
            weightedAdj.put(u, list);
        }

        //If un-directed graph, then only add v to u also
        if(!direction){
            this.addWeightedEdge(v, u, weight, true);
        }
    }

    public void printWeightedAdjList(){
        for (Map.Entry<T,ArrayList<WeightedPair<T>>> entry : weightedAdj.entrySet()){
            System.out.print(entry.getKey() + " -> ");
            for (WeightedPair weightedPair : entry.getValue()) {
                System.out.print("["+ weightedPair.node + " , "+weightedPair.weight + "] " );
            }
            System.out.println("");
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
