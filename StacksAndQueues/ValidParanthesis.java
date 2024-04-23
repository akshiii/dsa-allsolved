package StacksAndQueues;

import java.util.Stack;

/**
 * Very famous question - [(){}()] - Every opening paranthesis/bracket must have correct closing bracket
 */
public class ValidParanthesis {

    static boolean isValid(String s) {
        Stack<Character> stack1 = new Stack<>();

        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[' ){
                stack1.push(ch);
            }
            else {
                //closing brackets
                if(!stack1.isEmpty()){
                    char top = stack1.peek();
                    switch (top) {
                        case '(':
                            if(ch == ')'){
                                //found closing bracket, push again 
                                stack1.pop();
                            }
                            else
                                return false;
                            break;
                        case '{':
                            if(ch == '}'){
                                stack1.pop();
                            }
                            else
                                return false;
                            break;
                        case '[':
                            if(ch == ']'){
                                stack1.pop();
                            }
                            else
                                return false;
                            break;
                        default:
                            return false;
                    }
                }
                else
                    return false;
                
            }
        }
        if(stack1.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String paranthesis = "{(((]";
        System.out.println(paranthesis+" valid ? "+isValid(paranthesis));
    }
    
}
