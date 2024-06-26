package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Unsolved
public class VerticalTraversal {

    static List<Integer> verticalList(node root){
        Map<Integer,Map<Integer, List<Integer>>> nodes = new HashMap<>();
        Queue<PairNode> queue = new LinkedList();
        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        PairNode pairNode = new PairNode(root, new PairInt(0, 0));
        queue.add(pairNode);

        while (!queue.isEmpty()) {
            PairNode temp = queue.remove();
            node frontNode = temp.node;
            int hd = temp.pairint.hd;
            int level = temp.pairint.level;

            Map<Integer, List<Integer>> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            list.add(frontNode.data);
            map.put(level,list);
            nodes.put(hd, map);
        }

        return ans;
    }
    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);
        root.right.left.right = new node(8);
        root.right.right.right = new node(9); // ans = 4 2 1 5 6 3 8 7 9
        

        List<Integer> list = verticalList(root);
        for (int li : list) {
            System.out.print(li+" ");
        }
    }
}
