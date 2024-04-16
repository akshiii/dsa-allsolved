public class FloydsCycleAlgo {

    public boolean implementAlgo(LinkedList list){

        Node slowPointer = list.head;
        Node fastPointer = list.head;

        while(fastPointer != null && fastPointer.next!=null && fastPointer.next.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer.data == fastPointer.data){
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
        list.addLast("5");
        list.makeLoopInLL();

        System.out.println();
        FloydsCycleAlgo floyd = new FloydsCycleAlgo();
        System.out.println("Result= " + floyd.implementAlgo(list));
    }
}
