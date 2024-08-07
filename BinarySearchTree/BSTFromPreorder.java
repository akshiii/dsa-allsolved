package BinarySearchTree;

import java.util.ArrayList;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
public class BSTFromPreorder {
    static ArrayList<Integer> preOrder = new ArrayList<>();
    static node curr = null;
    static node temp = null;

    static node makeBst(int min, int max, int i){
        if(i >= preOrder.size()){
            return null;
        }

        if(preOrder.get(i)< min || preOrder.get(i) > max){
            return null;
        }

        node root = new node(preOrder.get(i++));
        root.left = makeBst(min, root.data, i);
        root.right = makeBst(root.data, max, i);
        return  root;
    }

    // static node makeBst(){
    //     node curr = new node(preOrder.get(0));

    //     node temp = curr;
        

    //     while(temp != null){
    //         temp.left
    //     }
        
    //     return curr;
    // }

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

        curr = new node(preOrder.get(0));
        temp = curr;
        makeBst(INT_MIN, INT_MAX, 1);

        System.out.println("bst  ="+ curr.data);
    }
}
