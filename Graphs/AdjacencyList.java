package Graphs;

public class AdjacencyList {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1, false);
        graph.addEdge(1, 2, false);
        graph.addEdge(2, 0, false);

        graph.printAdjList();
    }
}
