package DynamicProgramming.DP1;

import java.util.Arrays;

public class CutIntoSegments {
    static int INT_MIN = -2147483648;

    static int recursiveSol(int n, int x, int y,int z){
        if(n == 0) return 0;
        if(n < 0) return INT_MIN;

        int a = recursiveSol(n-x, x,y,z) + 1;
        int b = recursiveSol(n-y, x,y,z) + 1;
        int c = recursiveSol(n-z, x,y,z) + 1;

        int ans = Math.max(a, Math.max(b, c));
        return ans;
    }

    static int memoizedSol(int n, int x, int y,int z, int[] dp){
        if(n == 0) return 0;
        if(n < 0) return INT_MIN;

        if(dp[n] != -1){
            return dp[n];
        }

        int a = memoizedSol(n-x, x,y,z, dp) + 1;
        int b = memoizedSol(n-y, x,y,z, dp) + 1;
        int c = memoizedSol(n-z, x,y,z, dp) + 1;

        dp[n] = Math.max(a, Math.max(b, c));
        return dp[n];
    }

    static int tabulationSol(int n, int x, int y,int z){
        int[] dp = new int[n+1];
        Arrays.fill(dp, INT_MIN);
        dp[0] = 0;

        for(int i = 1; i <= n; i++){
            if(i-x >= 0){
                dp[i] = Math.max(dp[i], dp[i-x] + 1);
            }
            if(i-y >= 0){
                dp[i] = Math.max(dp[i], dp[i-y] + 1);
            }
            if(i-z >= 0){
                dp[i] = Math.max(dp[i], dp[i-z] + 1);
            }
        }

        if(dp[n] < 0){
            return 0;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 17;
        int x = 5;
        int y = 2;
        int z = 2;
        int ans = recursiveSol(n,x,y,z);
        if(ans < 0){
            System.out.println("Max no of segments = "+0);
        }
        else 
            System.out.println("Max no of segments = "+ans);  

        /*memoized sol */
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        ans = memoizedSol(n,x,y,z, dp);
        if(ans < 0){
            System.out.println("Max no of segments = "+0);
        }
        else 
            System.out.println("Max no of segments = "+ans);

        /*Tabulation sol */
        ans = tabulationSol(n,x,y,z);
        System.out.println("Max no of segments = "+ans);

        //No other space optimization possible here

    }
}
