package Binary_search;

public class LeetCode153 {

    static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length;
        int mid = (start + end) / 2; 

        if(mid == 0) return nums[0];
        if (start > end) return -1;
        if (nums[start] < nums[end-1]) {
            //already sorted and not rotated
            return nums[start];
        }

        while(start < end){
            if(nums[mid] >= nums[0]){
                start = mid+1;
            }
            else{
                end = mid;
            }
            mid = (start + end) / 2;
        }
        return nums[start];
    }
    public static void main(String[] args) {
        int arr[]={2,1};
        System.out.println(findMin(arr));
    }
}
