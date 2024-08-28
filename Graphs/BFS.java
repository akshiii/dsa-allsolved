package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//Breadth First Search
public class BFS {
    static void printBFS(int vertex, Map<Integer, Boolean> visited, int node, Graph<Integer> graph){
        //This for loop is for any case of disconnected graph
        for(int i = 0; i < vertex; i++){
            if(visited.get(i) == false){
                bfs(visited, node, graph);
            }
        }
    }

    static void bfs(Map<Integer, Boolean> visited, int node, Graph<Integer> graph ){
        Queue<Integer> queue = new LinkedList();
        queue.add(node);

        visited.put(node, true);

        while(!queue.isEmpty()){
            int frontNode = queue.remove();

            //store frontnode into ans
            System.out.print(frontNode+" ");

            //traverse all neighbours
            ArrayList<Integer> list = graph.adj.get(frontNode);
            for (int val : list) {
                int neighbour = val;
                if(visited.get(neighbour) == false){
                    queue.add(neighbour);
                    visited.put(neighbour, true);
                }
            }
        }
    }
    public static void main(String[] args) {
        int vertex = 5; // no of nodes
        int startingNode = 0; // starting node
        Map<Integer , Boolean> visited = new HashMap<>();
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(0, 3, false);
        graph.addEdge(3, 1, false);
        graph.addEdge(2, 1, false);
        graph.addEdge(4, 1, false);
        graph.printAdjList();

        for(int i = 0; i < vertex; i++){
            visited.put(i, false);
        }

        System.out.print("BFS => ");
        printBFS(vertex, visited, startingNode, graph);
    }
}
