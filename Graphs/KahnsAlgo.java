package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//Topological sort using BFS
public class KahnsAlgo {

    static void findTS(int vertex, Graph<Integer> graph ){
        int[] indegree = new int[vertex];

        // Step 1: Finding indegree of all nodes
        for (Map.Entry<Integer,ArrayList<Integer>> entry : graph.adj.entrySet()){
            for (Integer li : entry.getValue()) {
                indegree[--li]++;
            }
        } 
        //Step 2 : Push all 0 indegree nodes 
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < indegree.length ; i++){
            if(indegree[i] == 0){
                queue.add(i+1);
            }
        }

        //Step 3: Do BFS
        while(!queue.isEmpty()){
            int front = queue.remove();

            System.out.print(front + " ");

            if(graph.adj.containsKey(front)){
                for (int neighbour : graph.adj.get(front)) {
                    indegree[neighbour - 1]--;
                    if(indegree[neighbour - 1] == 0){
                        queue.add(neighbour);
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int vertex = 5; // no of nodes
        int startingNode = 1; // starting node
        Map<Integer , Boolean> visited = new HashMap<>();
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(1, 2, true);
        graph.addEdge(1, 3, true);
        graph.addEdge(2, 5, true);
        graph.addEdge(3, 5, true);
        graph.addEdge(5, 4, true);
        graph.printAdjList();

        for(int i = 0; i < vertex; i++){
            visited.put(i+startingNode, false);
        }

        System.out.print("TS ( using Kahn's Algo ) => "); // 1 2 3 5 4
        findTS(vertex,graph);
    }
}
