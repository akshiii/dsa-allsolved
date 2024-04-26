package Stacks;

import java.util.Stack;

public class LargestRectangleInHistorgram {
    
    static int[] nextSmallerElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] newArr = new int[arr.length];
        for(int i = arr.length-1; i >= 0; i--){
            while(stack.lastElement() != -1 && arr[stack.lastElement()] >= arr[i]){
                stack.pop();
            }
            newArr[i] = stack.lastElement();
            stack.push(i);
        }
        return newArr;
    }

    static int[] prevSmallerElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] newArr = new int[arr.length];
        for(int i = 0; i < arr.length ; i++){
            while(stack.lastElement() != -1 && arr[stack.lastElement()] >= arr[i]){
                stack.pop();
            }
            newArr[i] = stack.lastElement();
            stack.push(i);
        }
        return newArr;
    }

    static int findLargestArea(int[] arr){

        int[] nextSmallerEl = nextSmallerElement(arr);
        int[] prevSmallerEl = prevSmallerElement(arr);

        int area = 0;
        for(int i = 0; i< arr.length ; i++){
            int length = arr[i];
            if(nextSmallerEl[i] == -1){
                nextSmallerEl[i] = arr.length;
            }
            int breadth = nextSmallerEl[i] - prevSmallerEl[i] - 1;

            int newArea = length * breadth;
            if(newArea > area){
                area = newArea;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        int area = findLargestArea(arr);
        System.out.println("Area => "+ area);
    }
}
