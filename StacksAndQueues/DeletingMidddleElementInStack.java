package StacksAndQueues;

import java.util.Stack;

/**
 * Deleting a middle elment in a stack using very good recursion technique
 */
public class DeletingMidddleElementInStack {

    static void deletMiddleElementFromStack(Stack stack, int count, int size){
        if(count == stack.size()/2){
            stack.pop();
            return;
        }

        int popEl = (int) stack.pop();
        deletMiddleElementFromStack(stack, count+1, size);
        stack.push(popEl);
    }

    public static void main(String[] args) {
        //Reversing a string using stack
        String str = "akshi";
        Stack<String> s = new Stack<>();
        for(int i = 0 ; i < str.length(); i++ ){
            char ch = str.charAt(i);
            s.push(String.valueOf(ch));
        }
        String reversedStr = "";
        int size = s.size();
        for(int j = 0 ; j < size; j++ ){
            reversedStr = reversedStr + s.pop();
        }
        
        System.out.println(str+ " => After reverse = "+reversedStr);
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(2);
        stack1.push(3);
        stack1.push(7);
        stack1.push(5);
        deletMiddleElementFromStack(stack1,0,stack1.size());
        System.out.println("After deleting middle element = "+stack1);

    }
}
