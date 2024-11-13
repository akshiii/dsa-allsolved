package DynamicProgramming.DP1;

import java.util.Arrays;

public class MaxSumOfNonAdjacentElements {
    static int recursiveSol(int[] nums, int n){
        //base case 
        if( n < 0) return 0;
        if( n == 0) return nums[0];

        int incl = recursiveSol(nums, n-2) + nums[n];
        int excl = recursiveSol(nums, n-1) + 0;

        return Math.max(incl, excl);
    }

    static int memoizedSol(int[] nums, int n, int[] dp){
        //base case 
        if( n < 0) return 0;
        if( n == 0) return nums[0];

        if(dp[n] != -1){
            return dp[n];
        }

        int incl = memoizedSol(nums, n-2, dp) + nums[n];
        int excl = memoizedSol(nums, n-1, dp) + 0;

        dp[n] = Math.max(incl, excl);
        return dp[n];
    }

    static int tabulationSol(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);

        for(int i = 2 ; i < n ; i++){
            int incl = dp[i-2] + nums[i];
            int excl = dp[i-1];
            dp[i] = Math.max(incl, excl);
        }

        return dp[n-1]; // return last index
    }

    static int spaceOptimizedSol(int[] nums){
        int n = nums.length;
        
        int prev1 = nums[0];
        int prev2 = Math.max(nums[1],nums[0]);

        for(int i = 2 ; i < n ; i++){
            int incl = prev2 + nums[i];
            int excl = prev1;
            int ans = Math.max(incl, excl);
            prev2 = prev1;
            prev1 = ans;
        }

        return prev1; 
    }


    public static void main(String[] args) {
        /*Recursion solution */
        int[] nums = {9,9,8,2}; // 17
        int n = nums.length;
        System.err.println("Max sum = "+ recursiveSol(nums, n-1));

        /*Rec+ Memoization solution */
        int[] nums1 = {9,9,8,2}; // 17
        n = nums1.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.err.println("Max sum = "+ memoizedSol(nums1, n-1, dp));


        /*TAbulation solution */
        int[] nums2 = {9,9,8,2}; // 17
        System.err.println("Max sum = "+ tabulationSol(nums2));

        /*Now space optimization */
        System.err.println("Max sum = "+ spaceOptimizedSol(nums));
    }
}
