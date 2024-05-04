package Queues;


class NQueues {
    int n; // size of array
    int k; //no of queues
    int[] front;
    int[] rear;
    int[] next;
    int freespot;
    int[] arr;

    NQueues(int n, int k){
        this.n = n;
        this.k = k;
        this.front = new int[k];
        this.rear = new int[k];
        this.arr = new int[n];
        this.next = new int[n];
        this.freespot = 0;

        for(int i = 0; i < k; i++){
            this.rear[i] = -1;
            this.front[i] = -1;
        }
        for(int i = 0; i < n; i++){
            this.next[i] = i+1;
        }
        this.next[n-1] = -1;
    }

    void enqueue(int data, int qn){
        if(this.freespot == -1){
            //overflow check
            System.out.println("No free space");
            return;
        }

        //find first free index
        int index = this.freespot;

        //update freespot
        this.freespot = this.next[index];

        //check first element
        if(this.front[qn-1] == -1){
            this.front[qn -1] = index;
        }
        else{
            //link new element
            this.next[this.rear[qn-1]] = index;
        }

        //update next
        this.next[index] = -1;

        //update rear 
        this.rear[qn-1] = index;

        //push element in actual arr
        this.arr[index] = data;
    }

    int dequeue(int qn){
        //underflow, find if queue is empty
        if(this.front[qn-1] == -1){
            System.out.println("Queue is empty");
            return -1;
        }

        //find index to pop
        int index = this.front[qn-1];

        //update front
        this.front[qn-1] = this.next[index];

        //manage free slots
        this.next[index] = this.freespot;

        //update new freeslot
        this.freespot = index;

        return arr[index];
    }
    
}
public class NQueuesInArray {
    public static void main(String[] args) {
        
    }
}
