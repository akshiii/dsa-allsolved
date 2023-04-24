public class checkSorted {


    static boolean isSorted(int arr[], int size){
        if(size == 0 || size == 1){
            return true;
        }
        if(arr[size-2] > arr[size -1]){
            return false;
        }
            return isSorted(arr, size-1);

    }
    public static void main(String[] args) {
        int arr[] = {4,16,9,11};

        if(isSorted(arr,arr.length)){
            System.out.println("True");
        }
        else
            System.out.println("False");
    }
}
  