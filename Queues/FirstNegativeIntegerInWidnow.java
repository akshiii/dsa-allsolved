package Queues;

// question detail - https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
public class FirstNegativeIntegerInWidnow {
    static int[] findFirstNegetive(int[] arr, int k){
        DoublyEndedQueue dQueue = new DoublyEndedQueue(k);
        int[] ans = new int[arr.length - k+1];
        

        // Step 1: Make a deque(doubly ended queue) and put first k elements
        for(int i = 0; i < k; i++){
            if(arr[i] < 0){
                dQueue.push_back(i);
            }
        }
        //Step 2: Store ans of first k sized window
        if(!dQueue.isEmpty()){
            ans[0] = arr[dQueue.getFront()];
        }
        else{
            ans[0] = 0;
        }
        int t = 1;

        //Step3: Process for remaining windows, to shift to next window we must 
        // remove 1 left element and add 1 element to the right, so window is shifted by 1 place foward
        for(int i = k; i < arr.length ; i++){
            //Remove left element
            if(!dQueue.isEmpty() && i - dQueue.getFront() >= k){
                dQueue.pop_front();
            }

            //Adding an element to right
            if(arr[i] < 0){
                dQueue.push_back(i);
            }

            //Store ans
            if(!dQueue.isEmpty()){
                ans[t] = arr[dQueue.getFront()];
            }
            else{
                ans[t] = 0;
            }
            t++;

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {8, -2, 3, -6, 10};
        int k = 2; //ans - [-2, -2, -6, -6]
        // int k = 3; //ans = [-2, -2, -6]
        int[] newArr = findFirstNegetive(arr, k);
        for(int i = 0; i< newArr.length ; i++){
            System.out.print(newArr[i]+" , ");
        }
    }
}
