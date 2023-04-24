public class power {


    static int calculatePower(int a, int b ){
        if(b == 0){
            return 1;
        }
        if(b == 1){
            return a;
        }

        int ans = calculatePower(a, b/2);

        
        if(b % 2 == 0){
            //if b is even
            return ans * ans;
        }
        else{
            //if b is odd
            return a * ans * ans;
        }
    }
    public static void main(String[] args) {
        int a = 3, b = 11;

        //calculate a to the power of b
        System.out.println(calculatePower(a,b));
    }
}
