package Graphs;

import java.util.Arrays;

//Solved here - https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
//NOT solved below
public class BellmanFordAlgorithm {
    static int INT_MAX = 2147483647;
    static void bellmanFord(int vertex, Graph<Integer> graph, int src, int dest){
        int[] dist = new int[vertex];
        Arrays.fill(dist, INT_MAX);
        dist[src] = 0;

        //Step 1
        for(int i = 0; i < vertex -1; i++){
            if(graph.weightedAdj.containsKey(i)){
                for (WeightedPair<Integer> neighbour : graph.weightedAdj.get(i)) {
                    if( dist[i] != INT_MAX && dist[i] + neighbour.weight < dist[neighbour.node]){
                        dist[neighbour.node] = dist[i] + neighbour.weight;
                    }
                }
            }
        }

        // Step 2
        boolean flag = false;
    }
    public static void main(String[] args) {
        int vertex = 3; // total no of nodes
        Graph<Integer> graph = new Graph<>();
        graph.addWeightedEdge(0, 1, 2, true); // 0->1 wt = 2
        graph.addWeightedEdge(0, 2, 2, true); //0-> 2 wt = 2
        graph.addWeightedEdge(1, 2, -1, true); //1-> 2 wt = -1

        int src =0; 
        int dest = 2;
        bellmanFord(vertex,graph, src, dest);
    }
}
