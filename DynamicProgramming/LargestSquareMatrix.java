package DynamicProgramming;

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
	public static void main(String[] args) {
		int[][] matrix = {{1,1,1,1,1},{1,1,1,1,1},{0,1,1,1,0}}; //3
		maxArea(matrix, 0,0);
		System.out.println("Max area = "+ max);
	}
}
