package BinarySearchTree;

//kth smallest element in bst
public class kthSmallest {

    static int kthValue;
    static int k = 4;

    static void findKthSmallest(node root){
        if(root == null){
            return ;
        }
        
        findKthSmallest(root.left);
        if(k != 0){
            k--;
        }
        if(k == 0){
            k--;
            kthValue = root.data;
            return;
        }
        findKthSmallest(root.right);
    }

    //TODO
    static void findKthLargest(node root){
        
    }

    public static void main(String[] args) {
        node root = new node(5);
        root.left = new node(3);
        root.right = new node(9);
        root.left.left = new node(1);
        root.left.left.left = new node(0);
        root.right.left = new node(8);
        root.right.right = new node(15);

        
        System.out.print(k+"th smallest = "); 
        findKthSmallest(root);
        System.out.print(kthValue); 
    }
    
}
