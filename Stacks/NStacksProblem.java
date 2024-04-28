package Stacks;

//Design a class which stores N stacks in a single array
class NStacks{
        int n;
        int s;
        int[] arr;
        int[] top;
        int[] next;
        int freespot;

        //N is no of Stacks, S is size of Array
        NStacks(int N, int S){
            this.n = N;
            this.s = S;
            this.arr = new int[S];
            this.top = new int[N];
            this.next = new int[S];

            //initialize top
            for(int i = 0; i< this.top.length; i++){
                this.top[i] = -1;
            }

            //next initialize
            for(int i = 0; i< this.next.length; i++){
                this.next[i] = i+1;
                if(i == this.next.length - 1){
                    this.next[i] = -1;
                }
            }

            //freespot
            this.freespot = 0;

        }

        // x is value, m is stack
        boolean push(int x,int m){
            if(freespot == -1){
                //no free space present
                return false;
            }

            //find index
            int index = this.freespot;

            //update freespot
            this.freespot = this.next[index];

            //insert in arr
            this.arr[index] = x;

            //Update next[]
            this.next[index] = this.top[m-1];

            //Update top
            this.top[m-1] = index;

            return true;
        }

        //Pops top element from mth stack, returns -1 if stack is empty, otherwise returns popped value
        int pop(int m){
            if(top[m-1] == -1){
                return -1;
            }

            //Push commands in reverse
            int index = this.top[m-1];
            this.top[m-1] = this.next[index];
            this.next[index] = this.freespot;
            this.freespot = index;

            return this.arr[index];

        }
}


public class NStacksProblem {

     public static void main(String[] args) {
        NStacks nStacks = new NStacks(3,6);
        nStacks.push(10,1);
        nStacks.push(20,1);
        nStacks.push(30,1);
        nStacks.push(40,2);
        nStacks.pop(1);
        nStacks.push(50,1);
        nStacks.pop(1);

        for(int i = 0; i< nStacks.arr.length; i++){
            System.out.print(nStacks.arr[i]+" , ");
        }
        

    }
    
    
}
