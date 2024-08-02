package BinarySearchTree;

public class InorderPredecessor {
    static int inorderPredecessor; 
    static boolean flag = false;   
    static int inorderSuccsessor;

    static void find(node root, int val){
        if(root == null){
            return ;
        }
        
        find(root.left, val);
        if(root.data == val){
            flag = true;
            System.out.println("Pre = "+ inorderPredecessor);
        }
        else {
            if(flag != true){
                inorderPredecessor = root.data;
            }
            else{
                inorderSuccsessor = root.data;
                System.out.println("Succ = "+ inorderSuccsessor);
                flag = false;
            }
        }
        find(root.right,val);
    }

    static void InOrder(node root){
        if(root == null){
            return;
        }
        InOrder(root.left);
        System.out.print(root.data+ " ");
        InOrder(root.right);
    }

    public static void main(String[] args) {
        node root = new node(5);
        root.left = new node(3);
        root.right = new node(9);
        root.left.left = new node(1);
        root.left.left.left = new node(0);
        root.right.left = new node(8);
        root.right.right = new node(15);

        
        find(root, 9);
        InOrder(root);
        System.out.println();
    }
    
}
