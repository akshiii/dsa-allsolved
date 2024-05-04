package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Interleave first half of a queue with second half using only Stack
public class InterleaveQueue {

    static void interleave(Queue queue){

        Stack<Integer> stack = new Stack<>();
        int size = queue.size() / 2;

        //Step 1: Take first half of quue in stack
        while(size != 0){
            int val = (int)queue.remove();
            stack.push(val);
            size--;
        }

        //Step 2: Reverse Stack
        reverse(stack);


        //Step 3: Now merge

        while(!stack.isEmpty()){
            int val = (int)stack.pop();
            queue.add(val);
            int next = (int)queue.remove();
            queue.add(next);
        }
    }

    
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
        Queue<Integer> queue = new LinkedList<>();
        queue.add(11);
        queue.add(12);
        queue.add(13);
        queue.add(14);
        queue.add(15);
        queue.add(16);
        queue.add(17);
        queue.add(18);
        queue.add(19);
        queue.add(20);

        //op- [11 16 12 17 13 18 14 19 15 20]
        interleave(queue);

        System.out.println(queue);
    }
}
