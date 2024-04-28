package Stacks;

//Storing N stacks in a single array
public class NStacksProblem {

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
        void push(int x,int m){
            //find index
            
        }
    }
    
    
}
