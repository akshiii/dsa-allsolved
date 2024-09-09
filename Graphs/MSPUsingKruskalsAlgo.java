package Graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

class KruskalTrio{
    int weight;
    int u;
    int v;

    KruskalTrio(int weight, int u, int v){
        this.weight = weight;
        this.u = u;
        this.v = v;
    }
}

public class MSPUsingKruskalsAlgo {

    static void makeSet(int[] parent,int[] rank,int vertex){
        //Step 1: Initially every node is its own parent  and every node's rank = 0
        for(int i = 0; i< vertex; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    /**
     * Path Compression
     */
    static int findParent(int[] parent, int node){
        if(parent[node] == node){
            return node;
        }

        return parent[node] = findParent(parent, parent[node]);
    }

    /**
     * Union set of 2 nodes
     */
    static void unionSet(int u, int v , int[] parent, int[] rank){
        u = findParent(parent, u);
        v = findParent(parent, v);

        if(rank[u] < rank[v]){
            parent[u] = v;
        }
        else if(rank[v] < rank[u]){
            parent[v] = u;
        }
        else{
            parent[v] = u; //for this equal case anyone can be a parent of any node, just make sure to update rank
            rank[u]++;
        }
    }

    static int findMspUsingKruskal(int[] rank, int[] parent, PriorityQueue<KruskalTrio> prQueue){
        int total = 0;
        while(!prQueue.isEmpty()){
            KruskalTrio pair = prQueue.poll();
            int u = findParent(parent, pair.u);
            int v = findParent(parent, pair.v);

            if(u != v){
                total += pair.weight;
                unionSet(u, v, parent, rank);
            }

        }
        return total;
    }
    

    public static void main(String[] args) {
        
        int vertex = 6;
        int edges = 9;
        int[] parent = new int[vertex];
        int[] rank = new int[vertex];

        makeSet(parent,rank,vertex);


        PriorityQueue<KruskalTrio> prQueue = new PriorityQueue<>(edges, Comparator.comparingInt(o -> o.weight));
        prQueue.add(new KruskalTrio(1,1,4));
        prQueue.add(new KruskalTrio(2,1,2));
        prQueue.add(new KruskalTrio(3,2,3));
        prQueue.add(new KruskalTrio(3,2,4));
        prQueue.add(new KruskalTrio(4,1,5));
        prQueue.add(new KruskalTrio(5,3,4));
        prQueue.add(new KruskalTrio(7,2,0));
        prQueue.add(new KruskalTrio(8,3,0));
        prQueue.add(new KruskalTrio(9,4,5));

        System.out.println("totals sum of msp edges = "+findMspUsingKruskal(rank, parent, prQueue));
        


    }
}
