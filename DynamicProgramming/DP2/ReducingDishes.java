// Leetcode:  https://leetcode.com/problems/reducing-dishes/
package DynamicProgramming.DP2;
import java.util.Arrays;

public class ReducingDishes {

    static int getMaxTime(int[] satisfaction, int index, int time){
        if(index == satisfaction.length){
            return 0;
        }
 
        int incude = satisfaction[index] * (time + 1) + getMaxTime(satisfaction, index+1, time+1);
        int exclude = getMaxTime(satisfaction, index+1, time);
 
        int ans = Math.max(incude, exclude);
        return ans;
    }
 
    static int getMaxTimeMem(int[] satisfaction, int index, int time, int dp[][]){
        if(index == satisfaction.length){
            return 0;
        }
 
        if(dp[index][time] != Integer.MIN_VALUE){
            return dp[index][time];
        }
 
        int incude = satisfaction[index] * (time + 1) + getMaxTimeMem(satisfaction, index+1, time+1,dp);
        int exclude = getMaxTimeMem(satisfaction, index+1, time,dp);
 
        dp[index][time] = Math.max(incude, exclude);
        return dp[index][time];
    }
 
    // TC= O(n2)
    static int tabulationSol(int[] satisfaction){
        
        int[][] dp = new int[satisfaction.length+1][satisfaction.length+1];

        for(int index = satisfaction.length - 1; index >= 0; index--){
            for(int time = index; time >= 0; time--){// time always starts from value of index
                int incude = satisfaction[index] * (time + 1) + dp[index+1][time+1];
                int exclude = dp[index+1][time];
        
                dp[index][time] = Math.max(incude, exclude);
            }
            
        }
        return dp[0][0];
    }

    //TODO: Unsolved
    static int spaceOptimizedSol(int[] satisfaction){

        int n = satisfaction.length;
        int[] curr = new int[n+1];
        int[] next = new int[n+1];

        for(int index = n - 1; index >= 0; index--){
            for(int time = index; time >= 0; time--){

                int include = satisfaction[index] * (time + 1) + next[time+1];
                int exclude = next[time];
        
                curr[time] = Math.max(include, exclude);
            }
            next = curr; // because we are going down to up
        }
        return next[0];
    }

    //Another special approach TC= O(n) -> for worst case, best case -> O(1)
    static int maxSatisfaction(int[] satisfaction) {  
        Arrays.sort(satisfaction);
        int prefixSum = 0;      
        int cur = 0;        
        
        for (int i = satisfaction.length - 1; i >= 0; i--) {    
            prefixSum += satisfaction[i];
            
            if(prefixSum<0){
                break;
            }

            cur += prefixSum;           
        }       

        return cur;                    
    }

    public static void main(String[] args) {
        // int[] satisfaction = {-1,-4,-5};
        // int[] satisfaction = {4,3,2};
        int[] satisfaction = {-1, -8, 0, 5 , -9};
 
        //Step1: Sort the array
        Arrays.sort(satisfaction);
 
        // Recursive Approach
        System.out.println("Max time = "+ getMaxTime(satisfaction, 0,0));
 
        //Memoized Approach
        int[][] dp = new int[satisfaction.length][satisfaction.length];
        for(int i = 0; i < satisfaction.length; i++){
            for(int j = 0; j < satisfaction.length; j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        System.out.println("Max time = "+ getMaxTimeMem(satisfaction, 0,0, dp));
        
        System.out.println("Max time = "+ tabulationSol(satisfaction));

        System.out.println("Max time = "+ maxSatisfaction(satisfaction));
    }
}
