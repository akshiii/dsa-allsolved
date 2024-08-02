package BinarySearchTree;


// TODO One test case not passing in https://leetcode.com/problems/validate-binary-search-tree/
//This fu below is solved
public class ValidateBST {
    static int INT_MAX = 2147483647;
    static int INT_MIN = -2147483648;


    static boolean validate(node root, int min , int max){
        if(root == null){
            return true;
        }

        if(root.data > min && root.data < max){
            boolean left = validate(root.left, min, root.data);
            boolean right = validate(root.right, root.data, max);
            return left && right;
        }
        else        
            return false;
    }

    public static void main(String[] args) {
        node root = new node(5);
        root.left = new node(3);
        root.right = new node(9);
        root.left.left = new node(1);
        root.left.left.left = new node(0);
        root.right.left = new node(8);
        root.right.right = new node(15);

        System.out.println("is bst? = "+ validate(root,INT_MIN,INT_MAX));
        
    }
}
