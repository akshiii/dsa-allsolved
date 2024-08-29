package Graphs;

import java.util.HashMap;
import java.util.Map;

//Cycely detection of directe graph - We are using DFS here
public class CycleDetectionDirected {

    static boolean isCycleDetected(int vertex, Map<Integer, Boolean> visited, Map<Integer, Boolean> dfsVisited, int startingNode, Graph<Integer> graph){
        for(int i = 0 + startingNode; i < vertex; i++){
            if(visited.get(i+startingNode) == false){
                boolean ans = isCyclic(visited, dfsVisited, startingNode, graph);
                if(ans){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isCyclic(Map<Integer, Boolean> visited,Map<Integer, Boolean> dfsVisited, int node, Graph<Integer> graph ){
        visited.put(node, true);
        dfsVisited.put(node, true);

        if(graph.adj.containsKey(node)){
            for (int neighbour : graph.adj.get(node)) {
                if(visited.get(neighbour) == false){
                    boolean cycleDetected = isCyclic(visited, dfsVisited, neighbour, graph);
                    if(cycleDetected){
                        return true;
                    }
                }else{
                    if(dfsVisited.get(neighbour) == true){
                        return true;
                    }
                }
            }
        }
        dfsVisited.put(node, false);

        return false;
    }
    public static void main(String[] args) {
        int vertex = 8; // no of nodes
        int startingNode = 1; // starting node
        Map<Integer , Boolean> visited = new HashMap<>();
        Map<Integer , Boolean> dfsVisited = new HashMap<>();
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(1, 2, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(3, 7, true);
        graph.addEdge(3, 8, true);
        graph.addEdge(8, 7, true);
        graph.addEdge(2, 4, true);
        graph.addEdge(4, 5, true);
        graph.addEdge(5, 6, true);
        graph.addEdge(6, 4, true);
        graph.printAdjList();

        for(int i = 0; i < vertex; i++){
            visited.put(i+startingNode, false);
            dfsVisited.put(i+startingNode, false);
        }

        System.out.print("Is cyclic (using dfs) ? => "+isCycleDetected(vertex, visited, dfsVisited, startingNode, graph));
    }
}
