package BinaryTree;


//Checking if a tree is balanced or not
public class BalancedBT {

    static boolean isBalanced(node root) {
        
    }

    public static void main(String[] args) {
        node root = new node(3);
        root.left = new node(9);
        root.right = new node(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new node(15);
        root.right.right = new node(7); 

        System.out.println("is balanced? = "+isBalanced(root));
    }
    
}
