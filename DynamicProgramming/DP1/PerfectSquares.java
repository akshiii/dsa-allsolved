package DynamicProgramming.DP1;

public class PerfectSquares {
	static int INT_MAX = 2147483647;

	static int recursiveSol(int n){
		if(n == 0){
			return 0;
		}

		int ans = n;
		for(int i = 1; i*i <= n; i++){
			ans = Math.min(ans, 1 + recursiveSol(n-i*i));
		}
		return ans;
	}

	static int memoizedSol(int n, int[] dp){
		if(n == 0){
			return 0;
		}
		if(dp[n] != -1){
			return dp[n];
		}

		int ans = n;
		for(int i = 1; i*i <= n; i++){
			ans = Math.min(ans, 1 + memoizedSol(n-i*i , dp));
		}
		dp[n] = ans;
		return dp[n];
	}

	static int tabulationSol(int n){
		int[] dp = new int[n+1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = INT_MAX;
		}
		dp[0] = 0;

		for(int i = 1; i <= n; i++){
			for(int j = 1; j*j <= n; j++){
				if(i - j*j >= 0){
					dp[i] = Math.min(dp[i], 1+ dp[i - j*j]);
				}
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// int N = 100;
		int N = 50;

		System.out.println("Min no of squares: "+ recursiveSol(N));

		int[] dp = new int[N+1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println("Min no of squares: "+ memoizedSol(N, dp));
		System.out.println("Min no of squares: "+ tabulationSol(N));
		//Space optimization not possible
	}
}
