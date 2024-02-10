//Finding middle node of a linked list
//If odd no of nodes then middle is length/2
// If even no of node then middle is length/2 + 1

public class MiddleOfLL {
    
    public void findMiddleNode(LinkedList list){
        Node curr = list.head;
        Node middle = list.head;
        while(curr.next != null){
            if(curr.next.next != null){
                curr = curr.next.next;
            }
            else curr = curr.next;
            middle = middle.next;
        }
        System.out.println("Middle is = "+middle.data);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.printList();
        System.out.println();

        MiddleOfLL ll = new MiddleOfLL();
        ll.findMiddleNode(list);
    }
}
