package Graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//TopologicalSort using dfs
public class TopologicalSort {
    static void topologicalSort(Map<Integer, Boolean> visited, int node, Graph<Integer> graph , Stack<Integer> stack){
        visited.put(node, true);

        if(graph.adj.containsKey(node)){
            for (int neighbour : graph.adj.get(node)) {
                if(visited.get(neighbour) == false){
                    topologicalSort(visited, neighbour, graph, stack);
                }
            }
        }
        stack.push(node);
        
    }
    public static void main(String[] args) {
        int vertex = 6; // no of nodes
        int startingNode = 1; // starting node
        Map<Integer , Boolean> visited = new HashMap<>();
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(1, 2, true);
        graph.addEdge(1, 3, true);
        graph.addEdge(2, 4, true);
        graph.addEdge(3, 4, true);
        graph.addEdge(4, 6, true);
        graph.addEdge(4, 5, true);
        graph.addEdge(5, 6, true);
        graph.printAdjList();

        for(int i = 0; i < vertex; i++){
            visited.put(i+startingNode, false);
        }

        System.out.print("Topological sort => ");
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < vertex; i++){
            if(visited.get(i+startingNode) == false){
                topologicalSort(visited, startingNode, graph, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
