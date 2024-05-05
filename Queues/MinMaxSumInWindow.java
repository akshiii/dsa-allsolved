package Queues;


// Sum of minimum and maximum elements of all subarrays of size k.
// https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/
//not using queue here still a efficient approach TC- O(n) SC- O(1)
public class MinMaxSumInWindow {
    static int findSumOfMinMax(int[] arr, int k){
        int sum = 0;
        int min = 0;
        int max = 0;

        //First k window max and min sum
        for(int i=0; i < k; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }
        sum = min + max;
        //next windows
        for(int i = k; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[k];
            }
            if(arr[i] > max){
                max = arr[i];
            }
            sum = sum + min + max;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        int k = 4;
        System.out.println(findSumOfMinMax(arr,k));
    }
}
