// IMP!! -> Here the logic for finding loop is correct but the way we are trying to make a loop in LL is not exactly correct, it is just to test the logic here.
// This is solved in leetcode here-https://leetcode.com/problems/linked-list-cycle/
import java.util.HashMap;
import java.util.Map;

public class FindLoopInLL {
    boolean isLoopExist(LinkedList list){
        Map<Node,Boolean> visited = new HashMap<>();
        Node temp = list.head;

        if(list.head == null){
            return false;
        }
        while(temp.next != null){
            if(visited.get(temp) != null && visited.get(temp) == true){
                return true;
            }
            visited.put(temp, true);
            temp = temp.next;
        }

        return false;
    }

    /*
    *Finding strating node of loop
    Ex- 1->2->3->4->5->2 ( This means here 2 is the strating node of loop)
    */
    Node findStartingPointOfLoop(LinkedList list){
        Map<Node,Boolean> visited = new HashMap<>();
        Node temp = list.head;

        if(list.head == null){
            return null;
        }
        while(temp.next != null){
            if(visited.get(temp) != null && visited.get(temp) == true){
                return temp;
            }
            visited.put(temp, true);
            temp = temp.next;
        }
        return null;
    }

    void removeLoopInLL(LinkedList list){
        Map<Node,Boolean> visited = new HashMap<>();
        Node temp = list.head;
        Node prev = null;

        if(list.head == null){
            return;
        }
        while(temp.next != null){
            if(visited.get(temp) != null && visited.get(temp) == true){
                prev.next = null;
                break;
            }
            // System.out.println(visited.get(temp));
            visited.put(temp, true);
            prev = temp;
            temp = temp.next;
        }
        return;
    }
    

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");
        list.makeLoopInLL();

        System.out.println();
        FindLoopInLL findLoop = new FindLoopInLL();
        System.out.println("Loop in LL ? = "+findLoop.isLoopExist(list));
        System.out.println("Starting point in Loop = " + findLoop.findStartingPointOfLoop(list).data);
        System.out.print("Removing Loop in LL ");
        findLoop.removeLoopInLL(list);
        list.printList();
    }
}
