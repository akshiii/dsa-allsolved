public class quickSort {


    static int partition(int arr[], int start, int end){

        int pivot = arr[start];
        int count = 0;

         for(int i = start + 1 ; i <= end ; i++){
            if(arr[i] <= pivot){
                count++;
            }
        }

        int pivotIndex = start + count;
        //swap
        int temp = arr[start];
        arr[start] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        int i = start, j = end;
        while( i < pivotIndex && j > pivotIndex){
            while(arr[i] <= pivot){
                i++;
            }
            while( arr[j] > pivot){
                j--;
            }

            if(i < pivotIndex && j > pivotIndex){
                //swap
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }



        return pivotIndex;
    }
    static void quickSortWithRec(int arr[], int start, int end){
        if(start >= end){
            return;
        }

        int p = partition(arr, start,end);

        quickSortWithRec(arr, start, p-1);
        quickSortWithRec(arr, p+1, end);
    }

    public static void main(String[] args) {
        int arr[] = {3,5,1,8,2,4,5,3,88,2,6,1,4,2,9,255,0,5};

        quickSortWithRec(arr, 0 , arr.length-1);

        for(int i = 0; i< arr.length ; i++){
            System.out.println(arr[i]);
        }
    }
    
}
