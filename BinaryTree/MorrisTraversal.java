package BinaryTree;

public class MorrisTraversal {

    static void printMorrisTraversal(node root){
        node current = root;
        while(root != null){
            if(root.left == null && current!= null){
                System.out.print(current.data+ " ");
                current = current.right;
            }
            else{
                node predecessor = null;
                if(current!= null){
                    predecessor = current.left;
                }
                while(predecessor != null && predecessor.right != null && predecessor.right != current){
                    predecessor = predecessor.right;
                }

                if(predecessor != null && predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }
                else{
                    if(predecessor != null){
                        predecessor.right = null;
                    }
                    if(current!= null){
                        System.out.print(current.data + " ");
                        current = current.right;
                    }
                }
            }
        }
    }

    static void InOrder(node root){
        if(root == null){
            return;
        }
        InOrder(root.left);
        System.out.print(root.data+ " ");
        InOrder(root.right);
    }
    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(3);
        root.right = new node(5);
        root.left.left = new node(7);
        root.left.right = new node(11);
        root.right.left = new node(17);
        
        System.out.print("Inorder => ");
        InOrder(root);
        //Verify the ans with Inorder
        System.out.print("Morris Traversal => ");
        printMorrisTraversal(root);

    }
}
