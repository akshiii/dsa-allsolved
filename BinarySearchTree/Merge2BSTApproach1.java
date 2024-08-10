package BinarySearchTree;

import java.util.ArrayList;

//This approach has TC= O(n) and SC= O(n)
public class Merge2BSTApproach1 {
    static ArrayList<Integer> arr1 = new ArrayList<>(); 
    static ArrayList<Integer> arr2 = new ArrayList<>(); 
    static ArrayList<Integer> arr3 = new ArrayList<>(); 


    static void InOrder(node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        InOrder(root.left, arr);
        System.out.print(root.data+ " ");
        arr.add(root.data);
        InOrder(root.right,arr);
    }

    static void merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2){

        int n = 0 , m = 0;
        int finalArray = 0;
        while( n < arr1.size() && m < arr2.size()){
            if(arr1.get(n) < arr2.get(m)){
                arr3.add(arr1.get(n));
                n++;

                // arr3[finalArray++] = arr1[n++];
            }
            else{
                arr3.add(arr2.get(m));
                m++;
                //  arr3[finalArray++] = arr2[m++];
            }
        }

        //copy remaining element of first array if any
        while( n < arr1.size()){
            arr3.add(arr1.get(n));
            n++;
        }
        //copy remaining element of second array if any
        while(m < arr2.size()){
            arr3.add(arr2.get(m));
            m++;
        }
    }

    static node inorderToBst(int s, int e){
        if(s > e){
            return null;
        }

        int mid = (s+e) / 2;
        node root = new node(arr3.get(mid));
        root.left = inorderToBst(s, mid -1);
        root.right = inorderToBst(mid+1, e);
        return root;
    }

    public static void main(String[] args) {
        node root1 = new node(5);
        root1.left = new node(3);
        root1.right = new node(9);
        root1.left.left = new node(1);
        root1.right.left = new node(8);

        node root2 = new node(4);
        root2.left = new node(2);
        root2.right = new node(6);
        root2.right.right = new node(7);

        //Step1: Inorder for both bst's
        InOrder(root1, arr1);
        InOrder(root2, arr2);

        //Step2: Merge these 2 sorted arrays
        merge(arr1, arr2);

        //Step 3: Convert this big inorder (array3) to a bst
        node newbst = inorderToBst(0, arr3.size()-1);
        System.out.println("merged bst =" + newbst.data);
    }
}
