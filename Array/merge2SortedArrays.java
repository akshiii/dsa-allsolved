package Array;

public class merge2SortedArrays{

    static void merge(int arr1[], int length1, int arr2[], int length2 , int arr3[]){

        int n = 0 , m = 0;
        int finalArray = 0;
        while( n < length1 && m < length2){
            if(arr1[n] < arr2[m]){
                arr3[finalArray++] = arr1[n++];
            }
            else{
                 arr3[finalArray++] = arr2[m++];
            }
        }

        //copy remaining element of first array if any
        while( n < length1){
            arr3[finalArray++] = arr1[n++];
        }
        //copy remaining element of second array if any
        while(m < length2){
            arr3[finalArray++] = arr2[m++];
        }
    }
    public static void main(String[] args) {
        int arr1[] = { 1,3,5};
        int arr2[] = { 2,5,6,7,9};
        int arr3[] = new int[arr1.length+arr2.length];


        merge(arr1 , arr1.length, arr2, arr2.length, arr3);

        for(int i = 0; i < arr3.length ; i++){
            System.out.println(arr3[i]);
        }
    }
}