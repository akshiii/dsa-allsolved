package DynamicProgramming;

public class CombinationSum4 {
	//TC= exponential
	static int recursiveSol(int[] arr, int target){

		if(target < 0){
			return 0;
		}
		if(target == 0){
			return 1;
		}

		int ans = 0;
		for(int i = 0; i < arr.length; i++){
			ans += recursiveSol(arr, target - arr[i]);
		}
		return ans;
	}

	//rec+ memoized sol TC = O(target)
	static int memoizedSol(int[] arr, int target, int[] dp){

		if(target < 0){
			return 0;
		}
		if(target == 0){
			return 1;
		}

		if(dp[target] != -1){
			return dp[target];
		}

		int ans = 0;
		for(int i = 0; i < arr.length; i++){
			ans += recursiveSol(arr, target - arr[i]);
		}

		dp[target] = ans;
		return dp[target];
	}

	//TC = O(arr.length) * O(target) = O(n*m)
	static int tabulationSol(int[] arr, int target){
		int[] dp = new int[target+1];
		dp[0] = 1;

		for(int i = 1; i <= target; i++){
			for(int j = 0; j < arr.length; j++){
				if(i - arr[j] >= 0){
					dp[i]+= dp[i - arr[j]];
				}
			}
		}
		return dp[target];
	}

	public static void main(String[] args) {
		int[] arr = {1,2,5};
		int target = 5;

		System.out.println("Combinations: "+ recursiveSol(arr,target));

		int[] dp = new int[target+1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println("Combinations: "+ memoizedSol(arr,target, dp));
		System.out.println("Combinations: "+ tabulationSol(arr,target));
		// spaceOptimizedSol ? here we dont know dp[i] depends on which value so we cant make it more space optimized
	}
}
