package BinaryTree;

class PairBool {
    boolean first;
    int second;

    public PairBool(boolean first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class SumTree {

    static PairBool isSumTreeFast(node root){
        if(root == null){
            PairBool p = new PairBool(true, 0);
            return p;
        }

        if(root.left == null && root.right == null){
            //leaf node
            PairBool p = new PairBool(true, root.data);
            return p;
        }

        PairBool left = isSumTreeFast(root.left);
        PairBool right = isSumTreeFast(root.right);

        boolean leftAns = left.first;
        boolean rightAns = right.first;

        boolean sumEqual = root.data == left.second + right.second;

        PairBool ans = new PairBool(false, 0);
        ans.second = root.data + left.second + right.second;

        if(leftAns && rightAns && sumEqual){
            ans.first = true;
        }
        else{
            ans.first = false;
        }
        return ans;
    }

    static boolean isSumTree(node root){
        return isSumTreeFast(root).first;
    }
    

    public static void main(String[] args) {
        node root = new node(3);
        root.left = new node(2);
        root.right = new node(1);
        // root.left.left = new node(6);
        // root.left.right = new node(5);
        // root.right.left = new node(15);
        // root.right.right = new node(7); 
        // root.right.left.left = new node(4);

        System.out.println("is sum tree? = "+isSumTree(root));
    }
}
