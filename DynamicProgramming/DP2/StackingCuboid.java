package DynamicProgramming.DP2;

public class StackingCuboid {

    
    static int maxHeight(int[][] cuboids){
        //Step1 : sort all dimensions for every cubiod
        for(int i = 0; i < cuboids.length; i++){
            sort(cuboids[i], cuboids[i].length);
        }

        //Step 2: Sort all cubiod basis on width or length
        sort(cuboids, cuboids.length);

        return 0;
    }

    static void sort(int arr[][], int size){
        //base case
        if( size == 0 || size == 1){
            return;
        }

        for(int i = 0; i < size - 1 ; i++){
            if(arr[i][0] > arr[i+1][0]){
                int[] temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
            // else if(arr[i][0] == arr[i+1][0]){
            //     if(arr[i][1] < arr[i+1][1]){
            //         int[] temp = arr[i];
            //         arr[i] = arr[i+1];
            //         arr[i+1] = temp;
            //     }
            // }
        }

        sort(arr, size -1);
    }
    
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
        int[][] cuboids = {{50,45,20},{95,37,53},{45,23,12}};
        // int[][] cuboids = {{38,25,45},{76,35,3}};
        // int[][] cuboids = {{7,11,17},{7,17,11},{11,7,17},{11,17,7},{17,7,11},{17,11,7}};


        System.out.println("Max height : "+ maxHeight(cuboids));
    }
}
