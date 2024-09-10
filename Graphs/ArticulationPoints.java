package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class ArticulationPoints {

    static void findArticulationPoints(int vertex, Graph<Integer> graph){
        int[] disc = new int[vertex];
        int[] low = new int[vertex];
        int parent = -1;
        boolean[] visited = new boolean[vertex];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        // Arrays.fill(parent, -1);
        Arrays.fill(visited, false);

        int timer = 0;
        //dfs
        for(int i = 0; i < vertex; i++){
            if(!visited[i]){
                dfs(i, parent, timer, disc, low, visited, graph);
            }
        }
    }

    static void dfs(int node, int parent, int timer, int[] disc, int[] low, boolean[] visited, Graph<Integer> graph){
        // System.out.print(node+" ");
        visited[node] = true;
        disc[node] = low[node] = timer++;
        

        //Har connected node ke lie recursive call
        ArrayList<Integer> list = graph.adj.get(node);
        for (int neighbour : list) {
            if(neighbour == parent){
                continue; 
            }
            if(!visited[neighbour]){
                dfs(neighbour, node, timer, disc, low, visited, graph);
                //while returning
                low[node]= Math.min(low[node], low[neighbour]);

                //check edge is bridge or not
                if(low[neighbour] >= disc[node] && parent!=-1){
                    System.out.print(" Bridge found at "+ node);
                }
            }
            else{
                //Back edge
                low[node] = Math.min(low[node], disc[neighbour]);
            }
        }
        if(parent == -1 && graph.adj.get(node).size() > 1){
            System.out.print(" Bridge found at "+ node);
        }
    }

    public static void main(String[] args) {
        int vertex = 5; // total no of nodes
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(0, 1, false);
        graph.addEdge(0, 3, false);
        graph.addEdge(0, 4, false);
        graph.addEdge(1, 2, false);
        graph.addEdge(3, 4, false);
        findArticulationPoints(vertex,graph);// 0,1

    }
}

