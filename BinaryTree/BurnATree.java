package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BurnATree {
    static Map<node, node> nodeToParent = new HashMap<>();

    static node createParentMapping(node root, int target){
        node result = null;
        Queue<node> queue = new LinkedList();
        queue.add(root);
        nodeToParent.put(root, null);

        while(!queue.isEmpty()){
            node front = queue.remove();
            //For finding target node
            if(front.data == target){
                result = front;
            }
            //For node to parent mapping

            if(front.left != null){
                nodeToParent.put(front.left, front);
                queue.add(front.left);
            }
            if(front.right != null){
                nodeToParent.put(front.right, front);
                queue.add(front.right);
            }
        }
        return result;
    }

    static int burnTree(node targetNode){
        int ans = 0;
        Map<node, Boolean> visited = new HashMap<>();
        Queue<node> q = new LinkedList();
        q.add(targetNode);
        visited.put(targetNode, true);

        while(!q.isEmpty()){
            Boolean flag = false;

            //Jitne bhi element pade hue hai queue me un sabki neighbouring nodes ko burn krna hai,
            //left, right and parent node will burn for this loop(which will mean in 1 sec it will burn all 3 neighbouring nodes(if they r present))
            int size = q.size();
            for(int i = 0; i < size ; i++){
                node front = q.remove();

                if(front.left != null && visited.get(front.left) == null){
                    flag = true;
                    q.add(front.left);
                    visited.put(front.left, true);
                }
                if(front.right != null && visited.get(front.right) == null){
                    flag = true;
                    q.add(front.right);
                    visited.put(front.right, true);
                }

                if(nodeToParent.get(front) != null && visited.get(nodeToParent.get(front)) == null){
                    flag = true;
                    q.add(nodeToParent.get(front));
                    visited.put(nodeToParent.get(front), true);
                }
            }
            if(flag == true){
                ans++;
            }
        }
        return ans;
    }

    static int minTimeToBurnATree(node root, int target){
        
        node targetNode = createParentMapping(root, target);
        int ans = burnTree(targetNode);
        return ans;
    }

    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        //2
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.left.right.left = new node(7);
        root.left.right.right = new node(8);
        //3
        root.right.right = new node(6);
        root.right.right.right = new node(9);
        root.right.right.right.right = new node(10);

        int target = 6;
        int ans = minTimeToBurnATree(root,target);
        System.out.println("Min time = "+ ans);
    }
}
