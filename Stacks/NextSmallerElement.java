package Stacks;

import java.util.Stack;

//input-> [ 2, 1, 4, 3]
//output ->  [ 1, -1, 3, -1]
public class NextSmallerElement {

    static int[] findNextSmallest(int[] arr){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] newArr = new int[arr.length];
        for(int i = arr.length-1; i >= 0; i--){
            while(stack.lastElement() >= arr[i]){
                stack.pop();
            }
            newArr[i] = stack.lastElement();
            stack.push(arr[i]);
        }
        return newArr;
    }
    
    public static void main(String[] args) {
        int[] arr = {2,1,4,3};
        int[] newArr = findNextSmallest(arr);
        for(int i: newArr){
            System.out.print(i+" , ");
        }
    }
}
