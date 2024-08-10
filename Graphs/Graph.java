package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    Map<Integer , ArrayList<Integer>> adj = new HashMap<>();

    public Graph(){}

    public void addEdge(int u, int v , boolean direction){
        // direction == true ? Directed graph
        // direction == false ? Undirected graph

        //Create an edge from u to v 
        if(adj.get(u) != null){
            ArrayList<Integer> list = adj.get(u);
            list.add(v);
            adj.put(u, list);
        }
        else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(v);
            adj.put(u, list);
        }
        
        //If directed graph, then only add v to u also
        if(direction){
            this.addEdge(v, u, false);
        }
    }

    public void printAdjList(){
        // List<Integer> list = verticalList(root);
        // for (int li : list) {
        //     System.out.print(li+" ");
        // }
    }
}
