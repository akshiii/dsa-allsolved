package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
//Unsolved - Similar to rat in a maze problem
//Leetcode = https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
class Pair{
    int row; 
    int column;

    public Pair(int row, int column){
        this.row = row;
        this.column = column;
    }
}
public class ShortestPathInBinaryMatrix {
    static int shortestPathBinaryMatrix(int[][] grid) {
        Map<Pair, Boolean> visited = new HashMap<>();
        Queue<Pair> queue = new LinkedList();
        Map<Pair, Pair> parent = new HashMap<>();

        for(int i = 0; i < grid.length; i++){
            visited.put(new Pair(grid[i][0], grid[i][1]), false);
        }

        int startingRow = grid[0][0];
        int startingCol = grid[0][1];
        Pair src = new Pair(startingRow, startingCol);
        
        queue.add(src);
        visited.put(src, true);
        parent.put(src, new Pair(-1, -1));

        while(!queue.isEmpty()){
            Pair frontNode = queue.remove();

            //calculate for 8 neighbours 
            //if neigbour is not visited && neighbour is not parent

        }


        return 1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1}, {1,0}}; // 2
        System.out.println("Shortest path = "+ shortestPathBinaryMatrix(grid));
    }
}
