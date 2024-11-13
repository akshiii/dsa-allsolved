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
    }
}
