package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Unsolved, partially solved
public class ZigZagTraversal {

    static List<List<Integer>> zigzagLevelOrder(node root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        // List<Integer> smallList = new ArrayList<>();
        Queue<node> queue = new LinkedList();
        boolean leftToRight = true;

        if(root == null){
            return levelOrderList;
        }
        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();
            List<Integer> smallList = new ArrayList<>();

            //Level Process
            for(int i = 0; i < size; i++){   
                node frontNode = queue.remove();

                //normal insert of reverse insert
                int index = leftToRight ? i : size - i -1;
                System.out.print(frontNode.data+" ");
                smallList.add(frontNode.data);

                if(leftToRight){
                    if(frontNode.right != null){
                        queue.add(frontNode.right);
                    }

                    if(frontNode.left != null){
                        queue.add(frontNode.left);
                    }
                }
                else{
                    if(frontNode.left != null){
                        queue.add(frontNode.left);
                    }

                    if(frontNode.right != null){
                        queue.add(frontNode.right);
                    }
                }
            }
            leftToRight = !leftToRight;

            System.out.print(" , ");
            levelOrderList.add(smallList);
        }

        return levelOrderList;
    }
    

    public static void main(String[] args) {
        node root = new node(3);
        root.left = new node(9);
        root.right = new node(20);
        root.left.left = new node(6);
        root.left.right = new node(1);
        root.right.left = new node(15);
        root.right.right = new node(7);
        root.right.right.left = new node(8);
        root.right.right.right = new node(2);
        root.right.left.left = new node(5);
        root.right.left.right = new node(4);
        //ans - 3, 20 9 , 6 1 15 7 , 2 8 4 5

        List<List<Integer>> list = zigzagLevelOrder(root);

    }
}
