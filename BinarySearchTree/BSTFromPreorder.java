package BinarySearchTree;

import java.util.ArrayList;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
public class BSTFromPreorder {

    static void makeBst(ArrayList<Integer> postorder){

    }

    public static void main(String[] args) {

        ArrayList<Integer> postOrder = new ArrayList<>(); 
        postOrder.add(20);
        postOrder.add(10);
        postOrder.add(5);
        postOrder.add(15);
        postOrder.add(13);
        postOrder.add(35);
        postOrder.add(30);
        postOrder.add(42);

        makeBst(postOrder);

        System.out.println("is balanced? =");
    }
}
