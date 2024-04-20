//Chcek if a Linked list is a palindrome or not,
// 1->2->3->2->1 This is a palindrome, right to left and left to right is same

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

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("2");
        list.addLast("1");
        list.printList();
        System.out.println();

        FindingPalindrome findingPalindrome = new FindingPalindrome();
        boolean isPalindrome = findingPalindrome.find(list);
        System.out.println("Is Palindrome?: "+ isPalindrome);

    }
}
