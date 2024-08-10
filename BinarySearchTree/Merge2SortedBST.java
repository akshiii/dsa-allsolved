package BinarySearchTree;

import java.util.ArrayList;

//This question solved 3 hard questions
//This approach has TC= O(n) and SC= O(1)
public class Merge2SortedBST {
    static ArrayList<Integer> arr = new ArrayList<>(); 
    static node prev = null;

    //converting a bst into a sorted doubly linked list in-place
    static void convertIntoSortedDLL(node root){
        if(root == null){
            return;
        }

        convertIntoSortedDLL(root.left);
        prev.right = root;
        root.left = prev;
        prev = root;

        convertIntoSortedDLL(root.right);
    }

    //merging 2 linked lists into one sorted ll
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

    //Uses slow ans fast method to give mid node in a ll
    static node getMidNode(node root){
        if(root == null || root.right == null){
            return root;
        }
        node slow = root;
        node fast = root;
        while(fast.right != null && fast.right.right != null){
            fast = fast.right.right;
            slow = slow.right;
        }
        return slow;
    }

    //converts linked list to a bst
    static node llToBst(node head){
        if(head == null || head.right == null){
            return head;
        }
        node midNode = getMidNode(head);
        node prev = midNode.left;
        node forw = midNode.right;

        forw.left = midNode.left = midNode.right = null;
        if(prev != null){
            prev.right = null;
        }

        midNode.left = llToBst(prev==null ? null : head);
        midNode.right = llToBst(forw);
        return midNode;
    }

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

        //Step 1 : flatten both bst into sorted doubly linked lists
        //BST 1:
            node dummy = new node(-1);
            prev = dummy;
            convertIntoSortedDLL(root1);
            node head1 = dummy.right;
            dummy.right = head1.left = null;
       
        //BST 2:
            dummy = new node(-1);
            prev = dummy;
            convertIntoSortedDLL(root2);
            node head2 = dummy.right;
            dummy.right = head2.left = null;
        
        //Step 2: Merge 2 sorted linked lists
        node head = merge2LL(head1, head2);

        //Step 3: Convert sorted ll into BST
        node bst  = llToBst(head);

        System.out.println("New bst = "+bst.data);
    }
}
