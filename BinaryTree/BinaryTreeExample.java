package BinaryTree;

import java.util.Scanner;

class node{
    int data;
    node left;
    node right;

    node(int d){
        this.data = d;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeExample {

    static node createBinaryTree(node root){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data: ");
        int rootData = sc.nextInt();
        root = new node(rootData);

        if(rootData == -1){
            return null;
        }

        System.out.println("Enter data for inserting in left of "+rootData);
        root.left = createBinaryTree(root.left);

        System.out.println("Enter data for inserting in right of "+rootData);
        root.right = createBinaryTree(root.right);

        return root;
    }

    
    //Breadth first search
    static void levelOrderTraversal(){

    }

    public static void main(String[] args) {
        node root = new node(0);
        createBinaryTree(root);
        System.out.println("Done!!");

    }
}
