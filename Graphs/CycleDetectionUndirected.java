package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//Cycle detection in undirected graphs - using bfs
public class CycleDetectionUndirected {


    //Detecting cycle using bfs
    static boolean isCycleDetectedUsingBFS(int vertex, Map<Integer, Boolean> visited, int node, Graph<Integer> graph){
        //This for loop is for any case of disconnected graph
        for(int i = 0; i < vertex; i++){
            if(visited.get(i+node) == false){
                boolean ans = isCyclic(visited, node, graph);
                if(ans){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isCyclic(Map<Integer, Boolean> visited, int node, Graph<Integer> graph ){

        Map<Integer , Integer> parent = new HashMap<>();
        parent.put(node, -1);
        visited.put(node, true);

        Queue<Integer> queue = new LinkedList();
        queue.add(node);


        while(!queue.isEmpty()){
            int frontNode = queue.remove();

            //traverse all neighbours
            for (int val : graph.adj.get(frontNode)) {
                int neighbour = val;
                if(visited.get(neighbour) == true && neighbour != parent.get(frontNode)){
                    return true;
                }
                else if(visited.get(neighbour) == false){
                    queue.add(neighbour);
                    visited.put(neighbour, true);
                    parent.put(neighbour, frontNode);
                }
            }
        }
        return false;
    }

    //Detecting cycle using dfs
    static boolean isCycleDetectedUsingDFS(int vertex, Map<Integer, Boolean> visited, int node, Graph<Integer> graph){
        for(int i = 0; i < vertex; i++){
            if(visited.get(i+node) == false){
                boolean ans = isCyclicDFS(visited, node ,-1, graph);
                if(ans){
                    return true;
                }
            }
        }   
        return false;
    }

    static boolean isCyclicDFS(Map<Integer, Boolean> visited, int node,int parent, Graph<Integer> graph ){
        visited.put(node, true);

        for (int neighbour : graph.adj.get(node)) {
            if(visited.get(neighbour) == false){
                boolean cycleDetected = isCyclicDFS(visited, neighbour, node,  graph);
                if(cycleDetected){
                    return true;
                }
            }
            else{
                //if visited is true
                if(neighbour != parent){
                    //cycle present
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int vertex = 6; // no of nodes
        int startingNode = 4; // starting node
        Map<Integer , Boolean> visited = new HashMap<>();
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(4, 5, false);
        graph.addEdge(5, 6, false);
        graph.addEdge(5, 7, false);
        graph.addEdge(7, 8, false);
        graph.addEdge(6, 8, false);
        graph.addEdge(9, 8, false);
        graph.printAdjList();

        for(int i = 0; i < vertex; i++){
            visited.put(i+4, false);
        }

        // System.out.print("Is cyclic (using bfs) ? => "+isCycleDetectedUsingBFS(vertex, visited, startingNode, graph));
        System.out.print("Is cyclic (using dfs) ? => "+isCycleDetectedUsingDFS(vertex, visited, startingNode, graph));
        
    }
}
