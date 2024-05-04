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
            arr[asciiValue - 97] = arr[asciiValue - 97] + 1;

            if(arr[asciiValue - 97] > 1){
                //Repeating
                if(!queue.isEmpty()){
                    isNonRepeating(queue,arr);
                    if(queue.isEmpty()){
                        newStr = newStr + "#";
                    }
                    else{
                        newStr = newStr + queue.peek();
                    } 
                }
                else{
                    newStr = newStr + "#";
                }
            }
            else{ 
                //Non Repeating
                queue.add(ch);
                newStr = newStr + queue.peek();
            }
            
        }

        return newStr;
    }

    static void isNonRepeating(Queue queue,int[] arr){
        if(!queue.isEmpty()){
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
        else{
            return;
        }
    }
    
    public static void main(String[] args) {
        String str = "aabcdefb"; // a#bbbbbc
        String str1 = "yewaahkpuo"; //yyyyyyyyyy
        String str2 = "yeweyrv"; //yyyywww 
        String str3 = "blybjrzbbyivawvdesebvusjnijimtzkuzdtfkpkpuyjynzxmapwzvrxpluuzbftozbqedqwtlvvnexfvualb"; //bbbllllllllllllllllllllllllllllllllllllllllllllllllllllllfffff##ooooooooooooooooooooo
        String newStr = findNonRepeating(str);
        System.out.println("Non repeating string = "+newStr);
    }
}
