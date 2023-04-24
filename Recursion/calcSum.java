public class calcSum{

    static int findSum(int arr[] , int size){
       
        if( size <= 0){
            return 0;
        }
        
        return (findSum(arr, size-1) + arr[size-1]);

    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        System.out.println(arr.length);

        System.out.println("Sum : "+findSum(arr,arr.length));
    }


}
