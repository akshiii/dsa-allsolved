public class binarySearchWIthRecursion {

    static boolean binarySearch(int arr[],int start,int end, int key){
        if(start > end){
            return false;
        }

        int  mid = (start + end) /2;   

        if(arr[mid] == key){
            return true;
        } 

        if(arr[mid] < key){
            start = mid + 1;
        }
        else {
            end = mid-1;
        }

        return binarySearch(arr,start,end,key);

    }

    public static void main(String[] args) {
        int arr[] = {2,3,4,5,6,7,8};
        int key = 8;

        if(binarySearch(arr,0,arr.length-1,key)){
            System.out.println("True");
        }
        else
            System.out.println("False");
    }
}
