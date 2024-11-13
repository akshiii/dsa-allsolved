package DynamicProgramming.DP1;

import java.util.Arrays;

public class MinCostClimbingStairs {

    //Recursion
    static int solve(int[] cost, int n){
        //base case
        if(n == 0){
            return cost[0];
        }
        if(n == 1){
            return cost[1];
        }

        int ans = cost[n] + Math.min(solve(cost,n-1), solve(cost, n-2));
        return ans;
    }

    //Recursion + Memoization
    static int solve2(int[] cost, int n, int[] dp){
        //base case
        if(n == 0){
            return cost[0];
        }
        if(n == 1){
            return cost[1];
        }

        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = cost[n] + Math.min(solve2(cost,n-1,dp), solve2(cost, n-2,dp));
        return dp[n];
    }

    //Approach 3: Tabulation
    static int solve3(int[] cost, int n){
        int[] dp = new int[n+1];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < n ; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[n-1], dp[n-2]);
    }

    //Approach 4: Space optimization
    static int solve4(int[] cost, int n){
        int prev2 = cost[0];
        int prev1 = cost[1];

        for(int i = 2; i < n ; i++){
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return Math.min(prev1, prev2);
    }

    public static void main(String[] args) {
        int[] cost = {10,15,20};//ans = 15
        int n = cost.length;

        int ans = Math.min(solve(cost,n-1), solve(cost, n-2));
        System.out.println("Min cost Approach 1 = "+ ans);

        //Approach 2: Recursion + Memoization
        int[] cost1 = {2,6,5,1};//ans = 7
        n = cost1.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int ans1 = Math.min(solve2(cost1,n-1, dp), solve2(cost1, n-2, dp));
        System.out.println("Min cost Approach 2 =  "+ ans1);


        //Approach 3: Tabulation
        int[] cost3 = {4,2,4,1,1,5};
        n = cost3.length;
        System.out.println("Min cost Approach 3 =  "+solve3(cost3, n));

        //Approach 4: Now reducing space complexicity
        int[] cost4 = {4,2,4,1,1,5};
        n = cost4.length;
        System.out.println("Min cost Approach 4 =  "+solve4(cost4, n));
    }
}
