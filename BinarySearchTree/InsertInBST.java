package BinarySearchTree;

class node{
    int data;
    node left;
    node right;

    node(int d){
        this.data = d;
        this.left = null;
        this.right = null;
    }
}

public class InsertInBST {

    static node insert(node root, int val) {
        if(root == null){
            root = new node(val);
            return root;
        }
        node curr = root;
        while(curr!=null){
            if(val > curr.data){
                if(curr.right!=null){
                    curr = curr.right;
                }
                else{
                    node newnode = new node(val);
                    curr.right = newnode;
                    return root;
                }
                
            }
            else {
                if(curr.left != null){
                    curr = curr.left;
                }
                else{
                    node newnode = new node(val);
                    curr.left = newnode;
                    return root;
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {
        node root = new node(5);
        root.left = new node(3);
        root.right = new node(9);
        root.left.left = new node(1);
        root.right.left = new node(8);

        int valueToInsert = 4;
        insert(root, valueToInsert);
        System.out.println(root);
    }
}
