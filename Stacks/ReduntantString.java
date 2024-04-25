package Stacks;

import java.util.Stack;

//Detect if an expression has extra brackets/redundant brackets -True if there are redundant brackets
// ((a/b)) - True
// (a) - True
// (a + (c*d)) - False
public class ReduntantString {
    static boolean isRedundantString(String str){
        //Logic here is that between 2 brackets ( ) there must be some opertor ( + - / *), if not then it is redundant, charcters (a, b, c) dont matter here
        Stack<Character> stack = new Stack<>();
        boolean redundant = false;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '/' || ch == '+' || ch == '*' || ch == '-'){
                stack.push(ch);
            }
            else if( ch == ')' ){
                //start popping top elemnet, if it finds an opearator  + - / * ,then its fine
                //but if it finds a opening bracket (, then its redundant.
                boolean found = false;
                char top = (char)stack.pop();
                while(top != '(' ){
                    if(top == '/' || top == '+' || top == '*' || top == '-'){
                        found = true;
                    }
                    top = (char)stack.pop();
                }
                if(found != true && top == '(' ){
                    redundant = true;
                }
            }
        }
        return redundant;
    }

    public static void main(String[] args) {
        String str = "((a+c)+a+b)";
        String str1 = "(((a+c)+a)+b)";
        String str2 = "()";
        System.out.println(isRedundantString(str1));
    }
    
}
