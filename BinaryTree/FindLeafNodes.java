package BinaryTree;

//Finding no of leaf nodes in B Tree
public class FindLeafNodes {

    static int totalLeafNodes(node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return totalLeafNodes(root.left) + totalLeafNodes(root.right);
    }

    public static void main(String[] args) {
        //ans - 3
        node root = new node(3);
        root.left = new node(9);
        root.right = new node(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new node(15);
        root.right.right = new node(7);

        //ans - 4

        // node root = new node(1);
        // root.left = new node(3);
        // root.right = new node(5);
        // root.left.left = new node(7);
        // root.left.right = new node(11);
        // root.right.left = new node(17);
        // root.right.right = null;
        System.out.print("total leafs = " + totalLeafNodes(root));
    }
}
