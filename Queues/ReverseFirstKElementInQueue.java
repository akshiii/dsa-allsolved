package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//TC- O(N) SC- O(k)
public class ReverseFirstKElementInQueue {

    static void reverse(Queue queue, int k){

        //Step1: Pop first k from queue and put into stack
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< k; i++){
            stack.push((int)queue.remove());
        }

        //Step2: Fetch from stacka nd push into queue
        while(!stack.isEmpty()){
            int val = (int) stack.pop();
            queue.add(val);
        }

        //Step3: Pop from front of queue (queue.size - k) elements and push at rear
        int n = queue.size();
        for(int i = 0; i< n - k; i++){
            int val = (int)queue.remove();
            queue.add(val);
        }
    }
 
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        int k = 3; //[3,2,1,4,5]
        reverse(queue,k);
        System.out.println(queue);

    }
}
