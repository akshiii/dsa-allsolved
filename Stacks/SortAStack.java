package Stacks;

import java.util.Stack;

/**
 * Imp question
 */
public class SortAStack {
    static void sortedInsert(Stack stack, int start, int valueToInsert){

        if(stack.isEmpty() || (int)stack.lastElement() < valueToInsert ){
            //Insert valueToInsert just when the top element is less than valueToInsert or the list is empty.
             stack.push(valueToInsert);
             return;
        }

        //Keep removing elements from top of stack till the valueToInsert reaches its right place
        int value = (int) stack.pop();
        sortedInsert(stack, start+1, valueToInsert);

        //Push back whatever values you removed
        stack.push(value);
    }

    static void sort(Stack stack){

        //Base case - When stack is empty
        if(stack.isEmpty()){
            return;
        }

        //Base case - Keep removing from stack until the stack size = 1
        if(stack.size() == 1){
            return ;
        }

        //Step 1: One by one remove all elements from stack
        int value = (int)stack.lastElement();
        stack.pop();

        //Step 2:One by one remove all elements from stack recursively
        sort(stack);

        //Step 3: Insert value in stack only in sorted way, at right place so that it is sorted.
        sortedInsert(stack, 0 , value);


    }
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(2);
        stack1.push(3);
        stack1.push(-7);
        stack1.push(-5);
        stack1.push(1);
        System.out.println(" Before = "+stack1);
        sort(stack1);
        
        System.out.println(" After = "+stack1);
    }
}
