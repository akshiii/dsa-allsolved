package DynamicProgramming;

//SC = O(1) TC = O(n)
public class Fibonacci {

    static int fibonacci(int n){

        int prev1 = 1;
        int prev2 = 0;

        int curr = 1;
        for(int i = 2; i< n; i++){
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }
    
    public static void main(String[] args) {
        System.out.println("sum of fibb = "+fibonacci(7));
    }
}
