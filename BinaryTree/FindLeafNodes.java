package BinaryTree;

//Unsloved
//Finding no of leaf nodes in B Tree
public class FindLeafNodes {

    static void totalLeafNodes(node root,int leaf){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leaf++;
        }
        totalLeafNodes(root.left,leaf);
        totalLeafNodes(root.right,leaf);
    }

    public static void main(String[] args) {
        node root = new node(3);
        root.left = new node(9);
        root.right = new node(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new node(15);
        root.right.right = new node(7);
        int leaf = 0;
        totalLeafNodes(root,leaf);
        System.out.print("total leafs = "+leaf);
    }
}
