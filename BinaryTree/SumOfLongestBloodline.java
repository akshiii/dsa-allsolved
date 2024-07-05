package BinaryTree;

/**
 * Sum of nodes of longest path from root to leaf node
 */


class SumOfLongestBloodline {
    public static int maxSum;
    public static int maxLevel;

    static void getSum(node root, int length, int sum){

        if(root == null){
            //leaf node compare

            if(length > maxLevel){
                maxLevel = length;
                maxSum = sum;
                //System.out.println("Max sum = "+maxSum);
            }
            else if(length == maxLevel){
                maxSum = max(sum, maxSum);
            }

            return;

        }

        sum = sum + root.data;

        getSum(root.left,length+1,sum);
        getSum(root.right,length+1,sum);

    }

    static int getSumOfLongestPath(node root){

        if(root == null){
            return 0;
        }
        maxSum = 0;
        maxLevel = 0;
        getSum(root,0,0);
        return maxSum;
    }

    static int max(int a, int b){
        if(a > b){
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        node root = new node(4);
        root.left = new node(9);
        root.right = new node(6);
        root.left.left = new node(5);
        root.left.right = new node(0);
        root.right.left = new node(0);
        root.right.right = new node(3);
        root.right.left.left = new node(6);

        System.out.print(getSumOfLongestPath(root));
    }
}
