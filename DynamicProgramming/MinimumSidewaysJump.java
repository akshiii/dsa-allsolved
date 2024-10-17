package DynamicProgramming;
 
public class MinimumSidewaysJump {
    static int INT_MAX = 1000000000;
 
    static int recursiveSol(int[] obstacles, int currlane,int pos){
        if(pos == obstacles.length-1){
            return 0;
        }
 
        if(obstacles[pos+1] != currlane){
            return recursiveSol(obstacles, currlane, pos+1);
        }
        else{
            //sideways jump
            int ans = INT_MAX;
            for(int i = 1; i <= 3; i++){
                if(currlane != i && obstacles[pos] != i){
                    ans = Math.min(ans, 1 + recursiveSol(obstacles, i, pos));
                }
            }
            return ans;
        }
    }
 
    static int memoizedSol(int[] obstacles, int currlane,int pos, int[][] dp){
        if(pos == obstacles.length-1){
            return 0;
        }
 
        if(dp[currlane][pos] != -1){
            return dp[currlane][pos];
        }
 
        if(obstacles[pos+1] != currlane){
            return memoizedSol(obstacles, currlane, pos+1,dp);
        }
        else{
            //sideways jump
            int ans = INT_MAX;
            for(int i = 1; i <= 3; i++){
                if(currlane != i && obstacles[pos] != i){
                    ans = Math.min(ans, 1 + memoizedSol(obstacles, i, pos,dp));
                }
            }
            dp[currlane][pos] = ans;
        }
        return dp[currlane][pos];
    }
 
    static int tabulationSol(int[] obstacles){
 
        int n = obstacles.length -1;
        int[][] dp = new int[4][obstacles.length];
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < obstacles.length; j++){
                dp[i][j] = INT_MAX;
            }
        }
 
        dp[0][n] = 0;
        dp[1][n] = 0;
        dp[2][n] = 0;
        dp[3][n] = 0;
 
        for(int pos = n-1; pos >= 0; pos-- ){
            for(int currlane = 1; currlane <= 3; currlane++){
                if(obstacles[pos+1] != currlane){
                    dp[currlane][pos] = dp[currlane][pos+1];
                }
                else{
                    //sideways jump
                    int ans = INT_MAX;
                    for(int i = 1; i <= 3; i++){
                        if(currlane != i && obstacles[pos] != i){
                            ans = Math.min(ans, 1 + dp[i][pos]);
                        }
                    }
                    dp[currlane][pos] = ans;
                }
            }
        }
        return Math.min(dp[2][0], Math.min(1+dp[1][0], 1+dp[3][0]));
    }
    public static void main(String[] args) {
        int[] obstacles = {0,1,2,3,0}; //2
        // int[] obstacles = {0,1,1,3,3,0};
 
        System.out.println("No of sideways jump = "+recursiveSol(obstacles, 2, 0));
 
        int[][] dp = new int[4][obstacles.length];
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < obstacles.length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println("No of sideways jump = "+memoizedSol(obstacles, 2, 0,dp));
 
        System.out.println("No of sideways jump = "+tabulationSol(obstacles));
 
    }
}