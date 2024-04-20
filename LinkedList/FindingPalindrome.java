//Chcek if a Linked list is a palindrome or not,
// 1->2->3->2->1 This is a palindrome, right to left and left to right is same

import java.util.ArrayList;
import java.util.Arrays;

public class FindingPalindrome {
    
    boolean find(LinkedList list){
        Node curr = list.head;
        String str1 = "";
        String str2 = "";
        while(curr != null){
            str1 = str1 +  Integer.parseInt(curr.data);
            str2 = Integer.parseInt(curr.data) + str2;
            curr = curr.next;
        }
        if(str1.equals(str2)){
            return true;
        }
        return false;
    }

    boolean find2(LinkedList list){
        Node curr = list.head;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();  

        while(curr!= null){
            int val = Integer.parseInt(curr.data);
            arrayList.add(val);
            curr = curr.next;
        }
        int length = arrayList.size();
        int s = 0;
        int e = length - 1;
        while(s<e){
            if(arrayList.get(s) != arrayList.get(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("1");
        list.addLast("2");
        // list.addLast("3");
        // list.addLast("2");
        // list.addLast("1");
        list.printList();
        System.out.println();

        FindingPalindrome findingPalindrome = new FindingPalindrome();
        boolean isPalindrome = findingPalindrome.find2(list);
        System.out.println("Is Palindrome?: "+ isPalindrome);

    }
}
