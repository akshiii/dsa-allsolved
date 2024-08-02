package BinarySearchTree;

public class InorderPredecessor {
    static int inorderPredecessor; 
    static boolean flag = false;   
    static int inorderSuccsessor;

    static int pre;
    static int succ;

    //Approach 1
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

    //Approach 2
    static void inorderPrede(node root, int val){

        node temp = root;
        while(temp.data != val){
            if(val > temp.data){
                temp = temp.right;
                succ = temp.data;
            }
            else{
                temp = temp.left;
                pre = temp.data;
            }   
        }

        if(temp.left != null){
            pre = max(temp.left).data;
        }
        if(temp.right != null){
            succ = min(temp.right).data;
        }
    }

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

    public static void main(String[] args) {
        node root = new node(5);
        root.left = new node(3);
        root.right = new node(9);
        root.left.left = new node(1);
        root.left.left.left = new node(0);
        root.right.left = new node(8);
        root.right.right = new node(15);

        int val = 9;
        find(root, val);
        InOrder(root);
        System.out.println();
        
        inorderPrede(root, val);
        System.out.println("For value =  "+ val+ " pre = "+ pre+" succ = "+ succ);

    }
    
}
