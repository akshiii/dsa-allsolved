package DynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change/description/
// Return the fewest number of coins that you need to make up that amount. 
public class MinimumCoins {
    static int INT_MAX = 2147483647;

    static int minimumCoinsRec(int target, int[] coins){
        if(target == 0){
            return 0;
        }
        if(target < 0){
            return INT_MAX;
        }
        int mini = INT_MAX;

        for(int i = 0; i < coins.length; i++){
            int ans = minimumCoinsRec(target - coins[i], coins);
            if(ans != INT_MAX){
                mini = Math.min(mini, 1 + ans);
            }
        }

        return mini;
    }

    static int minimumCoinsMem(int target, int[] coins, int[] dp){
        if(target == 0){
            return 0;
        }
        if(target < 0){
            return INT_MAX;
        }

        if(dp[target] != -1){
            return dp[target];
        }

        int mini = INT_MAX;
        for(int i = 0; i < coins.length; i++){
            int ans = minimumCoinsMem(target - coins[i], coins, dp);
            if(ans != INT_MAX){
                mini = Math.min(mini, 1 + ans);
            }
        }
        dp[target] = mini;

        return mini;
    }

    static int minimumCoinsTabu(int target, int[] coins){
        int[] dp = new int[target+1];
        Arrays.fill(dp, INT_MAX);
        dp[0] = 0;

        for(int i = 1; i <= target; i++){
            for(int j = 0; j< coins.length; j++){
                if(i - coins[j] >= 0 && dp[i - coins[j]] != INT_MAX){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        if(dp[target] == INT_MAX){
            return -1;
        }
        return dp[target];
    }
    /*Recursive solution */
    static int getMinCoins(int target, int[] coins){
        
        int ans = minimumCoinsRec(target,coins);
        if(ans == INT_MAX){
            return -1;
        }
        return ans;
    }

    /*Memoized sol */
    static int memoizedSol(int target, int[] coins){
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        int ans = minimumCoinsMem(target,coins, dp);
        if(ans == INT_MAX){
            return -1;
        }
        return ans;
    }

    /*Tabulation sol */
    static int tabulationSol(int target, int[] coins){
        return minimumCoinsTabu(target,coins);
    }
    public static void main(String[] args) {
        int[] coins = {1,2,5}; 
        int amount = 11; // ans - 3
        System.out.println("Min coins : "+getMinCoins(amount, coins));

        int[] coins1 = {2}; 
        int amount1 = 3; //ans - -1
        System.out.println("Min coins : "+getMinCoins(amount1, coins1));


        int[] coins2 = {1}; 
        int amount2 = 0; // ans - 0
        System.out.println("Min coins : "+getMinCoins(amount2, coins2));

        int[] coins3 = {186,419,83,408};
        int amount3 = 6249; // ans - 20
        System.out.println("Min coins : "+memoizedSol(amount3, coins3));

        int[] coins4 = {186,419,83,408};
        int amount4 = 6249; // ans - 20
        System.out.println("Min coins : "+tabulationSol(amount4, coins4));


    }
}
