package InterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Asked in Adobe
// Given a value of V Rs and an infinite supply of each of the denominations {1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, 
//The task is to find the minimum number of coins and/or notes needed to make the change?
public class NotesDenominations {
    static Map<Integer, Integer> ans = new HashMap<>();// <Deno , count>
    static int[] notes = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
      
    static void countDenominations(int v, int sum){
        if(sum == v){
            return;// denomination, count
        }
        
        //Step 1: Start at the max value possible
        int startingIndex = findStartingValue(v);
        
        // Step 2: To keep adding this max value from array until i cannot add anymore
        
        while(sum < v){
            if(startingIndex == -1 ){
                return;
            }
            while( sum + notes[startingIndex] <= v){
                sum = sum + notes[startingIndex]; //1000
                if(ans.get(notes[startingIndex]) != null){
                    int val = ans.get(notes[startingIndex]);
                    ans.put(notes[startingIndex],++val);
                }
                else{
                    ans.put(notes[startingIndex],1);
                }
            }
            //Step 3: To go left
            startingIndex --;
        } 
    }
    
    static int findStartingValue(int v){
        int start = 0;
        int end = notes.length -1;
        
        int mid = (int)Math.floor(start + end)/2;
        
        System.out.println("mid = "+mid);
        while(start < end){
            if( notes[mid] <= v){
                start = mid+1;
            }
            else if( v < notes[mid] ){
                end = mid -1;
            }
            mid = (start + end)/2;
        }
        
        return mid;
    }

    public static void main(String[] args) {
        int v = 1200;
        int sum = 0;
        
        countDenominations(v, sum);     

        System.out.println(ans);


        int result = 0;
        List<Integer> keys = new ArrayList<>(ans.keySet());
        Collections.sort(keys);
        for (Integer val : keys) {
            int i = ans.get(val);
            result = result +  i;
        }


        System.out.println(result);
    }
}
