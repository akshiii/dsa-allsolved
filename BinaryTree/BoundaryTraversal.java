package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    
    static void printBoundaryTraversal(node root){
        List<Integer> leftNodes = new ArrayList<>();
        
        if( root == null){
            return;
        }

        if(root.left == null && root.right == null){
            //leaf node
            return;
        }

        if(root.left == null && root.right != null){
            //right node
            leftNodes.add(root.data);
            printBoundaryTraversal(root.left);
            return;
        }
        else{
            leftNodes.add(root.data);
            printBoundaryTraversal(root.left);
        }
    }

    static void printLeftNodes(node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }

        System.out.print( root.data + " , ");
        printLeftNodes(root.left);
    }

    static void printLeafNodes(node root){

    }

    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(4);
        root.left.left = new node(3);
        root.left.right = new node(5);
        root.left.right.left = new node(6);
        root.left.right.right = new node(8);
        root.right.right = new node(7);
        root.right.right.right = new node(9);
        root.right.right.right.left = new node(10);
        root.right.right.right.right = new node(11);


        //ans 1 2 3 6 8 10 11 9 7 4
        printBoundaryTraversal(root);
    }
}
