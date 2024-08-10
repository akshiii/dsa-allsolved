package BinarySearchTree;

//Lasrgest Bst in binary tree

class Info {
    int maxi;
    int mini;
    boolean isBst;
    int size;

    public Info(){}
    public Info(int maxi, int mini, boolean isBst, int size){
        this.maxi = maxi;
        this.mini = mini;
        this.isBst = isBst;
        this.size = size;
    }
}

public class LargestBstInBT {
    static int maxSize = 0;
    static int INT_MAX = 2147483647;
    static int INT_MIN = -2147483648;

    static Info solve(node root){
        if(root == null){
            return new Info(INT_MIN, INT_MAX, true, 0);
        }

        Info left = solve(root.left);
        Info right = solve(root.right);

        Info currNode = new Info();
        currNode.size = left.size + right.size +1;
        currNode.maxi = max(root.data, right.maxi);
        currNode.mini = min(root.data, left.mini);

        if(left.isBst && right.isBst && root.data > left.maxi && root.data < right.mini){
            currNode.isBst = true;
        }
        else{
            currNode.isBst = false;
        }

        if(currNode.isBst){
            maxSize = max(maxSize, currNode.size);
        }

        return currNode;
    }
    static int max(int a, int b){
        if(a > b){
            return a;
        }
        return b;
    }
    static int min(int a, int b){
        if(a > b){
            return b;
        }
        return a;
    }

    public static void main(String[] args) {
        node root = new node(5);
        root.left = new node(2);
        root.right = new node(4);
        root.left.left = new node(1);
        root.left.right = new node(3);

        Info temp = solve(root);
        System.out.println("Max size = "+ maxSize);
    }
}
