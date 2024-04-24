package Stacks;

import java.util.Stack;

//Insert an elemnet at its bottom in a given stack
public class PushAtBottom {

    static void insertAtBottom(Stack stack, int start, int end,int valueToPush){
        if(start == end){
            stack.push(valueToPush);
            return;
        }

        int value = (int) stack.pop();
        insertAtBottom(stack, start+1, end,valueToPush);
        stack.push(value);
        
    }


    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(2);
        stack1.push(3);
        stack1.push(7);
        stack1.push(5);
        int valueToPush = 9;
        insertAtBottom(stack1,0,stack1.size(),valueToPush);
        
        System.out.println(" After = "+stack1);
    }
    
}
