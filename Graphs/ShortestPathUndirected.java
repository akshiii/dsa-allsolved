package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

//Finding shortest path in undirected graph( Using BFS )
public class ShortestPathUndirected {
    
    static void findShortestPath(int vertex, Map<Integer, Boolean> visited, Graph<Integer> graph, int src , int dest){
        Map<Integer , Integer> parent = new HashMap<>();
        Queue<Integer> queue = new LinkedList();
        queue.add(src);
        visited.put(src, true);
        parent.put(src, -1);

        while(!queue.isEmpty()){
            int frontNode = queue.remove();

            for(int neighbour : graph.adj.get(frontNode)){
                if(visited.get(neighbour) == false){
                    visited.put(neighbour, true);
                    parent.put(neighbour, frontNode);
                    queue.add(neighbour);
                }
            }
        }

        
        Stack<Integer> stack = new Stack<>();
        stack.push(dest);
        while(dest != src){
            int pa = parent.get(dest);
            dest = pa;
            stack.push(dest);
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+ " ");
        }

    }

    public static void main(String[] args) {
        int vertex = 8; // no of nodes
        int startingNode = 1; // starting node
        int src = 1; // source node
        int dest = 8; //destination node
        Map<Integer , Boolean> visited = new HashMap<>();
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(1, 2, false);
        graph.addEdge(1, 3, false);
        graph.addEdge(1, 4, false);
        graph.addEdge(2, 5, false);
        graph.addEdge(3, 8, false);
        graph.addEdge(4, 6, false);
        graph.addEdge(6, 7, false);
        graph.addEdge(5, 8, false);
        graph.addEdge(7, 8, false);
        graph.printAdjList();

        for(int i = 0; i < vertex; i++){
            visited.put(i+startingNode, false);
        }

        System.out.print("Shortest path => "); // 1 3 8
        findShortestPath(vertex, visited, graph, src, dest);
    }
}
