//Sorting 0s, 1s, 2s in LL
public class Sort012LL {

    //Approach 1
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

    void insertAtTail(Node tail, Node curr){
        tail.next = curr;
        tail = curr;
    }
    //Approach 2  
    void sortLL2(LinkedList list, Sort012LL sort012ll){
        Node zeroHead = new Node("-1");
        Node zeroTail = zeroHead;

        Node oneHead = new Node("-1");
        Node oneTail = oneHead;
        
        Node twoHead = new Node("-1");
        Node twoTail = twoHead;

        Node curr = list.head;
        //creating separate lists fro 0 1 and 2
        while(curr!= null){

            if(curr.data == "0"){
                zeroTail.next = curr;
                zeroTail = curr;
            }
            else if (curr.data == "1") {
                oneTail.next = curr;
                oneTail = curr;
            }
            else if(curr.data == "2"){
                twoTail.next = curr;
                twoTail = curr;
            }
             
            curr = curr.next;
        }

        //Now merge all 3 lists
        if(oneHead.next != null){
            zeroTail.next = oneHead.next;
        }
        else {
            zeroTail.next = twoHead.next;
        }
        
        oneTail.next = twoHead.next;
        twoTail.next = null;
        list.head = zeroHead.next;
        

    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // list.addLast("1");
        list.addLast("2");
        // list.addLast("0");
        // list.addLast("1");
        // list.addLast("0");
        list.addLast("2");
        list.printList();

        Sort012LL sort012ll = new Sort012LL();
        sort012ll.sortLL2(list,sort012ll);
        System.out.println("");
        list.printList();
    }
    
}


