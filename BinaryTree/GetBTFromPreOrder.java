package BinaryTree;

import java.util.ArrayList;

/**
 * Get binary tree from inorder and preorder
 */
public class GetBTFromPreOrder {
    public static int index = 0;

    static node solve(ArrayList<Integer> inorder, ArrayList<Integer> preorder, int inorderStart, int inorderEnd, int n){

        //base case
        if(index >= n || inorderStart > inorderEnd){
            return null;
        }

        int element = preorder.get(index++);

        node root = new node(element);

        root.left = solve(inorder, preorder,inorderStart, element -1, n);
        root.right = solve(inorder, preorder, element + 1, inorderEnd, n);

        return root;
    }
    public static void main(String[] args) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inorder.add(3);
        inorder.add(1);
        inorder.add(4);
        inorder.add(0);
        inorder.add(5);
        inorder.add(2);

        ArrayList<Integer> preorder = new ArrayList<>();
        preorder.add(0);
        preorder.add(1);
        preorder.add(3);
        preorder.add(4);
        preorder.add(2);
        preorder.add(5);

        int n = 6;

        node ans = solve(inorder, preorder,0, n-1 , n);
        System.out.println(ans.data);
    }
}
