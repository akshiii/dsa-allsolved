public class ReverseLinkedList {

    public void reverseLL(LinkedList list) {
        Node prev = null;
        Node curr = list.head;
        Node forward;
        while(curr != null){
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        list.head = prev;
        list.printList();
    }

    public void reverseUsingRecursion(LinkedList list,Node curr, Node prev){

        if(curr == null){
            list.head = prev;
            return;
        }

        Node forward = curr.next;
        reverseUsingRecursion(list, forward, curr);
        curr.next = prev;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.printList();
        System.out.println();

        ReverseLinkedList rll = new ReverseLinkedList();
        rll.reverseUsingRecursion(list, list.head,null);
        list.printList();
    }
}
