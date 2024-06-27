package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Difference between TopView and BottomView is that the condition at line no 41 is not there, 
//as for BottomView we now want to override the upper nodes to latest(lower) nodes.
//For TopView once we get a node for a particular hd ( horizontal distance) we will not consider other nodes. 
//but for BottomView we will override the hd with latest node 
class PairNodeInt{
    node node;
    int hd; // hd is horizontal distance

    public PairNodeInt(node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class BottomView {

    static List<Integer> getBottomView(node root){
        Map<Integer , Integer> nodes = new HashMap<>();
        Queue<PairNodeInt> queue = new LinkedList();
        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        PairNodeInt pairNodeInt = new PairNodeInt(root, 0);
        queue.add(pairNodeInt);

        while (!queue.isEmpty()) {
            PairNodeInt temp = queue.remove();
            node frontNode = temp.node;
            int hd = temp.hd;

            // if(nodes.get(hd) == null){ 
                nodes.put(hd, frontNode.data);
            // }

        
            if(frontNode.left != null){
                PairNodeInt pair = new PairNodeInt(frontNode.left, hd - 1);
                queue.add(pair);
            }

            if(frontNode.right != null){
                PairNodeInt pair = new PairNodeInt(frontNode.right, hd + 1);
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
        root.right = new node(4);
        root.left.left = new node(3);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);// ans = 3 2 6 4 7
        

        List<Integer> list = getBottomView(root);
        for (int li : list) {
            System.out.print(li+" ");
        }
    }
}

