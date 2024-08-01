package BinarySearchTree;


public class SearchANode {

    static node find(node root, int val){
        //base case
        if(root == null || root.data == val){
            return root;
        }

        if(val > root.data){
            return find(root.right, val);
        }
        else{
            return find(root.left, val);
        }
        
    }
    

    public static void main(String[] args) {
        node root = new node(5);
        root.left = new node(3);
        root.right = new node(9);
        root.left.left = new node(1);
        root.right.left = new node(8);

        node result = find(root, 1);
        System.out.println(result.data);

    }
}
