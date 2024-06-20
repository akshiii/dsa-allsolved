package BinaryTree;


//Longest path between 2 end nodes( end nodes can be leaf node or root node)

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
}

class DiameterOfBt{

    //Optimized approach - TC- O(n)
    static Pair diameterFast(node root){
        if(root == null){
            Pair pair = new Pair(0, 0);
            return pair;
        }

        Pair left = diameterFast(root.left);
        Pair right = diameterFast(root.right);

        int op1 = left.first;
        int op2 = right.first;
        int op3 = left.second + right.second + 1;

        Pair ans = new Pair(0, 0);
        ans.first = max(op1, max(op2, op3));
        ans.second = max(left.second, right.second) + 1;

        return ans;
    }
    
    static int diameter(node root){
        return diameterFast(root).first;
    }


    //TC => O(n2) Unoptimized solution
    static int diameterOfBinaryTree(node root) {
        if(root == null){
            return 0;
        }

        int op1 = diameterOfBinaryTree(root.left);
        int op2 = diameterOfBinaryTree(root.right);
        int op3 = height(root.left) + height(root.right) + 1;
        int ans = max(op1, max(op2,op3));

        return ans;
    }

    static int height(node root){
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        int ans = max(left,right)+1;

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

        System.out.println("Diameter = "+diameter(root));
    }
}