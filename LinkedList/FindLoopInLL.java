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
            System.out.println(visited.get(temp));
            visited.put(temp, true);
            temp = temp.next;
        }

        return false;
    }
    

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");
        list.makeLoopInLL();

        FindLoopInLL findLoop = new FindLoopInLL();
        System.out.println("Loop in LL ? = "+findLoop.isLoopExist(list));
    }
}
