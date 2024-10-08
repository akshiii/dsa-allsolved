//Removing duplicates from Sorted Linked List

import java.util.HashMap;
import java.util.Map;

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

    //Delete all nodes that have duplicate numbers, 1->2->2->3->3->4-> null   Result= 1->4->null
    void deleteAllDuplicates(LinkedList list){
        Node lastUniqueNode = null;
        Node curr = list.head;
        boolean temp = false;
        if(list.head == null){
            return;
        }
        if(curr.next == null){
            return;
        }
        if(curr.data != curr.next.data){
            list.head = curr;
            lastUniqueNode = curr;
            temp = true;
        }
        while(curr !=null){
            if(curr.next != null && curr.next.next != null){
                if(curr.data != curr.next.data && curr.next.data != curr.next.next.data){
                    if(temp == false){
                        curr = curr.next;
                        list.head = curr;
                        lastUniqueNode = curr;
                        temp = true;
                    }
                    else{
                        curr = curr.next;
                        lastUniqueNode.next = curr;
                        lastUniqueNode = curr;
                    }
                } 
                else{
                    curr = curr.next;
                }
            }
            else{
                if(curr.next == null){
                    if(lastUniqueNode != null){
                        lastUniqueNode.next = null;
                    }
                    else{
                        list.head = null;
                    }
                    break;
                }
                else if(curr.next.next == null){
                    if(lastUniqueNode == null && curr.data == curr.next.data){
                        list.head = null;
                    }
                    else if(lastUniqueNode != null && curr.data == curr.next.data){
                        lastUniqueNode.next = null;
                    }
                    else if(lastUniqueNode == null && curr.data != curr.next.data){
                        list.head = curr.next;
                    }
                    else{
                        lastUniqueNode.next = curr.next;
                        break;
                    }
                    break;
                }
            }
            
        }
    }
    

    //Unsolved
    void deleteAllDuplicates2(LinkedList list){
        Node prev = list.head;
        Node curr = prev;

        Map<String,Boolean> visited = new HashMap<>();
        boolean flag = false;

        while(curr != null && curr.next!= null){
            if(curr.data == curr.next.data || visited.get(curr.data) != null && visited.get(curr.data) == true){
                visited.put(curr.data, true);
                prev.next = curr.next;
                curr = prev.next;
            }
            else{
                if(flag == false){
                    //for when beginning nodes are duplicates
                    flag = true;
                    if(visited.get(prev.data) != null && visited.get(prev.data) == true){
                        list.head = prev.next;
                        curr = curr.next;
                    }
                    else{
                        list.head = prev;
                        curr = curr.next;
                    }
                }
                else {
                    prev = prev.next;
                    curr = curr.next;
                }
            }
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("1");
        list.addLast("1");
        list.addLast("1");
        list.addLast("2");
        list.addLast("2");
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
        // removeDuplicates.deleteAllDuplicates(list);
        removeDuplicates.deleteAllDuplicates2(list);
        System.out.println();
        list.printList();
    }
}
