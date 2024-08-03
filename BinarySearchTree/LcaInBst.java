package BinarySearchTree;

//Lowest common incestor in bst
public class LcaInBst {

    static node getLca(node root, int a , int b){
         if(root == null){
            return null;    
         }
        if(root.data < a && root.data < b){
            return getLca(root.right, a, b);
        }
        if(root.data > a && root.data > b){
            return getLca(root.left, a, b);
        }

        return root;

    }

    public static void main(String[] args) {
        node root = new node(5);
        root.left = new node(3);
        root.right = new node(9);
        root.left.left = new node(1);
        root.left.left.left = new node(0);
        root.right.left = new node(8);
        root.right.right = new node(15);

        int a = 8;
        int b = 15;
        System.out.println("lca = " + getLca(root,a,b).data);
    }
}
