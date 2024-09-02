package Graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Shortest path in Directed Acyclic graph
public class ShortestPathDirected {
    static int INT_MAX = 2147483647;

    static void topologicalSort(Map<Integer, Boolean> visited, int node, Graph<Integer> graph , Stack<Integer> stack){
        visited.put(node, true);

        if(graph.weightedAdj.containsKey(node)){
            for (WeightedPair<Integer> neighbour : graph.weightedAdj.get(node)) {
                if(visited.get(neighbour.node) == false){
                    topologicalSort(visited, neighbour.node, graph, stack);
                }
            }
        }
        stack.push(node);
    }

    static void findShortestPath(Map<Integer, Boolean> visited, Graph<Integer> graph, int vertex, int src, Stack<Integer> stack){
        int[] dist = new int[vertex];
        for(int i = 0; i< vertex ; i++){
            dist[i] = INT_MAX;
        }
        dist[src] = 0;

        while(!stack.isEmpty()){
            int top = stack.pop();
            if(dist[top] != INT_MAX){
                if(graph.weightedAdj.containsKey(top)){
                    for (WeightedPair<Integer> neighbour : graph.weightedAdj.get(top)) {
                        if(dist[top] + neighbour.weight < dist[neighbour.node]){
                            dist[neighbour.node] = dist[top] + neighbour.weight;
                        }
                    }
                }
            }
        }

        System.out.println("Shortest distance in DAG = ");
        for(int i = 0; i < vertex; i++){
            if(dist[i] == INT_MAX){
                System.out.print(" INT_MAX ");
            }
            else{
                System.out.print(dist[i] + " ");
            }
            
        }
    }
    
    public static void main(String[] args) {
        int vertex = 6; // no of nodes
        int startingNode = 0; // starting node
        int src = 1; // source node
        Map<Integer , Boolean> visited = new HashMap<>();
        Graph<Integer> graph = new Graph<>();
        graph.addWeightedEdge(0, 1, 5);
        graph.addWeightedEdge(0, 2, 3);
        graph.addWeightedEdge(1, 2, 2);
        graph.addWeightedEdge(1, 3, 6);
        graph.addWeightedEdge(2, 3, 7);
        graph.addWeightedEdge(2, 4, 4);
        graph.addWeightedEdge(2, 5, 2);
        graph.addWeightedEdge(3, 4, -1);
        graph.addWeightedEdge(4, 5, -2);
        graph.printWeightedAdjList();

        for(int i = 0; i < vertex; i++){
            visited.put(i+startingNode, false);
        }

        //Step 1: Finding TS 
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < vertex; i++){
            if(visited.get(i+startingNode) == false){
                topologicalSort(visited, startingNode, graph, stack);
            }
        }

        //Step2 : Update the dist array
        findShortestPath(visited,graph,vertex,src,stack);
    }
}
