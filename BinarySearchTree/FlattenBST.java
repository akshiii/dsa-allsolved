package BinarySearchTree;

import java.util.ArrayList;

//Flatten bst to a sorted list
public class FlattenBST {
    static ArrayList<Integer> arr = new ArrayList<>(); 


    static void InOrder(node root){
        if(root == null){
            return;
        }
        InOrder(root.left);
        arr.add(root.data);
        System.out.print(root.data+ " ");
        InOrder(root.right);
    }

    static node flatten(node root){
        InOrder(root);

        node newRoot = new node(arr.get(0));
        node curr = newRoot;

        int size = arr.size();
        for(int i = 1; i < size; i++){
            node temp = new node(arr.get(i));
            curr.left = null;
            curr.right = temp;
            curr = temp;
        }

        curr.left = null;
        curr.right = null;

        return newRoot;
    }

    public static void main(String[] args) {
        node root = new node(4);
        root.left = new node(3);
        root.right = new node(16);
        root.left.left = new node(1);
        root.left.left.left = new node(0);
        root.right.left = new node(8);

        node nn = flatten(root);
        System.out.println("new ="+ nn.data);
    }
}
