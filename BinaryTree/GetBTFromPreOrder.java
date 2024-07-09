package BinaryTree;

import java.util.ArrayList;

/**
 * Get binary tree from inorder and preorder
 * Solved - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
public class GetBTFromPreOrder {
    public static int index = 0;

    static int findPositionOfRoot(ArrayList<Integer> inorder, int element){
        return inorder.indexOf(element);
    }
    static node solve(ArrayList<Integer> inorder, ArrayList<Integer> preorder, int inorderStart, int inorderEnd, int n){

        //base case
        if(index >= n || inorderStart > inorderEnd){
            return null;
        }

        int element = preorder.get(index++);

        node root = new node(element);
        int position = findPositionOfRoot(inorder, element);

        root.left = solve(inorder, preorder, inorderStart, position -1, n);
        root.right = solve(inorder, preorder, position + 1, inorderEnd, n);

        return root;
    }

    static void PostOrder(node root){
        if(root == null){
            return;
        }
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data+ " ");
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
        int n = inorder.size();
        node ans = solve(inorder, preorder,0, n-1 , n); // 3 4 1 5 2 0
        
        PostOrder(ans);
    }
}
