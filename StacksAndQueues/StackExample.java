package StacksAndQueues;

import java.util.Stack;

//Making our own stack class
    class MyStack{
        int[] arr;
        int size;
        int top;

        MyStack(int size){
            this.arr = new int[size];
            this.size = size;
            this.top = -1;
        }

        void push(int data){
            if(this.size - this.top > 1){
                this.top++;
                this.arr[this.top] = data;
            }
        }

        void pop(){
            if(this.top > 0){
                top--;
            }
            System.out.println("Stack underlfow");
        }

        int peek(){
            return this.arr[this.top];
        }

        boolean isEmpty(){
            return this.top > -1 ? false : true;
        }

    }

public class StackExample {
    
    public static void main(String[] args) {

        MyStack myStack1 = new MyStack(5);
        myStack1.push(3);
        myStack1.push(4);
        myStack1.push(7);
        myStack1.pop();
        System.out.println("");
    }
}
