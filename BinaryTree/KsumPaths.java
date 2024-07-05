package BinaryTree;

import java.util.ArrayList;

public class KsumPaths {
    public static int count;

    static void paths(node root, int k , ArrayList<Integer> path){
        if(root == null){
            return ;
        }
        path.add(root.data);

        paths(root.left, k, path);
        paths(root.right, k, path);

        int sum = 0;
        int size = path.size();
        for(int i = size - 1; i >= 0 ; i--){
            sum = sum + path.get(i);
            if(sum == k){
                count++;
            }
        }
        path.remove(size - 1);
    }

    static int getTotalPaths(node root, int k){
        ArrayList<Integer> path = new ArrayList<Integer>(); // Create an ArrayList object
        count = 0;
        paths(root, k, path);
        return count;
    }

    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.right.left = new node(4);

        System.out.println("total paths = "+getTotalPaths(root,3));
    }
}
