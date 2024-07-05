package BinaryTree;

/**
 * Lowest Common Ancestor of any given 2 nodes in a Binary Tree
 */
public class LowestCommonAncestor {

    static node getLCA(node root, int n1, int n2){
        if(root == null){
            return null;
        }

        if(root.data == n1 || root.data == n2){
            System.out.println(root.data);
            return root;
        }

        node leftAns = getLCA(root.left, n1, n2);
        node rightAns = getLCA(root.right, n1, n2);

        if(leftAns != null && rightAns!= null){
            return root;
        }
        else if(leftAns == null && rightAns!= null){
            return rightAns;
        }
        else if(leftAns != null && rightAns == null){
            return leftAns;
        }
        else{
            //both are null
            return null;
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

        node ans = getLCA(root,3,2); //6
        System.out.println(ans.data);
    }
}
