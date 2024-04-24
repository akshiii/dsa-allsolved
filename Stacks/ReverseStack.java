package Stacks;

import java.util.Stack;


/**
 * Reverse a Stack ( It uses push at bottom logic also)
 */
public class ReverseStack {

    static void insertAtBottom(Stack stack, int start, int end,int valueToPush){
        if(start == end){
            stack.push(valueToPush);
            return;
        }

        int value = (int) stack.pop();
        insertAtBottom(stack, start+1, end,valueToPush);
        stack.push(value);
        
    }

    static void reverse(Stack stack){
        if(stack.isEmpty()){
            return ;
        }

        //Step 1: Take top most value
        int value = (int)stack.lastElement();

        //Step2: Remove top most value
        stack.pop();

        //Step 4: Reverse rest values
        reverse(stack);

        //Step 3: Insert the topmost value at bottom
        insertAtBottom(stack,0,stack.size(),value);
    }
    
    public static void main(String[] args) {
         Stack<Integer> stack1 = new Stack<>();
        stack1.push(2);
        stack1.push(3);
        stack1.push(7);
        stack1.push(5);
        stack1.push(8);
        System.out.println(" Before = "+stack1);
        reverse(stack1);
        
        System.out.println(" After = "+stack1);
    }
}
