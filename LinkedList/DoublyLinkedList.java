public class DoublyLinkedList {
    Node head;

    class Node{
        String data;
        Node prev;
        Node next;

        Node(String data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void addHead(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insertAtPosition(int position){
        //insert node at any position
    }

    public void printDLL(){
        Node curr = head;
        while (curr.next != null) {
            System.out.print(curr.data + "-> ");
            curr = curr.next;
        }
        System.out.print(curr.data + "-> NULL");
    }


    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(); 
        doublyLinkedList.addHead("2");
        doublyLinkedList.addHead("3");
        doublyLinkedList.addHead("4");
        doublyLinkedList.printDLL();
    }
}
