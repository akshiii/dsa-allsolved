package StacksAndQueues;

//Saving 2 stacks in one array - One stack will start from i=0 and one stack from back, i = array_size.
class TwoStackArray{
    int[] arr;
    int size;
    int top1;
    int top2;

    TwoStackArray(int size){
        this.arr = new int[size];
        this.top1 = -1;
        this.top2 = size;
        this.size = size;
    }

    void push1(int data){
        if(this.top2 - this.top1 > 1){
            this.top1++;
            this.arr[this.top1] = data ;
        }
    }

    void push2(int data){
        if(this.top2 - this.top1 > 1){
            this.top2--;
            this.arr[this.top2] = data ;
        }
    }

    void pop1(){
        if(this.top1 > -1){
            this.top1--;
        }
    }

    void pop2(){
        if(this.top2 < this.size){
            this.top2++;
        }
    }

}
public class TwoStackInAnArray {
    public static void main(String[] args) {
        TwoStackArray twoStackArray = new TwoStackArray(4);
        twoStackArray.push1(1);
        twoStackArray.push2(4);
        twoStackArray.push1(2);
        twoStackArray.push1(3);
        twoStackArray.pop2();
        twoStackArray.push2(5);
        System.out.println("");
        for(int i : twoStackArray.arr){
            System.out.print(i+ " ");
        }
        
    }
}
