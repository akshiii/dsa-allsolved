package BinaryTree;

//Check if 2 trees are identical
// TC == O(n) as we are visiting every node only 1 time
public class IdenticalTrees {

    static boolean isIdentical(node r1 , node r2){
        if(r1 == null && r2 == null){
            return true;
        }

        if(r1 == null && r2 != null){
            return false;
        }

        if(r1 != null && r2 == null){
            return false;
        }

        boolean left = isIdentical(r1.left, r2.left);
        boolean right = isIdentical(r1.right, r2.right);

        boolean value = r1.data == r2.data;

        if(left && right && value){
            return true;
        }
        else{
            return false;
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
