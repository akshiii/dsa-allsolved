package Stacks;

import java.util.Stack;

/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. 
The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
Now you want to find out who the celebrity is or verify that there is not one.
 */

public class Celebrity_Problem {
    static int findCelebrity(int[][] arr){
        Stack<Integer> stack = new Stack<>();
        for(int i= 0; i < arr.length; i++){
            stack.push(i);
        }

        while(stack.size() != 1){
            int A = stack.pop();
            int B = stack.pop();
            if(arr[A][B] == 1){
                //A knows B, hence A is not a celebrity
                stack.push(B);
            }
            else{
                //A does not know B, hence B is not a celebrity
                stack.push(A);
            }
        }
        int potentialCandidate = stack.pop();
        boolean notaCelebrity = false;
        for(int i = 0; i< arr.length; i++){
            if(arr[potentialCandidate][i] != 0){
                // row of celebrity must have all 0s, if not then its not a celebrity
                notaCelebrity = true;
            }
            if(arr[i][potentialCandidate] != 1){
                //column of celebrity must be all 1s except the diagonal element, if not then its not a celebrity
                if(i != potentialCandidate){
                    notaCelebrity = true;
                }
            }
        }
        if(notaCelebrity == true){
            return -1;
        }
        return potentialCandidate;
    }
    

    public static void main(String[] args) {
        int[][] mainArr = {
            {0,1,1,0},
            {1,0,1,1},
            {0,0,0,0},
            {0,1,1,0},
        };
        int[][] mainArr1 = {
            {0,1},
            {1,0}
        };

        System.out.println("Celebrity is = "+findCelebrity(mainArr1));
    }
}
