public class linearSearchWithR {

     static boolean isElementPresent(int arr[],int size, int key){
        if(size==0){
            return false;
        }

        if(arr[size-1] == key){
            return true;
        }

        return isElementPresent(arr, size-1,key);

    }
    public static void main(String[] args) {
        int arr[] = {3,5,1,2,6};
        int key = 21;

        if(isElementPresent(arr,arr.length,key)){
            System.out.println("True");
        }
        else
            System.out.println("False");
    }
}
