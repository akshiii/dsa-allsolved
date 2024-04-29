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

//Circular queue
class CircularQueue{
    int[] arr;
    int front;
    int rear;
    
    CircularQueue(int size){
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    void push(int data){
        if((this.front == 0 && this.rear == this.arr.length -1) || (this.rear == (this.front -1) % (this.arr.length -1))){
            //Queue is full
            System.out.println("Queue is full");
        }
        else if(this.front == -1){
            //Queue is fully empty
            this.front = 0;
            this.rear = 0;
            this.arr[this.front] = data;
        }
        else if(this.rear == this.arr.length -1 && this.front != 0){
            //Some space available in queue
            this.rear = 0;
            this.arr[this.rear] = data;
        }
        else{
            this.rear++;
            this.arr[this.rear] = data;
        }
    }

    int pop(){
        if(this.front == -1 && this.rear == -1){
            //Queue is empty;
            return -1;
        }
        else if(this.front == this.rear){
            //Only 1 element is present in queue
            int val =  this.arr[this.front];
            this.arr[this.front] = -1;
            this.front = -1;
            this.rear = -1;
            return val;
        }
        else if(this.front == this.arr.length -1){
            int val =  this.arr[this.front];
            this.arr[this.front] = -1;
            this.front = 0;
            return val;
        }
        else{
            int val = this.arr[this.front];
            this.arr[this.front] = -1;
            this.front++;
            return val;
        }
    }

    boolean isEmpty(){
        if(this.front == -1 || this.rear == -1 ){
            return true;
        }
        else{
            return false;
        }
    }
}

public class MyQueue {
    
    public static void main(String[] args) {
        // Queue<Integer> queue = new PriorityQueue<>();
        // queue.add(1);
        // queue.add(2);
        // queue.add(3);
        // queue.add(4);
        // System.out.println(queue.remove());
        
        // ArrayQueue arrayQueue = new ArrayQueue(4);
        // arrayQueue.push(1);
        // arrayQueue.push(2);
        // arrayQueue.push(3);
        // System.out.println("Empty? "+arrayQueue.isEmpty());
        // System.out.println("Pop= "+arrayQueue.pop());
        // arrayQueue.push(4);
        // arrayQueue.push(5);

        CircularQueue circularQueue = new CircularQueue(3);
        System.out.println(circularQueue.isEmpty());
        circularQueue.push(2);
        circularQueue.push(3);
        // circularQueue.push(3);
        System.out.println("Pop = "+circularQueue.pop());
        circularQueue.push(4);
        // System.out.println("Pop = "+circularQueue.pop());
        circularQueue.push(6);
        circularQueue.push(7);                
        System.out.println("Pop = "+circularQueue.pop());

        // circularQueue.push(7);
        // circularQueue.push(9);
    }
}
