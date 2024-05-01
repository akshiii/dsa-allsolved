package Queues;

// question detail - https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
public class FirstNegativeIntegerInWidnow {
    static long[] findFirstNegetive(long[] arr, int k){
        long[] newArr = new long[arr.length-1];
        long[] window = new long[k];
        for(int i = 0; i < k; i++){
            window[i] = arr[i];
        }

        int rear = 0;
        int i = 0;
        while(rear == arr.length -k){
            window[i] = arr[i];
            i++;
        }

        return newArr;
    }

    public static void main(String[] args) {
        long[] arr = {-8, 2, 3, -6, 10};
        // int k = 2; //ans - [-8, 0 , -6, -6]
        int k = 3; //ans = [-1 -1 -7 -15 -15 0]
        long[] newArr = findFirstNegetive(arr, k);
        for(int i = 0; i< newArr.length ; i++){
            System.out.print(newArr[i]+" , ");
        }
    }
}
