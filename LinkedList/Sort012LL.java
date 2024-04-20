//Sorting 0s, 1s, 2s in LL
public class Sort012LL {

    void sortLL(LinkedList list){
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        Node curr = list.head;
        while(curr != null){
            switch (curr.data) {
                case "0":
                    zeroCount++;
                    break;
                case "1":
                    oneCount++;
                    break;
                case "2":
                    twoCount++;
                    break;
                default:
                    break;
            }
            curr = curr.next;
        }
        curr = list.head;
        while(zeroCount != 0){
            curr.data = "0";
            curr = curr.next;
            zeroCount--;
        }
        while(oneCount != 0){
            curr.data = "1";
            curr = curr.next;
            oneCount--;
        }
        while(twoCount != 0){
            curr.data = "2";
            curr = curr.next;
            twoCount--;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("1");
        list.addLast("2");
        list.addLast("0");
        list.addLast("1");
        list.addLast("0");
        list.addLast("2");
        list.printList();

        Sort012LL sort012ll = new Sort012LL();
        sort012ll.sortLL(list);
        System.out.println("");
        list.printList();
    }
    
}


