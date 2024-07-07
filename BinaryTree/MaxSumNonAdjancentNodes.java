package BinaryTree;


class PairIntInt{
    int first;
    int second; 

    public PairIntInt(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class MaxSumNonAdjancentNodes {

    static PairIntInt getMaxSum(node root){
        if(root == null){
            PairIntInt pair = new PairIntInt(0, 0);
            return pair;
        }

        PairIntInt left = getMaxSum(root.left);
        PairIntInt right = getMaxSum(root.right);

        PairIntInt res = new PairIntInt(0, 0);
        res.first = root.data + left.second + right.second;
        res.second = max(left.first, left.second) + max(right.first, right.second);
        return res;
    }

    static int max(int a, int b){
        if(a > b){
            return a;
        }
        return b;
    }
    
    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.right.left = new node(5);
        root.right.right = new node(6);

        PairIntInt ans = getMaxSum(root);
        System.out.println("max sum = " + max(ans.first,ans.second));
        
    }
}
