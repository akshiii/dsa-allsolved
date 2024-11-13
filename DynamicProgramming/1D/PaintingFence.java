package DynamicProgramming;

import java.util.Arrays;

public class PaintingFence {
    static final int MOD = 1000000007;

    static long recursiveSol(int n,int k){
        if(n == 1) return k;
        if(n == 2) return k*k;

        long ans = recursiveSol(n-2, k) * (k-1) + recursiveSol(n-1, k) * (k-1);
        return ans;
    }

    static long memoizedSol(int n,int k, long[] dp){
        if(n == 1) return k;
        if(n == 2) return k*k;

        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = memoizedSol(n-2, k, dp) * (k-1) + memoizedSol(n-1, k, dp) * (k-1);
        return dp[n];
    }

    static long tabulationSol(int n,int k){
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        dp[1] = k;
        dp[2] = k*k;

        for(int i = 3; i <=n ; i++){
            long same = dp[i-2] * (k-1);
            long diff = dp[i-1] * (k-1);

            long ans = same + diff;
            dp[i] = ans;
        }

        return dp[n];
    }

    static long spaceOptiSol(int n,int k){

        long prev2= k;
        long prev1 = k*k;

        for(int i = 3; i <=n ; i++){
            long same = prev2 * (k-1);
            long diff = prev1 * (k-1);

            long ans = same + diff;
            prev2 = prev1;
            prev1 = ans;
        }
        
        return prev1;
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 4; // n = 4  ans = 66
        System.out.println("Total ways to paint = "+ recursiveSol(n,k));

        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        System.out.println("Total ways to paint = "+ memoizedSol(n,k, dp));

        System.out.println("Total ways to paint = "+ tabulationSol(n,k));

        System.out.println("Total ways to paint = "+ spaceOptiSol(n,k));
    }
}
