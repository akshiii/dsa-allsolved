package Graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

//We find Minimum spanning tree using Prim's algo
public class PrimsAlgorithm {
    static int INT_MAX = 2147483647;

    //it will return sum of all new edges 
    static int findMSPUsingPrims(Graph<Integer> graph, int vertex){
        int[] key = new int[vertex];
        boolean[] mst = new boolean[vertex];
        int[] parent = new int[vertex];

        Arrays.fill(key, INT_MAX);
        Arrays.fill(mst, false);
        Arrays.fill(parent, -1);

        key[0] = 0;
        parent[0] = -1;

        PriorityQueue<PairInt> prQueue = new PriorityQueue<>(vertex, Comparator.comparingInt(o -> o.dist));
        // for(int i = 0; i < vertex; i++){
        //     prQueue.add(new PairInt(i, INT_MAX));
        // }

        prQueue.add(new PairInt(0, 0));
        

        while(!prQueue.isEmpty()){
            PairInt min = prQueue.poll();

            if(mst[min.node]){
                continue;
            }

            mst[min.node] = true;

            if(graph.weightedAdj.containsKey(min.node)){
                for (WeightedPair<Integer> neighbour : graph.weightedAdj.get(min.node)) {
                    if(neighbour.weight < key[neighbour.node]){
                        key[neighbour.node] = neighbour.weight;
                        prQueue.add(new PairInt(neighbour.node, key[neighbour.node]));
                        parent[neighbour.node] = min.node;
                    }
                }
            }
        }
        int sum = IntStream.of(key).sum(); //Finding sum of all edges
        return sum;
    }

    public static void main(String[] args) {
        int vertex = 5; // total no of nodes
        Graph<Integer> graph = new Graph<>();
        graph.addWeightedEdge(0, 1, 2, false);
        graph.addWeightedEdge(1, 2, 3, false);
        graph.addWeightedEdge(0, 3, 6, false);
        graph.addWeightedEdge(1, 4, 5, false);
        graph.addWeightedEdge(3, 1, 8, false);
        graph.addWeightedEdge(4, 2, 7, false);
        // o/p => key = [0, 2, 3, 6, 5];
        //        parent = [-1, 0, 1, 0, 1];
        graph.printWeightedAdjList();

        System.out.println("sum of edges = "+ findMSPUsingPrims(graph, vertex));
    }
}
