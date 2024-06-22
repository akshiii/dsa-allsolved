package BinaryTree;

//Check if 2 trees are identical
public class IdenticalTrees {

    static boolean isIdentical(node r1 , node r2){
        if(r1 == null && r2 == null){
            return true;
        }
    }

    public static void main(String[] args) {
        node root1 = new node(3);
        root1.left = new node(9);
        root1.right = new node(20);
        root1.right.left = new node(15);
        root1.right.right = new node(7); 

        node root2 = new node(3);
        root2.left = new node(9);
        root2.right = new node(20);
        root2.right.left = new node(15);
        root2.right.right = new node(7); 
        

        System.out.println("is identical ? = "+ isIdentical(root1, root2));
    }
    
}
