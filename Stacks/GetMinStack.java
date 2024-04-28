package Stacks;

import java.util.Stack;

//Design a stack that supports getMin() in O(1) time and O(1) space complexity.
class MinStack{
    Stack<Integer> stack;
    int mini;

    MinStack(){
        this.stack = new Stack<>();
        this.mini = -1;
    }

    void push(int data){
        if(this.stack.isEmpty()){
            this.stack.push(data);
            this.mini = data;
        }
        else if(data < this.mini){
            int val = 2 * data - this.mini;
            this.stack.push(val);
            this.mini = data;
        }
        else{
            this.stack.push(data);
        }
    }

    int pop(){
        if(this.stack.isEmpty()){
            return -1;
        }
        else{
            int curr = this.stack.lastElement();
            if(curr > mini){
                return this.stack.pop();
            }
            else{
                int prevMini = this.mini;
                int val = 2*this.mini - curr;
                this.mini = val;
                this.stack.pop();
                return prevMini;
            }
        }
    }
}

public class GetMinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(8);
        minStack.push(2);
        minStack.push(4);
        System.out.println("pop= "+ minStack.pop());
        System.out.println("pop= "+ minStack.pop());
        System.out.println("pop= "+ minStack.pop());
        System.out.println("pop= "+ minStack.pop());
    }
    
}
