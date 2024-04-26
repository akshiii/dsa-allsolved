package Stacks;

import java.util.Stack;

//Minimum cost to make a string valid - 
// {{{{}} - 1
// {{{{{{ - 6
// {{{}} - -1(cannot make odd no of strings valid)

public class MakeValidString {
    
    static int findMinimumCost(String str){
        if(str.length()%2 == 1){
            //Odd no charcters cannot be made valid
            return -1;
        }
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < str.length(); i++){

            char ch = str.charAt(i);
            if(ch == '{'){
                stack.push(ch);
            }
            else if(!stack.isEmpty() && ch == '}' && stack.lastElement() == '{'){
                //Removing all correct ones
                stack.pop();
            }
            else if(ch == '}'){
                stack.push(ch);
            }
        }
        if(stack.isEmpty()){
            return 0;
        }
        else{
            //Count corrections or cost to correct string 
            int openBracesCount = 0;
            int closedBracesCount = 0; 
            while(!stack.isEmpty()){
                char val = (char)stack.pop();
                if(val == '{'){
                    openBracesCount++;
                }
                else{
                    closedBracesCount++;
                }
            }
            if(openBracesCount%2 == 1 || closedBracesCount%2 == 1){
                //odd opening/closed braces
                count = (openBracesCount +closedBracesCount)/2 + 1;
            }
            else{
                count = (openBracesCount + closedBracesCount)/2;
            }
            
        }



        return count;
    }

    public static void main(String[] args) {
        String str = "}}}{{{"; // 4 
        String str1 = "}}}}"; // 2
        String str2 = "{{{{"; // 2
        String str3 = "{{{"; // -1
        String str4 = "{{{{}}}}"; //0
        System.out.println(findMinimumCost(str3));
    }
}
