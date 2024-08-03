package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

//Two sum in a BST
public class TwoSumBst {
    static ArrayList<Integer> inorder = new ArrayList<>();
    static int node1;
    static int node2;

    static void InOrder(node root){
        if(root == null){
            return;
        }
        InOrder(root.left);
        inorder.add(root.data);
        System.out.print(root.data+ " ");
        InOrder(root.right);
    }

    static void twoSum(node root, int sum){
        int arraySize = inorder.size();
        int i = 0;
        int j = arraySize - 1;

        while(i< j ){
            if(inorder.get(i) + inorder.get(j) == sum){
                node1 = inorder.get(i);
                node2 = inorder.get(j);
                return;
            }
            else if(inorder.get(i) + inorder.get(j) > sum){
                j--;
            }
            else{
                i++;
            }
        }
        
    }
    
    public static void main(String[] args) {
        node root = new node(4);
        root.left = new node(3);
        root.right = new node(6);
        root.left.left = new node(1);
        root.left.left.left = new node(0);
        root.right.left = new node(8);
        root.right.right = new node(15);

        int sum = 12;
        InOrder(root);
        twoSum(root, sum);
        System.out.println("node1 = "+ node1 + " node2 = "+ node2);
    }
}
