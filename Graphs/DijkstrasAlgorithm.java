package Graphs;

import java.util.PriorityQueue;
import java.util.Stack;

class PairInt{
    int dist;
    int node;

    public PairInt(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}
/*
//We are using a MinStack which will give min of stack in O(1). This is a replcement for Set and PriorityQueue Daa structure
class MinStack{
    Stack<PairInt> stack;
    PairInt mini;

    MinStack(){
        this.stack = new Stack<>();
        this.mini = new PairInt(-1, -1);
    }

    void push(int dist, int node){
        if(this.stack.isEmpty()){
            this.mini = new PairInt(dist, node);
            this.stack.push(this.mini);
        }
        else if(node < this.mini.node){
            int val = 2 * node - this.mini.node;
            this.stack.push(new PairInt(dist, val));
            this.mini = new PairInt(dist, node);
        }
        else{
            this.stack.push(new PairInt(dist, node));
        }
    }

    PairInt pop(){
        if(this.stack.isEmpty()){
            return new PairInt(-1, -1);
        }
        else{
            PairInt curr = this.stack.lastElement();
            if(curr.node > this.mini.node){
                return this.stack.pop();
            }
            else{
                int prevMini = this.mini.node;
                int val = 2*this.mini.node - curr.node;
                this.mini = new PairInt(curr.dist, val);
                this.stack.pop();
                return new PairInt(curr.dist, prevMini);
            }
        }
    }

    PairInt getMin(){
        return this.mini;
    }
}
*/

/*
 * Priority Queue (Min-Heap): If you need to remove the minimum element multiple times, 
 * a priority queue (implemented as a min-heap) allows you to remove the minimum element in 𝑂(log 𝑛) time. 
 * However, finding the minimum element is 𝑂(1), but insertion or removal is 𝑂(log 𝑛), not 𝑂(𝑛).
*/

public class DijkstrasAlgorithm {
    public static void main(String[] args) {
        /*
        MinStack minStack = new MinStack();
        minStack.push(1,5);
        minStack.push(2,3);
        minStack.push(3,8);
        minStack.push(4,2);

        System.out.println("mini = "+ minStack.getMin().node);
        PairInt pop1 = minStack.pop();
        System.out.println("pop= [ "+ pop1.dist+ " , "+ pop1.node + " ]");
        System.out.println("mini = "+ minStack.getMin().node);
        */

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(7);
        pq.add(3);
        pq.add(5);
        pq.add(4);
        pq.add(8);

        System.out.println("peek = "+ pq.peek()); // This will print the smallest element
        System.out.println("removing = "+ pq.poll()); // This will remove the smallest element
        System.out.println("peek = "+ pq.peek()); // This will print the next smallest element
    }
}
