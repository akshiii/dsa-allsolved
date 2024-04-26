package Stacks;

import java.util.Stack;

//Leetcode - 1541. Minimum Insertions to Balance a Parentheses String
public class MinInsertions {

    static int minInsertions(String s) {
        int length = s.length();
        if(length == 0){
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i< s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else{
                if(ch == ')' && !stack.isEmpty() && stack.lastElement() == ')'){
                    char val1 = stack.pop(); // ')'
                    if(!stack.isEmpty()){
                        char val2 = stack.pop();
                        if(val2 == '('){
                            //found a match
                        }
                        else{
                            stack.push(val2);
                            stack.push(val1);
                            stack.push(ch);
                        }   
                    }
                    else{
                        stack.push(val1);
                        stack.push(ch);
                    }
                                     
                }
                else
                    stack.push(ch);
            }
        }

        if(stack.isEmpty()){
            return 0;
        }
        //System.out.println(stack);

        int count = 0;
        while(!stack.isEmpty()){
            char ch = stack.pop();
            if( ch == '('){
                count = count+2;
            }
            else if(ch == ')' && !stack.isEmpty()){
                count = count+1;
                stack.pop();
            }
            else if(ch == ')' && stack.isEmpty()){
                count = count + 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "(()))"; // 1
        String str1 = "())"; //0
        String str2 = "))())("; // 3
        String str3 = "()()()()()("; //7 
        String str4 = "(())))"; //0
        String str5 = "(()))(()))()())))"; //1 
        System.out.println(minInsertions(str5));
    }
    
}
