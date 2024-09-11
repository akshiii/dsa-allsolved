package Graphs;

import java.util.Arrays;
import java.util.Stack;

public class KosarajusAlgorithm {
    static void topologicalSort(int node, boolean[] visited, Stack<Integer> stack,Graph<Integer> graph ){
        visited[node] = true;

        if(graph.adj.containsKey(node)){
            for (int neighbour : graph.adj.get(node)) {
                if(visited[neighbour] == false){
                    topologicalSort(neighbour, visited, stack, graph);
                }
            }
        }
        stack.push(node);
    }

    static void reverseDfs(int node, boolean[] visited, Graph<Integer> transposeGraph){
        visited[node] = true;

        if(transposeGraph.adj.containsKey(node)){
            for (int neighbour : transposeGraph.adj.get(node)) {
                if(visited[neighbour] == false){
                    reverseDfs(neighbour, visited, transposeGraph);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertex = 5;
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(2, 0, true);
        graph.addEdge(0, 1, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(1, 3, true);
        graph.addEdge(3, 4, true);//3

        
        //Step 1
        boolean[] visited = new boolean[vertex];
        Arrays.fill(visited, false);

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < vertex; i++){
            if(visited[i] == false){
                topologicalSort(i, visited, stack, graph);
            }
        }

        //Step 2
        Graph<Integer> transposeGraph = new Graph<>();
        for(int i = 0; i < vertex; i++){
            visited[i] = false; // changing it back to false to reuse in step 3 logic
            if(graph.adj.containsKey(i)){
                for (int neighbour : graph.adj.get(i)) {
                    transposeGraph.addEdge(neighbour, i, true);
                }
            }
        }
        transposeGraph.printAdjList();


        //Step 3:
        int count = 0;
        while(!stack.isEmpty()){
            int top = stack.pop();

            if(!visited[top]){
                count++;
                reverseDfs(top,visited,transposeGraph);
            }
        }

        System.out.println("count = "+count); //3
    }
}
