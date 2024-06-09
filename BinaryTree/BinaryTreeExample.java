package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
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
    static void levelOrderTraversal(node root){
        Queue<node> queue = new LinkedList();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            node temp = queue.remove();
            
            if(temp == null){
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                System.out.println();
            }

            else{
                System.out.print(" "+temp.data);
                if(temp.left != null){
                    queue.add(temp.left);
                }

                if(temp.right != null){
                    queue.add(temp.right);
                }
            }      
        }
              
    }

    public static void main(String[] args) {
        node root = new node(0);
        node newRoot = createBinaryTree(root);
        System.out.println("Done!!");
        levelOrderTraversal(newRoot);

    }
}
