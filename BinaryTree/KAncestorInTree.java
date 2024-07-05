package BinaryTree;
import java.util.ArrayList;


/**
 * K th ancestor in a BT
 */
public class KAncestorInTree {

    public static void kthAncestor(node root,ArrayList<Integer> arr, int n1, int k){
        if(root == null){
            return ;
        }
        if(root.data == n1){
            return ;
        }

        arr.add(root.data);

        kthAncestor(root.left,arr, n1, k);
        kthAncestor(root.right,arr, n1, k);

        if(root.data == n1){
            return ;
        }
    }

    public static void main(String[] args) {
        node root = new node(4);
        root.left = new node(9);
        root.right = new node(6);
        root.left.left = new node(5);
        root.left.right = new node(0);
        root.right.left = new node(1);
        root.right.right = new node(3);
        root.right.left.left = new node(2);

        ArrayList<Integer> arr = new ArrayList<Integer>();
        kthAncestor(root,arr,3, 2); // Find 2nd ancestor of 3
        System.out.println(arr.get(arr.size() -1 - 2));
    }
}
