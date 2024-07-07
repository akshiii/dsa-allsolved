package BinaryTree;
import java.util.ArrayList;


/**
 * K th ancestor in a BT
 */
public class KAncestorInTree {

    static node kAnces(node root, int k, ArrayList<Integer> arr){
        if(root == null){
            return null;
        }

        if(root.data == k ){
            System.out.println(root.data);
            arr.add(root.data);
            return root;
        }

        node leftAns = kAnces(root.left, k, arr);
        node rightAns = kAnces(root.right, k,arr);

        if((leftAns != null || rightAns!= null) && !arr.isEmpty()){
            arr.add(root.data);
            return root;
        }
        else{
            return null;
        }
    }

    static int getKAncestor(node root,int n1, int k){
        ArrayList<Integer> path = new ArrayList<Integer>(); // Create an ArrayList object
        kAnces(root, n1,path);
        if(path.size() <= k){
            return -1;
        }
        return path.get(k);        
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

        
        System.out.println("Ancestor = "+getKAncestor(root,2, 3)); // Find 2nd ancestor of 3
    }
}
