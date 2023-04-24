public class palidrome {

     static boolean checkPalindrome(StringBuilder mystr, int i){
        if(i > mystr.length()-1-i){
            return true;
        }

        char char1 = mystr.charAt(i);
        char char2 = mystr.charAt(mystr.length()-1-i);

        if(char1 == char2){
            return checkPalindrome(mystr, i+1);
        }
        else{
            return false;
        }
        
    }

    public static void main(String[] args) {
        //Reverse a string with recursion
        StringBuilder myStr = new StringBuilder( "abba");

        System.out.println("Ans : "+ checkPalindrome(myStr,0));
    }
}
