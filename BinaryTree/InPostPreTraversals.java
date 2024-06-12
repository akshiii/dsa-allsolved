package BinaryTree;

//Node or N means print it
public class InPostPreTraversals {

    // Left Node Right
    static void InOrder(node root){
        if(root == null){
            return;
        }
        InOrder(root.left);
        System.out.print(root.data+ " ");
        InOrder(root.right);
    }

    // Node Left Right
    static void PreOrder(node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+ " ");
        PreOrder(root.left);
        PreOrder(root.right);
    }

    // Left Right Node
    static void PostOrder(node root){
        if(root == null){
            return;
        }
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data+ " ");
    }

    public static void main(String[] args) {
        // Input: 1 3 5 7 11 17 null
        node root = new node(1);
        root.left = new node(3);
        root.right = new node(5);
        root.left.left = new node(7);
        root.left.right = new node(11);
        root.right.left = new node(17);
        root.right.right = null;
        System.out.print("Inorder => ");
        InOrder(root);
        System.out.println();
        System.out.print("Preorder => ");
        PreOrder(root);
        System.out.println();
        System.out.print("Postorder => ");
        PostOrder(root);
    }
}
