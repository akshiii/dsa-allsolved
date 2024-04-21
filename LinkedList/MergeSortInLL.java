public class MergeSortInLL {
    
    static Node mergeSort(Node head){
        //base case 
        if(head == null || head.next == null){
            return head;
        }

        //break list into 2 halves after finding mid
        Node mid = findMid(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;

        //recursive calls to solve both halves
        left = mergeSort(left);
        right = mergeSort(right);

        //merge both left and rigt halves
        Node result = merge(left,right);

        return result;
    }

    static Node merge(Node left, Node right){
        if(left == null) return right;
        if(right == null) return left;

        if(Integer.parseInt(right.data) < Integer.parseInt(left.data)){
            return mergeLL(right, left);
        }
        return mergeLL(left,right);
    }

    static Node mergeLL(Node l1, Node l2){
        Node prev = l1;
        Node curr = l1.next;
        Node temp = l2;

        while(curr!= null && temp != null){
            if(Integer.parseInt(prev.data) <= Integer.parseInt(temp.data) && Integer.parseInt(temp.data) <= Integer.parseInt(curr.data)){
                Node dummy = temp.next;
                prev.next = temp;
                temp.next = curr;
                temp = dummy;
                prev = prev.next;
            }
            else{
                prev = prev.next;
                curr = curr.next;
            }
        }
        if(temp != null && curr == null){
            prev.next = temp;
        }
        return l1;
    }

    static Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;        
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("-1");
        list.addLast("5");
        list.addLast("3");
        list.addLast("7");
        list.addLast("0");
        list.printList();System.out.println("");

        Node node = mergeSort(list.head);

        System.out.println("After merge sort: ");
        Node temp = node;
        while(temp !=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }
}
