package DynamicProgramming.DP2;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {

    static int recursiveSol(int[] seq, int curr, int prev) {
        if(curr == seq.length){
            return 0;
        }

        int include = 0;
        if(prev == -1 || seq[curr] > seq[prev]){
            include = 1 + recursiveSol(seq, curr+1, curr);
        }

        int exclude = 0 + recursiveSol(seq, curr+1, prev);

        return Math.max(include, exclude);
    }

    static int memoizedSol(int[] seq, int curr, int prev, int[][] dp) {
        if(curr == seq.length){
            return 0;
        }

        if(dp[curr][prev+1] != -1){
            return dp[curr][prev+1];
        }

        int include = 0;
        if(prev == -1 || seq[curr] > seq[prev]){
            include = 1 + memoizedSol(seq, curr+1, curr,dp);
        }

        int exclude = 0 + memoizedSol(seq, curr+1, prev,dp);

        dp[curr][prev+1]  =  Math.max(include, exclude);
        return dp[curr][prev+1];
    }
    
    // TC = O(n2) SC= O(n2)
    static int tabulationSol(int[] seq){

        int n = seq.length;
        int[][] dp = new int[n+1][n+1];

        //ulta flow from previous answer-(memoizedSol)
        for(int curr = n-1; curr >= 0; curr--){
            for(int prev = curr-1; prev >= -1 ; prev--){// previous always starts from curr -1
                int include = 0;
                if(prev == -1 || seq[curr] > seq[prev]){
                    include = 1 + dp[curr+1][curr+1];
                }

                int exclude = 0 + dp[curr+1][prev+1];

                dp[curr][prev+1] = Math.max(include, exclude);
            }
        }
        return dp[0][0];
    }

    static int spaceOptimizedSol(int[] seq){

        int n = seq.length;
        int[] current = new int[n+1];
        int[] next = new int[n+1];

        //ulta flow from previous answer-(memoizedSol)
        for(int curr = n-1; curr >= 0; curr--){
            for(int prev = curr-1; prev >= -1 ; prev--){// previous always starts from curr -1
                int include = 0;
                if(prev == -1 || seq[curr] > seq[prev]){
                    include = 1 + next[curr+1];
                }

                int exclude = 0 + next[prev+1];

                current[prev+1] = Math.max(include, exclude);
            }
            next = current;
        }
        return next[0];
    }
    public static void main(String[] args) {
        // int[] seq = {10,9,2,5,3,7,101,18};
        // int[] seq = {0,1,0,3,2,3};
        int[] seq = {7,7,7,7,7,7,7};
        System.out.println(recursiveSol(seq, 0, -1));

        int[][] dp = new int[seq.length][seq.length+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp.length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(memoizedSol(seq, 0, -1, dp));

        System.out.println(tabulationSol(seq));
        
        System.out.println(spaceOptimizedSol(seq));
    }
    
}
