package BinaryTree;
import java.util.ArrayList;


/**
 * K th ancestor in a BT
 */
public class KAncestorInTree {
    public static int kth;

    /**
     * Here we are traversing the tree from root to k(our destination node) then as we find it,
     * we will store the path from that node till root node, in a reverse manner in an array.
     * This basic approach to traverse a tree must be remembered always.
     */
    static node kAnces(node root, int k, ArrayList<Integer> arr){
        if(root == null){
            return null;
        }

        if(root.data == k ){
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

    static node approach2(node root, int n1){
        if(root == null){
            return null;
        }

        if(root.data == n1){
            return root;
        }

        node leftAns = approach2(root.left, n1);
        node rightAns = approach2(root.right, n1);

        if(leftAns != null && rightAns == null){
            kth--;
            if(kth <= 0){
                return root;
            }
            return leftAns;
        }

        if(rightAns != null && leftAns == null){
            kth--;
            if(kth <= 0){
                return root;
            }
            return rightAns;
        }

        return null;
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

        kth = 3;
        System.out.println("Ancestor approach 2 = "+approach2(root,2).data);

        System.out.println("Ancestor = "+getKAncestor(root,2, 3)); // Find 2nd ancestor of 3
    }
}
