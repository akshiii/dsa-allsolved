package Binary_search;

public class BinarySearch {

    static int binarySearch(int[] arr, int valueToFind, int start, int end){
        int mid = (start + end) / 2;
        if(start > mid){
            return -1;
        }
        if(arr[mid] == valueToFind){
            return mid;
        }
        else{
            if(valueToFind > arr[mid]){
                return binarySearch(arr, valueToFind, mid+1, end);
            }
            else{
                return binarySearch(arr, valueToFind, start, mid-1);
            }
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        System.out.println("Found at index: " + binarySearch(arr,7,0,arr.length-1));
    }
}
