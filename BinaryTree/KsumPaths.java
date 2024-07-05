package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//TODO: Unsolved
public class KsumPaths {
    public static int count;

    static void paths(node root, int k , Queue<Integer> queue){
        if(root == null){
            return ;
        }
        queue.add(root.data);

        paths(root.left, k, queue);
        paths(root.right, k, queue);

        int sum = 0;
        while(!queue.isEmpty()){
            sum = sum + queue.remove();
            if(sum == k){
                count++;
            }
        }
    }

    static int getTotalPaths(node root, int k){
        Queue<Integer> queue = new LinkedList();
        count = 0;
        paths(root, k, queue);
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
