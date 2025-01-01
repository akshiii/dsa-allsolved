package DynamicProgramming.DP2;

import java.util.ArrayList;

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

    //DP with Binary search TC- O(nlogn) SC- O(1)
    static int binarySearchSol(int[] seq, int n){
        if(n == 0){
            return 0;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(seq[0]);

        for(int i = 1; i < seq.length; i++){
            if(seq[i] > arrayList.get(arrayList.size() - 1)){
                arrayList.add(seq[i]);
            }
            else{
                int upperBound = upperBound(arrayList, seq[i]);
                arrayList.set(upperBound, seq[i]);
            }
        }

        return arrayList.size();
    }

    //upper bound is first element in a sorted range that is strictly greater than a given value.
    static int upperBound(ArrayList<Integer> seq, int k){
        int start = 0, end = seq.size() - 1;
        int mid;
        
        while(start < end){
            mid = (int)Math.floor((start+end)/2);
            if(seq.get(mid) <= k){
                start = mid+1;
                if(seq.get(mid) == k){
                    start = mid;
                    break;
                }
            }
            else{
                end = mid;
            }
        }

        return start;
    }
    public static void main(String[] args) {
        // int[] seq = {10,9,2,5,3,7,101,18};
        // int[] seq = {0,1,0,3,2,3};
        // int[] seq = {7,7,7,7,7,7,7};
        int[] seq = {5,8,3,7,9,1};
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

        System.out.println(binarySearchSol(seq, seq.length));
    }
    
}
