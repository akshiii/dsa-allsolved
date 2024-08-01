package BinarySearchTree;

public class DeleteInBST {

    //min in bst
    static node min(node root){
        node temp = root;
        while(temp.left != null){
            temp = temp.left;
        }
        
        return temp;
    }

    //max in bst
    static node max(node root){
        node temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        
        return temp;
    }

    public static void main(String[] args) {
        node root = new node(5);
        root.left = new node(3);
        root.right = new node(9);
        root.left.left = new node(1);
        root.left.left.left = new node(0);
        root.right.left = new node(8);

        System.out.println("min in bst = "+ min(root).data);
        System.out.println("max in bst = "+ max(root).data);
    }
    
}
