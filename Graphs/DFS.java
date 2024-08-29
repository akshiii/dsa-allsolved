package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Depth First Search
public class DFS {
    static void printDFS(int vertex, Map<Integer, Boolean> visited, int node, Graph<Integer> graph){
        //This for loop is for any case of disconnected graph
        for(int i = 0; i < vertex; i++){
            if(visited.get(i) == false){
                dfs(visited, node, graph);
            }
        }
    }

    static void dfs(Map<Integer, Boolean> visited, int node, Graph<Integer> graph ){
        System.out.print(node+" ");
        visited.put(node, true);

        //Har connected node ke lie recursive call
        ArrayList<Integer> list = graph.adj.get(node);
        for (int val : list) {
                int neighbour = val;
                if(visited.get(neighbour) == false){
                    dfs(visited, neighbour, graph);
                }
        }
    }
    
    public static void main(String[] args) {
        int vertex = 5; // no of nodes
        int startingNode = 0; // starting node
        Map<Integer , Boolean> visited = new HashMap<>();
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(0, 2, false);
        graph.addEdge(2, 1, false);
        graph.addEdge(2, 4, false);
        graph.addEdge(1, 3, false);
        graph.addEdge(4, 3, false);
        graph.printAdjList();

        for(int i = 0; i < vertex; i++){
            visited.put(i, false);
        }

        System.out.print("DFS => ");
        printDFS(vertex, visited, startingNode, graph);
    }
}
