package BinaryTree;

import java.util.ArrayList;

/**
 * Get binary tree from Postorder and inorder
 * Solved - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
public class GetBTFromPostorder {
    public static int index = 0;

    static int findPositionOfRoot(ArrayList<Integer> inorder, int element){
        return inorder.indexOf(element); // returns -1 if element is not found
    }
    static node solve(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int inorderStart, int inorderEnd, int n){

        //base case
        if(index < 0 || inorderStart > inorderEnd){
            return null;
        }

        int element = postorder.get(index--);

        node root = new node(element);
        int position = findPositionOfRoot(inorder, element);

        root.right = solve(inorder, postorder, position + 1, inorderEnd, n); 
        //Catch here - call for right sub tree will be made first as with post order LRN from back R comes first then L comes
        root.left = solve(inorder, postorder, inorderStart, position -1, n);
        

        return root;
    }

    static void PreOrder(node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+ " ");
        PreOrder(root.left);
        PreOrder(root.right);
    }

    public static void main(String[] args) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inorder.add(3);
        inorder.add(1);
        inorder.add(4);
        inorder.add(0);
        inorder.add(5);
        inorder.add(2);

        ArrayList<Integer> postorder = new ArrayList<>();
        postorder.add(3);
        postorder.add(4);
        postorder.add(1);
        postorder.add(5);
        postorder.add(2);
        postorder.add(0);
        int n = inorder.size();
        index = n - 1 ;
        node ans = solve(inorder, postorder,0, n-1 , n);
        
        PreOrder(ans); // 0 1 3 4 2 5
    }
}

