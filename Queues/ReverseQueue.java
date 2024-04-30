package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
   
    static void reverse(Queue queue){
        if(queue.size() == 0){
            return;
        }

        int val = (int)queue.remove();

        reverse(queue);
       
        queue.add(val);
    }

    public static void main(String[] args) {
        //If here we use new PriorityQueue , then the result wont be same
        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        reverse(queue);
        System.out.println(queue);

    }
}
