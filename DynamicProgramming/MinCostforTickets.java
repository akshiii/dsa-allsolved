package DynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;

class PairInt{
    int day;
    int cost;

    public PairInt(int day, int cost) {
        this.day = day;
        this.cost = cost;
    }
}
public class MinCostforTickets {
	static int INT_MAX = 2147483647;

	static int recursiveSol(int n, int[] days, int[] cost, int index){
		if(index >= n){
			//days exceeded
			return 0;
		}

		// 1 - day pass
		int option1 = cost[0] + recursiveSol(n, days, cost, index + 1);

		//7 day pass
		int i;
		for(i = index; i < n && days[i] < days[index] + 7; i++){}

		int option2 = cost[1] +	recursiveSol(n, days, cost, i);

		//30 day pass
		for(i = index; i < n && days[i] < days[index] + 30; i++){}

		int option3 = cost[2] +	recursiveSol(n, days, cost, i);

		int ans = Math.min(Math.min(option2, option1), option3);
		return ans;
	}

	static int memoizedSol(int n, int[] days, int[] cost, int index, int[] dp){
		if(index >= n){
			//days exceeded
			return 0;
		}

		if(dp[index] != -1){
			return dp[index];
		}

		// 1 - day pass
		int option1 = cost[0] + memoizedSol(n, days, cost, index + 1, dp);

		//7 day pass
		int i;
		for(i = index; i < n && days[i] < days[index] + 7; i++){}

		int option2 = cost[1] +	memoizedSol(n, days, cost, i, dp);

		//30 day pass
		for(i = index; i < n && days[i] < days[index] + 30; i++){}

		int option3 = cost[2] +	memoizedSol(n, days, cost, i,dp);

		dp[index] = Math.min(Math.min(option2, option1), option3);
		return dp[index];
	}

	//bottom up approach used here
	static int tabulationSol(int n, int[] days, int[] cost){

		int[] dp = new int[n+1];
		for (int j = 0; j < dp.length; j++) {
			dp[j] = INT_MAX;
		}

		dp[n] = 0;

		for(int k = n-1; k >= 0; k--){
			// 1 - day pass
			int option1 = cost[0] + dp[k + 1]; // simply replace with dp whereever there is recursive call from previous solutions

			//7 day pass
			int i;
			for(i = k; i < n && days[i] < days[k] + 7; i++){}
			int option2 = cost[1] +	dp[i];

			//30 day pass
			for(i = k; i < n && days[i] < days[k] + 30; i++){}
			int option3 = cost[2] +	dp[i];

			dp[k] = Math.min(Math.min(option2, option1), option3);
		}

		return dp[0];
	}

	static int spaceOptimizedSol(int n, int[] days, int[] cost){
		int ans = INT_MAX;

		Queue<PairInt> month = new LinkedList<>();
		Queue<PairInt> week = new LinkedList<>();
		for(int day : days){
			while(!month.isEmpty() && month.peek().day + 30 <= day){
				month.remove();
			}
			while(!week.isEmpty() && week.peek().day + 7 <= day){
				week.remove();
			}

			// week.add
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] days = {1,4,6,7,8,20};
		int[] cost = {2,7,15};

		System.out.println("Min cost = "+ recursiveSol(days.length, days ,cost , 0));

		int[] dp = new int[days.length+1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println("Min cost = "+ memoizedSol(days.length, days ,cost , 0, dp));

		System.out.println("Min cost = "+ tabulationSol(days.length, days ,cost));

	}
}
