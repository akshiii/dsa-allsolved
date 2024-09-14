package InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Asked in Adobe
// Given a value of V Rs and an infinite supply of each of the denominations {1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, 
//The task is to find the minimum number of coins and/or notes needed to make the change?
public class NotesDenominations {
    static Map<Integer, Integer> ans = new HashMap<>();// <Deno , count>
    static int INT_MAX = 2147483647;
    // static int[] notes = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
      
    static int countDenominations(int amount, int[] notes, int startingIndex){
        int sum = 0;
        int coins = 0;
           
        // Step 2: To keep adding this max value from array until i cannot add anymore  
        while(sum < amount){
            if(startingIndex == -1 ){
                return INT_MAX;
            }
            while( sum + notes[startingIndex] <= amount){
                sum = sum + notes[startingIndex]; //1000
                coins++;
            }
            //Step 3: To go left
            startingIndex --;
        }
        return coins;
    }
    
    //TC - O(log n)
    static int findStartingValue(int[] coins, int v){
        int start = 0;
        int end = coins.length -1;
        
        int mid = (int)Math.floor(start + end)/2;
        
        System.out.println("mid = "+mid);
        while(start < end){
            if( coins[mid] <= v){
                start = mid+1;
            }
            else if( v < coins[mid] ){
                end = mid -1;
            }
            mid = (start + end)/2;
        }
        return mid;
    }

    static int getMinCoins(int amount, int[] coins){
        int startingPoint = findStartingValue(coins, amount);
        int ans = countDenominations(amount, coins, startingPoint);
        if(ans == INT_MAX){
            return -1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] coins = {1,2,5}; 
        int amount = 11; // ans - 3
        System.out.println("Min coins : "+getMinCoins(amount, coins));

        int[] coins1 = {2}; 
        int amount1 = 3; //ans - -1
        System.out.println("Min coins : "+getMinCoins(amount1, coins1));


        int[] coins2 = {1}; 
        int amount2 = 0; // ans - 0
        System.out.println("Min coins : "+getMinCoins(amount2, coins2));

        int[] coins3 = {186,419,83,408};
        int amount3 = 6249; // ans - 20
        Arrays.sort(coins3);
        System.out.println("Min coins : "+getMinCoins(amount3, coins3));
        
    }
}
