package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


class PairNodeLevel{
    node node;
    int level; // level is tree levels

    public PairNodeLevel(node node, int level) {
        this.node = node;
        this.level = level;
    }
}

class LeftView {

    static List<Integer> getLeftView(node root){
        Map<Integer , Integer> nodes = new HashMap<>();
        Queue<PairNodeLevel> queue = new LinkedList();
        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        PairNodeLevel pairNodeInt = new PairNodeLevel(root, 0);
        queue.add(pairNodeInt);

        while (!queue.isEmpty()) {
            PairNodeLevel temp = queue.remove();
            node frontNode = temp.node;
            int level = temp.level;

            if(nodes.get(level) == null){ 
                nodes.put(level, frontNode.data);
            }

        
            if(frontNode.left != null){
                PairNodeLevel pair = new PairNodeLevel(frontNode.left, level + 1);
                queue.add(pair);
            }

            if(frontNode.right != null){
                PairNodeLevel pair = new PairNodeLevel(frontNode.right, level + 1);
                queue.add(pair);
            }
        }

        //storing all nodes in ans list
        List<Integer> keys = new ArrayList<>(nodes.keySet());
        Collections.sort(keys);
        for (int val : keys) {
            int i = nodes.get(val);
            ans.add(i);
        }

        return ans;
    }
    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(5);
        root.left.left = new node(3);
        root.left.right = new node(4);
        root.left.right.right = new node(7);
        root.right.right = new node(6);
        root.right.right.right = new node(8);
        root.right.right.right.right = new node(9);
        // ans = 1 2 3 7 9
        

        List<Integer> list = getLeftView(root);
        for (int li : list) {
            System.out.print(li+" ");
        }
    }
}

