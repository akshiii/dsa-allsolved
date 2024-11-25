package DynamicProgramming.DP2;

import java.util.ArrayList;

// TODO: Not solved
public class RussianDolls {
    static int findMax(int[][] envelopes){
        // Step 1: Sort by width
        sort(envelopes, envelopes.length);
        int[] heights = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++){
            heights[i] = envelopes[i][1];
        }
        int max = binarySearchSol(heights, envelopes.length);

        return max;
    }
    static void sort(int arr[][], int size){
        //base case
        if( size == 0 || size == 1){
            return;
        }

        for(int i = 0; i < size - 1 ; i++){
            if(arr[i][0] > arr[i+1][0]){
                int[] temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
            else if(arr[i][0] == arr[i+1][0]){
                if(arr[i][1] < arr[i+1][1]){
                    int[] temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }

        sort(arr, size -1);
    }
     //DP with Binary search TC- O(nlogn) SC- O(1)
    static int binarySearchSol(int[] seq, int n){
        if(n == 0){
            return 0;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(seq[0]);

        for(int i = 1; i < seq.length; i++){
            if(seq[i] > arrayList.get(arrayList.size() - 1)){
                arrayList.add(seq[i]);
            }
            else{
                int upperBound = upperBound(arrayList, seq[i]);
                arrayList.set(upperBound, seq[i]);
            }
        }

        return arrayList.size();
    }

    //upper bound is first element in a sorted range that is strictly greater than a given value.
    static int upperBound(ArrayList<Integer> seq, int k){
        int start = 0, end = seq.size() - 1;
        int mid;
        
        while(start < end){
            mid = (int)Math.floor((start+end)/2);
            if(seq.get(mid) <= k){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }

        return start;
    }
   
    public static void main(String[] args) {
        int[][] envelopes = {{5,4}, {6,4}, {6,7}, {2,3}}; //3
        // int[][] envelopes = {{1,1}, {1,1}, {1,1}, {1,1}}; //1

        System.out.println("Max : "+ findMax(envelopes));
    }
    
}
