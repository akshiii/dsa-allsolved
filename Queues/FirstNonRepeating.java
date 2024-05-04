package Queues;

import java.util.LinkedList;
import java.util.Queue;

//First non repeating character in stream
//ip- "aabc" => output - "a#bc" 
//ip - "zzc" => output = "z#c"
//ip- "aabcdefb" => output - "a#bbbbbc"
public class FirstNonRepeating {

    static String findNonRepeating(String A){
        String newStr = "";
        int[] arr = new int[26];
       
        Queue<Character> queue = new LinkedList();
        

        for(int i = 0; i< A.length(); i++){
            char ch = A.charAt(i);
            int asciiValue = ch & 0xFF;
            if(arr[asciiValue - 97] > 0){
                //repeating char
                
                if(!queue.isEmpty()){
                    isNonRepeating(queue,arr);
                    char peek = queue.peek();
                    if(peek != ch){
                        newStr = newStr + peek;
                    }
                    else{
                        queue.remove();
                        if(queue.isEmpty()){
                            newStr = newStr + "#";
                        }
                        else{
                            newStr = newStr + queue.peek();
                        }
                    }
                }
                else{
                    newStr = newStr + "#";
                }
            }
            else{ 
                queue.add(ch);
                newStr = newStr + queue.peek();
            }
            arr[asciiValue - 97] = arr[asciiValue - 97] + 1;
        }

        return newStr;
    }

    static void isNonRepeating(Queue queue,int[] arr){
        char peek = (char) queue.peek();
        int asciiPeek = peek & 0xFF;
        if(arr[asciiPeek - 97] > 1 ){
            queue.remove();
            isNonRepeating(queue, arr);
        }
        else{
            return;
        }

    }
    
    public static void main(String[] args) {
        String str = "aabcdefb";
        String str1 = "yewaahkpuo"; //yyyyyyyyyy
        String str2 = "yewehy"; 
        String newStr = findNonRepeating(str1);
        System.out.println("Non repeating string = "+newStr);
    }
}
