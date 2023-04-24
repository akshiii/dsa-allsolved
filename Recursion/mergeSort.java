public class mergeSort {
    //merge sort using recusrion
    static void merge(int arr[], int start, int end){
        int mid = (start + end)/2;

        //length of left part
        int len1 = mid - start +1;
        //length of right part
        int len2 = end - mid;

        //creating 2 arrays for left and right
        int first[] = new int[len1];
        int second[] = new int[len2];

        //copy values
        int mainArrayIndex = start;
        for( int i = 0 ; i < len1 ; i++){
            first[i] = arr[mainArrayIndex++];
        }
        mainArrayIndex = mid + 1;
        for( int i = 0 ; i < len2 ; i++){
            second[i] = arr[mainArrayIndex++];
        }

        //merge 2 sorted arrays
        int index1 = 0, index2 = 0;
        mainArrayIndex  =  start;

        while(index1 < len1 && index2 < len2){
            if(first[index1] < second[index2]){
                arr[mainArrayIndex++] = first[index1++];
            }
            else{
                arr[mainArrayIndex++] = second[index2++];
            }
        }

        while( index1 < len1){
            arr[mainArrayIndex++] = first[index1++];
        }
        while( index1 < len2){
            arr[mainArrayIndex++] = second[index2++];
        }

    }

    static void mergeSortWithRec(int arr[], int start, int end){

        //base case
        if(start >= end){
            return;
        }

        int mid = (start + end)/2;
        //sortuing left part
        mergeSortWithRec(arr, start, mid);
        //sorting right part
        mergeSortWithRec(arr, mid+1, end);

        //now merge back all parts
        merge(arr,start,end);

    }

    public static void main(String[] args) {
        int arr[] = {27,35,8,6,10,5,1,22,3,33,1,3,44,1};

        mergeSortWithRec(arr, 0 , arr.length-1);

        for(int i = 0; i< arr.length ; i++){
            System.out.println(arr[i]);
        }
    }
}
