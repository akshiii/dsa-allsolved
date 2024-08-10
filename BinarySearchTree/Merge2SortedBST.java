package BinarySearchTree;

import java.util.ArrayList;

//TODO: Unsolved
////This approach has TC= O(n) and SC= O(1)
public class Merge2SortedBST {
    static ArrayList<Integer> arr = new ArrayList<>(); 
    static node prev;

    //converting a bst into a sorted doubly linked list
    // static void convertIntoSortedDLL(node root, node head){
    //     if(root == null){
    //         return;
    //     }

    //     convertIntoSortedDLL(root.right, head);
    //     root.right = head;
    //     if(head != null){
    //         head.left = root;
    //     }
    //     head = root;

    //     convertIntoSortedDLL(root.left, head);
    // }

    static void Inorder(node curr){
        // Base case
        if (curr == null)
            return;
        Inorder(curr.left);
        prev.left = null;
        prev.right = curr;
        prev = curr;
        Inorder(curr.right);
    }
  
    // Function to flatten binary
    // tree using level order
    // traversal
    static node flatten(node parent){
        // Dummy node
        node dummy = new node(-1);
        
        // Pointer to previous
        // element
        prev = dummy;
        
        // Calling in-order
        // traversal
        Inorder(parent);
        
        prev.left = null;
        prev.right = null;
        node ret = dummy.right;
        
        // Delete dummy node
        //delete dummy;
        return ret;
    }

    static node merge2LL(node head1, node head2){
        node head = null;
        node tail = null;

        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                if(head == null){
                    head = head1;
                    tail = head1;
                    head1 = head1.right;
                }else{
                    tail.right = head1;
                    head1.left = tail;
                    tail = head1;
                    head1 = head1.right;
                }
            }
            else{
                if(head == null){
                    head = head2;
                    tail = head2;
                    head1 = head2.right;
                }else{
                    tail.right = head2;
                    head2.left = tail;
                    tail = head2;
                    head2 = head2.right;
                }
            }
        }

        while(head1 != null){
            tail.right = head1;
            head1.left = tail;
            tail = head1;
            head1 = head1.right;
        }
        while(head2 != null){
            tail.right = head2;
            head2.left = tail;
            tail = head2;
            head2 = head2.right;
        }

        return head;
    }

    static int countNodes(node root){
        int count = 0;
        node temp = root;
        while(temp!= null){
            count++;
            temp = temp.right;
        }
        return count;
    }

    static node sortedLLToBst(node head, int n ){
        //base case
        if(n <= 0 || head == null){
            return null;
        }

        node left = sortedLLToBst(head, n/2);
        node root = head;
        root.left = left;
        head = head.right;

        root.right = sortedLLToBst(head, n - n/2 -1);
        return root;
    }

    
    
    // static void InOrder(node root){
    //     if(root == null){
    //         return;
    //     }
    //     InOrder(root.left);
    //     System.out.print(root.data+ " ");
    //     InOrder(root.right);
    // }
    public static void main(String[] args) {
        node root1 = new node(5);
        root1.left = new node(3);
        root1.right = new node(9);
        root1.left.left = new node(1);
        root1.right.left = new node(8);

        node root2 = new node(4);
        root2.left = new node(2);
        root2.right = new node(6);
        root2.right.right = new node(7);

        //merge 2 bst
        //Step 1 : flatten both bst into sorted linked lists
        // node head1 = null;
        node head1 = flatten(root1);
        head1.left = null;
        

        node head2 = flatten(root2);
        // convertIntoSortedDLL(root2, head2);
        head2.left = null;

        // flatten(root1);
        // flatten(root2);

        // InOrder(root1);
        //Step 2: Merge 2 sorted linked lists
        node head = merge2LL(head1, head2);

        //Step 3: Convert sorted ll into BST
        node bst = sortedLLToBst(head, countNodes(head));

        System.out.println("New bst = ");
        // InOrder(bst);
    }
}
