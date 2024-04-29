package Queues;

import java.util.PriorityQueue;
import java.util.Queue;

class ArrayQueue{
    int[] arr;
    int front;
    int rear;
    
    ArrayQueue(int size){
        this.arr = new int[size];
        this.front = 0;
        this.rear = 0;  
    }

    void push(int data){
        if(this.rear <= this.arr.length-1){
            this.arr[this.rear] = data;
            this.rear++;
        }
    }

    int pop(){
        if(this.rear > 0 && this.front!=this.rear){
            int val = this.arr[this.front];
            this.arr[this.front] = -1;
            this.front++;
            return val;
        }
        if(this.front == this.rear){
            this.front = 0;
            this.rear = 0;
        }
        return -1;
    }

    boolean isEmpty(){
        if(this.rear == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
public class MyQueue {
    
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.remove());
        
        ArrayQueue arrayQueue = new ArrayQueue(4);
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        System.out.println("Empty? "+arrayQueue.isEmpty());
        System.out.println("Pop= "+arrayQueue.pop());
        arrayQueue.push(4);
        arrayQueue.push(5);
    }
}
