package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Leetcode- 102 Solved
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrder(node root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        List<Integer> smallList = new ArrayList<>();
        Queue<node> queue = new LinkedList();
        if(root == null){
            return levelOrderList;
        }
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            node temp = queue.remove();
            
            if(temp == null){
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                System.out.println();
                levelOrderList.add(new ArrayList(smallList));
                smallList.clear();
            }

            else{   
                System.out.print(" "+temp.data);
                smallList.add(temp.data);
                if(temp.left != null){
                    queue.add(temp.left);
                }

                if(temp.right != null){
                    queue.add(temp.right);
                }
            }     
        }
                
        
        return levelOrderList;
    }

    public static void main(String[] args) {
        // Input: root = [3,9,20,null,null,15,7]
        node root = new node(3);
        root.left = new node(9);
        root.right = new node(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new node(15);
        root.right.right = new node(7);
        levelOrder(root);

    }
}
