// You are given two non-empty linked lists representing two non-negative integers. 
//Add the two numbers and return the sum as a new linked list.
public class AddTwoLL {

    static void reverseUsingRecursion(LinkedList list,Node curr, Node prev){

        if(curr == null){
            list.head = prev;
            return;
        }

        Node forward = curr.next;
        reverseUsingRecursion(list, forward, curr);
        curr.next = prev;
    }

    static LinkedList add(LinkedList list1, LinkedList list2){

        reverseUsingRecursion(list1, list1.head, null);
        reverseUsingRecursion(list2, list2.head, null);

        int carry = 0;
        LinkedList linkedList = new LinkedList();
        Node curr1 = list1.head;
        Node curr2 = list2.head;
        while(curr1 != null && curr2 != null){
            int result = Integer.parseInt(curr1.data) + Integer.parseInt(curr2.data);
            int newNodeData = result % 10;
            linkedList.addLast(String.valueOf(newNodeData+carry));
            // System.out.println("carry is="+ 232/10);
            carry = result / 10;

            
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while(curr1 != null){
            int result = Integer.parseInt(curr1.data);
            int newNodeData = result % 10;
            linkedList.addLast(String.valueOf(newNodeData + carry));
            carry = result / 10;
            curr1 = curr1.next;
        }
        while(curr2 != null){
            int result = Integer.parseInt(curr2.data);
            int newNodeData = result % 10;
            linkedList.addLast(String.valueOf(newNodeData + carry));
            carry = result / 10;
            curr2 = curr2.next;
        }

        reverseUsingRecursion(linkedList, linkedList.head, null);
        return linkedList;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast("2");
        list1.addLast("4");
        // list1.addLast("3");
        LinkedList list2 = new LinkedList();
        list2.addLast("5");
        list2.addLast("6");
        list2.addLast("4");
        list1.printList();System.out.println();
        list2.printList();
        System.out.println();

        LinkedList nl = add(list1,list2);
        System.out.print("New list = ");
        nl.printList();

    }
}
