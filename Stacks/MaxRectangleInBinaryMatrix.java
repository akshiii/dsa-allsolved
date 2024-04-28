package Stacks;

import java.util.Stack;

//Finding max rectangle in binary matrix
public class MaxRectangleInBinaryMatrix {

        
    static int[] nextSmallerElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] newArr = new int[arr.length];
        for(int i = arr.length-1; i >= 0; i--){
            while(stack.lastElement() != -1 && arr[stack.lastElement()] >= arr[i]){
                stack.pop();
            }
            newArr[i] = stack.lastElement();
            //Storing elemnet index instaed of values
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
             //Storing elemnet index instaed of values
            stack.push(i);
        }
        return newArr;
    }

    static int findLargestArea(int[] arr){

        //Finding next smaller elements of arr ( elemnet index)
        int[] nextSmallerEl = nextSmallerElement(arr);
         //Finding previous smaller elements of arr (elemnet index)
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

    static int findMaxRectangleInMatrix(int[][] arr){
        int maxArea = 0;
        int[] histogram = new int[arr.length];
        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j< arr.length; j++){
                if(i == 0){
                    histogram[j] = arr[i][j];
                }
                else{
                    if(arr[i][j] == 0){
                        histogram[j] = 0;
                    }
                    else{
                        histogram[j] = histogram[j] + arr[i][j];
                    }
                    
                }
                
            }

            //Give this histogram to findLargestArea in historgram
            int histogramArea = findLargestArea(histogram);
            if(histogramArea > maxArea){
                maxArea = histogramArea;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] mainArr = {
            {0,1,1,0},
            {1,1,1,1},
            {1,1,1,1},
            {1,1,0,0},
        };
        int[][] mainArr1 = {
            {0,1,1,0},
            {1,1,1,0},
            {0,1,1,0},
            {1,1,0,0},
        };
        System.out.println("Max area = "+findMaxRectangleInMatrix(mainArr));
    }
    
}
