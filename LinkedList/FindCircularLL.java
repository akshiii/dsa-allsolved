//Find if LL is circular or not
public class FindCircularLL {

    public boolean isCircularLL(LinkedList list){
        Node head = list.head;

        Node temp = head;

        while(temp != null && temp.next!=null){
            temp = temp.next;
            System.out.println("temp.data= " + temp.data);
            if(temp.data == head.data){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("1");

        list.printList();
        System.out.println();

        FindCircularLL fl = new FindCircularLL();
        System.out.println("Result= " + fl.isCircularLL(list));
    }
}
