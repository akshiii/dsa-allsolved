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

    static node delete(node root, int val){
        if(root == null){
            return root;
        }

        if(root.data == val){
            //0 child
            if(root.left == null && root.right == null){
                return null;
            }

            //1 child -> has 2 cases
              // only left child
              if(root.left != null && root.right == null){
                return root.left;
              }

              //only right child
              if(root.left == null && root.right != null){
                return root.right;
              }

            //2 child
            if(root.left != null && root.right != null){
                //Either take min of right subtree or take max of left subtree and set it as new node 
                node mini = min(root.right);
                root.data = mini.data;
                //delete this mini 
                root.right = delete(root.right, mini.data);
                return root;
            }

        }
        else if(root.data > val){
            root.left = delete(root.left, val);
            return root;
        }
        else{
            root.right = delete(root.right, val);
            return root;
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

        System.out.println("min in bst = "+ min(root).data);
        System.out.println("max in bst = "+ max(root).data);
        System.out.print("Inorder => ");
        InOrder(root);

        // int val = 8;
        // System.out.print("Inorder predecessor of "+ val+ " => "+inorderPredecesor(root, val).data);
        // System.out.print("Inorder succecessor of "+ val+ " => "+inorderSuccecesor(root, val).data);

        int nodeToDelete = 1;
        node newnode = delete(root, nodeToDelete);
        System.out.println("Node deleted " + nodeToDelete);
        InOrder(newnode);
    }
    
}
