public class bubbleSort {
    static void sort(int arr[], int size){
        //base case
        if( size == 0 || size == 1){
            return;
        }

        for(int i = 0; i < size - 1 ; i++){
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        sort(arr, size -1);
    }
    public static void main(String[] args) {
        
        int arr[] ={2,4,6,3,1};

        sort(arr,arr.length);

        for( int i = 0; i< arr.length ; i++){  
            System.out.println(arr[i]);
        }
    }
}
