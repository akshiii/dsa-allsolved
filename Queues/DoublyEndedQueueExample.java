package Queues;

class DoublyEndedQueue{
    int[] arr;
    int front;
    int rear;

    DoublyEndedQueue(int size){
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    boolean push_front(int data){
        if(this.isFull()){
            System.out.println("Queue is full");
            return false;
        }
        else if(this.front == -1){
            //first element
            this.front = 0;
            this.rear = 0;
        }
        else if(this.front == 0 && this.rear != this.arr.length -1){
            //go back in array
            this.front = this.arr.length -1;
        }
        else{
            //normal flow- we increment front backwards
            //In normal queue when we pop then we push front forward(push++) here when we push we move front backward(front--)
            this.front--;
        }
        this.arr[this.front] = data;
        return true;
    }

    //same as push() from circular queue
    boolean push_back(int data){
        if(isFull()){
            //Queue is full
            System.out.println("Queue is full");
            return false;
        }
        else if(this.front == -1){
            //Queue is fully empty
            this.front = 0;
            this.rear = 0;
        }
        else if(this.rear == this.arr.length -1 && this.front != 0){
            //Some space available in queue
            this.rear = 0;
        }
        else{
            this.rear++;
        }
        this.arr[this.rear] = data;
        return true;
    }

    //same logic as circluar queue pop()
    int pop_front(){
        if(isEmpty()){
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


    int pop_back(){
        if(this.isEmpty()){
            System.out.println("Queue is full");
            return -1;
        }
        int val =  this.arr[this.rear];
        this.arr[this.rear] = -1;
        if(this.front == 0 && this.rear == 0){
            //single el
            this.front = -1;
            this.rear = -1;
        }
        else if(this.rear == 0){
            this.rear = this.arr.length -1;
        }
        else{
            this.rear--;
        }
        return val;
    }

    boolean isEmpty(){
        if( this.front == -1 ){
            return true;
        }
        return false;
    }

    boolean isFull(){
        if((this.front == 0 && this.rear == this.arr.length -1) || (this.front!= 0 && this.rear == (this.front -1) % (this.arr.length -1))){
            return true;
        }
        return false;
    }

    int getFront() 
    {
        if(this.isEmpty()){
            return -1;
        }
        return this.arr[this.front];
    }

    // Returns the last element of the deque. If the deque is empty, it returns -1.
    int getRear() 
    {
         if(this.isEmpty()){
            return -1;
        }
        return this.arr[this.rear];
    }
}

public class DoublyEndedQueueExample {
    public static void main(String[] args) {
        DoublyEndedQueue deque = new DoublyEndedQueue(5);
        System.out.println(deque.isEmpty());
        System.out.println(deque.push_front(10));
        System.out.println(deque.push_front(20));
        System.out.println(deque.push_back(30));
        System.out.println(deque.getFront());
        System.out.println(deque.pop_back());
        System.out.println(deque.pop_back());
    }   
}
