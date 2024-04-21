//This is throwing NPE error here, but its fully solved in leetcode
// https://leetcode.com/problems/copy-list-with-random-pointer/submissions/1238284474/



class NodeInt {
    int val;
    NodeInt next;
    NodeInt random;

    public NodeInt(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    static NodeInt copyRandomList(NodeInt head) {
        NodeInt cloneHead = null;
        NodeInt cloneTail = null;

        //Step1: Create a clone list
        NodeInt temp = head;
        while (temp != null) {
            NodeInt newNode = new NodeInt(temp.val);
            if (cloneHead == null) {
                cloneHead = newNode;
                cloneTail = newNode;
            } else {
                cloneTail.next = newNode;
                cloneTail = newNode;
            }
            temp = temp.next;
        }

        //Step2: Add clone nodes in between original nodes
        NodeInt originalNode = head;
        NodeInt cloneNode = cloneHead;
        while(originalNode!=null && cloneNode!=null){
            NodeInt temp1 = originalNode.next;
            originalNode.next = cloneNode;
            originalNode = temp1;

            NodeInt temp2 = cloneNode.next;
            cloneNode.next = originalNode;
            cloneNode = temp2;
        }

        //Step3: Now copy random pointers
        temp = head;
        while(temp!=null){
            if(temp.next != null){
               temp.next.random = temp.random.next;
            }
            if(temp.next != null){
                temp = temp.next.next;
            }
            else{ temp = null; }
        }

        //Step 4: Revert changes in step 2
        originalNode = head;
        cloneNode = cloneHead;
        while(originalNode != null && cloneNode!= null){
            originalNode.next = cloneNode.next;
            originalNode = originalNode.next;

            if(originalNode.next != null){
                cloneNode.next = originalNode.next;
            }
            cloneNode = cloneNode.next;

        }

        //Step 5: Return clone node
        return cloneHead;
    }

    static void insertAtTail(NodeInt head, NodeInt tail, int val) {
        NodeInt newNode = new NodeInt(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public static void main(String[] args) {
        NodeInt n1 = new NodeInt(3);
        NodeInt n2 = new NodeInt(5);
        NodeInt n3 = new NodeInt(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        n1.random = n2;
        n2.random = n3;
        n3.random = n1;

        NodeInt copiedNode = copyRandomList(n1);
        System.out.println("Copied list = ");
    }
}