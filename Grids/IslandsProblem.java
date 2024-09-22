package Grids;

// https://leetcode.com/problems/number-of-islands/solutions/1820827/number-of-islands/
//Return no of total islands, we can go only 4 ways top, left , right and down
public class IslandsProblem {

    static int findTotalIslands(int[][] island){
        int count = 0;

        for(int i = 0; i < island.length; i++){
            for(int j = 0; j < island[0].length; j++){
                if(island[i][j] == 1){
                    markEntireIsland(island, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    static void markEntireIsland(int[][] island, int i , int j){
        island[i][j] = 2;
        if(j+1 <= island[0].length - 1 && island[i][j+1] == 1){
            markEntireIsland(island, i, j+1);
        }
        if(j-1 >= 0 && island[i][j-1] == 1){
            markEntireIsland(island, i, j-1);
        }
        if(i+1 <= island.length - 1 && island[i+1][j] == 1){
            markEntireIsland(island, i+1, j);
        }
        if( i-1 >= 0 && island[i-1][j] == 1){
            markEntireIsland(island, i-1, j);
        }
    }

    public static void main(String[] args) {
        int[][] island = {
            {1 , 1 , 0 , 0 , 0},
            {1 , 1 , 0 , 0 , 0},
            {0 , 0 , 1 , 0 , 0},
            {0 , 0 , 0 , 1 , 1}
        }; // 3

        System.out.println("Total islands = "+ findTotalIslands(island));
    }
}
