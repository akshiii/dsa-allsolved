
//https://leetcode.com/problems/maximal-square/
public class LargestSquareMatrix {
	static int max = 0;

	static int maxArea(int[][] matrix, int i, int j){
		if(i >= matrix.length || j >= matrix[0].length){
			return 0;
		}

		int right = maxArea(matrix, i, j+1);
		int down = maxArea(matrix, i+1, j);
		int diagonal = maxArea(matrix, i+1, j+1);

		if(matrix[i][j] == 1){
			int ans = 1 + Math.min(right, Math.min(down, diagonal));
			max = Math.max(max, ans);
			return ans;
		}
		else
			return 0;
	}

	static int memoizedSol(int[][] matrix, int i, int j, int[][] dp){
		if(i >= matrix.length || j >= matrix[0].length){
			return 0;
		}

		if(dp[i][j] != -1){
			return dp[i][j];
		}

		int right = memoizedSol(matrix, i, j+1,dp);
		int down = memoizedSol(matrix, i+1, j,dp);
		int diagonal = memoizedSol(matrix, i+1, j+1,dp);

		if(matrix[i][j] == 1){
			dp[i][j] = 1 + Math.min(right, Math.min(down, diagonal));
			max = Math.max(max, dp[i][j]);
			return dp[i][j];
		}
		else
			return dp[i][j] = 0;
	}

	static void tabulationSol(int[][] matrix){
		int row = matrix.length;
		int column = matrix[0].length;

		int[][] dp = new int[row+1][column+1];
		for (int i = row -1; i >= 0; i--) {
			for(int j = column -1; j >= 0 ; j--){

				int right = dp[i][j+1];
				int down = dp[i+1][j];
				int diagonal = dp[i+1][j+1];

				if(matrix[i][j] == 1){
					dp[i][j] = 1 + Math.min(right, Math.min(down, diagonal));
					max = Math.max(max, dp[i][j]);
				}
				else
					dp[i][j] = 0;
			}
		}
	}

	//SC = O(column) = O(n) TC = O(m*n)
	static void spaceOptimizedSol(int[][] matrix){
		int row = matrix.length;
		int column = matrix[0].length;

		int[] curr = new int[column+1];
		int[] next = new int[column+1];

		for (int i = row -1; i >= 0; i--) {
			for(int j = column -1; j >= 0 ; j--){

				int right = curr[j+1];
				int down = next[j];
				int diagonal =next[j+1];

				if(matrix[i][j] == 1){
					curr[j] = 1 + Math.min(right, Math.min(down, diagonal));
					max = Math.max(max, curr[j]);

				}
				else
					curr[j] = 0;
			}
			next = curr;
		}
	}

	//SC = O(1) TC = O(m*n) UNSOLVED
	static void morespaceOptimizedSol(int[][] matrix){
		int row = matrix.length;
		int column = matrix[0].length;

		// int[] curr = new int[column+1];
		// int[] next = new int[column+1];

		int right = -1;
		int down = -1;
		int diagonal = -1;

		for (int i = row -2; i >= 0; i--) {
			for(int j = column -2; j >= 0 ; j--){

				right = matrix[i][j+1];
				down = matrix[i+1][j];
				diagonal = matrix[i+1][j+1];

				if(matrix[i][j] == 1){
					int ans = 1 + Math.min(right, Math.min(down, diagonal));
					max = Math.max(max, ans);

				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,1,1,1,1},{1,1,1,1,1},{0,1,1,1,0}}; //3
		maxArea(matrix, 0,0);
		System.out.println("Max area = "+ max);

		max = 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++){
				dp[i][j] = -1;
			}
		}
		memoizedSol(matrix, 0,0, dp);
		System.out.println("Max area = "+ max);

		max = 0;
		tabulationSol(matrix);
		System.out.println("Max area = "+ max);

		max = 0;
		spaceOptimizedSol(matrix);
		System.out.println("Max area = "+ max);

		max = 0;
		morespaceOptimizedSol(matrix);
		System.out.println("Max area = "+ max);
	}
}
