package BinaryTree;

class Pair {
    boolean first;
    int second;

    public Pair(boolean first, int second) {
        this.first = first;
        this.second = second;
    }
}

class PairOfInt {
    int first;
    int second;

    public PairOfInt(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

//Checking if a tree is balanced or not
public class BalancedBT {

    static Pair isBalancedFast(node root) {
        if( root == null){
            Pair p = new Pair(true, 0);
            return p;
        }

        Pair left = isBalancedFast(root.left);
        Pair right = isBalancedFast(root.right);

        boolean leftAns = left.first;
        boolean rightAns = right.first;

        boolean diff = Math.abs(left.second - right.second) <= 1;

        Pair ans = new Pair(false, 0);
        ans.second = max(left.second, right.second) + 1;
        if(leftAns && rightAns && diff){
            ans.first = true;
        }
        else{
            ans.first = false;
        }
        return ans;
    }

    static boolean balanced(node root){
        return isBalancedFast(root).first;
    }

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
        // root.right.left.left = new node(4);

        System.out.println("is balanced? = "+isBalanced(root));
    }
    
}
