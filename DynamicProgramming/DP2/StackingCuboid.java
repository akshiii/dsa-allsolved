package DynamicProgramming.DP2;

import java.util.Arrays;

// TODO: Not passing all testcases in leetcode
// https://leetcode.com/problems/maximum-height-by-stacking-cuboids/
public class StackingCuboid {
    static int maxHeight(int[][] cuboids){
        //Step1 : sort all dimensions for every cubiod
        for(int i = 0; i < cuboids.length; i++){
            Arrays.sort(cuboids[i]);
        }

        //Step 2: Sort cubiods basis on width or length
        Arrays.sort(cuboids, (a,b) -> Integer.compare(a[0], b[0]));

        //Step 3: Use LIS logic 
        int[] seq = new int[cuboids.length];
        for(int i = 0; i < cuboids.length; i++){
            seq[i] = cuboids[i][2];
        }
        return tabulationSol(cuboids);
    }

    static int tabulationSol(int[][] seq){
        int n = seq.length;
        int[][] dp = new int[n+1][n+1];

        for(int curr = n-1; curr >= 0; curr--){
            for(int prev = curr-1; prev >= -1 ; prev--){// previous always starts from curr -1
                int include = 0;
                if(prev == -1 || check(seq[curr] , seq[prev])){
                    include = seq[curr][2] + dp[curr+1][curr+1];
                }

                int exclude = 0 + dp[curr+1][prev+1];

                dp[curr][prev+1] = Math.max(include, exclude);
            }
        }
        return dp[0][0];
    }

    static boolean check(int[] base, int[] newBox){
        if(newBox[0] <= base[0] && newBox[1] <= base[1] && newBox[2] <= base[2]){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        // int[][] cuboids = {{50,45,20},{95,37,53},{45,23,12}}; // ans - 190
        // int[][] cuboids = {{38,25,45},{76,35,3}};
        // int[][] cuboids = {{7,11,17},{7,17,11},{11,7,17},{11,17,7},{17,7,11},{17,11,7}};
        int[][] cuboids = {{92,47,83},{75,20,87},{68,12,83},{12,85,15},{16,24,47},{69,65,35},{96,56,93},{89,93,11},{86,20,41},{69,77,12},{83,80,97},{90,22,36}};


        System.out.println("Max height : "+ maxHeight(cuboids));
    }
}
