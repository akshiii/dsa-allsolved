import java.util.HashMap;
import java.util.Map;

public class DeleteDuplicatesFromUnorderedLL {
    

    void removeDuplicates(LinkedList list){
        Map<String,Boolean> visited = new HashMap<>();
        Node prev = list.head;
        Node curr = prev.next;
        visited.put(prev.data,true);
        while(prev != null && curr!=null){ 
            
            if(visited.get(curr.data)!= null && visited.get(curr.data) == true){
                if(curr.next == null){
                    prev.next = null;
                    break;
                }
                else{
                    prev.next = curr.next;
                    curr = curr.next;
                }
            }
            else{
                visited.put(curr.data,true);
                prev = prev.next;
                curr = curr.next;
            }
         }
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("7");
        list.addLast("1");
        list.addLast("3");
        list.addLast("5");
        list.addLast("5");
        list.printList();

        System.out.println();
        DeleteDuplicatesFromUnorderedLL findLoop = new DeleteDuplicatesFromUnorderedLL();
        findLoop.removeDuplicates(list);
        list.printList();
    }
}
