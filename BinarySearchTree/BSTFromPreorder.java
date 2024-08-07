package BinarySearchTree;

import java.util.ArrayList;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
public class BSTFromPreorder {
    static ArrayList<Integer> preOrder = new ArrayList<>();
    static int i = 0;

    static node makeBst(int min, int max){
        if(i >= preOrder.size()){
            return null;
        }

        if(preOrder.get(i)< min || preOrder.get(i) > max){
            return null;
        }

        node root = new node(preOrder.get(i++));
        root.left = makeBst(min, root.data);
        root.right = makeBst(root.data, max);
        return  root;
    }

     static void InOrder(node root){
        if(root == null){
            return;
        }
        InOrder(root.left);
        System.out.print(root.data+ " ");
        InOrder(root.right);
    }
    public static void main(String[] args) {

        preOrder.add(20);
        preOrder.add(10);
        preOrder.add(5);
        preOrder.add(15);
        preOrder.add(13);
        preOrder.add(35);
        preOrder.add(30);
        preOrder.add(42);

        int INT_MAX = 2147483647;
        int INT_MIN = -2147483648;
        node newnode = makeBst(INT_MIN, INT_MAX);
        InOrder(newnode);
    }
}
