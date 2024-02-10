public class LinkedList {
    Node head;

    // class Node{
    //     String data;
    //     Node next;

    //     Node(String data){
    //         this.data = data;
    //         this.next = null;
    //     }
    // }

    public void addFirst( String data){
        Node newNode = new Node(data);
        if(head == null){

            //if there is no list
            head = newNode;
            return;
        }
        // if a list already exists
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){

            //if there is no list
            head = newNode;
            return;
        }
        //creating cuuNode only for traversing
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void printList(){
        if(head == null){
            System.out.print("No LL exists!!");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.print("Null");
    }

    public void deleteLast(){
        if(head == null){
            System.out.print("List is empty");
        }

        //if only 1 node is there
        if(head.next == null){
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;

        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }

        secondLast.next = null;
    }

    public void deleteFromMiddle(int position){
        //position can be from 1 to length of LL ( any number)
        Node prev = null;
        Node curr = head;

        int count = 1;
        while(count < position){
          prev = curr;
          curr = curr.next;
          count++;
          
        }
        prev.next = curr.next;
    }

    public void reverseIterate(){
        if(head == null ||head.next == null){
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while(currNode !=null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
        
    }
}
