package DynamicProgramming;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/dearrangement-of-balls0918/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
public class CountDerangements {
    static final int MOD = 1000000007;
    static long recursiveSol(int n){

        if(n == 1) return 0;
        if(n == 2) return 1;

        long ans = ((n-1) * (recursiveSol(n-2)%MOD + recursiveSol(n-1)%MOD) %MOD)%MOD;

        return ans;
    }

    static long memoizedSol(int n, long[] dp){

        if(n == 1) return 0;
        if(n == 2) return 1;

        if(dp[n]!= -1){
            return dp[n];
        }

        dp[n] = ((n-1) * (recursiveSol(n-2)%MOD + recursiveSol(n-1)%MOD) %MOD)%MOD;

        return dp[n];
    }

    static long tabulationSol(int n){

        long[] dp = new long[n+1];
        Arrays.fill(dp, 0);
        dp[1] = 0;
        dp[2] = 1;

        for(int i = 3; i <= n; i++){
           long first = dp[i-1] %MOD;
           long second = dp[i-2] %MOD;
           long sum = (first + second )%MOD;

           long ans = ((i-1)*sum)%MOD;
           dp[i] = ans;
        }

        return dp[n];
    }

    static long spaceOptSol(int n){

        long prev2 = 0;
        long prev1 = 1;

        for(int i = 3; i <= n; i++){
           long first = prev1 %MOD;
           long second = prev2 %MOD;
           long sum = (first + second )%MOD;

           long ans = ((i-1)*sum)%MOD;
           prev2 = prev1;
           prev1 = ans;
        }

        return prev1;
    }
    public static void main(String[] args) {
        int n = 7;
        System.out.println("Total derangements = "+ recursiveSol(n));

        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        System.out.println("Total derangements = "+ memoizedSol(n, dp));

        System.out.println("Total derangements = "+ tabulationSol(n));

        System.out.println("Total derangements = "+ spaceOptSol(n));
        
    }
}
