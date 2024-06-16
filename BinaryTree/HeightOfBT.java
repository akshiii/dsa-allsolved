package BinaryTree;

public class HeightOfBT{

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
        root.left.left = new node(8);
        root.left.right = new node(1);
        root.right.left = new node(15);
        root.right.right = new node(7);
        root.right.right.right = new node(2);
        System.out.println("Max Height = "+calculateHeight(root));
    }
}