public class NStairs {

    static int distinctWays(int stairs){
        if(stairs < 0){
            return 0;
        }

        if(stairs == 0){
            return 1;
        }

        int ways = distinctWays(stairs-1) + distinctWays(stairs-2);
        return ways;
    }
    public static void main(String[] args) {
        int stairs = 5;
        System.out.println(distinctWays(stairs));

    }
}
