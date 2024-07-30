package BinaryTree;

//Flatten a tree into linked list
public class FlattenATreeIntoLL {
    
    static void flatten(node root){
        node curr = root;
        while(curr!= null){
            if(curr.left != null ){
                node predecessor = curr.left;
                while(predecessor.right!=null){
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(5);
        root.left.left = new node(3);
        root.left.right = new node(4);
        root.right.right = new node(6);

        flatten(root);
        System.out.println("Flattened"+root);
    }
}
