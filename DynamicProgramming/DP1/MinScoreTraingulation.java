package DynamicProgramming.DP1;
 
public class MinScoreTraingulation {
    static int INT_MAX = 2147483647;
 
    static int recursiveSol(int[] polygon, int i , int j){
        //base case
        if(i+1 == j){
            return 0;
        }
 
        int ans = INT_MAX;
        for(int k = i+1; k < j; k++){
            int ab = recursiveSol(polygon, i, k);
            int cd = recursiveSol(polygon, k, j);
            int sumArea = polygon[i]* polygon[j]* polygon[k] + ab + cd;
            ans = Math.min(ans, sumArea);
        }
        return ans;
    }
 
    static int memoizedSol(int[] polygon, int i , int j, int[][] dp){
        //base case
        if(i+1 == j){
            return 0;
        }
 
        if(dp[i][j] != -1){
            return dp[i][j];
        }
 
        int ans = INT_MAX;
        for(int k = i+1; k < j; k++){
            ans = Math.min(ans, polygon[i]* polygon[j]* polygon[k] + memoizedSol(polygon, i, k, dp) + memoizedSol(polygon, k, j, dp));
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
 
    //TC= O(n3) n cube complexicity SC = O(n2)
    static int tabulationSol(int[] polygon){
        int[][] dp = new int[polygon.length][polygon.length];
        int i,j;
 
 
        for(i = polygon.length -1 ; i >=0 ; i--){
            for(j = i+2; j < polygon.length; j++){
 
                int ans = INT_MAX;
                for(int k = i+1; k < j; k++){
                    ans = Math.min(ans, polygon[i]* polygon[j]* polygon[k] + dp[i][k] + dp[k][j]);
                }
                dp[i][j] = ans;
 
            }
        }
        return dp[0][polygon.length-1];
    }
 
    //My Solution - does not pass all test cases
    //TC= O(n*(n-2)) almos n2 SC = O(1)
    static int tabulationSol2(int[] polygon){
        int i,j;
 
        int ans = INT_MAX;
        for(i = 0 , j = i+1 ; i < polygon.length && j <= polygon.length ; i++ , j++){
 
                if(j > polygon.length -1){
                    j = 0;
                }
                int sol = 0;
                int k = j + 1;
                if(k > polygon.length -1 ){
                    k = 0;
                }
                int temp = j;
                for(int p = 0; p < polygon.length -2; p++){
                    sol+= polygon[i]* polygon[j]* polygon[k];
                    k++;
                    if(k > polygon.length -1 ){
                        k = 0;
                    }
                    j++;
                    if(j > polygon.length -1){
                        j = 0;
                    }
                }
                ans = Math.min(ans, sol);
                j = temp;
 
        }
        return ans;
    }
    public static void main(String[] args) {
        // int[] polygon = {3,7,4,5};
        // int[] polygon = {1,2,3,4,5,6};
        int[] polygon = {1,3,1,4,1,5};
 
        System.out.println("min area = "+ recursiveSol(polygon, 0, polygon.length-1));
 
 
        int[][] dp = new int[polygon.length][polygon.length];
        for (int i = 0; i < polygon.length; i++) {
            for(int j = 0; j < polygon.length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println("min area = "+ memoizedSol(polygon, 0, polygon.length-1,dp));
 
        System.out.println("min area = "+ tabulationSol(polygon));
 
    }
}