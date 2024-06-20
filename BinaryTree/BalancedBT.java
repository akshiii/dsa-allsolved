package BinaryTree;


//Checking if a tree is balanced or not
public class BalancedBT {

    //Unoptimized approach
    static boolean isBalanced(node root) {
        if( root == null){
            return true;
        }

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        boolean diff = Math.abs(calculateHeight(root.left) - calculateHeight(root.right)) <= 1;

        if(left && right && diff){
            return true;
        }
        else    
            return false;

    }

    static int calculateHeight(node root){
        if(root == null){
            return 0;
        }

        int left = calculateHeight(root.left);
        int right = calculateHeight(root.right);

        int ans = max(left,right)+ 1;
        return ans;
    }

    static int max(int a, int b){
        if(a > b){
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        node root = new node(3);
        root.left = new node(9);
        root.right = new node(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new node(15);
        root.right.right = new node(7); 
        root.right.left.left = new node(4);

        System.out.println("is balanced? = "+isBalanced(root));
    }
    
}
