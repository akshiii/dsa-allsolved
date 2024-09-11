package Graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class PairInt{
    int node;
    int dist; // dist of node

    public PairInt(int node, int dist) {
        this.dist = dist;
        this.node = node;
    }
}
/*
 * Priority Queue (Min-Heap): If you need to remove the minimum element multiple times, 
 * a priority queue (implemented as a min-heap) allows you to remove the minimum element in 𝑂(log 𝑛) time. 
 * However, finding the minimum element is 𝑂(1), but insertion or removal is 𝑂(log 𝑛), not 𝑂(𝑛).
*/

public class DijkstrasAlgorithm {
    static int[] arr;
    static int INT_MAX = 2147483647;

    static void findShortestDistUsingDij(Graph<Integer> graph, int vertex, int srcNode){
        arr = new int[vertex];
        Arrays.fill(arr, INT_MAX); // store int_max for all values
        arr[srcNode] = 0; // dist from src_node to src_node is 0

        boolean[] vis = new boolean[vertex];

        // PriorityQueue<>(capacity,comparator );capacity - the initial capacity for this priority queue
        // comparator - the comparator that will be used to order this priority queue. 
        PriorityQueue<PairInt> prQueue = new PriorityQueue<>(vertex, Comparator.comparingInt(o -> o.dist));

        prQueue.add(new PairInt(srcNode, 0));

        while(!prQueue.isEmpty()){
            PairInt minNode = prQueue.poll();

            if(vis[minNode.node]){
                continue;
            }
            
            vis[minNode.node] = true;

            if(graph.weightedAdj.containsKey(minNode.node)){
                for (WeightedPair<Integer> neighbour : graph.weightedAdj.get(minNode.node)) {
                    if(minNode.dist + neighbour.weight < arr[neighbour.node]){
                        arr[neighbour.node] = arr[minNode.node] + neighbour.weight;
                        prQueue.add(new PairInt(neighbour.node, arr[neighbour.node]));
                    }
                }
            }
        }

        for(int i = 0; i < arr.length ; i++){
            System.out.print(arr[i]+ " ");
        }
    }
    public static void main(String[] args) {
        int vertex = 4; // total no of nodes
        Graph<Integer> graph = new Graph<>();
        graph.addWeightedEdge(0, 1, 5, false);
        graph.addWeightedEdge(0, 2, 8, false);
        graph.addWeightedEdge(1, 2, 9, false);
        graph.addWeightedEdge(1, 3, 2, false);
        graph.addWeightedEdge(3, 2, 6, false);


        // int vertex =3; // total no of nodes
        // Graph<Integer> graph = new Graph<>();
        // graph.addWeightedEdge(0, 1, 5, true);
        // graph.addWeightedEdge(0, 2, 6, true);
        // graph.addWeightedEdge(2, 1, -3, true);
        // graph.printWeightedAdjList();

        int srcNode = 0;

        findShortestDistUsingDij(graph, vertex, srcNode);
    }
}
