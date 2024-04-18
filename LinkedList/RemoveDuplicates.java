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

    //Delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. 
    // void deleteAllDuplicates(LinkedList list){
    //     Node prevPrev = list.head;
    //     Node prev = list.head;
    //     Node curr = prev.next;
    //     boolean temp = false;
    //     while(curr != null){
    //         while(curr != null && prev.data == curr.data ){
    //                 System.out.println("Found common="+ prev.data);
    //                 curr = curr.next;
    //                 temp = true;
    //         }

    //         if( curr == null || curr.next == null){
    //             prevPrev.next = curr;
    //             if(curr!=null){
    //                 prevPrev = curr;
    //             }
    //             break;
    //         }
            
    //         else if (curr.data != curr.next.data && temp == true ){
    //             prevPrev.next = curr;
    //             prevPrev = curr;
    //         }
            
    //         prev = curr;
    //         curr = curr.next;
    //         temp = false;
    //     }
    // }

    // TODO: Unsolved!!!
    void deleteAllDuplicates(LinkedList list){
        Node lastDistinctNode = list.head;
        Node prev = list.head;
        Node curr = prev.next;
        boolean temp = false;
        boolean firstUniqueFound = false;


        while(curr != null){

            while(curr != null && curr.next != null && ( prev.data == curr.data || curr.data == curr.next.data)){
                    System.out.println("Found common="+ prev.data);
                    curr = curr.next;
                    temp = true;
            }
            
            if (prev.data != curr.data && temp == false){
                if(curr.next != null && curr.data != curr.next.data){
                    
                    
                    lastDistinctNode.next = curr;
                    lastDistinctNode = prev;
                    if(!firstUniqueFound){
                        list.head = lastDistinctNode;
                        firstUniqueFound = true;
                    }
                }
                else if(curr.next == null){
                    
                    lastDistinctNode.next = curr;
                    lastDistinctNode.next.next = null;
                    if(!firstUniqueFound){
                        list.head = lastDistinctNode;
                        firstUniqueFound = true;
                    }
                    break;
                }
            }
            else if(curr.next == null && temp == true){
                if(!firstUniqueFound){
                        list.head = lastDistinctNode;
                        firstUniqueFound = true;
                    }
                lastDistinctNode.next = null;
                break;
            }
            
            prev = curr;
            curr = curr.next;
            temp = false;
        }
    }
    

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("1");
        list.addLast("1");
        list.addLast("1");
        list.addLast("2");
        // list.addLast("2");
        // list.addLast("2");
        list.addLast("3");
        // list.addLast("3");
        // list.addLast("4");
        list.addLast("4");
        // list.addLast("5");
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
