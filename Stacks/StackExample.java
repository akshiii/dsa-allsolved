package Stacks;


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

        int pop(){
            if(this.top > -1){
                int result = this.arr[this.top];
                this.top--;
                return result;
            }
            else{
                return -1;
            }
        }

        int peek(){
            return this.arr[this.top];
        }

        boolean isEmpty(){
            return this.top > -1 ? false : true;
        }

        public void increment(int k, int val) {
            int temp = 0;
            while(temp < k ){   
                if(temp <= this.top ){
                    this.arr[temp] = this.arr[temp] + val;
                }
                temp++;
            }
        }
    }

public class StackExample {
    
    public static void main(String[] args) {

        MyStack myStack1 = new MyStack(5);
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(3);
        
        myStack1.increment(5, 100);
        System.out.println("");
    }
}
