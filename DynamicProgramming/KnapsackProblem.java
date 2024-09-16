package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class KnapsackProblem {
    static int recursiveSol(int index,  int[] weight, int[] value, int capacity){
        if(index == 0){
            if(weight[0] <= capacity){
                return value[0];
            }
            else return 0;
        }

        int include = 0;
        if(weight[index] <= capacity){
            include = value[index] + recursiveSol(index-1, weight, value, capacity - weight[index]);
        }

        int exclude = 0 + recursiveSol(index-1, weight, value, capacity);
        int ans = Math.max(include, exclude);
        return ans;
    }

    static int memoizedSol(int index,  int[] weight, int[] value, int capacity, int[][] dp){
        if(index == 0){
            if(weight[0] <= capacity){
                return value[0];
            }
            else return 0;
        }

        if(dp[index][capacity] != -1){
            return dp[index][capacity];
        }

        int include = 0;
        if(weight[index] <= capacity){
            include = value[index] + memoizedSol(index-1, weight, value, capacity - weight[index], dp);
        }

        int exclude = 0 + memoizedSol(index-1, weight, value, capacity, dp);
        dp[index][capacity] = Math.max(include, exclude);
        return dp[index][capacity];
    }

    static int tabulationSol(int index,  int[] weight, int[] value, int capacity){

        int[][] dp = new int[index][capacity+1]; // all values are initilized with 0 already
        
        for(int w = weight[0]; w <= capacity; w++ ){
            if(weight[0] <= capacity){
                dp[0][w] = value[0];
            }
        }

        for(int i = 1; i < index; i++ ){
            for(int w = 0; w <= capacity; w++ ){
                int include = 0;
                if(weight[i] <= w){
                    include = value[i] + dp[i-1][w - weight[i]];
                }

                int exclude = 0 + dp[i-1][w];
                dp[i][w] = Math.max(include, exclude);
            }
        }

        return dp[index-1][capacity];
    }
    
    static int spaceOptimizedSol(int index,  int[] weight, int[] value, int capacity){

        int[] prev = new int[capacity+1];
        int[] curr = new int[capacity+1];

        for(int w = weight[0]; w <= capacity; w++ ){
            if(weight[0] <= capacity){
                prev[w] = value[0];
            }
        }

        for(int i = 1; i < index; i++ ){
            for(int w = 0; w <= capacity; w++ ){
                int include = 0;
                if(weight[i] <= w){
                    include = value[i] + prev[w - weight[i]];
                }

                int exclude = 0 + prev[w];
                curr[w] = Math.max(include, exclude);
            }
            prev = curr;
        }

        return prev[capacity];
    }
   
    public static void main(String[] args) {
        int n = 4; // items
        // int[] w = {1,2,4,5};
        // int[] v = {5,4,8,6};
        int capacity = 5;//max-weight

        n = 10;
        int[] v = {5 ,10, 7, 5, 1, 1, 5, 4 ,5, 8};
        int[] w = {4 ,4 ,1 ,1, 2, 6 ,4 ,4 ,4, 6};
        capacity = 6;
        System.out.println("Max value of knapsack = "+ recursiveSol(n-1,w,v,capacity));

        int[][] dp = new int[n][capacity+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < capacity+1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Max value of knapsack = "+ memoizedSol(n-1,w,v,capacity, dp));

        System.out.println("Max value of knapsack = "+ tabulationSol(n,w,v,capacity));

        System.out.println("Max value of knapsack = "+ spaceOptimizedSol(n,w,v,capacity));


    }

}
