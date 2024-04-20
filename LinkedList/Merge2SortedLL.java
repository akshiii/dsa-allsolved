
//Merging 2 sorted linked lists
public class Merge2SortedLL {

    LinkedList mergeLL(Merge2SortedLL merge2SortedLL,LinkedList l1, LinkedList l2){ 
        //base cases
        if(l1.head == null) return l2;
        if(l2.head == null) return l1;

        //Data of First node of list 2 must always be bigger than first node of List 1, 
        //if not then Exchange l2 to l1, and l1 to l2
        if(Integer.parseInt(l2.head.data) < Integer.parseInt(l1.head.data)){
            return merge2SortedLL.merge(l2, l1);
        }
        return merge2SortedLL.merge(l1, l2);
    }
    
    LinkedList merge(LinkedList list1, LinkedList list2){

        Node prev = list1.head;
        Node curr = prev.next;
        Node temp = list2.head;

        while(curr != null && temp != null){
            if(Integer.parseInt(prev.data) <= Integer.parseInt(temp.data) &&  Integer.parseInt(temp.data) <= Integer.parseInt(curr.data) ){
                    //add temp.data in between of list1  and update the list2 
                    Node dummyTemp = temp.next;
                    prev.next = temp;
                    temp.next = curr;

                    // update the list2 
                    temp = dummyTemp;
                    prev = prev.next;
            }
            else {
                    prev = prev.next;
                    curr = curr.next;
            }
        }
        //Add the rest of the nodes from list 2 if all elements of list 1 are over
        if(temp != null && curr == null ){
            prev.next = temp;
        }
        return list1;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast("1");
        list1.addLast("2");
        list1.addLast("3");
        LinkedList list2 = new LinkedList();
        list2.addLast("2");
        list2.addLast("5");
        list2.addLast("6");

        list1.printList();System.out.println("");
        list2.printList();System.out.println("");
        
        System.out.println("After Merging");

        Merge2SortedLL merge2SortedLL = new Merge2SortedLL();
        
        LinkedList mergedList = merge2SortedLL.mergeLL(merge2SortedLL, list1, list2);
        mergedList.printList();
    }
}
