public class ReverseKGroups {
    
    /**
     * Recursive function
     * @param list actual list
     * @param start Starting node for K group to reverse
     * @param k Size of groups
     * @return New head node 
     */
    static Node kReverse(LinkedList list,Node start, int k) {
        //base call
        if(start == null){
            return null;
        }
        //reverse first k nodes
        Node next = null;
        Node curr = start;
        Node prev = null;
        int count = 0;

        while(curr!= null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            count++;  
        }

        //recursive call
        if(next != null){
            start.next = kReverse(list, next, k);
        }

        //return head of reversed list
        return prev;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");
        list.addLast("6");
        list.printList();
        System.out.println();

        // ReverseKGroups rll = new ReverseKGroups();
        list.head = kReverse(list,list.head, 2);
        
        list.printList();
    }
}
