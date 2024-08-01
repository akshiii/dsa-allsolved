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

    static void InOrder(node root){
        if(root == null){
            return;
        }
        InOrder(root.left);
        System.out.print(root.data+ " ");
        InOrder(root.right);
    }

    //TODO: previous node in Inorder traversal of the Binary Tree
    static node inorderPredecesor(node root, int val){
        node temp = root;
        while(temp.data != val){
            if(val > temp.data){
                temp = temp.right;
            }
            else{
                temp = temp.left;
            }   
        }
        return max(temp.left);
    }

    //TODO
    static node inorderSuccecesor(node root, int val){
        node temp = root;
        while(temp.data != val){
            if(val > temp.data){
                temp = temp.right;
            }
            else{
                temp = temp.left;
            }   
        }
        return min(temp.right);
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
        System.out.print("Inorder => ");
        InOrder(root);

        int val = 8;
        System.out.print("Inorder predecessor of "+ val+ " => "+inorderPredecesor(root, val).data);
        // System.out.print("Inorder succecessor of "+ val+ " => "+inorderSuccecesor(root, val).data);

    }
    
}
