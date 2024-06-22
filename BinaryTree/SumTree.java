package BinaryTree;

public class SumTree {

    static boolean isSumTree(node root){
        return true;
    }
    

    public static void main(String[] args) {
        node root = new node(3);
        root.left = new node(9);
        root.right = new node(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new node(15);
        root.right.right = new node(7); 
        // root.right.left.left = new node(4);

        System.out.println("is balanced? = "+isSumTree(root));
    }
}
