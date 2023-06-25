import java.util.ArrayList;


//Thsi works for strings as well
public class permutations_of_numbers {

    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    static void permutations(int[] nums, ArrayList<ArrayList<Integer>> ans, int index){
        if(index >= nums.length){
           ArrayList<Integer> array4 = new ArrayList<>();
            for (int num : nums) {
                array4.add(num);
            }
            ans.add(array4);
            return; 
        }

        for(int j = index; j < nums.length ; j++){
            swap(nums,index, j);
            permutations(nums, ans, index+1);
            //backtrack
            swap(nums,index, j);
        }

    }
    
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        // int[] ans = new int[6];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        permutations(nums,ans,0);
        for(ArrayList<Integer> value: ans){
            System.out.println(value);
        }
        
    }
}
