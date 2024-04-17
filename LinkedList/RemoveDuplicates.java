//Removing duplicates from Sorted Linked List
public class RemoveDuplicates {

    //Removing only duplicate extra nodes
    void removeDuplicates(LinkedList list){
        Node prev = list.head;
        Node curr = prev.next;
        while(curr != null){
            if(prev.data == curr.data ){
                System.out.println("Found common="+ prev.data);
                Node temp = curr.next;
                prev.next = temp;
                curr = temp;
            }
            else {
                prev = prev.next;
                curr = curr.next;
            }
        }
    }

    //NOT SOLVED!!
    //Completely delete all nodes which have duplicates
    void deleteAllDuplicates(LinkedList list){
        Node prevPrev = list.head;
        Node prev = prevPrev.next;
        Node curr = prev.next;
        while(curr != null){
            // if(prev.data == curr.data ){
                
                while(prev.data == curr.data){
                    System.out.println("Found common="+ prev.data);
                    Node temp = curr.next;
                    prev.next = temp;
                    curr = temp;
                } 
            // }
            // else {
                prevPrev.next = curr;
                prev = prevPrev.next;
                curr = prev.next;
                // prevPrev = prevPrev.next;
            // }
        }
    }
    

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("1");
        list.addLast("2");
        list.addLast("2");
        list.addLast("2");
        list.addLast("3");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");
        list.printList();

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        // removeDuplicates.removeDuplicates(list);
        // System.out.println();
        // list.printList();
        System.out.println();
        removeDuplicates.deleteAllDuplicates(list);
        System.out.println();
        list.printList();
    }
}
