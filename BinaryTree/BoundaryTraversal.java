package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    
    static void printBoundary(node root){
        printLeftNodes(root);
        // System.out.println("");
        printLeafNodes(root);
        // System.out.println("");
        printRightNodes(root.right);
    }

    static void printLeftNodes(node root){
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
            System.out.print( root.data + " , ");
            leftNodes.add(root.data);
            printLeftNodes(root.right);
            return;
        }
        else{
            System.out.print( root.data + " , ");
            leftNodes.add(root.data);
            printLeftNodes(root.left);
        }
    }

    static void printLeafNodes(node root){
        if( root == null){
            return;
        }

        
        if(root.left == null && root.right == null){
            //leaf node
            System.out.print( root.data + " , ");
        }
        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }

    static void printRightNodes(node root){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            return;
        }

        if(root.left != null && root.right == null){
            printRightNodes(root.left);
            System.out.print( root.data + " , ");
        }
        else{
            printRightNodes(root.right);
            System.out.print( root.data + " , ");
        }
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
        root.right.right.right.right = new node(11);//ans 1 2 3 6 8 10 11 9 7 4
        printBoundary(root);
    }
}
