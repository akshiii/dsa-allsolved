package BinarySearchTree;

import java.util.ArrayList;

//https://leetcode.com/problems/balance-a-binary-search-tree/submissions/1344225819/
public class BalancedBST {
    static ArrayList<Integer> arr = new ArrayList<>(); 

    static void InOrder(node root){
        if(root == null){
            return;
        }
        InOrder(root.left);
        arr.add(root.data);
        InOrder(root.right);
    }

    //balance a bst
    static node inorderToBst(int s, int e){
        if(s > e){
            return null;
        }

        int mid = (s+e) / 2;
        node root = new node(arr.get(mid));
        root.left = inorderToBst(s, mid -1);
        root.right = inorderToBst(mid+1, e);
        return root;
    }

    public static void main(String[] args) {
        node root = new node(10);
        root.left = new node(8);
        root.right = new node(12);
        root.left.left = new node(4);
        root.left.left.left = new node(2);
        root.right.right = new node(16);

        InOrder(root);
        inorderToBst(0, arr.size()-1);
        System.out.println("is balanced? =");
    }
}
